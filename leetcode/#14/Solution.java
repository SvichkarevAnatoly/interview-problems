// Longest Common Prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        
        String first = strs[0];
        String second = strs[1];
        
        String commonPrefix = "";
        for(int i = 0; i < minLength(first, second); i++) {
            if(first.charAt(i) == second.charAt(i)) {
                commonPrefix += first.charAt(i);
            } else {
                break;
            }
        }
        if(commonPrefix.equals("")) {
            return "";
        }
        
        String tmpCommonPrefix;
        for(int i = 2; i < strs.length; i++) {
            String curStr = strs[i];
            tmpCommonPrefix = "";
            for(int j = 0; j < minLength(curStr, commonPrefix); j++) {
                if(curStr.charAt(j) == commonPrefix.charAt(j)) {
                    tmpCommonPrefix += commonPrefix.charAt(j);
                } else {
                    break;
                }
            }
            commonPrefix = tmpCommonPrefix;
        }
        
        return commonPrefix;
    }
    
    private int minLength(String first, String second) {
        if(first.length() < second.length()) {
            return first.length();
        } else {
            return second.length();
        }
    }
}
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
*/
