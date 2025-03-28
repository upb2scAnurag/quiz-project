import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a question
   class Question {
    private String question;
    private List<String> options;
    String answer;

    // Constructor to initialize the question, options, and the correct answer
    public Question(String question, List<String> options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    // Getter for the question
    public String getQuestion() {
        return question;
    }

    // Getter for the options
    public List<String> getOptions() {
        return options;
    }

    // Method to check if the given answer is correct
    public boolean isCorrectAnswer(String answer) {
        return this.answer.equalsIgnoreCase(answer);
    }
 }

// Main class for the QuizApp
public class quizproject {
    private List<Question> questions; // List to store questions
    private int score; // Variable to store the user's score

    // Constructor to initialize the QuizApp and load the questions
    public quizproject() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions(); // Load questions into the quiz
    }

    // Method to load questions into the quiz
    private void loadQuestions() {
        // Adding sample questions to the quiz
        questions.add(new Question("What is the capital of France?",
                List.of("A) Paris", "B) London", "C) Rome", "D) Berlin"), "A"));

        questions.add(new Question("Which planet is known as the Red Planet?",
                List.of("A) Earth", "B) Mars", "C) Jupiter", "D) Venus"), "B"));

        questions.add(new Question("What is the largest ocean on Earth?",
                List.of("A) Atlantic Ocean", "B) Indian Ocean", "C) Arctic Ocean", "D) Pacific Ocean"), "D"));

        questions.add(new Question("Who wrote 'Romeo and Juliet'?",
                List.of("A) Charles Dickens", "B) Mark Twain", "C) William Shakespeare", "D) Leo Tolstoy"), "C"));

        questions.add(new Question("What is the chemical symbol for water?",
                List.of("A) H2O", "B) O2", "C) CO2", "D) NaCl"), "A"));
    }

    // Method to start the quiz and interact with the user
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in); // Scanner to get user input
        System.out.println("Welcome to the Quiz!");

        // Loop through each question in the list
        for (Question question : questions) {
            System.out.println(question.getQuestion()); // Display the question
            // Display the options for the question
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            // Ask the user for an answer
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            // Check if the answer is correct and update the score
            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++; // Increment score for correct answer
            } else {
                System.out.println("Wrong! The correct answer was: " + question.answer);
            }
            System.out.println(); // Empty line for better readability
        }

        // Display the final score
        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        scanner.close(); // Close the scanner object to avoid resource leak
    }

    // Main method to run the QuizApp
    public static void main(String[] args) {
        // Create an instance of QuizApp and start the quiz
        quizproject quizApp = new quizproject();
        quizApp.startQuiz();
    }
}

