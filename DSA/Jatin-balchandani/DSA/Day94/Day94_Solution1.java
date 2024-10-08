public class Day94_Solution1 {

        static int par[];
        static int size[];

        static int find(int a){
            if(par[a]==a) return a;
            else return par[a] = find(par[a]);
        }

        static void union(int a, int b){
            a = find(a);
            b = find(b);
            if(a!=b){
                if(size[a]>size[b]){
                    par[b] = a;
                    size[a]+=size[b];
                }else{
                    par[a] = b;
                    size[b]+=size[a];
                }
            }
        }
        public int minMalwareSpread(int[][] edge, int[] initial) {
            int n = edge.length;

            par = new int[n];
            size = new int[n];

            for(int i=0; i<n; i++){
                par[i] = i;
                size[i] = 1;
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(edge[i][j]==1){
                        union(i,j);
                    }
                }
            }

            int[] infected = new int[n];
            for(var x : initial){
                int a = find(x);
                infected[a]++;
            }

            int ans = -1;
            int max = -1;

            for(var x : initial){
                int a = find(x);
                if(infected[a]==1 && size[a]>=max){
                    if(max==size[a]){
                        ans = Math.min(ans,x);
                    }else{
                        ans = x;
                    }
                    max = size[a];
                }
            }

            if(ans==-1){
                int min = Integer.MAX_VALUE;
                for(var x : initial) min = Math.min(min,x);
                return min;
            }
            return ans;
        }
    }
