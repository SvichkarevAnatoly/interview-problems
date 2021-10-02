// Valid Parentheses
class Solution {
    public boolean isValid(String s) {
        Stack<Character> validationStack = new Stack<>();
        for(int i=0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            try {
                switch(bracket) {
                    case '(':
                    case '{':
                    case '[':
                        validationStack.push(bracket);
                        break;
                    case ')':
                        if(validationStack.pop() != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if(validationStack.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if(validationStack.pop() != '[') {
                            return false;
                        }
                        break;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return validationStack.isEmpty();
    }
}
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Example 5:
Input: s = "{[]}"
Output: true

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
