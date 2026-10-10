class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        long k = (long)k1 + k2;

        int max = 0;
        long[] freq = new long[100001];

        for(int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            max = Math.max(max, diff);
        }

        for(int d = max; d > 0 && k > 0; d--) {

            long cnt = freq[d];

            if(cnt == 0) continue;

            if(k >= cnt) {
                freq[d] -= cnt;
                freq[d - 1] += cnt;
                k -= cnt;
            } else {
                freq[d] -= k;
                freq[d - 1] += k;
                k = 0;
            }
        }

        long ans = 0;

        for(long d = 1; d <= 100000; d++) {
            ans += freq[(int)d] * d * d;
        }

        return ans;
    }
}
