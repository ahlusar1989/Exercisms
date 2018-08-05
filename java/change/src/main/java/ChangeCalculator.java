import java.util.*;

public class ChangeCalculator {
    private List<Integer> givenCoins = new LinkedList<>();

    public ChangeCalculator(List<Integer> givenCoins) {
        this.givenCoins = givenCoins;
    }

    public List<Integer> computeMostEfficientChange(int givenTarget){
        if (givenTarget < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        if (givenTarget > 0 && givenTarget < this.givenCoins.get(0)) {
            throw new IllegalArgumentException("The total " + givenTarget + " cannot be represented in the given currency.");
        }
        if (givenTarget == 0) {
            return new LinkedList<>();
        }

        Map<Integer, List<Integer>> minimaCoins = new HashMap<>();

        for(int i = 0; i <= givenTarget; i++) {
            int currentAmount  = i;
            List<Integer> minimalForCurrentAmount =
                    this.givenCoins
                            .stream()
                            .filter(c -> c <= currentAmount)
                            .map(c -> addToList(c, minimaCoins.get(currentAmount - c)))
                            .filter(c -> c.stream().mapToInt(j -> j).sum() == currentAmount)
                            .sorted(Comparator.comparingInt(List :: size))
                            .findFirst()
                            .orElse(new LinkedList<Integer>());

            minimaCoins.put(currentAmount, minimalForCurrentAmount);
        }

        List<Integer> mostEfficientOutput = minimaCoins.get(givenTarget);

        if(mostEfficientOutput.size() == 0){
            throw new IllegalArgumentException("The total " + givenTarget + " cannot be represented in the given currency.");
        }
        return  mostEfficientOutput;
    }
    private static List<Integer> addToList(int currentCoin, List<Integer> coins) {
        List<Integer> newCoins = new LinkedList<>(coins);

        newCoins.add(0, currentCoin);
        return newCoins;
    }
}
