import java.util.*;

public class Day98_solution1 {
        public int numRabbits(int[] answers) {
            HashMap<Integer, Integer> map=new HashMap<>();
            for(int i=0; i<answers.length ; i++){
                if(map.containsKey(answers[i])){
                    map.put(answers[i], map.get(answers[i])+1);
                }else{
                    map.put(answers[i],1);
                }
            }
            int ans=0;
            for(Integer key : map.keySet()){
                int q = (map.get(key))/(key+1);
                int r = (map.get(key))%(key+1);
                q += r==0 ? 0 : 1;
                ans += q*(key+1);
            }
            return ans;
        }
    }
