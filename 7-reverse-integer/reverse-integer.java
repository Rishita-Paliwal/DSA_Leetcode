class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;  // get last digit
            x /= 10;           // remove last digit

            // Check for overflow before it happens:
            if (rev > Integer.MAX_VALUE / 10 || 
               (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || 
               (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;  // add the digit
        }

        return rev;
    }
}
