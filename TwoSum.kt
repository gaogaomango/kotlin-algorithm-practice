class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(x in (0 until nums.size)) {
            if(map.containsKey(nums[x])) {
                map[nums[x]]?.let {
                    return intArrayOf(it, x)
                }
            }
            map[target - nums[x]] = x
        }
        return intArrayOf()
    }
}