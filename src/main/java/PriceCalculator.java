import java.util.Scanner;

public class PriceCalculator {

    boolean booleanMark = true;
   public String product; //userAnswer;
   private final String finishInput = "Завершить";
   private String productList = "";
   double productPrice;
   private double finalSum;


   PriceCalculator() {
       Scanner userInput = new Scanner(System.in);

       do{
           System.out.println("Please input product name.");
           product = userInput.next();
           setProduct(product);
               System.out.println("Please input product price.");
               productPrice = userInput.nextDouble();  //нет проверки на строку.....тут появится ошибка при вводе другого типа.....программа прерывает работу....
               while(productPrice < 0) {
                   System.out.println("That is not correct price value. Try again please:");
                   productPrice = userInput.nextDouble();
               }
           setPrice(productPrice);
           System.out.println("If You don't want to new product adds, write: \"Завершить\"/\"Продолжить\"");  //in here You can input different value for continue....
           product = userInput.next();
       }while(booleanMark != (product.equalsIgnoreCase(finishInput)));
       System.out.println("Products been added successfully!");
   }


   private void setProduct(String productName){
       productList = productList.concat(productName);
       productList  = productList.concat("\n" );
   }

   private void setPrice(double productPrice){
       finalSum+=productPrice;
   }

   public String getProductList(){
       System.out.println("Product list:");
       return productList;
   }

   public double getFinalSum(){
       return finalSum;
   }


   public void onePersonPrice(double finalPrice, int personCount){
     double personBill = finalPrice/personCount;
     System.out.println(getProductList());
     System.out.println(String.format("Your bill from one person: %.2f", personBill));   //String.format("%.2f", personBill));   personBill
     rub(personBill);
   }

   private void rub(double personBill){
    int intValue = (int)Double.parseDouble(String.format("%.2f", personBill));//(int)personBill;
    String convertToStr = Integer.toString(intValue);
       switch(convertToStr.charAt(convertToStr.length() - 1)) {
           case  '1' :  System.out.println("рубль");
               break;
           case '2':
           case '3':
           case '4':
               System.out.println("рубля");
               break;
           default : System.out.println("рублей");
               break;
       }
   }

}
