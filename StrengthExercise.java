public class StrengthExercise extends Exercise {
    public StrengthExercise() {
        super("Strength Exercise", 5.0); // Average calories burned per minute for strength training
    }

    @Override
    public double calculateCaloriesBurned(int duration) {
        return duration * caloriesBurnedPerMinute;
    }
}
