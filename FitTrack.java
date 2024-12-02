import java.util.Scanner;

public class FitTrack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        FitnessManager fitnessManager = new FitnessManager(user);

        System.out.println("Welcome to FitTrack: Your Personal Fitness Tracker!");

        // User Profile Setup
        System.out.print("Enter your name: ");
        user.setUserName(scanner.nextLine());
        System.out.print("Enter your current weight (kg): ");
        user.setCurrentWeight(scanner.nextDouble());
        System.out.print("Enter your target weight (kg): ");
        user.setTargetWeight(scanner.nextDouble());
        scanner.nextLine(); // consume leftover newline

        boolean running = true;
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Log Exercise");
            System.out.println("2. Update Weight");
            System.out.println("3. View Progress Summary");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    fitnessManager.logExercise(scanner);
                    break;
                case 2:
                    fitnessManager.updateWeight(scanner);
                    break;
                case 3:
                    fitnessManager.viewProgressSummary();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using FitTrack! Stay healthy!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
