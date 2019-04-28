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
}