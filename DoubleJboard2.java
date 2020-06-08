import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.math.*;

/**
 * Class that makes the board for Double Jeoprady.
 * Extends Jboard class mostly the same
 * 
 * TODO
 * Add final Jeoprody method.
 * Make it so its Buttons have diffrent point values. This should incorporated into Jboard first.
 * 
 * 
 * @author timothysullivan
 *
 */
public class DoubleJboard2 extends Jboard2 implements WindowListener  {

	/**
	 * Screen Width
	 */
	private int screenWidth = getScreenWidth();
	/**
	 * Screen Height
	 */
	private int screenHeight = getScreenHeight();

	DoubleJboard2() {};
	/**
	 * DoubleJboard constructor
	 * @param p An array list of players. These are the players from the first Jboard.
	 * These players start with their scores from the first game
	 * @param cnames The new category names for double jeoprady.
	 */
	DoubleJboard2(ArrayList<Player> p, String[] cnames) {
		players = p;
		categories = makeCategories(cnames);
		numCategories = cnames.length;
		numPlayers = p.size();
		//allQButtons = new JButton[numPlayers];
		title.setText("FFLC 89 2020 Double Jeoprady");
		doubleJ.setVisible(false);
		addWindowListener(this);
		addComponentListener(this);
		nCQs = 5;
		qvals = new int[nCQs];
		int val = 150;
		for (int k = 0; k < nCQs; k++) {
			qvals[k] = val;
			val += 150;
		}
		createQuestions();
		load.setVisible(false);
		save.setVisible(false);
	}
	
	/**
	 * Same as above with numCategoryQs
	 * @param p
	 * @param cnames
	 * @param numCategoryQs The number of category questions. The default value is 5.
	 */
	DoubleJboard2(ArrayList<Player> p, String[] cnames, int numCategoryQs) {
		players = p;
		categories = makeCategories(cnames);
		numCategories = cnames.length;
		numPlayers = p.size();
		//allQButtons = new JButton[numPlayers];
		title.setText("FFLC 89 2020 Double Jeoprady");
		doubleJ.setVisible(false);
		addWindowListener(this);
		addComponentListener(this);
		nCQs = numCategoryQs;
		qvals = new int[nCQs];
		int val = 150;
		for (int k = 0; k < nCQs; k++) {
			qvals[k] = val;
			val += 150;
		}
		createQuestions();
	}
	
	/**
	 * The same as above with custom question values.
	 * @param p
	 * @param cnames
	 * @param numCategoryQs
	 * @param questionValues The point value per question. The default is increments of 150 starting at 150.
	 */
	DoubleJboard2(ArrayList<Player> p, String[] cnames, int numCategoryQs, int[] questionValues) {
		players = p;
		categories = makeCategories(cnames);
		numCategories = cnames.length;
		numPlayers = p.size();
		//allQButtons = new JButton[numPlayers];
		title.setText("FFLC 89 2020 Double Jeoprady");
		doubleJ.setVisible(false);
		addWindowListener(this);
		addComponentListener(this);
		nCQs = numCategoryQs;
		qvals = questionValues;
		createQuestions();
	}
	
	
	//maybe fix so its not the same method as in Jboard
	public ArrayList<category> makeCategories(String[] cnames) {
		ArrayList<category> cats = new ArrayList<category>();
		for (int k = 0; k < cnames.length; k++) {
			category c = new category(cnames[k]);
			cats.add(c);
		}
		return cats;
	}
	
	// Makes it so you don't leave app when closing DJ window disabled now for editing purposes.
//	@Override
//	public void windowClosing(WindowEvent e) {
//		// TODO Auto-generated method stub
//	}
}
