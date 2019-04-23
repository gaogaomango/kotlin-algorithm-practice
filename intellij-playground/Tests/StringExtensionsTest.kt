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

}