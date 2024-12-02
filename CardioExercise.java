public class CardioExercise extends Exercise {
    public CardioExercise() {
        super("Cardio Exercise", 8.0); // Average calories burned per minute for cardio
    }

    @Override
    public double calculateCaloriesBurned(int duration) {
        return duration * caloriesBurnedPerMinute;
    }
}
