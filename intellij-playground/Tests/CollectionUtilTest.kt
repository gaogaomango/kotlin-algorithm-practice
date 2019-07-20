import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test

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

    @Test
    fun mergeKLists_OK() {
        val initialList1: ListNode? = ListNode(1)
        initialList1?.next = ListNode(4)
        initialList1?.next?.next = ListNode(5)

        val initialList2: ListNode? = ListNode(1)
        initialList2?.next = ListNode(3)
        initialList2?.next?.next = ListNode(4)

        val initialList3: ListNode? = ListNode(2)
        initialList3?.next = ListNode(6)

        val expectation = ListNode(1)
        expectation.next = ListNode(1)
        expectation.next?.next = ListNode(2)
        expectation.next?.next?.next = ListNode(3)
        expectation.next?.next?.next?.next = ListNode(4)
        expectation.next?.next?.next?.next?.next = ListNode(4)
        expectation.next?.next?.next?.next?.next?.next = ListNode(5)
        expectation.next?.next?.next?.next?.next?.next?.next = ListNode(6)

        val result = CollectionUtil.mergeKLists(arrayOf(initialList1, initialList2, initialList3))
        var tmpResult = result
        var tmpExpectation = expectation

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation.next!!
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }

    }

    @Test
    fun swapPairs_OK() {
        val inputNode: ListNode? = ListNode(1)
        inputNode?.next = ListNode(2)
        inputNode?.next?.next = ListNode(3)
        inputNode?.next?.next?.next = ListNode(4)

        val resultNode = CollectionUtil.swapPairs(inputNode)
        var tmpResult = resultNode
        var tmpExpectation: ListNode? = ListNode(2)
        tmpExpectation?.next = ListNode(1)
        tmpExpectation?.next?.next = ListNode(4)
        tmpExpectation?.next?.next?.next = ListNode(3)

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation?.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation!!.next!!
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }
    }

    @Test
    fun swapPairs2_OK() {
        val inputNode: ListNode? = ListNode(1)
        inputNode?.next = ListNode(2)
        inputNode?.next?.next = ListNode(3)
        inputNode?.next?.next?.next = ListNode(4)

        val resultNode = CollectionUtil.swapPairs2(inputNode)
        var tmpResult = resultNode
        var tmpExpectation: ListNode? = ListNode(2)
        tmpExpectation?.next = ListNode(1)
        tmpExpectation?.next?.next = ListNode(4)
        tmpExpectation?.next?.next?.next = ListNode(3)

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation?.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation!!.next!!
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }
    }

    @Test
    fun reverseKGroup_OK1() {
        val inputNode: ListNode? = ListNode(1)
        inputNode?.next = ListNode(2)
        inputNode?.next?.next = ListNode(3)
        inputNode?.next?.next?.next = ListNode(4)
        inputNode?.next?.next?.next?.next = ListNode(5)

        val resultNode = CollectionUtil.reverseKGroup(inputNode, 2)
        var tmpResult = resultNode
        var tmpExpectation: ListNode? = ListNode(2)
        tmpExpectation?.next = ListNode(1)
        tmpExpectation?.next?.next = ListNode(4)
        tmpExpectation?.next?.next?.next = ListNode(3)
        tmpExpectation?.next?.next?.next?.next = ListNode(5)

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation?.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation!!.next!!
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }
    }

    @Test
    fun reverseKGroup_OK2() {
        val inputNode: ListNode? = ListNode(1)
        inputNode?.next = ListNode(2)
        inputNode?.next?.next = ListNode(3)
        inputNode?.next?.next?.next = ListNode(4)
        inputNode?.next?.next?.next?.next = ListNode(5)

        val resultNode = CollectionUtil.reverseKGroup(inputNode, 3)
        var tmpResult = resultNode
        var tmpExpectation: ListNode? = ListNode(3)
        tmpExpectation?.next = ListNode(2)
        tmpExpectation?.next?.next = ListNode(1)
        tmpExpectation?.next?.next?.next = ListNode(4)
        tmpExpectation?.next?.next?.next?.next = ListNode(5)

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation?.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation!!.next!!
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }
    }

    @Test
    fun reverseKGroup2_OK1() {
        val inputNode: ListNode? = ListNode(1)
        inputNode?.next = ListNode(2)
        inputNode?.next?.next = ListNode(3)
        inputNode?.next?.next?.next = ListNode(4)
        inputNode?.next?.next?.next?.next = ListNode(5)

        val resultNode = CollectionUtil.reverseKGroup2(inputNode, 2)
        var tmpResult = resultNode
        var tmpExpectation: ListNode? = ListNode(2)
        tmpExpectation?.next = ListNode(1)
        tmpExpectation?.next?.next = ListNode(4)
        tmpExpectation?.next?.next?.next = ListNode(3)
        tmpExpectation?.next?.next?.next?.next = ListNode(5)

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation?.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation!!.next!!
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }
    }

    @Test
    fun reverseKGroup2_OK2() {
        val inputNode: ListNode? = ListNode(1)
        inputNode?.next = ListNode(2)
        inputNode?.next?.next = ListNode(3)
        inputNode?.next?.next?.next = ListNode(4)
        inputNode?.next?.next?.next?.next = ListNode(5)

        val resultNode = CollectionUtil.reverseKGroup2(inputNode, 3)
        var tmpResult = resultNode
        var tmpExpectation: ListNode? = ListNode(3)
        tmpExpectation?.next = ListNode(2)
        tmpExpectation?.next?.next = ListNode(1)
        tmpExpectation?.next?.next?.next = ListNode(4)
        tmpExpectation?.next?.next?.next?.next = ListNode(5)

        while (tmpResult?.next != null && tmpExpectation?.next != null) {
            assertEquals(tmpResult.next!!.value, tmpExpectation?.next!!.value)
            tmpResult = tmpResult.next
            tmpExpectation = tmpExpectation!!.next!!
        }
        if((tmpResult?.next == null && tmpExpectation?.next != null)
            || (tmpResult?.next != null && tmpExpectation?.next == null)) {
            fail("the size is not expectation size")
        }
    }

    @Test
    fun search_OK() {
        assertEquals(4, CollectionUtil.search(intArrayOf(4,5,6,7,0,1,2), 0))
        assertEquals(-1, CollectionUtil.search(intArrayOf(4,5,6,7,0,1,2), 3))
        assertEquals(-1, CollectionUtil.search(intArrayOf(1,3), 2))
    }

    @Test
    fun search2_OK() {
        assertEquals(4, CollectionUtil.search2(intArrayOf(4,5,6,7,0,1,2), 0))
        assertEquals(-1, CollectionUtil.search2(intArrayOf(4,5,6,7,0,1,2), 3))
        assertEquals(-1, CollectionUtil.search2(intArrayOf(1,3), 2))
    }

    @Test
    fun searchRange_OK() {
        isSameArray(intArrayOf(3, 4), CollectionUtil.searchRange(intArrayOf(5,7,7,8,8,10), 8))
        isSameArray(intArrayOf(-1, -1), CollectionUtil.searchRange(intArrayOf(5,7,7,8,8,10), 6))
        isSameArray(intArrayOf(0, 0), CollectionUtil.searchRange(intArrayOf(1), 1))
        isSameArray(intArrayOf(0, 1), CollectionUtil.searchRange(intArrayOf(2, 2), 2))
    }

    private fun isSameArray(expectationArray: IntArray, resultArray: IntArray) {
        expectationArray.sort()
        resultArray.sort()
        if(expectationArray.size != resultArray.size) {
            fail("expectation array doesn't have same size as result array")
        }
        for((index, value) in expectationArray.withIndex()) {
            assertEquals(value, resultArray[index])
        }
    }

    @Test
    fun searchInsertTest_OK() {
        assertEquals(2, CollectionUtil.searchInsert(intArrayOf(1,3,5,6), 5))
        assertEquals(1, CollectionUtil.searchInsert(intArrayOf(1,3,5,6), 2))
        assertEquals(4, CollectionUtil.searchInsert(intArrayOf(1,3,5,6), 7))
        assertEquals(0, CollectionUtil.searchInsert(intArrayOf(1,3,5,6), 0))
    }

    @Test
    fun isValidSudoku_OK() {
        assertEquals(true, CollectionUtil.isValidSudoku(arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        )))

        assertEquals(false, CollectionUtil.isValidSudoku(arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        )))
    }

    @Test
    fun isValidSudoku2_OK() {
        assertEquals(true, CollectionUtil.isValidSudoku2(arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        )))

        assertEquals(false, CollectionUtil.isValidSudoku2(arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        )))
    }}