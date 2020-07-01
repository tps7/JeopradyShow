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
		title.setText("<html> FFLC 810 2020 Double Jeoprady </html>");
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
		title.setText("<html> FFLC 810 2020 Double Jeoprady </html>");
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
		title.setText("FFLC 810 2020 Double Jeoprady");
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
	
	@Override 
	public void createboard() {
		super.createboard();
		this.remove(DJ);
	}
	
	@Override
	public void createQuestions() {
//		for (int k = 0; k < categories.size(); k++) {
//			for (int j = 1; j < nCQs + 1; j++) {
//				if (qvals.length == nCQs) {
//					categories.get(k).addQuestion(qvals[j - 1], "question", "answer");
//				} else {
//					categories.get(k).addQuestion(j * 100, "question", "answer");
//				}
//			}
//		}
		
		//League History
		categories.get(0).addQuestion(150, "Who is the current League Champion?", "Timmy");
		categories.get(0).addQuestion(300, "How many points does Chris need to complete his Loser Punishments?", "69");
		categories.get(0).addQuestion(450, "Who is that Player Timmy drafted that made Jack Throw a fit? This did not necessarily occur "
				+ "last year and could have occurred years prior.", "Shane Vereen");
		categories.get(0).addQuestion(600, "Name the entire first round of last years draft. If you go and look at the draft board you can’t answer.", 
				"David Johnson, Alvin Kamara, Saquon Barkley, Ezekiel Elliot, Christain Mccaffery, Deandre Hopkins, Levvon Bell, Todd Gurley, Michael Thomas, Davante Adams."
				+ "(If you say Odell Instead of Adams you still get points because they were technically interchangeable)");
		categories.get(0).addQuestion(750, "Name 4 punishments Chris can complete that are worth 50 points or more.", 
				"Having girls put makeup on and wearing that makeup during the draft (50 points), Set Timmy Up with a girl (50 Points), "
				+ "Pay $500 to league champion and write letter of surrender (69 points), Threesome with Becky Cloud and Megan Quill (65 points), "
				+ "Hook up with Lindsey Goldman (55 points), Hookup with Mrs. Goldman (69 points)");
		
		//Do You Have Balls?
		categories.get(1).addQuestion(150, "A normal man has 7 Testicles.", "False a normal man has 2");
		categories.get(1).addQuestion(300, "The Capital of Massachusetts is Boston", "True");
		categories.get(1).addQuestion(450, "69 squared is equal to 4761", "True");
		categories.get(1).addQuestion(600, "你是同性戀嗎", "Translates to \"Are You Gay?\" "
				+ "If you answered false you get points if you answered true you don’t because you are gay.");
		categories.get(1).addQuestion(750, "If Timmy flips a coin it will land on heads.", "Whatever the coin lands on");
		
		//NFL
		categories.get(2).addQuestion(150, "How many points is a touchdown worth?", "6");
		categories.get(2).addQuestion(300, "How many Superbowls have been played in the NFL?", "52 SuperBowls");
		categories.get(2).addQuestion(450, "Who is the Highest Paid Player", "Russell Wilson $35 million. Will accept other answers "
				+ "If you say what metric you used but Wilson is highest paid by average annual salery");
		categories.get(2).addQuestion(600, "How many teams have never won a superbowl?", "12 teams.");
		categories.get(2).addQuestion(750, "Most avid NFL fans would agree that you a score a touchdown by crossing the oppenents goalline. "
				+ "However there is another way to score a touchdown without the ball crossing over the opponents goalline. "
				+ "Explain in detail a situation that this would happen and/or say what rule allows this to happen.", 
				"Palpably Unfair Act. An example of this is a player from the bench running onto the field to tackle a player who had broken away and was easily going to score a touchdown.");
		
		//Sex Acts
		categories.get(3).addQuestion(150, "What is it called when a man sticks his penis into a womens mouth?", 
				"BlowJob Will also accept Oral sex");
		categories.get(3).addQuestion(300, "What is the Missouri Compromise?", 
				"This term refers to an act whereby a young lady circumvents the loss of her viginity by practicing anal instead of vaginal intercourse. "
				+ "Its namesake refers to the compromise of 1820, whereby Missouri was excluded from inclusion a free state, even though it was above the Mason-Dixon line.");
		categories.get(3).addQuestion(450, "Define The Landshark", "The woman braces herself facing a wall, naked, hands against the wall, legs spread, bent over so that her ass is lusciously jutting out. "
				+ "(hint: She might want to wear a biking helmet and some rollerblading wrist guards to avoid serious injury.) Next, the guy also naked as well as stiff cocked, "
				+ "walks to the opposite end of the room, places his palms together and raises them above his head, "
				+ "(thus imitating the dorsal fin of a shark) and begins chanting the theme to Jaws. When given some predetermined signal, "
				+ "the guy sprints toward the girl at full speed with his pelvis-out, fin protruding, and rams her dead square in the ass");
		categories.get(3).addQuestion(600, "Given the definition define the Sex Act: A sex act in which a woman is reverse cowgirl on top of a man, and then they attempt to jump/throw her to another man standing by a wall. "
				+ "Unbeknownst to her, the second man plans to sidestep and let her hit the wall and fall down, hopefully leaving her writhing in agony. "
				+ "Then both men ejaculate on her.", "Flying Circus");
		categories.get(3).addQuestion(750, "Define the Sex act Spicy Gringo", "The act of stuffing a women’s rear end with a Volcano Taco from Taco Bell, and then eating it.");
		
		//America Fuck Yeah!
		categories.get(4).addQuestion(150, "What Day Year and Month did America declare its independence?", "July 4th 1776");
		categories.get(4).addQuestion(300, "America has Back to Back World War championships. Name 2 other countries that also have back to back world war championships. "
				+ "Hint: If your country was successfully invaded you did not win the war.", 
				"Britain/UK, Canada, Australia,  New Zealand,  India, South Africa, may accept other anwers that were British colonies");
		categories.get(4).addQuestion(450, "Name 10 of the original 13 colonies", 
				"New Hampshire, Massachusetts Connecticut Rhode Island, New York, New Jersey, "
				+ "Pennsylvania, Delaware, Maryland, Virginia, North Carolina, South Carolina and Georgia");
		categories.get(4).addQuestion(600, "What was the Last Major Battle in the revolutionary war? This Battle effictivly ended the war.", "Battle of Yorktown 1781");
		categories.get(4).addQuestion(750, "How many populated territories does the US have? Name all of them except one.", 
				"American Samoa, Guam, Northern Mariana Islands, Puerto Rico, US Virgin Islands");
		
		//Packers
		categories.get(5).addQuestion(150, "Who is the Packers starting QB", "Aaron Rodgers");
		categories.get(5).addQuestion(300, "When did the Packers last win the Superbowl?", "2010 season, 2011 Defeated Steelers 31-25");
		categories.get(5).addQuestion(450, "How many championships (not just Super Bowls) have the Packers won?", 
				"13 Championships the most in the NFL.");
		categories.get(5).addQuestion(600, "What years did the packers win superbowls?", "1967, 1968, 1997, 2011");
		categories.get(5).addQuestion(750, "Who founded the Packers must give first and last names.", "Earl “Curly” Lambeau and George-Whitney Calhoun.");
		
		//Bears
		categories.get(6).addQuestion(150, "What player lead the Bears Defense in Sacks Last Year?", "Khalil Mack");
		categories.get(6).addQuestion(300, "When did the Bears Last win the Superbowl?", "1985 season they won it in 1986");
		categories.get(6).addQuestion(450, "How many Championships (not just Super Bowls) have the Bears won?", "9 championships second most in the NFLs");
		categories.get(6).addQuestion(600, "In 2017 The Bears selelcted Mitch Tribusky in the first round. Before Tribusky who was the Last QB that the bears used a first round draft pick on?", 
				"Rex Grossman 2003 22 overall");
		categories.get(6).addQuestion(750, "How many interceptions did Jay cutler throw during his time with the Bears? Guess within +- 5",
				"109");
		
}
	
	// Makes it so you don't leave app when closing DJ window disabled now for editing purposes.
//	@Override
//	public void windowClosing(WindowEvent e) {
//		// TODO Auto-generated method stub
//	}
}
