public class StrengthExercise extends Exercise {
    public StrengthExercise() {
        super("Strength Exercise", 5.0); // 5.0 calories burned per minute
    }

    @Override
    public double calculateCaloriesBurned(int duration) {
        return duration * caloriesBurnedPerMinute; // Calories burned = duration * rate per minute
    }
}
