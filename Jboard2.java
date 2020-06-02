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
 * A class that makes the Jeoprady board.
 * The class is an extension of a JFrame. 
 * It implements action, window, and compenent listners.
 * 
 * TODO most of these are not need for function but are extra things to do if time.
 * Make Qboard so it dynamically resizes. (DONE)
 * Make Qboard appear on same screen as JBoard.
 * Allign player name and points with right and left end of button columns.
 * Adjust Font sizes so it changes more dynamically so you can always read font.
 * Accomadate a diffrent number of questions per category. (DONE)
 * Accomadate diffrent point values per category.(DONE)
 * Include Daily Doubles. Weigh probablility towards begining.
 * Change some methods to private or maybe change some varibles to public or protected
 * Add a button and function that allows you to save the game and lode it later.
 * Adjust bounds for things like Title. When you don't have same length things are a bit off.
 * Comment all the other classes.
 * Decrease spacing between scoreboard and end of the buttons.
 * Change Colors to normal Jeoprady.
 * Make sizing better.
 * Add Audio text reader.
 * Option to create Jboard with given questions and values in a list of questions.
 * Create adjusted Scroreboard where winners are in certain order? or a scoreboard on side.
 * Make it so Double Jeoprady Button is disabled/does not appear until all buttons are clicked.ß
 * 
 * @author timothysullivan
 *
 */
public class Jboard2 extends JFrame implements ActionListener, WindowListener, ComponentListener {  
	//Private and Protected Varibles
	//General varibles
    /**
     * Screen Width
     */
    private int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    /**
     * Screen Height
     */
    private int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    /**
     * categories
     */
    protected ArrayList<category> categories = new ArrayList<category>();
    
    /**
     * players
     */
    protected ArrayList<Player> players = new ArrayList<Player>();
    
    /**
     * An interger storing the number of categories.
     */
    protected int numCategories;
    
    /**
     * An integer storing the number of players.
     */
    protected int numPlayers;
    
    /**
     * An interger stroing the number of questions per category. The default value is 5.
     */
    protected int nCQs;
    
    /**
     * The point values for each question default is increments by 100.
     */
    protected int[] qvals = new int[] {};
    //varibles for things on Jboard Like buttons and labels
    
    /**
     * 2d array of all buttons
     */
    private JButton[][] allButtons;
    /**
     * edit button
     */
    private JButton edit = new JButton("edit");
    /**
     * done button
     */
    private JButton done = new JButton("done");
    /**
     * submit button for change scores
     */
    private JButton submit2 = new JButton("Submit");
    /**
     * submit for change button
     */
    private JButton submit1 = new JButton("Submit");
    /**
     * double jeoprady button
     */
    protected JButton doubleJ = new JButton("Double Jeoprady");
    /**
     * reEnable buttons input field
     */
    private JTextField buttonEdit = new JTextField("");
    /**
     * JLabel for the game title.
     */
    protected JLabel title = new JLabel("FFLC 89 2020 Jeopardy");
    /**
     * reEnable buttons input label
     */
    private JLabel editBtext = new JLabel("Edit Buttons:");
    /**
     * Where you enter data to change scroes
     */
    private JTextField changeScores = new JTextField("");
    /**
     * label for change Scores text field
     */
    private JLabel changeScoresText = new JLabel("Edit Scores");
    /**
     * is the board being edited
     */
    private boolean isEdit = false;
    /**
     * ArrayList that holds all the labels of the player names.
     */
    private ArrayList<JLabel> allNames = new ArrayList<JLabel>();
    /**
     * Arraylist that holds all the labels of the scores.
     */
    private ArrayList<JLabel> allScores = new ArrayList<JLabel>();
    /**
     * Arraylist that holds all the labels of the scores.
     */
    private ArrayList<JLabel> allCategories = new ArrayList<JLabel>();

    //Qboard vars

    /**
     * the question board
     */
    private JDialog qboard = new JDialog();
    /**
     * The label at the top of the Q board giving the category and point value for the quesion.
     */
    private JLabel qInfo = new JLabel("", SwingConstants.CENTER);
    /**
     * go back button
     */
    private JButton goBack = new JButton("Go Back");
    /**
     * show answer button
     */
    private JButton showAns = new JButton("Show Answer");
    /**
     * all Queston buttons
     */
    protected JButton[] allQButtons;
    /**
     * The question.
     */
    private JLabel question_text = new JLabel("", SwingConstants.CENTER);
    /**
     * the answer to the question
     */
    private JLabel ans = new JLabel("", SwingConstants.CENTER);
    
    //End varible declaration begin code
    
    
    /**
     * empty constructor
     */
    Jboard2() {}
    
    /**
     * This is the Jboard constructor used to construct the jeoprady board without given player points.
     * This is the default Jboard constructor meaning it is set to the default 5 questions
     * with point values 100-500.
     * @param categories_names An array of strings. The strings are the names of the categories.
     * @param playerNames The names of the players.
     */
    Jboard2(String[] categories_names,String[] playerNames) {
    	setcategories(categories_names);
    	makePlayers(playerNames);
    	numCategories = categories.size();
    	numPlayers = players.size();
    	addWindowListener(this); 
    	addComponentListener(this);
    	nCQs = 5;
    	createQuestions();
    }
    
    /**
     * Same as default constructor with added num CategoryQ's
     * @param categories_names 
     * @param playerNames
     * @param numCategoryQs The number of questions per category.
     */
    Jboard2(String[] categories_names,String[] playerNames, int numCategoryQs) {
    	setcategories(categories_names);
    	makePlayers(playerNames);
    	numCategories = categories.size();
    	numPlayers = players.size();
    	addWindowListener(this); 
    	addComponentListener(this);
    	nCQs = numCategoryQs;
    	createQuestions();
    }
    
    /**
     * same as default with questions values added.
     * @param categories_names
     * @param playerNames
     * @param numCategoryQs
     * @param questionValues The point value for each question row.
     */
    Jboard2(String[] categories_names,String[] playerNames, int numCategoryQs, int[] questionValues) {
    	setcategories(categories_names);
    	makePlayers(playerNames);
    	numCategories = categories.size();
    	numPlayers = players.size();
    	addWindowListener(this); 
    	addComponentListener(this);
    	nCQs = numCategoryQs;
    	qvals = questionValues;
    	createQuestions();
    }
    
    
    
    /**
     * setcategories: Helper function that sets the name of the categories and 
     * adds the categories to the categories arraylist.
     * @param cnames list of names of the categories
     */
    public void setcategories(String[] cnames) {
    	for (int k = 0; k < cnames.length; k++) {
    		category c = new category(cnames[k]);
    		categories.add(c);
    	}
    	return;
    }
    
    public ArrayList<Player> getPlayers() {
    	return players;
    }
    
    /**
     * makePlayers: Helper function that creates the players and adds them to a player arraylist.
     * @param pnames Names of the players.
     */
    public void makePlayers(String[] pnames) {
    	for (int k = 0; k < pnames.length; k++) {
    		Player p = new Player(pnames[k]);
    		players.add(p);
    	}
    	return;
    }
    
    /**
     * Gets Screen height
     *
     * @return Screen height
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * Gets screen width
     *
     * @return screen width
     */
    public int getScreenWidth() {
        return screenWidth;
    }
    
    /**
     * enable_all_buttons: A single method that enables all buttons.
     * This method is only called if when inputing buttons you input all.
     */
    public void enable_all_buttons() {
        for (int k = 0; k < allButtons.length; k++) {
            for (int j = 0; j < allButtons[0].length; j++) {
            	allButtons[k][j].setVisible(true);
            }
        }

    }

    /**
     * getButtonVal: Gets int value of a button if the button has a numerical value
     *
     * @param b A button that has a numerical value. This is one of the buttons below the cateogries.
     * @return value of button or zero if button has no value.
     */
    public int getButtonVal(JButton b) {
        String s = b.getText();
        int val = 0;
        try {
            val = Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
        return val;
    }

    /**
     * reEnable_Buttons: reEnables individual buttons based on user input
     * This method relies on text input from a text field.
     * Uses a x and y cordnate system for buttons with (0, 0) being the top left game button.
     * The bottom left game button has cordinates of (l, w) where l is the number of categories - 1 and
     * w is the number of questions per category - 1.
     * 
     */
    public void reEnable_Buttons() {
        int x = 0;
        int y = 0;
        String input = buttonEdit.getText();

        //if input is all reEnables all disabled buttons
        if (input.equals("all")) {
            this.enable_all_buttons();
        }

        String[] vals = input.split(" ");
        boolean inputs = false;
        try {
            x = Integer.parseInt(vals[0]);
            y = Integer.parseInt(vals[1]);
            inputs = true;
        } catch (Exception e) {
            System.out.println("bad inputs");
            return;
        }

        if (x < allButtons.length && y < allButtons[0].length) {
            allButtons[x][y].setVisible(true);
        }

    }

    /**
     * changeScore: Changes the players score.
     * This function is called when the submit button for editing scores is pressed.
     */
    public void changeScore() {
        String input = changeScores.getText();
        String[] vals = input.split(" ");
        int score = 0;
        int index = 0;
        try {
            index = Integer.parseInt(vals[0]);
            score = Integer.parseInt(vals[1]);
        } catch (Exception e) {
            System.out.println("bad inputs");
            return;
        }
        if (index < players.size()) {
            players.get(index).setScore(score);
            allScores.get(index).setText(Integer.toString(players.get(index).getScore()));
        }
    }
    
    /**
     * CreateBoard: This methods creates the title and the labels 
     * for all the categories and any other miscilanous things on the board.
     * It also places all of these things on the board in the correct location realative to screen size.
     */
    public void createboard() {
        //title
        title.setForeground(Color.BLACK);
        title.setFont(new Font("TimesRoman", 1, screenHeight / 25));
        title.setBounds(screenWidth / 2 - ((int) (screenWidth / 3.6)) / 2, screenHeight / 15,
                (int) (screenWidth / 3.6), screenHeight / 18);
        add(title);

        //editbutton
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        edit.setBounds(screenWidth * 5 / 6, screenHeight / 10, (int) (screenWidth / 28.8), screenHeight / 30);
        edit.addActionListener(this);
        add(edit);

        //donebutton
        done.setBounds(screenWidth * 5 / 6 + (int) (screenWidth / 19.2 * 1.3), screenHeight / 10,
                (int) (screenWidth / 19.2), screenHeight / 30);
        done.addActionListener(this);
        done.setVisible(false);
        add(done);

        //edit buttons text Field
        buttonEdit.setBounds(screenWidth / 30, screenHeight / 4, (int) (screenWidth / 14.4), screenHeight / 30);
        buttonEdit.setVisible(false);
        add(buttonEdit);

        //edit buttons Text
        editBtext.setLabelFor(buttonEdit);
        editBtext.setBounds(screenWidth / 30, screenHeight / 4 - screenHeight / 30 * 3 / 2,
                (int) (screenWidth / 14.4), screenHeight / 30);
        editBtext.setVisible(false);
        add(editBtext);

        //submit button for change buttons
        submit1.setBounds(screenWidth / 30, screenHeight / 4 + screenHeight / 30 * 3 / 2,
                (int) (screenWidth / 14.4), screenHeight / 30);
        submit1.addActionListener(this);
        add(submit1);
        submit1.setVisible(false);

        //Change scores text field
        changeScores.setBounds(screenWidth / 30, screenHeight / 2, (int) (screenWidth / 14.4), screenHeight / 30);
        changeScores.setVisible(false);
        add(changeScores);

        //Label for change scores
        changeScoresText.setBounds(screenWidth / 30, screenHeight / 2 - screenHeight / 30 * 3 / 2,
                (int) (screenWidth / 14.4), screenHeight / 30);
        changeScoresText.setVisible(false);
        add(changeScoresText);

        //Submit button for change scroes
        submit2.setBounds(screenWidth / 30, screenHeight / 2 + screenHeight / 30 * 3 / 2,
                (int) (screenWidth / 14.4), screenHeight / 30);
        submit2.addActionListener(this);
        add(submit2);
        submit2.setVisible(false);

        //Double Jeoprody button
        doubleJ.setBounds((int) (screenWidth / 7.2), screenHeight / 15, (int) (screenWidth / 9.6), screenHeight / 18);
        doubleJ.addActionListener(this);
        add(doubleJ);
        
        //varibles needed for below
        int x = screenWidth / 8;
        int y = screenHeight / 6;
        int widthIncrementor = (int) ((8./9.) * screenWidth - x) / numCategories;
        int heightIncrementor = (int) ((2./3.) * screenHeight - y) / nCQs;
        
        /**
         * Label Dimensions.
         * Start x: 1/8 screen width. End x: 8/9 screen width.
         * Start y = 1/6 screen height. End y: 1/4 screen height - 1/6 screen height
         * xdimension: width incrmentor. 
         * ydimension: 1/4 screen height - 1/6 screen height. This is because 1/4 height is 
         * the start of the buttons and we want labels to be right above the buttons.
         */
        
        //Create labels for categories
        for (int k = 0; k < categories.size(); k++) {
            JLabel subject = new JLabel(categories.get(k).getCname(), SwingConstants.CENTER);
            subject.setFont(new Font("TimesRoman", 0, screenHeight / 37));
            subject.setBounds(x, screenHeight / 6, (int) widthIncrementor, 
            		screenHeight / 4 - screenHeight / 6);
            subject.setBorder(border);
            add(subject);
            allCategories.add(subject);
            x += widthIncrementor;
        }
        
        x = screenWidth / 8;
        y = screenHeight / 4;
        
        /**
         * Button Dimenstions:
         * Start x: 1/8 screen width. End x: 8/9 screen width.
         * Start y = 1/4 screen height. End y: 2/3 screen height
         * xdimension: width incrmentor. 
         * ydimension: height incrementor
         */
        
        //create buttons
        JButton[][] buttons = new JButton[numCategories][nCQs];
        Integer val = 0; 
        String value = "";
        //making all buttons and assigning values
        for (int k = 0; k < buttons.length; k++) {
            for (int j = 0; j < buttons[0].length; j++) {
            	val = categories.get(k).getQuestion(j).getValue();
                value = val.toString();
                buttons[k][j] = new JButton();
                buttons[k][j].setText(value);
                buttons[k][j].setEnabled(true);
                buttons[k][j].addActionListener(this);
                buttons[k][j].setBounds(x, y, widthIncrementor, heightIncrementor);
                add(buttons[k][j]);
                y += heightIncrementor;
            }
            x += widthIncrementor;
            y = screenHeight / 4;
        }
        allButtons = buttons;
        
        x = screenWidth / 8;
        
        /**
         * ScoreBoard Dimenstions:
         * Start x: 1/8 screen width. End x: 8/9 screen width.
         * Start y = 3/4 screen height. End y: height / 18 + 1.3 * height / 18.
         * height / 18 is the ydimension for both label and player name. the 1.3 is margin. 
         * xdimension: width incrmentor. 
         * ydimension: height / 18.
         */
        
        //make scoreboard
        int labelwIncrementor = (int) ((8./9.) * screenWidth - x) / numPlayers;
        Font f = new Font("TimesRoman", 0, screenHeight / 28);
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 1);
        for (int k = 0; k < players.size(); k++) {
            JLabel pname = new JLabel(players.get(k).getName(), SwingConstants.CENTER);
            JLabel scores = new JLabel(Integer.toString(players.get(k).getScore()), SwingConstants.CENTER);
            pname.setFont(f);
            scores.setFont(f);
            scores.setBounds(x, screenHeight * 3 / 4, labelwIncrementor, screenHeight / 18);
            //height here same as above but position is below (this is why the h/18 * 1.3 is below)
            pname.setBounds(x, screenHeight * 3 / 4 + (int) (screenHeight / 18 * 1.3),
                    labelwIncrementor, screenHeight / 18);
            x += labelwIncrementor;
            allScores.add(scores);
            allNames.add(pname);
            add(pname);
            add(scores);
        }
    }
    
    /**
     * resizeBoard: Function that resizes the board if the size of the window changes.
     * This gets called if the height or width changes by .1% or more.
     * This is very similar to the create board method.
     */
    public void resizeBoard() {
    	//changing button bounds
    	title.setBounds(screenWidth / 2 - ((int) (screenWidth / 3.6)) / 2, screenHeight / 15,
                (int) (screenWidth / 3.6), screenHeight / 18);
    	edit.setBounds(screenWidth * 5 / 6, screenHeight / 10, (int) (screenWidth / 28.8), screenHeight / 30);
    	done.setBounds(screenWidth * 5 / 6 + (int) (screenWidth / 19.2 * 1.3), screenHeight / 10,
                (int) (screenWidth / 19.2), screenHeight / 30);
    	buttonEdit.setBounds(screenWidth / 30, screenHeight / 4, (int) (screenWidth / 14.4), screenHeight / 30);
    	editBtext.setBounds(screenWidth / 30, screenHeight / 4 - screenHeight / 30 * 3 / 2,
    	        (int) (screenWidth / 14.4), screenHeight / 30);
    	submit1.setBounds(screenWidth / 30, screenHeight / 4 + screenHeight / 30 * 3 / 2,
    	        (int) (screenWidth / 14.4), screenHeight / 30);
    	changeScores.setBounds(screenWidth / 30, screenHeight / 2, (int) (screenWidth / 14.4), screenHeight / 30);
    	changeScoresText.setBounds(screenWidth / 30, screenHeight / 2 - screenHeight / 30 * 3 / 2,
    	        (int) (screenWidth / 14.4), screenHeight / 30);
    	submit2.setBounds(screenWidth / 30, screenHeight / 2 + screenHeight / 30 * 3 / 2,
    	        (int) (screenWidth / 14.4), screenHeight / 30);
    	doubleJ.setBounds((int) (screenWidth / 7.2), screenHeight / 15, (int) (screenWidth / 9.6), screenHeight / 18);
    	
    	//changing player name and score bounds
    	int x = screenWidth / 8;
    	int labelwIncrementor = (int) ((8./9.) * screenWidth - x) / numPlayers;
    	for (int k = 0; k < allScores.size(); k++) {
    		allScores.get(k).setBounds(x, screenHeight * 3 / 4, labelwIncrementor, screenHeight / 18);
    		allNames.get(k).setBounds(x, screenHeight * 3 / 4 + (int) (screenHeight / 18 * 1.3),
    				labelwIncrementor, screenHeight / 18);
    		x += labelwIncrementor;
    	}
    	
    	//changing button and category label bounds
    	x = screenWidth / 8;
        int y = screenHeight / 4;
    	int widthIncrementor = (int) ((8./9.) * screenWidth - x) / numCategories;
        int heightIncrementor = (int) ((2./3.) * screenHeight - y) / nCQs; 
        for (int k = 0; k < allButtons.length; k++) {
        	allCategories.get(k).setBounds(x, screenHeight / 6, widthIncrementor, 
        		screenHeight / 4 - screenHeight / 6);
        	for (int j = 0; j < allButtons[0].length; j++) {
        		allButtons[k][j].setBounds(x, y, widthIncrementor, heightIncrementor);
        		y += heightIncrementor;
        	}
        	y = screenHeight / 4;
        	x += widthIncrementor;
        }
    }
    
    /**
     * createQBoard: This method creates and places all the parts of the question board (Qboard).
     * This board appears when you click a point button on the Jboard
     *
     * @param q An question object that is the question coresponding to a category/point value.
     */
    public void createQBoard(Question q) {
    	//creating qbuttons
        JButton[] qbuttons = new JButton[numPlayers];
        qboard = new JDialog();
        qboard.addComponentListener(this);
        int x = (int) (screenWidth / 9.6);
        int y = screenHeight * 2 / 3;
        int qxIncrementor = (int) ((8./9.) * screenWidth - x) / numPlayers;
        for (int k = 0; k < players.size(); k++) {
            JButton person = new JButton(players.get(k).getName());
            person.setBounds(x, y, qxIncrementor, screenHeight / 18);
            person.addActionListener(this);
            person.setVisible(false);
            qboard.add(person);
            qbuttons[k] = person;    
            x += qxIncrementor;
        }
        allQButtons = qbuttons;
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Font f = new Font("TimesRoman", 1, screenHeight / 25);
        Font a = new Font("TimesRoman", 0, screenHeight / 45);
        qboard.setSize(screenWidth, screenHeight);

        //title
        qInfo.setText(q.getCategory() + " " + Integer.toString(q.getValue()));
        JLabel title = new JLabel(q.getCategory() + " " + Integer.toString(q.getValue()), SwingConstants.CENTER);
        qInfo = title;
        qInfo.setFont(f);
        qInfo.setBounds(screenWidth / 2 - ((int) (screenWidth / 5.76)) / 2, screenHeight / 9,
                ((int) (screenWidth / 5.76)), screenHeight / 9);
        qInfo.setVisible(true);
        qboard.add(title);

        //question
        question_text.setText(q.get_question());
        question_text.setFont(a);
        question_text.setBounds(0, screenHeight / 4, screenWidth, screenHeight / 9);
        qboard.add(question_text);

        //answer
        ans.setFont(a);
        ans.setText(q.getAnswer());
        ans.setBounds(0, screenHeight / 2, screenWidth, screenHeight / 9);
        qboard.add(ans);
        ans.setVisible(false);

        //showAns button
        showAns.setBounds(screenWidth / 2 - ((int) (screenWidth / 5.76)) / 2, screenHeight / 2,
                (int) (screenWidth / 5.76), screenHeight / 18);
        showAns.addActionListener(this);
        qboard.add(showAns);

        //go back button
        goBack.setBounds((int) (screenWidth / 28.8), screenHeight / 18, (int) (screenWidth / 14.4), screenHeight / 18);
        goBack.addActionListener(this);
        qboard.add(goBack);

        qboard.getContentPane().setBackground(Color.WHITE);
        qboard.setLayout(null);
        qboard.setVisible(true);
    }
    
    /**
     * resizeQboard: A method called when the size of the qboard changes that dynamically 
     * resizes the Qboard based on the Qboards new dimenstions.
     * @param nwidth The new Qboard width.
     * @param nheight The new Qboard height.
     */
    public void resizeQboard(int nwidth, int nheight) {
    	qboard.setSize(nwidth, nheight);
    	int x = (int) (nwidth / 8);
        int y = nheight * 2 / 3;
    	int qxIncrementor = (int) ((8./9.) * nwidth - x) / numPlayers;
    	for (int k = 0; k < players.size(); k++) {
            JButton person = new JButton(players.get(k).getName());
            allQButtons[k].setBounds(x, y, qxIncrementor, nheight / 18);
            qboard.add(person);   
            x += qxIncrementor;
        }
    	ans.setBounds(0, nheight / 2, nwidth, nheight / 9);
    	showAns.setBounds(nwidth / 2 - ((int) (nwidth / 5.76)) / 2, nheight / 2,
                (int) (nwidth / 5.76), nheight / 18);
    	goBack.setBounds((int) (nwidth / 28.8), nheight / 18, (int) (nwidth / 14.4), nheight / 18);
    	question_text.setBounds(0, nheight / 4, nwidth, nheight / 9);
    	qInfo.setBounds(nwidth / 2 - ((int) (nwidth / 5.76)) / 2, nheight / 9,
                ((int) (nwidth / 5.76)), nheight / 9);
    }
    
    //private varibles for the purpose of storing values below.
    private int val = 0;
    private int val1 = 0;
    private int val2 = 0;
    
    /**
     * actionPerformed: This method handels what happens when 
     * any of the buttons on the Qboard or Jboard are pressed
     * Returns after each button is pressed because will the method
     * run each time there is a button pressed (action event).
     * This prevents Null pointer errors and redundency because each action can only happen once.
     * @param e Action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //If one of the number buttons is clicked
        for (int k = 0; k < allButtons.length; k++) {
            for (int j = 0; j < allButtons[0].length; j++) {
                if (e.getSource() == allButtons[k][j]) {
                    if (isEdit == false) {
                        val1 = k;
                        val2 = j;
                        allButtons[k][j].setVisible(false);
                        val = Integer.parseInt(allButtons[k][j].getText());
                        this.createQBoard(categories.get(k).getQuestion(j));
                    }
                    return;
                }
            }
        }

        //If the edit button is clicked
        if (e.getSource() == edit) {
            isEdit = true;
            done.setVisible(true);
            editBtext.setVisible(true);
            buttonEdit.setVisible(true);
            submit1.setVisible(true);
            submit2.setVisible(true);
            changeScoresText.setVisible(true);
            changeScores.setVisible(true);
            return;
        }

        //If the done button is clicked
        if (e.getSource() == done) {
            isEdit = false;
            done.setVisible(false);
            editBtext.setVisible(false);
            buttonEdit.setVisible(false);
            submit1.setVisible(false);
            submit2.setVisible(false);
            changeScoresText.setVisible(false);
            changeScores.setVisible(false);
            return;
        }

        //Submit button for editing buttons
        if (e.getSource() == submit1) {
            reEnable_Buttons();
            return;
        }

        //Submit button for editng scores
        if (e.getSource() == submit2) {
            changeScore();
            return;
        }
        
      //If double jeoprady button is pressed on main board.
        //This creates and opens a double jeoprady board.
        if (e.getSource() == doubleJ) {
        	
        	String[] c = new String[] {"z", "y", "x", "v", "w", "u", "t"};
        	DoubleJboard2 d = new DoubleJboard2(players, c);
            d.getContentPane().setBackground(Color.WHITE);
            d.setSize(d.getScreenWidth(), d.getScreenHeight());
            d.createboard();
            //d.createScoreboard();
            d.createQuestions();
            //d.createbuttons();
            d.setLayout(null);
            d.setVisible(true);
        	return;
        }

        //Qboard no JBoard should come after this because it causes null pointer errors. 
        //if show answer button is clicked
        if (e.getSource() == showAns) {
            showAns.setVisible(false);
            ans.setVisible(true);
            for (int k = 0; k < allQButtons.length; k++) {
                allQButtons[k].setVisible(true);
            }
            return;
        }

        //if go back is clicked
        if (e.getSource() == goBack) {
            qboard.dispose();
            showAns.setVisible(true);
            ans.setVisible(false);
            System.out.println();
            allButtons[val1][val2].setVisible(false);
            return;
        }

        //If one of the player buttons on Qboard is pressed. tells us who won and brings us back to the scoreboard
        for (int k = 0; k < allQButtons.length; k++) {
            if (e.getSource() == allQButtons[k]) {
                players.get(k).add(val);
                allScores.get(k).setText(Integer.toString(players.get(k).getScore()));
                qboard.dispose();
                showAns.setVisible(true);
                ans.setVisible(false);
                return;
            }
        }   
    }

    /**
     * createQuestions: This is the method where all the questions are made.
     */
    public void createQuestions() {
        for (int k = 0; k < categories.size(); k++) {
            for (int j = 1; j < nCQs + 1; j++) {
            	if (qvals.length == nCQs) {
            		categories.get(k).addQuestion(qvals[j - 1], "question", "answer");
            	} else {
            		categories.get(k).addQuestion(j * 100, "question", "answer");
            	}
            }
        }
    }
    /**
	 * percentDiffrence: Helper function to caculate the percent diffrence between two numbers.
	 * @param one First value.
	 * @param two Second value.
	 * @return Double of the percent diffrence between the two numbers. Value is in form 55% not .55.
	 */
	public double percentDiffrence(double one, double two) {
		return ( Math.abs(one - two) / ((one + two) / 2.) ) * 100.;
	}
	
    ///////////////////////////////********** Window and Compenent Events ****************\\\\\\\\\\\\\\\\\\\\\\\
    //below is the code for listners most of it blank mthods because I did not need to use those function
    
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * windowClosing: method to kill program when window is closed.
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void windowStateChanged(WindowEvent e) {
		
	}
	
	
	/**
	 * Compenent Resized: Overiding compenent risized method. 
	 * Checks to see if Window is size has changed by more than .1%.
	 * If the window size has changed by more than .1% then it changes screenWidth and Height and resizes the board.
	 * The .1% tolerence is so low because the lower tolerance gives a more smooth look when changing window sizes.
	 */
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("1308745324");
		double nwidth = getBounds().width;
		double nheight = getBounds().height;
		if (percentDiffrence(screenWidth, nwidth) > .1 || percentDiffrence(screenHeight, nheight) > .1) {
			screenWidth = (int) nwidth;
			screenHeight = (int) nheight;
			//run resize board
			resizeBoard();
		}
		if (e.getSource() == qboard) {
			double nqw = qboard.getBounds().width;
			double nqh = qboard.getBounds().height;
			if (percentDiffrence(screenWidth, nqw) > .1 || percentDiffrence(screenHeight, nqh) > .1) {
				//System.out.println("hello?");
				resizeQboard((int) nqw, (int) nqh);
			}
		}
	}
	

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
