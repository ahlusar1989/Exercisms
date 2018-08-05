import org.jetbrains.annotations.Contract;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class BaseConverter {

    private int[] integerSequence = new int[]{};
    private int numInBase = 0;
    private final int fromBase;
    public BaseConverter(int numInBase, int[] integerSequence){
        if (numInBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }
        if (integerSequence.length > 0){
            for (int i = 0; i < integerSequence.length - 1; i ++){
                if (integerSequence[i] < 0){
                    throw new IllegalArgumentException("Digits may not be negative.");
                }
                if (integerSequence[i] >= numInBase){
                    throw new IllegalArgumentException("All digits must be strictly less than the base.");
                }
            }
        }
        this.integerSequence = integerSequence;
        this.numInBase = numInBase;
        this.fromBase = convertFromBase(numInBase, integerSequence);
    }

    @Contract(pure = true)
    private int convertFromBase(int from, int[] digits) {
        int fromBase = 0;

        for (int digit : digits) {
            fromBase = fromBase * from + digit;
        }
        return fromBase;
    }

    public int[] convertToBase(int baseToConvert) {
        List<Integer> result = new LinkedList<>();
        if (baseToConvert < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        if (this.integerSequence.length > 1 && this.integerSequence[0] == 0) {
            return new int[]{0};
        }

        if (this.integerSequence.length == 0) {
            return new int[]{0};
        }

        int remainder = this.fromBase;
        int multiplier = 1;
        while(remainder > 0) {
            multiplier *= baseToConvert;

            int valueOfDigit = remainder % multiplier;
            int digit = valueOfDigit / (multiplier / baseToConvert);

            result.add(digit);
            remainder -= valueOfDigit;
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
