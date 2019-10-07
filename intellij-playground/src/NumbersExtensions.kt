object NumbersExtensions {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val sortedNums = nums1.plus(nums2).sorted()
        val mid = sortedNums.size / 2

        return if (sortedNums.size % 2 == 0) {
            (sortedNums[mid] + sortedNums[mid - 1]).toDouble() / 2
        } else {
            sortedNums[mid].toDouble()
        }

    }

    fun reverseInt(x: Int): Int {
        val xStr = x.toString()
        val list = mutableListOf<Char>()
        var isNegative = false
        var lastInt = 0
        var reverseInt: Int

        if (xStr[0] == '-') {
            isNegative = true
            lastInt = 1
        }

        for (i in xStr.length - 1 downTo lastInt) {
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

        if (len % 2 == 0) {
            for (i in 0 until len / 2) {
                if (xStr[i] == xStr[len - 1 - i]) continue else return false
            }
        } else {
            for (i in 0 until len / 2 + 1) {
                if (xStr[i] == xStr[len - 1 - i]) continue else return false
            }
        }

        return true
    }

    fun isPalindrome2(x: Int): Boolean {
        val xStr = x.toString()
        return xStr == xStr.reversed()
    }

    fun maxArea(height: IntArray): Int {
        if (height.isEmpty()) return 0
        if (height == null) return 0

        var result = 0
        var tmpResult = 0
        var leftPos = 0
        var rightPos = height.size - 1
        var leftHeight = 0
        var rightHeight = 0

        while (leftPos < rightPos) {
            leftHeight = height[leftPos]
            rightHeight = height[rightPos]

            if (leftHeight >= rightHeight) {
                tmpResult = (rightPos - leftPos) * rightHeight
                rightPos--
            } else {
                tmpResult = (rightPos - leftPos) * leftHeight
                leftPos++
            }
            result = if (tmpResult > result) tmpResult else result
        }

        return result
    }

    fun maxArea2(height: IntArray): Int {
        if (height.isEmpty()) return 0
        if (height == null) return 0

        var leftPos = 0
        var rightPos = height.size - 1
        var result = 0

        while (leftPos < rightPos) {
            result = Math.max(result, (rightPos - leftPos) * Math.min(height[leftPos], height[rightPos]))
            if (height[leftPos] < height[rightPos]) leftPos++ else rightPos--
        }

        return result
    }

    fun intToRoman(num: Int): String {
        when (num) {
            !in 1..3999 -> return ""
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
        if (num >= devideNumber) {
            repeat(num / devideNumber) { sb.append(addLetter) }
            return num % devideNumber
        }
        return num
    }

    fun romanToInt(s: String): Int {
        var tmpS = s
        tmpS = tmpS.replace("CM".toRegex(), "CCCCCCCCC")
        tmpS = tmpS.replace("CM".toRegex(), "DCCCC")
        tmpS = tmpS.replace("CD".toRegex(), "CCCC")
        tmpS = tmpS.replace("XC".toRegex(), "XXXXXXXXX")
        tmpS = tmpS.replace("XC".toRegex(), "LXXXX")
        tmpS = tmpS.replace("XL".toRegex(), "XXXX")
        tmpS = tmpS.replace("IX".toRegex(), "IIIIIIIII")
        tmpS = tmpS.replace("IX".toRegex(), "VIIII")
        tmpS = tmpS.replace("IV".toRegex(), "IIII")

        println("tmpS: $tmpS")

        var total = 0
        tmpS.forEach {
            when (it) {
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

    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans: MutableList<List<Int>> = mutableListOf()
        if (nums.isEmpty()) return ans
        if (nums.size < 3) return ans
        nums.sort()
        for (i in nums.indices) {
            if (i != 0 && nums[i] == nums[i - 1]) continue
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    ans.add(listOf(nums[i], nums[j++], nums[k--]))
                    while (j < k && nums[j] == nums[j - 1]) j++
                    while (j < k && nums[k] == nums[k + 1]) k--
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k--
                } else {
                    j++
                }
            }
        }
        return ans
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var ans = 0L
        nums.sort()
        var minDiff = Integer.MAX_VALUE
        for (i in 0..(nums.size - 2)) {
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                var curSum = nums[i] + nums[j] + nums[k]
                if (curSum == target) {
                    return curSum
                } else if (curSum < target) {
                    j++
                } else {
                    k--
                }
                if (minDiff > Math.abs(curSum - target)) {
                    minDiff = Math.abs(curSum - target)
                    ans = curSum.toLong()
                }
            }
        }
        return ans.toInt()
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if(nums.isEmpty() || nums.size < 4) return emptyList()
        val result = mutableSetOf<List<Int>>()
        nums.sort()
        var i = 0
        var j = 0
        var k = 0
        var l = 0

        for (i in 0..nums.size -3) {
            j = i + 1
            for(j in i+1..nums.size - 2) {
                k = j + 1
                l = nums.lastIndex
                while(k < l) {
                    var tmpResult = nums[i] + nums[j] + nums[k] + nums[l] - target
                    if(tmpResult == 0) {
                        result.add(listOf(nums[i], nums[j], nums[k], nums[l]))
                        k++
                        l--
                    } else if(tmpResult > 0) {
                        l--
                    } else {
                        k++
                    }
                }
            }
        }
        return result.toList()
    }

    fun removeDuplicates(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        var i = 0
        for(j in 1 until nums.size) {
            if(nums[j] != nums[i]) {
                i++
                nums[i] = nums[j]
            }
        }
        return i + 1
    }

    fun removeElement(nums: IntArray, `val`: Int): Int {
        if(nums.isEmpty()) return 0
        if(nums.size == 1 && nums[0] == `val`) return 0

        nums.sort()
        var fast = 0
        var last = nums.lastIndex

        while(fast <= last) {
            while(fast < last && nums[last] == `val`) {
                last--
            }
            if(nums[fast] == `val`) {
                nums[fast] = nums[last]
                last--
            }
            fast++
        }

        return last + 1
    }

    fun divide(dividend: Int, divisor: Int): Int {
        val arr = mutableListOf<Long>()
        var remain = Math.abs(dividend.toLong())
        var value = Math.abs(divisor.toLong())

        while (value <= remain) {
            arr.add(value)
            value = value shl 1
        }

        var res = 0.toLong()
        var e = arr.size

        while (e > 0 && remain != 0.toLong()) {
            val (index, _) = binarySearch(remain, arr.toTypedArray(), 0, e)
            if (index >= 0) {
                res += 1.toLong() shl index
                remain -= arr[index]
            }
            e = index
        }
        if (dividend or divisor < 0 && dividend and divisor >= 0) {
            res = -res
        }
        return Math.min(Math.max(res, Integer.MIN_VALUE.toLong()), Integer.MAX_VALUE.toLong()).toInt()
    }

    private fun <T: Comparable<T>> binarySearch(pivot: T, arr: Array<T>, start: Int = 0, end: Int = arr.size): Pair<Int, Int> {
        var s = start
        var e = end

        while (s + 1 < e) {
            val mid = ((e - s) shr 1) + s
            if (pivot < arr[mid]) {
                e = mid
            } else if (pivot > arr[mid]) {
                s = mid
            } else {
                return mid to 0
            }
        }
        if (arr[s] > pivot) {
            s = -1
        }
        return s to -1
    }

    fun nextPermutation(nums: IntArray) {
        var i = nums.size - 2
        while(i >= 0) {
            if(nums[i] < nums[i + 1])
                break
            i--
        }

        if(i == -1) {
            nums.reverse()
            return
        }
        var index = nums.reverseBinarySearchFirstGreater(nums[i], i + 1)
        nums[i] = nums[index].also { nums[index] = nums[i] }
        nums.reverse(i + 1)
    }

    private inline fun IntArray.reverseBinarySearchFirstGreater(element: Int, fromIndex: Int = 0, toIndex: Int = size): Int {
        var low = toIndex - 1
        var high = fromIndex

        while(low > high) {
            val mid = (low + high + 1) shr  1
            val midVal = this[mid]

            if(midVal <= element)
                low = mid - 1
            else
                high = mid
        }
        return low
    }

    private inline fun IntArray.reverse(fromIndex: Int = 0, toIndex: Int = size) {
        val lastIndex = toIndex - 1
        val midTimes2 = fromIndex + lastIndex
        val mid = (midTimes2 + 1) shr 1
        for (i in fromIndex until mid) {
            val j = midTimes2 - i
            this[i] = this[j].also { this[j] = this[i] }
        }
    }

    fun countAndSay(n: Int): String {
        var result = "1"
        var sb: StringBuilder
        for(i in 2..n) {
            var index = 0
            sb = StringBuilder()
            while(index < result.length) {
                val current = result[index]
                var count = 1
                while(index < result.length - 1 && result[index] == result[index + 1]) {
                    count++
                    index++
                }
                sb.append(count).append(current)
                index++
            }
            result = sb.toString()
        }

        return result
    }

}