import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PangramChecker {

    public boolean isPangram(String input) {
        HashSet<Character> words = new HashSet();
        boolean isPangram = true;
        try{
            String[] split = input
                    .replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase().split("\\s+");

        String joined =  String.join("", split);
        for(int i = 0; i < joined.length(); i++){
            words.add(joined.charAt(i));
        }
        if(words.size() < 26){
            isPangram = false;
        }

        } catch(Exception e){
            System.out.println("Error when parsing string");
        }
        return isPangram;
    }
}
