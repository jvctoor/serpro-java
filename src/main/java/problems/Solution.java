package problems;

import java.util.HashMap;
import java.util.Map;

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

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            if (mp.containsKey(num)) return true;
            mp.put(num, num);
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        boolean volta = BFS(matrix, 0, target);

        return volta;

    }

    public boolean BFS(int[][] matrix, int i, int target) {

        int len = matrix.length;

        if (i > len-1) {
            return false;
        }

        int depth = matrix[i].length;

        if (target > matrix[i][depth-1] && i <= matrix.length-1) {
            return BFS(matrix, i+1, target);
        }

        if (target <= matrix[i][depth-1]) {
            for (int j = depth-1; j >= 0; j--) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }






}
