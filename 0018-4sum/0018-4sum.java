class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Arrays.sort(nums);
        // int n=nums.length;
        // List<List<Integer>> result=new ArrayList<>();
        // Set<List<Integer>> set=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             for(int l=k+1;l<n;l++){
        //                 long sum=(long) nums[i] + nums[j] + nums[k] + nums[l];
        //                 if (sum== target){
        //                     List<Integer> quad=new ArrayList<>();
        //                     quad.add(nums[i]);
        //                     quad.add(nums[j]);
        //                     quad.add(nums[k]);
        //                     quad.add(nums[l]);
        //                     set.add(quad);
        //                 } 
        //             }
        //         }
        //     }
        // }
        // result.addAll(set);
        // return result;  
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Minimum possible sum
            long min1 = (long) nums[i] + nums[i+1]
                      + nums[i+2] + nums[i+3];

            if (min1 > target)
                break;

            // Maximum possible sum
            long max1 = (long) nums[i] + nums[n-1]
                      + nums[n-2] + nums[n-3];

            if (max1 < target)
                continue;

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // Minimum possible sum
                long min2 = (long) nums[i] + nums[j]
                          + nums[j+1] + nums[j+2];

                if (min2 > target)
                    break;

                // Maximum possible sum
                long max2 = (long) nums[i] + nums[j]
                          + nums[n-1] + nums[n-2];

                if (max2 < target)
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                            nums[i], nums[j],
                            nums[left], nums[right]
                        ));

                        left++;
                        right--;

                        while (left < right &&
                               nums[left] == nums[left - 1])
                            left++;

                        while (left < right &&
                               nums[right] == nums[right + 1])
                            right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}