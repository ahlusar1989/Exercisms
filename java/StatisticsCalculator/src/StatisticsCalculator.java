import java.util.Scanner;

public class StatisticsCalculator {

    public static final String FEED_BACK = "Please enter a valid integer";

    public static void main(String[] args){
        Scanner client = new Scanner(System.in);
        //initialize array with size garnered from client
        double[] container = initializeArrayWithSize(client);
        // fill array with values garnered from client
        double[] filled = fillArray(client, container);

        //compute mean
        double mean = computeAverage(filled);
        //compute sigma
        double sigma = computeStandardDeviation(filled);

        System.out.printf("Mean: %.2f ",  mean);
        System.out.println();
        System.out.printf("Standard Deviation: %.2f ", sigma);
    }

    public static double computeAverage(double[] arr){
        double sum = 0;
        int count = arr.length;

        // prevent ZeroDivision Exception here
        if (count == 0) return 0;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return ((sum) / (count));
    }

    public static double computeStandardDeviation(double[] arr){
        double mean = computeAverage(arr);

        double sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum + (arr[i] - mean) * (arr[i] - mean);
        }
        double variance = (sum) / (arr.length);
        return (Math.sqrt(variance));
    }


    public static double[] fillArray(Scanner sc, double[] cons) {
        for(int i = 0; i < cons.length; i++) {
            System.out.println("Enter a value " + String.valueOf(i + 1) + ": ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println(FEED_BACK);
            }
            cons[i] = sc.nextInt();
        }
        return cons;
    }

    public static double[] initializeArrayWithSize(Scanner sc) {
        int totalNumOfInputs = 0;
        double[] container;
        System.out.println("How many values: ");
        while(!sc.hasNextInt()){
            sc.next();
            System.out.println(FEED_BACK);
        }
        totalNumOfInputs = sc.nextInt();
        container = new double[totalNumOfInputs];
        return container;
    }
}
