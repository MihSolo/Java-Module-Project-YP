import java.util.Scanner;

public class PriceCalculator {
    boolean booleanMark = true;
    public String product;
    private final String finishInput = "Завершить";
    private String productList = "";
    double productPrice;
    private double finalSum;

    public void priceCalculator() {
        Scanner userInput = new Scanner(System.in);
        do {
            System.out.println("Пожалуйста введите название продукта:");
            product = userInput.next();
            setProduct(product);
            System.out.println("Пожалуйста введите цену продукта:");
            while (!userInput.hasNextDouble()) {
                System.out.println("Ошибка…попробуйте ещё раз!!!");
                userInput = new Scanner(System.in);
            }
            productPrice = userInput.nextDouble();
            while (productPrice < 0) {
                System.out.println("Цена не может быть меньше нуля…введите другую цену:");
                while (!userInput.hasNextDouble()) {
                    System.out.println("Ошибка…попробуйте ещё раз!!!");
                    userInput = new Scanner(System.in);
                }
                productPrice = userInput.nextDouble();
            }
            setPrice(productPrice);
            System.out.println("Хотите завершить ввод: \"Завершить\"/\"Продолжить\"");
            product = userInput.next();
        } while (booleanMark != (product.equalsIgnoreCase(finishInput)));
        System.out.println("Продукт был успешно добавлен!!!");
    }

    private void setProduct(String productName) {
        productList = productList.concat(productName);
        productList = productList.concat("\n");
    }

    private void setPrice(double productPrice) {
        finalSum += productPrice;
    }

    public String getProductList() {
        System.out.println("Список продутов:");
        return productList;
    }

    public double getFinalSum() {
        return finalSum;
    }

    public void onePersonPrice(double finalPrice, int personCount) {
        double personBill = finalPrice / personCount;
        System.out.println(getProductList());
        System.out.println(String.format("С каждого участника: %.2f", personBill));
        rub(personBill);
    }

    private void rub(double personBill) {
        int intValue = (int) Math.floor(personBill);
        int rubValue = intValue % 100;
        if (rubValue >= 11 && rubValue <= 19) {
            System.out.println("рублей");
        } else {
            switch (rubValue % 10) {
                case 1 -> System.out.println("рубль");
                case 2, 3, 4 -> System.out.println("рубля");
                default -> System.out.println("рублей");
            }
        }
    }
}
