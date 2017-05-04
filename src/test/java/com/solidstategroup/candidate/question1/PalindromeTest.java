package com.solidstategroup.candidate.question1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrzejfolga on 04/05/2017.
 */
public class PalindromeTest {

    private Palindrome palindrome = new Palindrome();

    @Test
    public void shouldFindPalindrome() throws Exception {

        String aPalidrome = "abcba";

        boolean isPalindrome = this.palindrome.isPalindrome(aPalidrome);

        assertTrue("String should be palindrom", isPalindrome);
    }

    @Test
    public void shouldNotFindPalindrome() throws Exception {

        String notPalindrome = "abab";

        boolean isPalindrome = this.palindrome.isPalindrome(notPalindrome);

        assertFalse("String should not be palindrom", isPalindrome);
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailToFindIfNoValue() throws Exception {

        this.palindrome.isPalindrome(null);
    }
}