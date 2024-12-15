public class CardioExercise extends Exercise {
    public CardioExercise() {
        super("Cardio Exercise", 8.0); // 8.0 calories burned per minute
    }

    @Override
    public double calculateCaloriesBurned(int duration) {
        return duration * caloriesBurnedPerMinute; // Calories burned = duration * rate per minute
    }
}
