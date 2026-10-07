class Solution {
    public int[] sortArray(int[] nums) {
        
        int max=nums[0];
        int min=nums[0];
        for(int i=0; i<nums.length; i++){
            max = Math.max(nums[i] , max);
            min = Math.min(min, nums[i]);
        }

        int count[] = new int[max-min+1];

        for(int i = 0; i<nums.length;i++){
            count[nums[i]-min]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                nums[j++]=i+min;
                count[i]--;
            }
        }
        return nums;
    }
}