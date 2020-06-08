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
        /*Home page = new Home();
        page.setSize(840, 840);
        page.createPage();
        page.setLayout(null);
        page.setVisible(true);
        page.getContentPane().setBackground(Color.WHITE);*/
    	
        // "m", "n", "o", "p", "q", "r", "s", "t"
        String[] cats = new String[] {"a", "b", "c", "d", "e", "f", "h", "i", "j", "l"};
        //String[] cats = new String[] {"a", "b", "c", "d"};
//    	String[] cats = new String[] {"a", "b", "c", "d", "e", "f", "h", "i", "j", "l",
//    			"m", "n", "o", "p", "q", "r", "s", "t"};
        String[] people = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        //String[] people = new String[] {"1", "2", "3"};
//    	String[] people = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
//    			"14", "15", "16", "17"};
        
        String[] doubleJC = new String[] {"z", "y", "x", "v", "w", "u", "t"};
        int[] pointVals = new int[] {100, 200, 300, 400, 500, 600, 750};
        //int[] pointVals = new int[] {123, 155, 169, 307, 450};
        Jboard2 j2 = new Jboard2(cats, people, doubleJC, pointVals.length, pointVals);
        j2.getContentPane().setBackground(Color.WHITE);
        j2.setSize(j2.getScreenWidth(), j2.getScreenHeight());
        j2.createboard();
        j2.getContentPane().setLayout(null);
        j2.setVisible(true);
        System.out.println(j2.getScreenWidth());
        System.out.println(j2.getScreenHeight());
        
//        long startTime = System.currentTimeMillis();
//        long elapsedTime = 0;
//        
//        for (int k = 0; k < 15; k++) {
//        	 while (elapsedTime < 2000) {
//                 //perform db poll/check
//                 elapsedTime = (new Date()).getTime() - startTime;
//             }
//        	 elapsedTime = 0;
//        	 startTime = new Date().getTime();
//        	 System.out.println(j2.getScreenWidth() + " , " + j2.getScreenHeight());
//        }
//        System.out.println("dfadfsdf");
    }
}
