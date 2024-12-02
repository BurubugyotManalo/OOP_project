**Project Overview**
**FitTrack**
FitTrack is a Java-based console application designed to help users track their fitness journey. The program allows users to input their personal details, set fitness goals, log exercise activities, and track weight changes over time. By providing real-time feedback on progress, FitTrack helps users stay motivated and focused on achieving their health and wellness goals.

The app uses key Object-Oriented Programming (OOP) principles such as encapsulation, inheritance, polymorphism, and abstraction to structure the code efficiently and maintain high standards of software design.

Core Features:
**User Profile Setup**
Allows users to input their name, current weight, and target weight.
**Exercise Logging**
Users can log their daily exercises, categorized into cardio or strength training.
**Weight Tracking**
Users can update their current weight and track progress toward their target weight.
**Progress Summary**
View a summary of their exercise history and weight progress.
**Exit Option**
Provides a clean exit from the program.

Explanation of How OOP Principles Were Applied
FitTrack demonstrates the following core Object-Oriented Programming (OOP) principles:

**Encapsulation**
Encapsulation is the practice of restricting direct access to some of an object's components and providing controlled access through public methods (getters and setters). In FitTrack, the User class encapsulates the user's personal information, such as their name, current weight, and target weight. These details are stored as private fields, and the values are accessed or modified only through public getter and setter methods, ensuring that the data is protected and can only be altered in a controlled manner.

**Inheritance**
Inheritance allows a class to inherit properties and behaviors (methods) from another class, promoting code reuse and establishing hierarchical relationships. In FitTrack, the Exercise class serves as a base class, and the CardioExercise and StrengthExercise classes are subclasses that inherit from Exercise. The subclasses can extend or modify the functionality of the base class, allowing each exercise type to have its specific behavior while still being treated as a general exercise.

**Polymorphism**
Polymorphism allows objects of different classes to be treated as objects of a common superclass, enabling the same method to behave differently based on the object's type. In FitTrack, polymorphism is used when logging exercises. The logExercise method behaves differently depending on whether the exercise is a cardio or strength training exercise. This flexibility allows the program to handle different types of exercises with a unified method, improving code readability and reducing redundancy.

**Abstraction**
Abstraction hides complex implementation details and shows only the essential features of an object, making the interaction with the object simpler for the user. In FitTrack, abstraction is applied using abstract classes. The Exercise class is abstract, meaning it provides a common interface for all exercise types, but it doesn't provide a complete implementation for logging an exercise. Instead, subclasses like CardioExercise and StrengthExercise provide their specific implementations. This allows the user to interact with a simplified interface while the system handles the complexity behind the scenes.

**SDG 3: Good Health and Well-being - Integration into FitTrack**
FitTrack aligns with SDG 3: Good Health and Well-being, which aims to ensure healthy lives and promote well-being for all. The project contributes to this goal in the following ways:

**Encouraging Physical Activity**
By allowing users to log their exercises, FitTrack promotes regular physical activity, which is key to maintaining good health and preventing diseases.
**Supporting Healthy Weight Management**
Users can track and update their weight, helping them manage their weight effectively and work toward healthier lifestyles.
**Improving Mental Well-being**
Achieving fitness goals boosts users’ sense of accomplishment, contributing to better mental health.
**Empowering Users**
FitTrack gives users the tools to monitor their health, make informed decisions, and stay motivated to lead a healthier life.

In summary, FitTrack directly supports SDG 3 by encouraging physical activity, promoting weight management, and fostering overall well-being.
**Instructions for Running the Program**
**Clone the Repository**
Clone or download the repository to your local machine.
**Setup Your Development Environment**
Ensure that you have the Java Development Kit (JDK) installed on your machine.
**Compile the Code**
Navigate to the project folder in your terminal or command prompt and compile the Java files.
**Run the Program**
After compiling, run the program to start interacting with the FitTrack app.
**Interacting with the Program**
The program will display a menu allowing you to log exercises, update weight, view progress, or exit.
