import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StringExtensionsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun lengthOfLongestSubstring() {
        assertEquals(3, StringExtensions.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, StringExtensions.lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, StringExtensions.lengthOfLongestSubstring("pwwkew"))
        assertEquals(2, StringExtensions.lengthOfLongestSubstring("aab"))
        assertEquals(3, StringExtensions.lengthOfLongestSubstring("dvdf"))
    }

    @Test
    fun longestPalindrome() {
        assertEquals("bab", StringExtensions.longestPalindrome("babad"))
        assertEquals("bb", StringExtensions.longestPalindrome("cbbd"))
    }

    @Test
    fun test_zigzagConversion_pattern() {
        assertEquals("PAHNAPLSIIGYIR", StringExtensions.zigzagConversion("PAYPALISHIRING", 3))
        assertEquals("PINALSIGYAHRPI", StringExtensions.zigzagConversion("PAYPALISHIRING", 4))
        assertEquals("AB", StringExtensions.zigzagConversion("AB", 1))
    }

    @Test
    fun myAtoi_test() {
        assertEquals(42, StringExtensions.myAtoi("42"))
        assertEquals(4193, StringExtensions.myAtoi("4193 with words"))
        assertEquals(0, StringExtensions.myAtoi("words and 987"))
        assertEquals(-2147483648, StringExtensions.myAtoi("-91283472332"))
    }

    @Test
    fun myAtoi_test2() {
        assertEquals(42, StringExtensions.myAtoi2("42"))
        assertEquals(4193, StringExtensions.myAtoi2("4193 with words"))
        assertEquals(0, StringExtensions.myAtoi2("words and 987"))
        assertEquals(-2147483648, StringExtensions.myAtoi2("-91283472332"))
    }

    @Test
    fun isMatch_OK() {
        assertEquals(false, StringExtensions.isMatch("aa", "a"))
        assertEquals(true, StringExtensions.isMatch("aa", "a*"))
        assertEquals(true, StringExtensions.isMatch("ab", ".*"))
        assertEquals(true, StringExtensions.isMatch("aab", "c*a*b"))
        assertEquals(false, StringExtensions.isMatch("mississippi", "mis*is*p*."))
        assertEquals(true, StringExtensions.isMatch("", ".*"))
    }

    @Test
    fun longestCommonPrefix_OK() {
        assertEquals("fl", StringExtensions.longestCommonPrefix(arrayOf("flower","flow","flight")))
        assertEquals("", StringExtensions.longestCommonPrefix(arrayOf("dog","racecar","car")))
        assertEquals("", StringExtensions.longestCommonPrefix(arrayOf("dog","dogcafe","car")))
    }

}