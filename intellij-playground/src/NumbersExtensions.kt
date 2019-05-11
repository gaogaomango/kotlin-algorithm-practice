import java.lang.StringBuilder

object NumbersExtensions {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val sortedNums = nums1.plus(nums2).sorted()
        val mid = sortedNums.size / 2

        return if(sortedNums.size % 2 == 0) {
            (sortedNums[mid] + sortedNums[mid - 1]).toDouble() / 2
        } else {
            sortedNums[mid].toDouble()
        }

    }

    fun reverseInt(x: Int) : Int {
        val xStr = x.toString()
        val list = mutableListOf<Char>()
        var isNegative = false
        var lastInt = 0
        var reverseInt: Int

        if(xStr[0] == '-') {
            isNegative = true
            lastInt = 1
        }

        for(i in xStr.length - 1 downTo lastInt) {
            list.add(xStr[i])
        }

        try {
            val reverseIntStr = list.map { it.toString() }.joinToString("")
            reverseInt = if (isNegative) -1 * (reverseIntStr).toInt() else reverseIntStr.toInt()
        } catch (e: NumberFormatException) {
            reverseInt = 0
        }

        return reverseInt
    }

    fun reverseInt2(x: Int): Int {
        val rs = Math.abs(x).toString().reversed()
        return (rs.toIntOrNull() ?: 0) * if (x < 0) -1 else 1
    }

    fun isPalindrome(x: Int): Boolean {
        val xStr = x.toString()
        val len = xStr.length

        if(len % 2 == 0) {
            for(i in 0 until len / 2) {
                if(xStr[i] == xStr[len - 1 - i]) continue else return false
            }
        } else {
            for(i in 0 until len / 2 + 1) {
                if(xStr[i] == xStr[len - 1 - i]) continue else return false
            }
        }

        return true
    }

    fun isPalindrome2(x: Int): Boolean {
        val xStr = x.toString()
        return xStr == xStr.reversed()
    }

    fun maxArea(height: IntArray): Int {
        if(height.isEmpty()) return 0
        if(height == null) return 0

        var result = 0
        var tmpResult = 0
        var leftPos = 0
        var rightPos = height.size - 1
        var leftHeight = 0
        var rightHeight = 0

        while(leftPos < rightPos) {
            leftHeight = height[leftPos]
            rightHeight = height[rightPos]

            if(leftHeight >= rightHeight) {
                tmpResult = (rightPos - leftPos) * rightHeight
                rightPos--
            } else {
                tmpResult = (rightPos - leftPos) * leftHeight
                leftPos++
            }
            result = if(tmpResult > result) tmpResult else result
        }

        return result
    }

    fun maxArea2(height: IntArray): Int {
        if(height.isEmpty()) return 0
        if(height == null) return 0

        var leftPos = 0
        var rightPos = height.size - 1
        var result = 0

        while(leftPos < rightPos) {
            result = Math.max(result, (rightPos - leftPos) * Math.min(height[leftPos], height[rightPos]))
            if(height[leftPos] < height[rightPos]) leftPos++ else rightPos--
        }

        return result
    }

    fun intToRoman(num: Int): String {
        when(num) {
            !in 1 .. 3999 -> return ""
        }
        val sb = StringBuilder()
        var tmpNum = num

        tmpNum = addRoman(sb, tmpNum, 1000, "M")
        tmpNum = addRoman(sb, tmpNum, 500, "D")
        tmpNum = addRoman(sb, tmpNum, 100, "C")
        tmpNum = addRoman(sb, tmpNum, 50, "L")
        tmpNum = addRoman(sb, tmpNum, 10, "X")
        tmpNum = addRoman(sb, tmpNum, 5, "V")
        tmpNum = addRoman(sb, tmpNum, 1, "I")

        var result = sb.toString()

        result = result.replace("CCCCCCCCC".toRegex(), "CM")
        result = result.replace("DCCCC".toRegex(), "CM")
        result = result.replace("CCCC".toRegex(), "CD")
        result = result.replace("XXXXXXXXX".toRegex(), "XC")
        result = result.replace("LXXXX".toRegex(), "XC")
        result = result.replace("XXXX".toRegex(), "XL")
        result = result.replace("IIIIIIIII".toRegex(), "IX")
        result = result.replace("VIIII".toRegex(), "IX")
        result = result.replace("IIII".toRegex(), "IV")

        return result
    }

    private fun addRoman(sb: StringBuilder, num: Int, devideNumber: Int, addLetter: String): Int {
        if(num >= devideNumber) {
            repeat(num / devideNumber) {sb.append(addLetter)}
            return num % devideNumber
        }
        return num
    }

    fun romanToInt(s: String): Int {
        var tmpS = s
        tmpS = tmpS.replace( "CM".toRegex(), "CCCCCCCCC")
        tmpS = tmpS.replace( "CM".toRegex(), "DCCCC")
        tmpS = tmpS.replace( "CD".toRegex(), "CCCC")
        tmpS = tmpS.replace( "XC".toRegex(), "XXXXXXXXX")
        tmpS = tmpS.replace( "XC".toRegex(), "LXXXX")
        tmpS = tmpS.replace( "XL".toRegex(), "XXXX")
        tmpS = tmpS.replace( "IX".toRegex(), "IIIIIIIII")
        tmpS = tmpS.replace( "IX".toRegex(), "VIIII")
        tmpS = tmpS.replace( "IV".toRegex(), "IIII")

        println("tmpS: $tmpS")

        var total = 0
        tmpS.forEach {
            when(it) {
                'I' -> total += 1
                'V' -> total += 5
                'X' -> total += 10
                'L' -> total += 50
                'C' -> total += 100
                'D' -> total += 500
                'M' -> total += 1000
            }
        }

        return total
    }
}