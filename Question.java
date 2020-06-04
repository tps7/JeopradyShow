import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

/**
 * This is a Question class. 
 * This class makes a question object that stores a question, answer, and point value.
 * This class can also store the cateogry for the question. 
 * @author timothysullivan
 *
 */
public class Question {
    Question() {
    }
    /**
     * string of the category
     */
    private String category = "";
    /**
     * string of the question
     */
    private String question = "Question";
    /**
     * string of the answer
     */
    private String answer = "Answer";
    /**
     * point value of the question
     */
    private int value = 0;
    /**
     * Label that shows the answer
     */
    
    /**
     * Question constructor.
     * @param q Question.
     * @param a Answer.
     */
    Question(String q, String a) {
        question = q;
        answer = a;
    }

    Question(int v, String q, String a) {
        value = v;
        question = q;
        answer = a;
    }

    Question(String c, int v, String q, String a) {
        category = c;
        question = q;
        answer = a;
        value = v;
    }

    /**
     * gets question
     *
     * @return the question
     */
    public String get_question() {
        return question;
    }

    /**
     * gets answer
     *
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * gets question point value
     *
     * @return point value
     */
    public int getValue() {
        return value;
    }

    /**
     * gets category
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }
        
    @Override
    public String toString() {
    	String rtrn = "";
    	rtrn += Integer.toString(value);
    	//rtrn += "\n";
    	rtrn += " ";
    	rtrn += get_question();
    	//rtrn += "\n";
    	rtrn += " ";
    	rtrn += getAnswer();
    	rtrn += " ";
    	return rtrn;
    	
    }
}