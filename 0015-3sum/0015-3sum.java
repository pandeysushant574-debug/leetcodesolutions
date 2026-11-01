class Solution {
    public void twosumhelaper(int f,int[] nums,List<List<Integer>> res){
        int i=f+1;
        int j=nums.length-1;
        while(i<j){
            int sum= nums[f]+nums[i]+nums[j];

            if(sum>0){
               j= j-1;
            }
            else if(sum<0){
                i=i+1;
            }
            else{
                // found atriplet
                res.add(Arrays.asList(nums[f],nums[i],nums[j])); // nums[f],nums[i],nums[j]to convert assay as list in java Array.asList()
                i=i+1;
                j=j-1;
                while(i<j && nums[i]==nums[i-1]){
                    i=i+1;
                }
                while(i<j && nums[j]==nums[j+1]){
                    j=j-1;
                }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
    //     // approach 1
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             for(int k=j+1;k<nums.length;k++){
    //                 int sum=0;
    //                 if(sum==nums[i]+nums[j]+nums[k]){
    //                     return Arrays.asList(Arrays.asList(nums[i],nums[j],nums[k]));
    //                 }
    //             }
    //         }
    //     }
    //     return Arrays.asList();
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        for (int f=0;f<nums.length;f++){
            if(nums[f]>0){
                break;
            }
            if(f==0 || nums[f]!=nums[f-1]){
                twosumhelaper(f,nums,res);
            }
        }
        return res;
     }
}