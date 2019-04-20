import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StringExtentionsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun lengthOfLongestSubstring() {
        assertEquals(3, StringExtentions.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, StringExtentions.lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, StringExtentions.lengthOfLongestSubstring("pwwkew"))
        assertEquals(2, StringExtentions.lengthOfLongestSubstring("aab"))
        assertEquals(3, StringExtentions.lengthOfLongestSubstring("dvdf"))
    }

}