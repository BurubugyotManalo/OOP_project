import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FitTrackGUI {
    private JFrame frame;
    private User user;
    private FitnessManager fitnessManager;
    private JTextArea progressSummaryArea;

    public FitTrackGUI() {
        user = new User();
        fitnessManager = new FitnessManager(user);

        frame = new JFrame("FitTrack: Your Personal Fitness Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("FitTrack: Your Personal Fitness Tracker", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(headerLabel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton logExerciseButton = new JButton("Log Exercise");
        JButton updateWeightButton = new JButton("Update Weight");
        JButton viewProgressButton = new JButton("View Progress");
        JButton exitButton = new JButton("Exit");

        menuPanel.add(logExerciseButton);
        menuPanel.add(updateWeightButton);
        menuPanel.add(viewProgressButton);
        menuPanel.add(exitButton);

        frame.add(menuPanel, BorderLayout.WEST);

        progressSummaryArea = new JTextArea();
        progressSummaryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(progressSummaryArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        logExerciseButton.addActionListener(_ -> logExercise());
        updateWeightButton.addActionListener(_ -> updateWeight());
        viewProgressButton.addActionListener(_ -> viewProgress());
        exitButton.addActionListener(_ -> System.exit(0));

        frame.setVisible(true);
        showUserSetupDialog();
    }

    private void showUserSetupDialog() {
        String name = JOptionPane.showInputDialog(frame, "Enter your name:", "User Setup",
                JOptionPane.QUESTION_MESSAGE);
        user.setUserName(name);

        double currentWeight = Double
                .parseDouble(JOptionPane.showInputDialog(frame, "Enter your current weight (kg):"));
        user.setCurrentWeight(currentWeight);

        double targetWeight = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter your target weight (kg):"));
        user.setTargetWeight(targetWeight);

        JOptionPane.showMessageDialog(frame, "User setup complete!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    private void logExercise() {
        String[] exerciseOptions = { "Cardio Exercise", "Strength Exercise" };
        String choice = (String) JOptionPane.showInputDialog(
                frame,
                "Select Exercise Type:",
                "Log Exercise",
                JOptionPane.QUESTION_MESSAGE,
                null,
                exerciseOptions,
                exerciseOptions[0]);

        if (choice == null)
            return;

        int duration = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter duration (in minutes):"));

        Exercise exercise = choice.equals("Cardio Exercise") ? new CardioExercise() : new StrengthExercise();
        double caloriesBurned = exercise.calculateCaloriesBurned(duration);
        fitnessManager.logExercise(exercise);

        JOptionPane.showMessageDialog(frame, "You burned " + caloriesBurned + " calories during this session.",
                "Exercise Logged", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateWeight() {
        double newWeight = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter your new weight (kg):"));
        user.setCurrentWeight(newWeight);
        JOptionPane.showMessageDialog(frame, "Weight updated successfully!", "Update Weight",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewProgress() {
        StringBuilder progress = new StringBuilder();
        progress.append("User: ").append(user.getUserName()).append("\n");
        progress.append("Current Weight: ").append(user.getCurrentWeight()).append(" kg\n");
        progress.append("Target Weight: ").append(user.getTargetWeight()).append(" kg\n\n");

        ArrayList<Exercise> exerciseLog = fitnessManager.getExerciseLog();
        if (!exerciseLog.isEmpty()) {
            progress.append("Logged Exercises:\n");
            for (Exercise exercise : exerciseLog) {
                progress.append("- ").append(exercise.getExerciseName()).append("\n");
            }
        } else {
            progress.append("No exercises logged yet.\n");
        }

        double weightLost = user.getTargetWeight() - user.getCurrentWeight();
        progress.append("\nWeight Lost So Far: ").append(Math.abs(weightLost)).append(" kg\n");

        progressSummaryArea.setText(progress.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FitTrackGUI::new);
    }
}
