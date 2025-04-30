package com.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Soluution {
    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int zeroIndex = 0;
        int noneZeroIndex = 1;
        while (noneZeroIndex < nums.length) {
            if (nums[zeroIndex] != 0) {
                zeroIndex++;
                noneZeroIndex = zeroIndex + 1;
            } else {
                if (nums[noneZeroIndex] != 0) {
                    nums[zeroIndex] = nums[noneZeroIndex];
                    zeroIndex++;
                    nums[noneZeroIndex] = 0;
                    noneZeroIndex++;
                } else {
                    noneZeroIndex++;
                }
            }
        }
    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;
            l++;
            r--;
        }
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindromic(s, i, i);
            String s2 = palindromic(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindromic(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = slow.next;
            }
        }
        if (fast != null && fast.val == slow.val) {
            slow.next = fast.next;
        }
        return head;
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        Character c = stack.pop();
                        sb.append(c);
                    }
                    sb.append(" ");
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                Character c = stack.pop();
                sb.append(c);
            }
        }
        return sb.toString().trim();
    }

    public static boolean circularArrayLoop(int[] nums) {
        // Replace this placeholder return statement with your code
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int startIndex = i;
            int currentIndex = startIndex;
            Set<Integer> set = new HashSet<>();
            int direction = 0;
            while (true) {
                int step = nums[currentIndex];
                if (step > 0) {
                    if (direction == -1) {
                        break;
                    } else {
                        direction = 1;
                    }
                    currentIndex = currentIndex + step % len >= len ? currentIndex + step % len - len
                            : currentIndex + step % len;
                } else {
                    if (direction == 1) {
                        break;
                    } else {
                        direction = -1;
                    }
                    currentIndex = currentIndex + step % len < 0 ? currentIndex + step % len + len
                            : currentIndex + step % len;
                }
                if (currentIndex == startIndex && set.isEmpty()) {
                    break;
                }
                if (currentIndex == startIndex && !set.isEmpty()) {
                    return true;
                } else {
                    if (set.contains(currentIndex)) {
                        break;
                    }
                    set.add(currentIndex);
                }
            }
        }
        return false;
    }

    public static ListNode middleNode(ListNode head) {

        // Replace this placeholder return statement with your code
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean detectCycle(ListNode head) {

        // Replace this placeholder return statement with your code
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode swapPairs(ListNode head) {

        // Replace this placeholder return statement with your code
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        ListNode current = head;
        ListNode pos = dump;
        dump.next = pos;
        while (current != null && current.next != null) {
            ListNode s = current.next.next;
            ListNode temp = current.next;
            current.next = null;
            pos.next = temp;
            pos = pos.next;
            pos.next = current;
            pos = pos.next;

            current = s;

        }
        if (current != null) {
            pos.next = current;
        }
        return dump.next;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // Replace this placeholder return statement with your code
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode pos = dumy;
        int count = 0;
        while (count < left - 1) {
            pos = pos.next;
            count++;
        }
        ListNode preNode = pos;
        Stack<ListNode> stack = new Stack<>();
        while (count < right) {
            pos = pos.next;
            stack.push(pos);
            count++;
        }
        ListNode s = pos.next;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            temp.next = null;
            preNode.next = temp;
            preNode = preNode.next;
        }
        preNode.next = s;
        return dumy.next;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        // Replace this placeholder return statement with your code
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode prevR = dummy;
        for (int i = 0; i < k - 1; i++) {
            prev = prev.next;
        }
        ListNode left = prev.next;
        ListNode leftBack = prev.next.next;

        ListNode pos = prev.next;
        while (pos != null && pos.next != null) {
            pos = pos.next;
            prevR = prevR.next;
        }
        ListNode right = prevR.next;
        ListNode rightBack = prevR.next.next;
        right.next = null;
        left.next = null;

        prev.next = right;
        prev.next.next = leftBack;

        prevR.next = left;
        prevR.next.next = rightBack;
        return dummy.next;
    }

    private static ArrayList<String> res = new ArrayList<>();

    public static ArrayList<String> permuteWord(String word) {

        // Replace this placeholder return statement with your code
        res = new ArrayList<>();
        LinkedList<Character> list = new LinkedList<>();
        backtrack(0, list, word.length(), word);
        return res;
    }

    private static void backtrack(int index, LinkedList<Character> list, int size, String word) {
        if (index == size) {
            String str = list.stream().map(String::valueOf).collect(Collectors.joining(""));
            res.add(str);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!list.contains(word.charAt(i))) {
                list.add(word.charAt(i));
                backtrack(index + 1, list, size, word);
                list.removeLast();
            }
        }
    }

    private static Map<Character, String> pair = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

    public static List<String> letterCombinations(String digits) {

        // Replace this placeholder return statement with your code
        LinkedList<String> list = new LinkedList<>();
        for (char c : digits.toCharArray()) {
            list.add(pair.get(c));
        }
        
        return new ArrayList<>();
    }

    public static int findBestValue(int[] arr, int target) {
      
        // Replace this placeholder return statement with your code
        int size = arr.length;
        Arrays.sort(arr);
        int mod = target % size;
        int v = mod > (size / 2) ? target / size + 1 : target / size;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= v) {
                sum += arr[i];
            } else {
                if (Math.abs(target - (sum + arr[i])) < Math.abs(target - (sum + v))) {
                    v = arr[i];                    
                }
                break;
            }
        }
        return v;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(permuteWord("word"));
    }
}
