import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        StepTracker st = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
                //Ввести количество шагов за определённый день
                int monthEdit;
                int dayEdit;
                int stepsAmount;
                boolean isSuccessfullInput = true;
                do {
                    System.out.println("Input month");
                    monthEdit = scanner.nextInt();
                    System.out.println("Input day");
                    dayEdit = scanner.nextInt();
                    System.out.println("Input steps amount");
                    stepsAmount = scanner.nextInt();
                    if (monthEdit <= 0 || monthEdit > 12) {
                        System.out.println("month is incorrect.");
                        isSuccessfullInput = false;
                    }
                    if (dayEdit <= 0 || dayEdit > 30) {
                        System.out.println("day is incorrect.");
                        isSuccessfullInput = false;
                    }
                    if (stepsAmount < 0) {
                        System.out.println("Steps amount can't be negative.");
                        isSuccessfullInput = false;
                    }
                    if (!isSuccessfullInput)
                        System.out.println("Try again");
                } while (!isSuccessfullInput);
                st.stepsInput(monthEdit, dayEdit, stepsAmount);
            }
            else if (userInput == 2) {
                //Напечатать статистику за определённый месяц
                System.out.println("For which month? (1 - Jan, 2 - Feb, ...)");
                int statMonth = scanner.nextInt();
                st.printStats(statMonth - 1);
            }
            else if (userInput == 3) {
                //Изменить цель по количеству шагов в день
                boolean isSuccessInput = false;
                int newGoal;
                do {
                    System.out.println("Input new goal for steps per day");
                    newGoal = scanner.nextInt();
                    if (newGoal > 0) {
                        isSuccessInput = true;
                    }
                    else {
                        System.out.println("Incorrect input. Try again");
                        isSuccessInput = false;
                    }
                } while (!isSuccessInput);
                st.changeDailyGoal(newGoal);
            }
            else if (userInput == 0) {
                System.out.println("Bye!");
            }
            else
                System.out.println("Wrong input. Try again");

        } while (userInput != 0);
    }

    public static void printMenu() {
        System.out.println("\n");
        System.out.println("Press 1 - to input steps for a day");
        System.out.println("Press 2 - to print statistic for a month");
        System.out.println("Press 3 - to change daily steps goal");
        System.out.println("Press 0 - to exit");
    }

}



