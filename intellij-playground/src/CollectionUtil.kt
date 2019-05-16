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
}