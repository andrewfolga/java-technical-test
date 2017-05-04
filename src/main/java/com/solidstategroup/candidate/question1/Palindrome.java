package com.solidstategroup.candidate.question1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Class that handles palindrome operations
 * <p>
 * Definition: A palindrome is a string that reads the same forward and backward.
 * For example, "abcba" is a palindrome, "abab" is not.
 */
public class Palindrome {

    /**
     * Please implement this method to
     * return true if the parameter is a palindrome and false otherwise.
     *
     * @param s string to determine if a palindrome
     * @return true if the parameter is a palindrome and false otherwise
     */
    public boolean isPalindrome(String s) {
        if (s == null) throw new NullPointerException("String has to be provided");

        boolean isPalindrome = true;

        for (int i = 0; i < s.length(); i++) {
            if (i >= s.length() / 2) {
                break;
            } else if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }


        return isPalindrome;
    }
}
