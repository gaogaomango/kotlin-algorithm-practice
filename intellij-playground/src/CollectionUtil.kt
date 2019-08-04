import java.util.*

object CollectionUtil {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head == null || n < 0) return null
        val start: ListNode? = ListNode(0)
        var slow = start
        var fast = start
        start?.next = head

        for(i in 0 until n) {
            fast = fast?.next
        }
        while(fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return start?.next
    }

    fun mergeTwoLists(_l1: ListNode?, _l2: ListNode?): ListNode? {
        var l1 = _l1
        var l2 = _l2

        if (l1 == null && l2 == null) return null
        if (l1 != null && l2 == null) return l1
        if (l1 == null && l2 != null) return l2

        var dummyHead: ListNode? = ListNode(0)
        var cur: ListNode? = dummyHead

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur?.next = l2
                cur = l2
                l2 = l2?.next
            }
            else if (l2 == null) {
                cur?.next = l1
                cur = l1
                l1 = l1?.next
            }
            else {
                if (l1?.value < l2?.value) {
                    cur?.next = l1
                    cur = l1
                    l1 = l1?.next
                }
                else {
                    cur?.next = l2
                    cur = l2
                    l2 = l2?.next
                }
            }
        }

        return dummyHead?.next
    }


    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.size == 0) return null
        if(lists.size == 1) return lists[0]

        return lists.fold(null){
                criteriaNode: ListNode?, nextNode: ListNode? ->

            var dummyHead: ListNode? = ListNode(0)
            var cur: ListNode? = dummyHead
            var l1: ListNode? = criteriaNode
            var l2: ListNode? = nextNode

            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    cur?.next = l2
                    cur = l2
                    l2 = l2?.next
                }
                else if (l2 == null) {
                    cur?.next = l1
                    cur = l1
                    l1 = l1?.next
                }
                else {
                    if (l1?.value < l2?.value) {
                        cur?.next = l1
                        cur = l1
                        l1 = l1?.next
                    }
                    else {
                        cur?.next = l2
                        cur = l2
                        l2 = l2?.next
                    }
                }
            }
            dummyHead?.next
        }
    }

    fun swapPairs(head: ListNode?): ListNode? {
        if(head == null) return null
        if(head.next == null) return head
        val seq = generateSequence(head){it.next}
        fun swapNode(node1: ListNode, node2: ListNode) {
            val tmp = node1.value
            node1.value = node2.value
            node2.value = tmp
        }

        seq.fold<ListNode, ListNode?>(null) { acc, listNode ->
            acc?.also {
                swapNode(acc, listNode)
            }
            if (acc == null) listNode else null
        }
        return head
    }

    fun swapPairs2(head: ListNode?): ListNode? {
        if(head == null) return null
        if(head.next == null) return head

        var late = head
        var fast = head.next

        late.next = fast!!.next
        fast!!.next = late

        late.next = swapPairs2(late.next)

        return fast
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if(k < 0) return head
        if(head == null) return head

        var num = k
        var first: ListNode? = head
        var last: ListNode? = head

        while(--num > 0 && last != null) {
            last = last.next
        }

        if(last != null) {
            var nextHead = last.next
            val stack = Stack<ListNode>()
            while(first != last) {
                stack.push(first)
                first = first!!.next
            }

            while(!stack.empty()) {
                last!!.next = stack.pop()
                last = last!!.next
            }

            last!!.next = reverseKGroup(nextHead, k)
        }

        return first
    }

    fun reverseKGroup2(head: ListNode?, k: Int): ListNode? {
        if(k < 0) return head
        if(head == null) return head

        var num = k
        var first: ListNode? = head
        var last: ListNode? = head

        while(--num > 0 && last != null) {
            last = last.next
        }

        if(last != null) {
            var nextHead = last.next
            val stackList = mutableListOf<ListNode?>()
            while(first != last) {
                stackList.add(first)
                first = first!!.next
            }

            while(stackList.isNotEmpty()) {
                last!!.next = stackList.removeAt(stackList.lastIndex)
                last = last!!.next
            }

            last!!.next = reverseKGroup(nextHead, k)
        }

        return first
    }

    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) return -1
        val minIndex = findMinIndex(nums)
        if(target == nums[minIndex]) return minIndex
        var low = if(target >= nums[0]) 0 else minIndex
        var high = if (target >= nums[nums.size - 1]) minIndex else nums.size - 1
        while (low < high) {
            val mid = (low + high) / 2
            if(nums[mid] == target) return mid
            else if (target > nums[mid]) low = mid - 1
            else high = mid
        }
        return if(nums[low] == target) low else -1
    }

    private fun findMinIndex(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1

        while(low < high) {
            val mid = (low + high) / 2
            if(nums[mid] > nums[high]) low = mid + 1 else high = mid
        }
        return low
    }

    fun search2(nums: IntArray, target: Int): Int {
        val pivot = pivotSearch(nums, 0, nums.size - 1)
        val leftResult = binarySearch(nums.sliceArray(0..pivot), target)
        if (leftResult != -1) {
            return leftResult
        }
        val rightResult = binarySearch(nums.sliceArray(pivot + 1 until nums.size), target)
        if (rightResult != -1) {
            return rightResult + pivot + 1
        }
        return -1
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val middle = (low + high) / 2
            when {
                nums[middle] == target -> return middle
                nums[middle] < target -> low = middle + 1
                nums[middle] > target -> high = middle - 1
            }
        }
        return -1
    }

    private fun pivotSearch(nums: IntArray, low: Int, high: Int): Int {
        if (high < low) {
            return -1
        }
        if (high == low) {
            return low
        }

        val mid = low + (high - low) / 2
        if (mid < high && nums[mid] > nums[mid + 1])
            return mid
        if (mid > low && nums[mid] < nums[mid - 1])
            return mid - 1
        return if (nums[low] >= nums[mid]) {
            pivotSearch(nums, low, mid - 1)
        } else {
            pivotSearch(nums, mid + 1, high)
        }
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if(nums == null || nums.isEmpty()) return return intArrayOf(-1, -1)
        lateinit var result: IntArray

        val index = binarySearch(nums, target)
        if(index == -1) {
            return intArrayOf(-1, -1)
        } else {
            var low = index
            while (low > 0 && nums[low - 1] == nums[index]) {
                low--
            }
            var high = index
            while (high < nums.size - 1 && nums[high + 1] == nums[index]) {
                high++
            }
            result = intArrayOf(low, high)
        }

        return result
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        if(nums == null || nums.isEmpty()) return 0
        var high = nums.size - 1
        var low = 0

        while(low <= high) {
            val mid = (high + low) / 2
            if(target == nums[mid]) {
                return mid
            } else if (target < nums[mid]) {
                high = mid - 1
            } else if (target > nums[mid]) {
                low = mid + 1
            }
        }

        return low
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val verticalCharMap = mutableListOf<MutableMap<Char, Int>>()
        for(i in board.indices) {
            verticalCharMap.add(mutableMapOf('1' to 0, '2' to 0, '3' to 0, '4' to 0, '5' to 0, '6' to 0, '7' to 0, '8' to 0, '9' to 0))
        }

        for(i in board.indices) {
            val checkMap = mutableMapOf('1' to 0, '2' to 0, '3' to 0, '4' to 0, '5' to 0, '6' to 0, '7' to 0, '8' to 0, '9' to 0)

            for(j in board[i].indices) {
                val charValue = board[i][j]
                if(charValue == '.') {
                    continue
                }
                // horizontal check
                when {
                    checkMap.containsKey(charValue) -> {
                        if(checkMap[charValue] != 0) {
                            return false
                        }
                        checkMap[charValue] = 1
                    }
                    else -> return false
                }

                // vertical check
                when {
                    verticalCharMap[i].containsKey(charValue) -> {
                        if(verticalCharMap[i][charValue] != 0) {
                            return false
                        }
                        verticalCharMap[i][charValue] = 1
                    }
                    else -> return false
                }
            }
        }

        return true
    }

    fun isValidSudoku2(board: Array<CharArray>): Boolean {
        val seen = hashSetOf<String>()
        for(i in board.indices) {
            for(j in board[i].indices) {
                val number = board[i][j]
                if(number != '.') {
                    if(!seen.add("$number in row $i") ||
                        !seen.add("$number in column $i") ||
                        !seen.add("$number in block ${i / 3}-${j-3}")) {
                        return false
                    }
                }
            }
        }

        return true
    }

    fun solveSudoku(board: Array<CharArray>): Unit {
        dfs(0, board)
    }

    fun dfs(pos: Int, board: Array<CharArray>): Boolean {
        if(pos == 81) {
            return true
        }

        val x = pos / 9
        val y = pos % 9
        if(board[x][y] == '.') {
            for(c in '1'..'9') {
                board[x][y] = c
                if(isValidSudoku(board, x, y) && dfs(pos + 1, board)) {
                    return true
                }
                board[x][y] = '.'
            }
        } else {
            return dfs(pos + 1, board)
        }
        return false
    }

    fun isValidSudoku(board: Array<CharArray>, x: Int, y: Int): Boolean {
        val c = board[x][y]
        val xx = x / 3 * 3
        val yy = y / 3 * 3  // (xx, yy) start of this block
        for (i in 0..8) {
            if (i != x && board[i][y] == c) return false
            if (i != y && board[x][i] == c) return false
            val tx = i / 3
            val ty = i % 3
            if (xx + tx != x && yy + ty != y && board[xx+tx][yy+ty] == c) {
                return false
            }
        }
        return true
    }

    fun insertionSort(items: MutableList<Int>): List<Int> {
        if(items.isEmpty() || items.size < 2)
            if(items.size <= 1) return items.toList()

        for(count in items.indices) {
            val item = items[count]
            var i = count
            while(i > 0 && item < items[i - 1]) {
                items[i] = items[i - 1]
                i--
            }
            items[i] = item
        }

        return items
    }

    fun heapSort(items: MutableList<Int>): List<Int> {
        heapify(items)
        var end = items.size - 1
        while(end > 0) {
            val temp = items[end]
            items[end] = items[0]
            items[0] = temp
            end--
            shiftDown(items, 0, end)
        }

        return items
    }

    fun heapify(items: MutableList<Int>) {
        var start = items.size /2
        while(start >= 0) {
            shiftDown(items, start, items.size -1)
            start--
        }
    }

    fun shiftDown(items: MutableList<Int>, start: Int, end: Int) {
        var root = start
        while(root * 2 + 1 <= end) {
            var child = root * 2 + 1
            if(child + 1 <= end && items[child] < items[child + 1]) child++
            if(items[root] < items[child]) {
                val temp = items[root]
                items[root] = items[child]
                items[child] = temp
                root = child
            }
            else return
        }
    }

    fun heapSort2(items: MutableList<Int>): List<Int> {
        buildMaxHeap(items)

        for(i in items.size - 1 downTo 1) {
            val temp = items[0]
            items[0] = items[i]
            items[i] = temp
            maxHeapify(items, 0, i -1)
        }

        println("sorted items: $items")

        return items
    }

    private fun buildMaxHeap(items: MutableList<Int>) {
        for(i in (items.size / 2) -1 downTo 0 ) {
            maxHeapify(items, i)
        }
    }

    private fun maxHeapify(items: MutableList<Int>, rootIndex: Int, heapSize: Int = items.size -1) {
        val leftChildIndex = (2 * rootIndex) + 1
        val rightChildIndex = (2 * rootIndex) + 2
        var largestElementIndex = rootIndex

        if(leftChildIndex <= heapSize && items[leftChildIndex] > items[rootIndex]) {
            largestElementIndex = leftChildIndex
        }

        if(rightChildIndex <= heapSize && items[rightChildIndex] > items[largestElementIndex]) {
            largestElementIndex = rightChildIndex
        }

        if(largestElementIndex != rootIndex) {
            val temp = items[rootIndex]
            items[rootIndex] = items[largestElementIndex]
            items[largestElementIndex] = temp
            maxHeapify(items, largestElementIndex, heapSize)
        }
    }

}
