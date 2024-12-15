import java.util.ArrayList;

public class FitnessManager {
    private final User user;
    private final ArrayList<Exercise> exerciseLog;

    public FitnessManager(User user) {
        this.user = user;
        this.exerciseLog = new ArrayList<>();
    }

    public void logExercise(Exercise exercise) {
        exerciseLog.add(exercise);
    }

    public ArrayList<Exercise> getExerciseLog() {
        return exerciseLog;
    }

    public void updateWeight(double newWeight) {
        user.setCurrentWeight(newWeight);
    }

    public User getUser() {
        return user;
    }
}
