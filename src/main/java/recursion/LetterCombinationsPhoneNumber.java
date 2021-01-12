package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsPhoneNumber lc = new LetterCombinationsPhoneNumber();
        String[] result = new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"};
        String digits = "23";
        System.out.println("expect: " + Arrays.toString(result) + " - got: " + lc.letterCombinations(digits));

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if (digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
        char firstChar = digits.charAt(0);
        String chars = mapper(firstChar);
        for (int c = 0; c < chars.length(); c++) {
            char firstCharOfChars = chars.charAt(c);
            result.add(firstCharOfChars+"");
        }

        if(digits.length()>0) {
            return recursion(result, digits.substring(1, digits.length()));
        }
        return result;
    }

    private String mapper(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    private List<String> recursion(List<String> incomingResult, String digits) {
        List<String> outgoingResult = new ArrayList<String>();
        if(digits!=null && digits.length()>0) {
            char firstChar = digits.charAt(0);
            String chars = mapper(firstChar);
            for (String entry : incomingResult
            ) {
                for (int c = 0; c < chars.length(); c++) {
                    char firstCharOfChars = chars.charAt(c);
                    String newEntry = entry + firstCharOfChars;
                    outgoingResult.add(newEntry);
                }

            }
            return recursion(outgoingResult, digits.substring(1, digits.length()));
        } else {
            return incomingResult;
        }
    }
}
