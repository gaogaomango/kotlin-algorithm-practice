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

    @Test
    fun mergeTwoLists_OK() {
        val initialList1 = ListNode(1)
        initialList1.next = ListNode(2)
        initialList1.next?.next = ListNode(4)

        val initialList2 = ListNode(1)
        initialList2.next = ListNode(3)
        initialList2.next?.next = ListNode(4)

        val expectation: ListNode? = ListNode(1)
        expectation?.next = ListNode(1)
        expectation?.next?.next = ListNode(2)
        expectation?.next?.next?.next = ListNode(3)
        expectation?.next?.next?.next?.next = ListNode(4)
        expectation?.next?.next?.next?.next?.next = ListNode(4)

        val result = CollectionUtil.mergeTwoLists(initialList1, initialList2)
        var tmpResult = result
        var tmpExpectation = expectation

        println(tmpResult)
        println(tmpExpectation)

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