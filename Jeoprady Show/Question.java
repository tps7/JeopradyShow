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
    
    private int maxLineLength = 100;
    /**
     * Question constructor.
     * @param q Question.
     * @param a Answer.
     */
    Question(String q, String a) {
        question = q;
        answer = a;
//        if (q.charAt(q.length() - 1) != '?') {
//        	question += '?';
//        }
    }

    Question(int v, String q, String a) {
        value = v;
        question = q;
        answer = a;
//        if (q.charAt(q.length() - 1) != '?') {
//        	question += '?';
//        }
    }

    Question(String c, int v, String q, String a) {
        category = c;
        question = q;
        answer = a;
        value = v;
        //makes question always end in ?
//        if (q.charAt(q.length() - 1) != '?') {
//        	question += '?';
//        }
    }
    
    public Question(Question q) {
    	this.value = q.value;
    	this.question = q.question;
    	this.answer = q.answer;
    	this.category = q.category;
    }

    /**
     * gets question
     *
     * @return the question
     */
    public String get_question() {
        return question;
    }
    public void setQuestion(String s) {
    	question = s;
    }

    /**
     * gets answer
     *
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String s) {
    	answer = s;
    }

    /**
     * gets question point value
     *
     * @return point value
     */
    public int getValue() {
        return value;
    }
    public void setValue(int v) {
    	value = v;
    }

    /**
     * gets category
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }
    //may need to change
    public void setCategory(String s) {
    	category = s;
    }
        
    @Override
    public String toString() {
    	String rtrn = "";
    	rtrn += Integer.toString(value);
    	rtrn += "\n";
    	//rtrn += " ";
    	rtrn += get_question();
    	rtrn += "\n";
    	//rtrn += " ";
    	rtrn += getAnswer();
    	//rtrn += " ";
    	return rtrn;
    	
    }
    
//    public void formatText() {
//    	
//    }
}