import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

public class category {
    category() {}
    private ArrayList<Question> questions = new ArrayList<Question>();
    private String cname;
    category(String s) {
        cname = s;
    }
    category(String s, ArrayList<Question> q) {
        cname = s;
        questions = q;
    }
    public String getCname() {
        return cname;
    }
    public void addQuestion(int val, String question, String answer) {
        questions.add(new Question(this.getCname(), val, question, answer));
        this.sortQ();

    }
    ////
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
    public Question getQuestion(int index) {
    	if (index >= questions.size()) {
    		return null;
    	} else {
    		return questions.get(index);
    	}
//        if (index < 10) {
//            try {
//                questions.get(index);
//            } catch (Exception e) {
//                return new Question(this.getCname(), 100, "test", "sucess");
//            }
//            return questions.get(index);
//
//        } else {
//            return null;
//        }
    }
/**if (val == 100) {
        questions[0] = new Question(this.getCname(), val, question, answer);
    } else if (val == 200) {
        questions[1] = new Question(this.getCname(), val, question, answer);
    } else if (val == 300) {
        questions[2] = new Question(this.getCname(), val, question, answer);
    } else if (val == 400) {
        questions[3] = new Question(this.getCname(), val, question, answer);
    } else if (val == 500) {
        questions[4] = new Question(this.getCname(), val, question, answer);
    } else { }

 if (questions.get(index) == null) {
 return new Question(this.getCname(), 100, "test", "sucess");
 } else {
 return questions.get(index);
 }*/
}