public abstract class Exercise {
    protected String exerciseName;
    protected double caloriesBurnedPerMinute;

    public Exercise(String exerciseName, double caloriesBurnedPerMinute) {
        this.exerciseName = exerciseName;
        this.caloriesBurnedPerMinute = caloriesBurnedPerMinute;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public abstract double calculateCaloriesBurned(int duration);
}
