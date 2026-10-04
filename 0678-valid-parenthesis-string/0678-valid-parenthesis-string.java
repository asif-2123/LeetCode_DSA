class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for(char ch : s.toCharArray()) {

            if(ch == '(') {
                low++;   high++;
            }else if(ch == ')') {
                low--;   high--;
            }else { 
                low--;   high++;
            }

            if(high < 0)     return false;
            low = Math.max(low, 0);
        }
        return low == 0;
    }
}