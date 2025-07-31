import java.util.ArrayList;
import java.util.List;

class Solution {
    String keys[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        } else {
            return helper(digits);
        }
    }

    public List<String> helper(String digits) {
        if (digits.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        List<String> result = new ArrayList<>();

        char firstDigit = digits.charAt(0);
        String restOfDigits = digits.substring(1);

        List<String> combinationsForRest = helper(restOfDigits);
        String possibleChars = keys[firstDigit - '0'];

        for (char ch : possibleChars.toCharArray()) {
            for (String s : combinationsForRest) {
                result.add(ch + s); // Correct concatenation
            }
        }

        return result;
    }
}
