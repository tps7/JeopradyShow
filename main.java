import java.awt.*;
import javax.swing.*;
import java.awt.Button;
import javax.swing.JPanel;

public class main {
    public static void main(String[] args) {
        /*Home page = new Home();
        page.setSize(840, 840);
        page.createPage();
        page.setLayout(null);
        page.setVisible(true);
        page.getContentPane().setBackground(Color.WHITE);*/

//        Jboard j = new Jboard();
//        j.getContentPane().setBackground(Color.WHITE);
//        //j.setSize(1000, 500);
//        j.setSize(j.getScreenWidth(), j.getScreenHeight()); //Try to get true full screen later
////        System.out.println(j.getScreenWidth());
////        System.out.println(j.getSceenHeight(););
//        j.createboard();
//        j.createScoreboard();
//        j.createQuestions();
//        //j.createGrid();
//        j.createbuttons();
//        j.setLayout(null);
//        j.setVisible(true);
        
        String[] cats = new String[] {"a", "b", "c", "d", "e", "f", "h", "i", "j", "l", "m"};
        String[] people = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        Jboard2 j2 = new Jboard2(cats, people);
        j2.getContentPane().setBackground(Color.WHITE);
        //j2.setSize(j2.getScreenWidth(), j2.getScreenHeight());
        j2.setSize(500, 500);
        j2.createboard();
        j2.createScoreboard();
        j2.createQuestions();
        j2.createbuttons();
        j2.getContentPane().setLayout(null);
        j2.setVisible(true);
        System.out.println(j2.getScreenWidth());
        System.out.println(j2.getScreenHeight());
        
        /*DoubleJboard d = new DoubleJboard(j.allPlayers);
        d.getContentPane().setBackground(Color.WHITE);
        d.setSize(d.getScreenWidth(), d.getScreenHeight());
        d.createboard();
        d.createScoreboard();
        d.createQuestions();
        d.createbuttons();
        d.setLayout(null);
        d.setVisible(true);*/
    }
}
