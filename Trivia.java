import java.util.Scanner;

enum TriviaQuestions {
    SUN_IS_A_STAR("True or False: The sun is a star?", true),
    FIRST_PRESIDENT("Who was the first president of the United States?", "George Washington"),
    STATES_IN_US("How many states are in the United States?", 50),
    VALUE_OF_PI("What is the value of Pi up to the second decimal point?", 3.14),
    FIRST_LETTER("What is the first letter of the English alphabet?", 'A');

    private final String question;
    private final Object answer;

    TriviaQuestions(String question, Object answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public Object getAnswer() {
        return answer;
    }
}

public class Trivia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = 0;

        for (TriviaQuestions trivia : TriviaQuestions.values()) {
            System.out.println(trivia.getQuestion());
            System.out.print("Your answer: ");
            String userInput = scanner.nextLine();

            if (isAnswerCorrect(userInput, trivia.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + trivia.getAnswer());
            }
            System.out.println();
        }

        int totalQuestions = TriviaQuestions.values().length;
        double percentageScore = (double) score / totalQuestions * 100;
        System.out.println("You got " + score + " out of " + totalQuestions + " right, for a score of " + percentageScore + "%");

        scanner.close();
    }

    private static boolean isAnswerCorrect(String userInput, Object correctAnswer) {
        if (correctAnswer instanceof Integer) {
            return correctAnswer.equals(Integer.valueOf(userInput.trim()));
        } else if (correctAnswer instanceof String) {
            return ((String) correctAnswer).equalsIgnoreCase(userInput.trim());
        } else if (correctAnswer instanceof Boolean) {
            return Boolean.parseBoolean(userInput.trim()) == (Boolean) correctAnswer;
        } else if (correctAnswer instanceof Double) {
            return Double.valueOf(userInput.trim()).equals(correctAnswer);
        } else if (correctAnswer instanceof Character) {
            return Character.toString((Character) correctAnswer).equalsIgnoreCase(userInput.trim());
        }
        return false;
    }
}
