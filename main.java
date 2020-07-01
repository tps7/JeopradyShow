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
//        String[] lastYearC = new String[] {"Ryan", "Kyle", "Chris", "Joey", "Lefteri", "Kosta", "Jack S", "Timmy",
//        		"Jeff", "Jared", "Jack W"};
//        //String[] cats = new String[] {"a", "b", "c", "d"};
////    	String[] cats = new String[] {"a", "b", "c", "d", "e", "f", "h", "i", "j", "l",
////    			"m", "n", "o", "p", "q", "r", "s", "t"};
//        String[] people = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
//        String [] lastYearP = new String[] {"Ryan", "Kyle", "Chris", "Joey", "Leftari", "Kosta", "Jack S",
//        		"Jeff", "Jared"};
//        //String[] people = new String[] {"1", "2", "3"};
////    	String[] people = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
////    			"14", "15", "16", "17"};
//        
//        String[] doubleJC = new String[] {"z", "y", "x", "v", "w", "u", "t"};
//        String[] lastYearDJC = new String[] {"Blaine", "Women", "Sex Acts", "FFLC", "Football"};
//        int[] pointVals = new int[] {100, 200, 300, 400, 500, 750};
//        //int[] pointVals = new int[] {123, 155, 169, 307, 450};
//        Jboard2 j2 = new Jboard2(cats, people, doubleJC, pointVals.length, pointVals);
//        //Jboard2 j2 = new Jboard2(lastYearC, lastYearP, lastYearDJC, pointVals.length, pointVals);
    	
    	
        
        ////////////**************************THIS YEAR JEOPRADY*****************************\\\\\\\\\\\
        String[] contestents = new String[]{"Ryan", "Kyle", "Chris", "Joey", "Leftari", "Kosta",
                                          "Jack S", "Jeff", "Jared"};
        String[] thisYearCategories = new String[] {"Ryan", "Kyle", "Chris", "Joey", "Leftari", "Kosta",
                "Jack S", "Timmy", "Jeff", "Jared", "Jack W"};
        String[] thisYearDJCategories = new String[]{"FFLC History", "Do You Have Balls?", 
                                                   "NFL", "Sex Acts", "America Fuck Yeah!", 
                                                   "Packers", "Bears"};
        int[] pointValues = new int[]{100, 200, 300, 400, 500, 750};
        Jboard2 j2 = new Jboard2(thisYearCategories, contestents, thisYearDJCategories,
        		pointValues.length, pointValues);
        
        j2.getContentPane().setBackground(Color.WHITE);
        j2.setSize(j2.getScreenWidth(), j2.getScreenHeight());
        j2.createboard();
        j2.getContentPane().setLayout(null);
        j2.setVisible(true);
        
        
//        System.out.println(j2.getScreenWidth());
//        System.out.println(j2.getScreenHeight());
    }
}
