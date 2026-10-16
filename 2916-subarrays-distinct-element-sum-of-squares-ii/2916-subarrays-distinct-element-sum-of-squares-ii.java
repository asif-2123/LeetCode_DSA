class Solution {
    static final int MOD = 1_000_000_007;

    class SegTree {
        int n;
        long[] sum, sq, lazy;

        SegTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int idx, int l, int r, long val) {
            sq[idx] += 2L * val * sum[idx] + (r - l + 1L) * val * val;
            sum[idx] += (r - l + 1L) * val;
            lazy[idx] += val;
        }

        void push(int idx, int l, int r) {
            if (lazy[idx] == 0) return;

            int mid = (l + r) >> 1;

            apply(idx * 2, l, mid, lazy[idx]);
            apply(idx * 2 + 1, mid + 1, r, lazy[idx]);

            lazy[idx] = 0;
        }

        void update(int idx, int l, int r, int ql, int qr, long val) {
            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(idx, l, r, val);
                return;
            }

            push(idx, l, r);

            int mid = (l + r) >> 1;

            update(idx * 2, l, mid, ql, qr, val);
            update(idx * 2 + 1, mid + 1, r, ql, qr, val);

            sum[idx] = sum[idx * 2] + sum[idx * 2 + 1];
            sq[idx] = sq[idx * 2] + sq[idx * 2 + 1];
        }

        long querySq() {
            return sq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegTree st = new SegTree(n);
        Map<Integer, Integer> last = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);

            st.update(1, 0, n - 1, prev + 1, i, 1);

            ans = (ans + st.querySq()) % MOD;

            last.put(nums[i], i);
        }

        return (int) ans;
    }
}