import java.util.stream.IntStream;

public class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String s = stringToVerify.replaceAll("-", "");

        return s.length() == 10 && IntStream.range(0, 9).allMatch(i -> Character.isDigit(s.charAt(i)))
                && (s.charAt(9) == 'X' || Character.isDigit(s.charAt(9)))
                && IntStream.range(0, 10).map(i -> parseX(s.charAt(i)) * (10 - i)).sum() % 11 == 0;
    }
    private int parseX(char ch){
        return (ch == 'X') ? 10 : (ch - '0');
    }
}
