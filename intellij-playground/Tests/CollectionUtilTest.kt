import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CollectionUtilTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun removeNthFromEnd_OK() {
        val initialList = ListNode(1)
        initialList.next = ListNode(2)
        initialList.next?.next = ListNode(3)
        initialList.next?.next?.next = ListNode(4)
        initialList.next?.next?.next?.next = ListNode(5)

        val expectation: ListNode? = ListNode(1)
        expectation?.next = ListNode(2)
        expectation?.next?.next = ListNode(3)
        expectation?.next?.next?.next = ListNode(5)

        val result = CollectionUtil.removeNthFromEnd(initialList, 2)
        var tmpResult = result
        var tmpExpectation = expectation

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation.next
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }
    }
}