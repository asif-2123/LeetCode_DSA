class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer(s);
        vis.add(s);
        boolean found = false;

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (isValid(cur)) {
                res.add(cur);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < cur.length(); i++) {
                char c = cur.charAt(i);
                if (c != '(' && c != ')') continue;

                String next = cur.substring(0, i) + cur.substring(i + 1);

                if (vis.add(next))
                    q.offer(next);
            }
        }

        return res;
    }

    private boolean isValid(String s) {
        int cnt = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else if (c == ')') {
                if (cnt == 0) return false;
                cnt--;
            }
        }

        return cnt == 0;
    }
}