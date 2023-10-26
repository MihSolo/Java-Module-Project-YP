import java.util.Scanner;

public class PersonCount {

    public int personCount(Scanner userInput) {
        int userCount;
        int cirklStep = 0;
        System.out.println("Привет! Будем платить сообща? Введи количество участников:");
        if (!userInput.hasNextInt()) {
            System.out.println("Пожалуйста, используйте только числа при вводе!!!");
            Scanner newInput = new Scanner(System.in);
            ++cirklStep;
            userCount = personCount(newInput);
        } else {
            userCount = userInput.nextInt();
        }
        if (userCount < 1) {
            System.out.println("Количество участников не может быть меньше одной персоны, попробуй снова…");
            ++cirklStep;
            userCount = personCount(userInput);
        } else if (userCount == 1) {
            if (cirklStep == 0) {
                System.out.println("Счёт будет рассчитан на одну персону.");
            }
            userCount = 1;
        }
        return userCount;
    }
}
