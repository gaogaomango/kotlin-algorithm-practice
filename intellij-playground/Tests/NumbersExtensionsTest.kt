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
}