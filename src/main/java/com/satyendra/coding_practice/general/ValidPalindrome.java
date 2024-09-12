package general;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
        System.out.println(validPalindrome.isPalindrome(" "));
    }
    private boolean isPalindrome(String s) {
        s = removeNonAlphaNumeric(s);
        int n = s.length();
        if(n < 2) {
            return true;
        }
        int i = 0 , j = n-1;
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    private String removeNonAlphaNumeric(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        Integer.toString(123);
        return sb.toString().toLowerCase();
    }
}
