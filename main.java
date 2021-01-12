import java.awt.*;
import javax.swing.*;
import java.awt.Button;
import javax.swing.JPanel;
import java.time.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class main {
    public static void main(String[] args) {
    	//Test inputs.
//        // "m", "n", "o", "p", "q", "r", "s", "t"
//        String[] cats = new String[] {"a", "b", "c", "d", "e", "f", "h", "i", "j", "l"};
//        //String[] cats = new String[] {"a", "b", "c", "d"};
    	String[] cats = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l"};
    	String[] djCats = new String[] {"m", "n", "o", "p", "q", "r", "s"};
    	
       String[] people = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
//        //String[] people = new String[] {"1", "2", "3"};
////    	String[] people = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
////    			"14", "15", "16", "17"};
//        
       int[] pointValues = new int[]{100, 200, 300, 400, 500, 600, 750};
        Jboard2 j2 = new Jboard2(cats, people, djCats, pointValues.length, pointValues);
        
        j2.getContentPane().setBackground(Color.WHITE);
        j2.setSize(j2.getScreenWidth(), j2.getScreenHeight());
        j2.createboard();
        j2.getContentPane().setLayout(null);
        j2.setVisible(true);
        
        
//        System.out.println(j2.getScreenWidth());
//        System.out.println(j2.getScreenHeight());
    }
}
