class Solution {
    int n;
    vector<int> st;
    void build(vector<int> &nums){
        st=vector<int> (2*n,0);
        for(int i=n;i<2*n;i++){
            st[i]=nums[i-n];
        }
        for(int i=n-1;i>0;--i){
            st[i]=st[i<<1]+st[i<<1|1];
        }
    }
    int getSum(int l,int r){
        int res=0;
        for(l+=n,r+=n;l<r;l>>=1,r>>=1){
            if(l&1) res+=st[l++];
            if(r&1) res+=st[--r];
        }
        return res;
    }   
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int fl, int sl) {
        n=nums.size();
        build(nums);
        int ans=0;
        for(int i=0;i<n-fl;i++){
            for(int j=i+fl;j<=n-sl;j++){
                ans=max(ans,getSum(i,i+fl)+getSum(j,j+sl));
            }
        }
        swap(fl,sl);
        for(int i=0;i<n-fl;i++){
            for(int j=i+fl;j<=n-sl;j++){
                ans=max(ans,getSum(i,i+fl)+getSum(j,j+sl));
            }
        }
        return ans;  
    }
};
