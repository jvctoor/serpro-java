package problems;

import javax.swing.tree.TreeNode;
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

    public int addDigits(int num) {
        while (num >= 10) {
            String numStr = String.valueOf(num);
            String[] digitsStr = numStr.split("");
            int newNum = 0;
            for (String digit : digitsStr) {
                newNum += Integer.parseInt(digit);
            }
            num = newNum;
        }
        return num;
    }

    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilhaDeWhopper = new Stack<>();

        // Populando a fila
        for(int estudante: students) {
            fila.add(estudante);
        }

        // Populando a pilha
        for (int i = sandwiches.length-1 ; i >= 0 ; i--) {
            pilhaDeWhopper.push(sandwiches[i]);
        }

        int alunosAble = 0;
        int pointer = sandwiches.length;

        while (fila.size() > 0) {

            int sandubaAtual = pilhaDeWhopper.peek();
            int alunoAtual = fila.poll();

            if (alunoAtual == sandubaAtual) {
                alunosAble++;
                pointer = sandwiches.length;
                pilhaDeWhopper.pop();
            } else {
                fila.offer(alunoAtual);
                pointer--;
                if (pointer == 0) {
                    break;
                }
            }


        }

        return students.length - alunosAble;

    }

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)){
                int contador = map.get(num) + 1;
                map.put(num, contador);
                continue;
            }
            map.put(num, 1);
        }

        int min = 0;
        int keye = 0;

        for (int key : map.keySet()) {

            if (map.get(key) > min) {
                min = map.get(key);
                keye = key;
            }

        }

        return keye;
    }

    public boolean hasCycle(String head) {

        HashSet<String> mp = new HashSet<>();
        String currentNode = head;

        while (currentNode != null && currentNode != null) {
            if (mp.contains(currentNode)) {
                return true;
            }
            mp.add(currentNode);
            if (currentNode != null) {
                currentNode = currentNode;
            } else {
                return false;
            }
        }

        return false;

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        if (root == null) {
            return tree;
        } else {
            return preOrder(root, tree);
        }
    }

    public List<Integer> preOrder(TreeNode node, List<Integer> tree) {
        if (node == null) {
            return tree;
        }
        tree.add(1);
        if (node != null) {
            this.preOrder(node, tree);
        }
        if (node != null) {
            this.preOrder(node, tree);
        }
        return tree;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        char[] primeira = strs[0].toCharArray();
        int index = 0;
        for (char c : primeira) {
            if (compareStrings(strs, c, index)) {
                sb.append(c);
            } else {
                break;
            }
            index++;
        }
        return sb.toString();
    }
    public boolean compareStrings(String[] strs, char letra, int index) {
        for(String str : strs) {
            if (index >= str.length() || str.charAt(index) != letra) {
                return false;
            }
        }
        return true;
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0 ; i < nums.length ; i++) {
            if (i+1 > nums.length-1) {
                if (target > nums[i]) {
                    return nums.length;
                }
            }
            if (nums[i] == target) {
                return i;
            }
            else if (target > nums[i] && target < nums[i+1]) {
                return i+1;
            }
            else if (target > nums[nums.length-1]) {
                return nums.length;
            }
        }
        return 0;
    }

    public int singleNumber(int[] nums) {
        Map<Integer,Boolean> mySet = new HashMap<>();
        for (int num : nums) {
            if (mySet.containsKey(num)) {
                mySet.put(num,true);
                continue;
            }
            mySet.put(num,false);
        }
        for (int num : nums) {
            if (mySet.get(num) == false) {
                return num;
            }
        }
        return 0;
    }


}
