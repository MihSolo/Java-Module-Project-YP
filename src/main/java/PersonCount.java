import java.util.Scanner;

public class PersonCount {


    //    private void requestToUser(){
//        System.out.println("Hello! How many person will divided this bill?");
//    }

    public int personCount(Scanner userInput) {
        // requestToUser();
        System.out.println("Hello! How many person will divided this bill?");
        int userCount = userInput.nextInt();
        if(userCount < 1){
            System.out.println("That is wrong person count, please try again!");
            userCount = personCount(userInput);
        }else if(userCount == 1){
            System.out.println("Please, pay Your bill. Person count:" + userCount);
            return userCount;
        }
        return userCount;
    }

}
