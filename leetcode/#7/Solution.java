class Solution {
    public int reverse(int x) {
        int result = 0;
        int digit;
        while(x != 0) {
            // digit always saves x sign, so we don't need to check it
            digit = x % 10;
            x /= 10;
            
            // -2^31 ends with 8 because last digit of powers of 2 repeats: 2,4,8,2,...,
            // so every 2^4 we got 2 at the end.
            // So MIN_VALUE ends with 8, because 31 % 4 == 3.
            // MAX_VALUE ends with 7, because it is 2^31-1
            if(result > Integer.MAX_VALUE/10 || 
              (result == Integer.MAX_VALUE/10 && digit > 7)) {
                return 0;
            }
            if(result < Integer.MIN_VALUE/10 ||
              (result == Integer.MIN_VALUE/10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        return result;
    }
}
