/*
 * This program will quiz you on your math skillz
 * Written by Cal Warhurst on 01/27/22
 * JDK 17.0.2
 */

/* 
 * By the way I'm really enjoying these assignments.
 * This class is an absolute delight and super fun.
 */
import javax.swing.JOptionPane;
import java.util.Random;

public class MathQuiz {

    public static void main(String[] args) {
        // Variables to be used
        int correct = 0,
                problems = -1,
                userAnswer;
        String input;

        // Asks the user for the number of math equations to solve 
        // and validates input
        while (problems <= 0) {
            try {
                input = JOptionPane.showInputDialog(null, "How many math "
                        + "problems would you like to solve?");
                if (input == null) {
                    System.exit(0);
                }
                problems = Integer.parseInt(input);
                if (problems <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a "
                            + "positive number.");
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }

        // Math Quiz
        for (int i = 0; i < problems; i++) {
            // Generate Variables
            Random ran = new Random();
            int x = ran.nextInt(11);
            int y = ran.nextInt(11);
            int operator = ran.nextInt(3);
            int answer;
            String question;

            // Assigns answer and formats question based on random operator
            switch (operator) {
                case 0:
                    answer = x + y;
                    question = x + " + " + y + " = ?";
                    break;
                case 1:
                    answer = x - y;
                    question = x + " - " + y + " = ?";
                    break;
                default:
                    answer = x * y;
                    question = x + " x " + y + " = ?";
                    break;
            }

            // Asks question and tests user answer
            input = JOptionPane.showInputDialog(null, question);
            try {
                userAnswer = Integer.parseInt(input);
                if (userAnswer == answer) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    correct++;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect.\n"
                            + "The correct answer was " + answer + ".");
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "That wasn't a number.");
            }

        }

        // Assigns quiz performance
        double percentCorrect = ((double) correct / problems) * 100;
        String performance = "You are really terrible at math.";
        if (percentCorrect >= 60) {
            performance = "You need more practice.";
        }
        if (percentCorrect >= 70) {
            performance = "You are okay at math.";
        }
        if (percentCorrect >= 80) {
            performance = "You are good at math.";
        }
        if (percentCorrect >= 90) {
            performance = "You are great at math!";
        }
        // Displays results
        JOptionPane.showMessageDialog(null, String.format("You got %d out of %d "
                + "questions correct which equates to %.2f%%.\n%s",
                correct, problems, percentCorrect, performance));

        System.exit(0); // closing JOptionPane thread
    }

}
