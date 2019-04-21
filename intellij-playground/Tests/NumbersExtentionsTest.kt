import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class NumbersExtentionsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun findMedianSortedArrays() {
        assertEquals(2.0, NumbersExtentions.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)), 0.0)
        assertEquals(2.5, NumbersExtentions.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), 0.0)
        assertEquals(2.5, NumbersExtentions.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), 0.0)
    }
}