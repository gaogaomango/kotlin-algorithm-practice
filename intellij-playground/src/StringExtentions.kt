object StringExtentions {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length <= 1) return s.length

        var result = 0
        var set = hashSetOf<Char>()
        var left = 0
        var right = 0

        while (right < s.length) {
            if(set.contains(s[right])) {
                set.remove(s[left])
                left++
            } else {
                set.add(s[right])
                right++
                result = Math.max(result, set.size)
            }
        }

        return result
    }
}