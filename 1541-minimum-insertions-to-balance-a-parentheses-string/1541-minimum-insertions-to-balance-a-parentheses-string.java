class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int need = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                need += 2;

                if (need % 2 == 1) {
                    ans++;
                    need--;
                }
            } else {
                need--;
                if (need == -1) {
                    ans++;
                    need = 1;
                }
            }
        }
        return ans + need;
    }
}