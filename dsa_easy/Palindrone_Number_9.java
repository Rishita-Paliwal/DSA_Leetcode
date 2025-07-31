class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int pop = x % 10;
            reversedHalf = reversedHalf * 10 + pop;
            x /= 10;
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
