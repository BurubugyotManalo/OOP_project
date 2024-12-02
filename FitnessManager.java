import java.util.ArrayList;
import java.util.Scanner;

public class FitnessManager {
    private final User user;
    private final ArrayList<Exercise> exerciseLog;

    public FitnessManager(User user) {
        this.user = user;
        this.exerciseLog = new ArrayList<>();
    }

    public void logExercise(Scanner scanner) {
        System.out.println("Select Exercise Type:");
        System.out.println("1. Cardio Exercise");
        System.out.println("2. Strength Exercise");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        Exercise exercise;
        if (choice == 1) {
            exercise = new CardioExercise();
        } else if (choice == 2) {
            exercise = new StrengthExercise();
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
            return;
        }

        System.out.print("Enter duration (in minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        double caloriesBurned = exercise.calculateCaloriesBurned(duration);
        exerciseLog.add(exercise);
        System.out.printf("You burned %.2f calories during this session.\n", caloriesBurned);
    }

    public void updateWeight(Scanner scanner) {
        System.out.print("Enter your new weight (kg): ");
        double newWeight = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline
        user.setCurrentWeight(newWeight);
        System.out.println("Weight updated successfully!");
    }

    public void viewProgressSummary() {
        System.out.printf("User: %s\n", user.getUserName());
        System.out.printf("Current Weight: %.2f kg\n", user.getCurrentWeight());
        System.out.printf("Target Weight: %.2f kg\n", user.getTargetWeight());

        if (!exerciseLog.isEmpty()) {
            System.out.println("Logged Exercises:");
            for (Exercise exercise : exerciseLog) {
                System.out.printf("- %s\n", exercise.exerciseName);
            }
        } else {
            System.out.println("No exercises logged yet.");
        }

        double weightLost = user.getTargetWeight() - user.getCurrentWeight();
        System.out.printf("Weight Lost So Far: %.2f kg\n", Math.abs(weightLost));
    }
}
