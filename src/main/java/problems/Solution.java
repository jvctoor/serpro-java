package problems;

class Solution {
    public boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        String strX = Integer.toString(x);
        char[] charList = strX.toCharArray();

        StringBuilder sb1 = new StringBuilder();

        for(int i = charList.length-1 ; i >= 0 ; i--) {
            sb1.append(charList[i]);
        }

        if (strX.equals(sb1.toString())) {
            return true;
        }

        return false;

    }




}
