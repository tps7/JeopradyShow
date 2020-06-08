import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

/**
 * Class of category project. This object stores a category name and a list of questions.
 * @author timothysullivan
 *
 */
public class category {
    category() {}
    /**
     * The Questions in the category.
     */
    private ArrayList<Question> questions = new ArrayList<Question>();
    /**
     * The category name.
     */
    private String cname;
    
    category(String s) {
        cname = s;
    }
    category(String s, ArrayList<Question> q) {
        cname = s;
        questions = q;
    }
    
    /**
     * getCname: Gets the name of the category.
     * @return Name of the category as a String.
     */
    public String getCname() {
        return cname;
    }
    public void setCname(String s) {
    	cname = s;
    }
    /**
     * addQuestion: Adds a question to the category arraylist. 
     * Auto sorts questions from lowest to highest point values.
     * @param val The point value of the question.
     * @param question The question itself.
     * @param answer The answer to the question.
     */
    public void addQuestion(int val, String question, String answer) {
        questions.add(new Question(this.getCname(), val, question, answer));
        this.sortQ();

    }
    /**
     * sortQ: Sorts the questions in order from lowest to highest.
     * This method is called in the addQuestion method.
     */
    public void sortQ() {
        for (int k = 1; k < questions.size(); k++) {
            Question current = questions.get(k);
            int j = k - 1;
            while (j >= 0 && current.getValue() < questions.get(j).getValue()) {
                questions.set(j + 1, questions.get(j));
                j--;
            }
            questions.set(j + 1, current);
        }


    }
    /**
     * getQuestion: Gets the question at a given index.
     * @param Index The index of the question you want.
     * @return Null if the index is invalid. Otherwise returns a question object at the given index.
     */
    public Question getQuestion(int index) {
    	if (index >= questions.size()) {
    		return null;
    	} else {
    		return questions.get(index);
    	}
    }
   /**
    * Sets question
    * @param q Quesition about to be set.
    * @param index Index where the quesion will be set.
    */
   public void setQuestion(Question q, int index) {
	   questions.set(index, q);
   }
   
   public void clearQuestions() {
	   questions.clear();
   }
}