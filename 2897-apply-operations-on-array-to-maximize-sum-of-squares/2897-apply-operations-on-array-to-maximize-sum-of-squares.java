class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int cnt[] = new int[32];

        for (int num : nums) {
            for (int bit = 0; bit < 32; bit++) {
                if (((num >> bit) & 1) == 1) {
                    cnt[bit]++;
                }
            }
        }
        long ans = 0;
        while (k-- > 0) {
            long cur = 0;
            for (int bit = 0; bit < 32; bit++) {
                if (cnt[bit] > 0) {
                    cur |= (1L << bit);
                    cnt[bit]--;
                }
            }
            ans = (ans + (cur * cur) % MOD) % MOD;
        }
        return (int) ans;
    }
}