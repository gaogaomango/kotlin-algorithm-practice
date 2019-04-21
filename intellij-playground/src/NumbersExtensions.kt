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
}