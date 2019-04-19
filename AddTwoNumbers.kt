import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception

fun main(args:Array<String>){
        val li1 = ListNode(2).apply {
            this.next = ListNode(4)
        }.apply {
            this.next?.next = ListNode(3)
        }
        val li2 = ListNode(5).apply {
            this.next = ListNode(6)
        }.apply {
            this.next?.next = ListNode(4)
        }
        var expect = ListNode(7).apply {
            this.next = ListNode(0)
        }.apply {
            this.next?.next = ListNode(8)
        }

        var actual = TwoNumbers.addTwoNumbers(li1, li2)
        try {
            while (true) {
                if(expect.`val` == actual?.`val`){
                    if(expect.next == null && actual.next == null) {
                        break
                    } else if((expect.next != null && actual.next == null) || (expect.next == null && actual.next != null)){
                        throw Exception()
                    } else {
                        expect = expect.next!!
                        actual = actual.next
                    }
                }
            }
        } catch (e: Exception) {
            fail()
        }
        println("success")
        assertTrue(true)
}

object TwoNumbers {

    fun add(l: ListNode?, r: ListNode?): Int = (l?.`val` ?: 0) + (r?.`val` ?: 0)
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var curLeft = l1
        var curRight = l2
        var root: ListNode? = null
        var cur: ListNode? = null
        var carry = 0
        while(curLeft != null || curRight != null || carry > 0) {
            val added = add(curLeft, curRight) + carry
            carry = if (added > 9) 1 else 0
            val node = ListNode(added % 10)
            if(root == null) {
                root = node
                cur = node
            } else {
                cur?.next = node
                cur = node
            }
            curLeft = curLeft?.next
            curRight = curRight?.next
        }
        return root
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}