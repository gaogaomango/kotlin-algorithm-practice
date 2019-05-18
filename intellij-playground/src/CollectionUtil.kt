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

}