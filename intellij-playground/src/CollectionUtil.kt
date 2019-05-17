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

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
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
                if (l1?.`val` < l2?.`val`) {
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
        } // end of while

        return dummyHead?.next

//        var result: ListNode? = ListNode(0)
//        var tmpList1 = l1
//        var tmpList2 = l2
//        var head = tmpList1
//        head = head?.next
//        var bet: ListNode? = head
//
//        while(!(tmpList1 == null && tmpList2 == null)) {
//            if(tmpList2 != null) {
//                head?.next = tmpList2
//                head = head?.next
//            }
//            if(tmpList1 != null) {
//                head?.next = tmpList1
//                head = head?.next
//            }
//            tmpList1 = tmpList1?.next
//            tmpList2 = tmpList2?.next
//        }
//
//        return bet

//        while(tmpList1 != null && tmpList2 != null) {
//            if(tmpList1?.next!!.value <= tmpList2?.next!!.value) {
//                tmpResult?.next = ListNode(tmpList1?.next!!.value)
//                tmpList1 = tmpList1.next
//                tmpResult = tmpResult?.next
//            } else {
//                tmpResult?.next = ListNode(tmpList2?.next!!.value)
//                tmpResult = tmpResult?.next
//                tmpList2 = tmpList2.next
//            }
//        }
//
//        while (tmpList1?.next != null) {
//            tmpResult?.next = ListNode(tmpList1?.next!!.value)
//            tmpResult = tmpResult?.next
//            tmpList1 = tmpList1.next
//        }
//
//        while (tmpList2?.next != null) {
//            tmpResult?.next = ListNode(tmpList2?.next!!.value)
//            tmpResult = tmpResult?.next
//            tmpList2 = tmpList2.next
//        }
//
//        return result?.next
    }

}