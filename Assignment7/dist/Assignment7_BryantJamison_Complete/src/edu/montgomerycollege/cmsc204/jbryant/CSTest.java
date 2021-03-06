package edu.montgomerycollege.cmsc204.jbryant;

import edu.montgomerycollege.cmsc204.jkartchner.Test;

/**
 * The CS test being administered by the application.
 *
 * @author Jamison Bryant <jbryan46@montgomerycollege.edu> for R. Alexander's CMSC 204 M/W 1:00PM-2:40PM
 */
public class CSTest extends Test
{
    private int currentQuestion;
    private String[] questions;
    private String[] answers;
    private double incorrectAnswers;

    /**
     * Creates a new test to be administered
     */
    public CSTest()
    {
        super();
        currentQuestion = 0;
        incorrectAnswers = 0;

        // Define questions and answers
        questions = new String[11];
        questions[0] = "";
        questions[1] = "Every node in a binary tree has ____ references.";
        questions[2] = "In a perfectly balanced binary tree, the height of the subtrees of the root are ____";
        questions[3] = "A node in a binary tree is called a(n) ____ if it has neither a left nor a right child.";
        questions[4] = "The number of nodes in the longest branch of the tree is called the ____ of the tree.";
        questions[5] = "Each item in a data set has a special member that uniquely identifies it called a(n) ____.";
        questions[6] = "In an ordered linked list the search algorithm is somewhat improved because the list is ____.";
        questions[7] = "A queue is a(n) ____ data structure.";
        questions[8] = "The ability to create new data types from existing data types is called ____.";
        questions[9] = "When the binding of methods takes place at execution time, it is considered ____.";
        questions[10] = "Which operator is used to determine if an object is of a particular class type?";

        answers = new String[11];
        answers[0] = "";
        answers[1] = "2";
        answers[2] = "equal";
        answers[3] = "leaf";
        answers[4] = "height";
        answers[5] = "key";
        answers[6] = "sorted";
        answers[7] = "FIFO";
        answers[8] = "inheritance";
        answers[9] = "dynamic";
        answers[10] = "instanceof";
    }

    /**
     * Creates a new test with a given set of questions and answers
     *
     * @param questions Questions to display
     * @param answers Correct answers to given questions
     */
    public CSTest(String[] questions, String[] answers)
    {
        this.questions = questions;
        this.answers = answers;
        currentQuestion = 0;
        incorrectAnswers = 0;
    }

    /**
     * Checks the answer of a particular question
     *
     * @param answer Answer to check
     * @return True if the answer was correct, false otherwise
     */
    @Override
    public String check(String answer)
    {
        String result = "Incorrect";

        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(answer)) {
                result = "Correct";
                break;
            }
        }

        if (result.equals("Incorrect")) {
            incorrectAnswers++;
        }

        return result;
    }

    /**
     * Returns the next question on the test
     *
     * @return Next question
     */
    @Override
    public String next()
    {
        String question = null;

        if (currentQuestion != questions.length) {
            question = questions[++currentQuestion];
        }

        return question;
    }

    /**
     * Returns the percentage of questions that have been answered correctly
     *
     * @return Percent of questions answered correctly
     */
    @Override
    public double getPercentCorrect()
    {
        return 100.0 - (10.0 * incorrectAnswers);
    }
}
