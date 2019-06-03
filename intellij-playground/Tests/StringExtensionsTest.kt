import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

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

    @Test
    fun letterCombinations_OK() {
        val result = StringExtensions.letterCombinations("23")
        val sortedList = result.sorted()
        val expectation = listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf").sorted()
        if(sortedList.size != expectation.size) {
            fail("size is not same")
        }
        for((index, value) in sortedList.withIndex()) {
            assertEquals(value, expectation[index])
        }
    }

    @Test
    fun isValidBracketPair_OK() {
        assertEquals(true, StringExtensions.isValidBracketPair("()"))
        assertEquals(true, StringExtensions.isValidBracketPair("()[]{}"))
        assertEquals(false, StringExtensions.isValidBracketPair("(]"))
        assertEquals(false, StringExtensions.isValidBracketPair("([)]"))
        assertEquals(false, StringExtensions.isValidBracketPair("["))
    }

    @Test
    fun generateParenthesis_OK() {
        val expectation = listOf(  "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()")
        val result = StringExtensions.generateParenthesis(3)
        val sortedResult = result.sortedBy { it[1] }.sortedBy { it[2] }.sortedBy { it[3] }
        val sortedExpectation = expectation.sortedBy { it[1] }.sortedBy { it[2] }.sortedBy { it[3] }
        println(sortedResult)
        println(sortedExpectation)
        if(sortedExpectation.size != sortedResult.size) {
            fail("size is not same as expectation")
        }
        for((i, v) in sortedResult.withIndex()) {
            assertEquals(sortedExpectation[i], v)
        }

    }

    @Test
    fun strStr_OK() {
        assertEquals(2, StringExtensions.strStr("hello", "ll"))
        assertEquals(-1, StringExtensions.strStr("aaaaa", "bba"))
    }

    @Test
    fun findSubstring_OK() {
        val result = StringExtensions.findSubstring("barfoothefoobarman", arrayOf("foo","bar"))
        val expectation = listOf(0, 9)
        checkIsSameList(result, expectation)

        val result2 = StringExtensions.findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","word"))
        val expectation2 = listOf<Int>()
        checkIsSameList(result2, expectation2)

        val result3 = StringExtensions.findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","good"))
        val expectation3 = listOf(8)
        checkIsSameList(result3, expectation3)

    }

    private  fun checkIsSameList(result: List<Int>, expectation: List<Int>) {
        if(result.size != expectation.size) {
            print("result: ")
            result.forEach {
                print(" $it")
            }
            println()
            print("expectation: ")
            expectation.forEach {
                print(" $it")
            }

            fail("list size is not same. ")
        }
        for((index, value) in result.withIndex()) {
            if(value != expectation[index]) {
                fail("element is not expected")
            }
        }
    }

}