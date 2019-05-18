import java.lang.StringBuilder
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

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

    fun zigzagConversion(s: String, numRows: Int): String {
        if(s.length <= 1 || s.length <= numRows || numRows == 1) return s
        val chars = CharArray(s.length)
        var k = 0
        for(i in 0 until numRows) {
            if(i == 0 || i == numRows -1) {
                for ( j in i until s.length step 2 * (numRows - 1)) {
                    chars[k++] = s[j]
                }
                continue
            }
            chars[k++] = s[i]
            for ( j in 2 * (numRows - 1) -i until s.length step 2 * (numRows - 1)) {
                chars[k++] = s[j]
                if(j + 2 * i < s.length) chars[k++] = s[j + 2 * i]
            }
        }

        return chars.joinToString("")
    }

    fun myAtoi(str: String): Int {
        if(str.isNullOrEmpty()) return 0
        val start = str.subSequence(findStart(str), str.length).toString()
        val subStr = start.subSequence(0, findEnd(start)).toString()

        val bigVal = if (subStr.isNotEmpty() && subStr != "-" && subStr != "+") BigInteger(subStr) else BigInteger("0")

        if(bigVal > BigInteger(Integer.MAX_VALUE.toString())) return Integer.MAX_VALUE
        if(bigVal < BigInteger(Integer.MIN_VALUE.toString())) return Integer.MIN_VALUE
        return bigVal.toInt()
    }

    private fun findStart(str: String): Int {
        var i = 0
        while(i < str.length) {
            if(!str[i].isWhitespace() || str[i] == '-' || str[i] == '+') return i
            i++
        }
        return str.length
    }

    private fun findEnd(str: String): Int {
        str.forEachIndexed { index, c ->
            if(!c.isDigit() && !((c == '-' || c == '+') && index == 0)) return index
        }
        return str.length
    }

    fun myAtoi2(str: String): Int {
        if(str.isNullOrEmpty()) return 0

        var isPlus = true
        var isFoundFirstNumber = false

        var startIndex = 0
        var endIndex = 0

        for(i in 0 until str.length) {
            val currentChar = str[i]
            if(isFoundFirstNumber) {
                if(currentChar.isDigit()) {
                    endIndex = i
                    isFoundFirstNumber = true
                } else if('.' == currentChar) {
                    break
                } else if(' ' == currentChar) {
                    break
                } else {
                    break
                }
            } else {
                if (currentChar.isDigit() || '+' == currentChar || '-' == currentChar) {
                    if ('-' == currentChar) {
                        isPlus = false
                    }
                    startIndex = i
                    endIndex = i
                    isFoundFirstNumber = true
                } else if (' ' == currentChar) {
                    continue
                } else {
                    return 0
                }
            }
        }
        if(!isFoundFirstNumber) {
            return 0
        }

        val resultStr = str.substring(startIndex, endIndex + 1)
        if(resultStr.length == 1 && ("-" == resultStr || "+" == resultStr)) return 0
        try {
            return Integer.parseInt(resultStr)
        } catch (e: NumberFormatException) {
            if(isPlus) return Integer.MAX_VALUE else return Integer.MIN_VALUE
        }
    }

    fun isMatch(s: String, p: String): Boolean {
        if(s == null || p == null) return false
        if(p.isEmpty()) return if (s.isEmpty()) s == p else false
        if(s.isNotEmpty() && !Regex("^[a-z]+$").matches(s)) return false
        if(!Regex("^([a-z]|\\*|\\.)+$").matches(p)) return false

        return Regex("^$p\$").matches(s)
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.isNullOrEmpty()) return ""
        if(strs.size == 1) return strs[0]
        strs.sort()

        for(i in strs[0].indices) {
            if(strs[0][i] != strs[strs.size - 1][i]) return strs[0].substring(0, i)
        }

        return strs[0]
    }

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return emptyList()

        val letterMap = hashMapOf(
            2 to listOf("a", "b", "c"),
            3 to listOf("d", "e", "f"),
            4 to listOf("g", "h", "i"),
            5 to listOf("j", "k", "l"),
            6 to listOf("m", "n", "o"),
            7 to listOf("p", "q", "r", "s"),
            8 to listOf("t", "u", "v"),
            9 to listOf("w", "x", "y", "z")
        )

        return digits
            .mapNotNull { letterMap[it.toString().toInt()] }
            .reduce{a, b ->
                a.flatMap { i ->
                    b.map { j ->
                        i + j
                    }
                }
            }
    }

    fun isValidBracketPair(s: String): Boolean {
        if(s.length % 2 != 0) return false
        val stackList = mutableListOf<Char>()
        s.forEach { charcter ->
            if(stackList.isEmpty()) {
                when (charcter) {
                    '(', '[', '{' -> stackList.add(charcter)
                    else -> return false
                }
            } else {
                when (charcter) {
                    '(', '[', '{' -> stackList.add(charcter)
                    ')' -> {
                        if(stackList.lastOrNull() == '(') {
                            stackList.removeAt(stackList.lastIndex)
                        } else {
                            return false
                        }
                    }
                    ']' -> {
                        if(stackList.lastOrNull() == '[') {
                            stackList.removeAt(stackList.lastIndex)
                        } else {
                            return false
                        }
                    }
                    '}' -> {
                        if(stackList.lastOrNull() == '{') {
                            stackList.removeAt(stackList.lastIndex)
                        } else {
                            return false
                        }
                    }
                }
            }
        }

        return stackList.isEmpty()
    }

    fun generateParenthesis(n: Int): List<String> {
        if(n == 0) return listOf()
        val insertString = "()"
        if(n == 1) return listOf(insertString)

        val result = mutableListOf<String>()
        for(str in generateParenthesis(n -1)) {
            for(i in 1..str.length) {
                val newStr = str.substring(0, i) + insertString + str.substring(i, str.length)
                result.add(newStr)
            }
        }

        return result.distinct()
    }
}