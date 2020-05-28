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
 * 
 * @author timothysullivan
 *
 */
public class DoubleJboard2 extends Jboard2 {

	/**
	 * Screen Width
	 */
	private int screenWidth = getScreenWidth();
	/**
	 * Screen Height
	 */
	private int screenHeight = getScreenHeight();

	//private ArrayList<category> categories; // = new ArrayList<category>();;

	//private ArrayList<Player> players;

	DoubleJboard2() {};

	DoubleJboard2(ArrayList<Player> p, String[] cnames) {
		players = p;
		categories = makeCategories(cnames);
		numCategories = cnames.length;
		numPlayers = p.size();
		allQButtons = new JButton[numPlayers];
		title.setText("Double Jeoprady");
		doubleJ.setVisible(false);
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




}
