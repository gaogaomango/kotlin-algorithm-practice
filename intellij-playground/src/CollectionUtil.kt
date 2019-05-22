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
}