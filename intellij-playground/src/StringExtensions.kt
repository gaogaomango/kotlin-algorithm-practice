object StringExtensions {
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

    @JvmStatic
    val SHARPE = '#'

    fun longestPalindrome(s: String): String {
        val sharped = mutableListOf(SHARPE)
        for(ch in s){
            sharped.add(ch)
            sharped.add(SHARPE)
        }

        var mx = 0
        val ends = IntArray(sharped.size)
        var (m, r) = -1 to 0

        for(i in 0 until sharped.size){
            var j = i+1
            if(j < r){
                val pre = 2*m - i
                j = minOf(r,i + (ends[pre] - pre))
            }
            while(j < sharped.size && 2*i -j >=0 && sharped[2*i-j] == sharped[j])
                j ++
            ends[i] = j
            if(j - i > ends[mx] -mx)
                mx = i
            if(j > r){
                m = i
                r = j
            }
        }
        return sharped.slice(2*mx-ends[mx]+1 until ends[mx])
            .filter{ it != '#'}.joinToString("")
    }
}