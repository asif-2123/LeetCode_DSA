class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] sq = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sq[i] = 1L * nums[i] * nums[i];
        }

        Arrays.sort(sq);
        long ans = 0;
        int n = sq.length;
        int countNeg = n / 2;

        for (int i = 0; i < n; i++) {
            if (i < countNeg) ans -= sq[i];
            else ans += sq[i];
        }
        return ans;
    }
}