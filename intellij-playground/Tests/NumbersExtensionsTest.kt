import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class NumbersExtensionsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun findMedianSortedArrays() {
        assertEquals(2.0, NumbersExtensions.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)), 0.0)
        assertEquals(2.5, NumbersExtensions.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), 0.0)
        assertEquals(2.5, NumbersExtensions.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), 0.0)
    }

    @Test
    fun test_reverseInt() {
        assertEquals(321, NumbersExtensions.reverseInt(123))
        assertEquals(-321, NumbersExtensions.reverseInt(-123))
        assertEquals(21, NumbersExtensions.reverseInt(120))
    }

    @Test
    fun test_reverseInt2() {
        assertEquals(321, NumbersExtensions.reverseInt2(123))
        assertEquals(-321, NumbersExtensions.reverseInt2(-123))
        assertEquals(21, NumbersExtensions.reverseInt2(120))
    }

    @Test
    fun isPalindrome_test() {
        assertEquals(true, NumbersExtensions.isPalindrome(121))
        assertEquals(false, NumbersExtensions.isPalindrome(-121))
        assertEquals(false, NumbersExtensions.isPalindrome(10))
    }

    @Test
    fun isPalindrome2_test() {
        assertEquals(true, NumbersExtensions.isPalindrome2(121))
        assertEquals(false, NumbersExtensions.isPalindrome2(-121))
        assertEquals(false, NumbersExtensions.isPalindrome2(10))
    }

    @Test
    fun maxArea_test() {
        assertEquals(49, NumbersExtensions.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    }

    @Test
    fun maxArea2_test() {
        assertEquals(49, NumbersExtensions.maxArea2(intArrayOf(1,8,6,2,5,4,8,3,7)))
    }

    @Test
    fun intToRoman_test() {
        assertEquals("III", NumbersExtensions.intToRoman(3))
        assertEquals("IV", NumbersExtensions.intToRoman(4))
        assertEquals("IX", NumbersExtensions.intToRoman(9))
        assertEquals("LVIII", NumbersExtensions.intToRoman(58))
        assertEquals("MCMXCIV", NumbersExtensions.intToRoman(1994))
        assertEquals("I", NumbersExtensions.intToRoman(1))
    }

    @Test
    fun romanToInt_test() {
        assertEquals(NumbersExtensions.romanToInt("III"), 3)
        assertEquals(NumbersExtensions.romanToInt("IV"), 4)
        assertEquals(NumbersExtensions.romanToInt("IX"), 9)
        assertEquals(NumbersExtensions.romanToInt("LVIII"), 58)
        assertEquals(NumbersExtensions.romanToInt("MCMXCIV"), 1994)
        assertEquals(NumbersExtensions.romanToInt("I"), 1)
    }
}