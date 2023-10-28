import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int personCount = new PersonCount().personCount(userInput);
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.priceCalculator();
        double finalSumValue = priceCalculator.getFinalSum();
        priceCalculator.onePersonPrice(finalSumValue, personCount);
    }
}