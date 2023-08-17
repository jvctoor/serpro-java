package problems;

import java.util.*;

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

    public double findMaxAverage(int[] nums, int k) {
        List<Double> avgs = new ArrayList<>();
        for (int i = 0 ; i + k <= nums.length ; i++) {
            double total = 0;
            for (int j = 0 ; j < k ; j++) {
                total += nums[i + j];
            }
            double avg = total / k;
            avgs.add(avg);
        }
        double maior = Double.NEGATIVE_INFINITY;
        for (double numero : avgs) {
            if (numero > maior) {
                maior = numero;
            }
        }
        return maior;
    }

    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : map.values()) {
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }






}
