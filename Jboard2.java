import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Jboard2 extends JFrame implements ActionListener {
    
//    private int screen_height;
//    private int screen_width;;
//    private int num_players;
//    private Player[] players;
//    private Question question;
//    private int qnum;
//    private int[] points;
    
    /**
     * Screen Width
     */
    private int screenWidth = 500;//(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    /**
     * Screen Height
     */
    private int screenHeight = 500;//(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    /**
     * categories
     */
    private ArrayList<category> categories = new ArrayList<category>();
    
    /**
     * 
     */
    private ArrayList<Player> players = new ArrayList<Player>();
    
    private int numCategories;
    
    private int numPlayers;
    
    /**
     * empty constructor
     */
    Jboard2() {}
    
    /**
     * This is the Jboard constructor used to construct the jeoprady board without given player points
     * @param categories_names An array of strings. The strings are the names of the categories.
     * @param playerNames The names of the players.
     */
    Jboard2(String[] categories_names,String[] playerNames) {
    	setcategories(categories_names);
    	makePlayers(playerNames);
    	numCategories = categories.size();
    	numPlayers = players.size();
    	
    }
    
    /**
     * This is the Jboard constructor used to construct the jeoprady board.
     * @param categories_names An array of strings. The strings are the names of the categories.
     * @param playerPoints The starting points of the players. If this is empty there are zero.
     * @param playerNames The names of the players.
     */
    Jboard2(String[] categories_names, int[] playerPoints, String[] playerNames) {
    	setcategories(categories_names);
    	makePlayers(playerPoints, playerNames);
    	
    }
    
    
    /**
     * Helper function that sets the categories
     * @param cnames list of names of the categories
     */
    public void setcategories(String[] cnames) {
    	for (int k = 0; k < cnames.length; k++) {
    		category c = new category(cnames[k]);
    		categories.add(c);
    	}
    	return;
    }
    
    /**
     * Helper function that creates the players.
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
     * Helper function that creates the players.
     * @param points Starting points of the players.
     * @param pnames Names of the players.
     */
    public void makePlayers(int[] points, String[] pnames) {
    	if (points.length != pnames.length) {
    		makePlayers(pnames);
    		return;
    	}
    	for (int k = 0; k < pnames.length; k++) {
    		Player p = new Player(pnames[k], points[k]);
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
     * gets screen width
     *
     * @return screen width
     */
    public int getScreenWidth() {
        return screenWidth;
    }
    
    //addComponentlister(this);
    //below this is the old Jboard class code used for creating the Jboard.
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
     * reEnable buttons input field
     */
    private JTextField buttonEdit = new JTextField("");
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
     * Arraylist that holds all the labels of the scores.
     */
    private ArrayList<JLabel> allScores = new ArrayList<JLabel>();
    /**
     * double jeoprady button
     */
    private JButton doubleJ = new JButton("Double Jeoprady");

    //Qboard vars

    /**
     * the question board
     */
    private JDialog qboard = new JDialog();
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
    private JButton[] allQButtons = new JButton[9];
    /**
     * the answer to the question
     */
    private JLabel ans = new JLabel("", SwingConstants.CENTER);

    
    /**
     * This methods creates the title and the labels for all the categories and any other miscilanous things on the board
     */
    public void createboard() {
        //title
        JLabel title = new JLabel("FFLC 89 2019 Jeopardy");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("TimesRoman", 1, screenHeight / 25));
        title.setBounds(screenWidth / 2 - ((int) (screenWidth / 3.6)) / 2, screenHeight / 15,
                (int) (screenWidth / 3.6), screenHeight / 18);
        add(title);
        float x = getAlignmentX();
        float y = getAlignmentY();
        System.out.println(x + " , " + y);

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

        //Create labels for categories
        int w = screenWidth / 8;
        for (int k = 0; k < categories.size(); k++) {
            JLabel subject = new JLabel(categories.get(k).getCname(), SwingConstants.CENTER);
            subject.setFont(new Font("TimesRoman", 0, screenHeight / 37));
            subject.setBounds(w, screenHeight / 6, (int) (screenWidth / 14.4), screenHeight / 12);
            subject.setBorder(border);
            add(subject);
            w += (int) (screenWidth / 14.4);
        }

    }

    /**
     * This method creates all the Score Buttons
     * Should be Void?
     * Should be in create board?
     * @return a 2d array of all the score buttons
     */
    public JButton[][] createbuttons() {
        JButton[][] buttons = new JButton[numCategories][5];
        int x = screenWidth / 8;
        int y = screenHeight / 6 + screenHeight / 12;
        Integer val = 100;
        String value = val.toString();
        double widthDivider = (1 / numCategories) * 10;
        double heightDivider = 1 / 12;

        //making all buttons and assigning values
        for (int k = 0; k < buttons.length; k++) {
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[k][j] = new JButton();
                buttons[k][j].setText(value);
                buttons[k][j].setEnabled(true);
                buttons[k][j].addActionListener(this);
                //buttons[k][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                
                buttons[k][j].setBounds(x, y, (int) (screenWidth / 14.4), screenHeight / 12);
                add(buttons[k][j]);
                val += 100;
                value = val.toString();
                y += screenHeight / 12;
            }
            x += (int) (screenWidth / 14.4);
            val = 100;
            value = val.toString();
            y = screenHeight / 6 + screenHeight / 12;
        }
        allButtons = buttons;
        return buttons;
    }

    /**
     * method that enables all buttons
     */
    public void enable_all_buttons() {
        for (int k = 0; k < allButtons.length; k++) {
            for (int j = 0; j < allButtons[0].length; j++) {
                allButtons[k][j].setVisible(true);
                //test
            }
        }

    }

    /**
     * Method that gets value of a button if the button has a numerical value
     *
     * @param b a button that has a numerical value
     * @return value of button
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
     * Method that can reEnable individual buttons based on user input
     * Input is aspose to be x,y cords of the button
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
        System.out.println(vals);
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
     * changes the score
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
     * Creates the scoreboard
     */
    public void createScoreboard() {
        Font f = new Font("TimesRoman", 0, screenHeight / 28);
        int x = screenWidth / 8;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        for (int k = 0; k < players.size(); k++) {
            JLabel pname = new JLabel(players.get(k).getName(), SwingConstants.CENTER);
            JLabel scores = new JLabel(Integer.toString(players.get(k).getScore()), SwingConstants.CENTER);
            pname.setFont(f);
            scores.setFont(f);
            scores.setBounds(x, screenHeight * 3 / 4, (int) (screenWidth / 14.4), screenHeight / 18);
            pname.setBounds(x, screenHeight * 3 / 4 + (int) (screenHeight / 18 * 1.3),
                    (int) (screenWidth / 14.4), screenHeight / 18);
            x += (int) (screenWidth / 11.5);
            allScores.add(scores);
            add(pname);
            add(scores);
        }
    }

    /**
     * Creates question board butttons
     */
    public void createQButtons() {
        qboard = new JDialog();
        int x = (int) (screenWidth / 9.6);
        int y = screenHeight * 2 / 3;
        for (int k = 0; k < players.size(); k++) {
            JButton person = new JButton(players.get(k).getName());
            person.setBounds(x, y, (int) (screenWidth / 14.4), screenHeight / 18);
            person.addActionListener(this);
            person.setVisible(false);
            qboard.add(person);
            allQButtons[k] = person;
            x += (screenWidth / 11.5);
        }
    }

    /**
     * Creates the question board
     *
     * @param q the question and answer
     */
    public void createQBoard(Question q) {
        this.createQButtons();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Font f = new Font("TimesRoman", 1, screenHeight / 25);
        Font a = new Font("TimesRoman", 0, screenHeight / 45);
        qboard.setSize(screenWidth, screenHeight);

        //title
        JLabel title = new JLabel(q.getCategory() + " " + Integer.toString(q.getValue()), SwingConstants.CENTER);
        title.setFont(f);
        title.setBounds(screenWidth / 2 - ((int) (screenWidth / 5.76)) / 2, screenHeight / 9,
                ((int) (screenWidth / 5.76)), screenHeight / 9);
        title.setVisible(true);
        qboard.add(title);

        //question
        JLabel ques = new JLabel(q.get_question(), SwingConstants.CENTER);
        ques.setFont(a);
        ques.setBounds(0, screenHeight / 4, screenWidth, screenHeight / 9);
        qboard.add(ques);

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
    
    private int val = 0;
    private int val1 = 0;
    private int val2 = 0;
    
    /**
     * What happens when the button is pressed
     * the private varibles are there to help retain information
     *
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
                        //val = categories.get(k).getQuestion(j).getValue();
                    }
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
        }

        //Submit button for editing buttons
        if (e.getSource() == submit1) {
            reEnable_Buttons();
        }

        //Submit button for editng scores
        if (e.getSource() == submit2) {
            changeScore();
        }

        //Qboard
        //if show answer button is clicked
        if (e.getSource() == showAns) {
            showAns.setVisible(false);
            ans.setVisible(true);
            for (int k = 0; k < allQButtons.length; k++) {
                allQButtons[k].setVisible(true);
            }
        }

        //if go back is clicked
        if (e.getSource() == goBack) {
            qboard.dispose();
            showAns.setVisible(true);
            ans.setVisible(false);
            System.out.println();
            allButtons[val1][val2].setVisible( false);
        }

        //If one of the player buttons on Qboard is pressed. tells us who won and brings us back to the scoreboard
        for (int k = 0; k < allQButtons.length; k++) {
            if (e.getSource() == allQButtons[k]) {
                players.get(k).add(val);
                allScores.get(k).setText(Integer.toString(players.get(k).getScore()));
                qboard.dispose();
                showAns.setVisible(true);
                ans.setVisible(false);
            }
        }
        if (e.getSource() == doubleJ) {
            DoubleJboard d = new DoubleJboard(players);
            d.getContentPane().setBackground(Color.WHITE);
            d.setSize(d.getScreenWidth(), d.getScreenHeight());
            d.createboard();
            d.createScoreboard();
            d.createQuestions();
            d.createbuttons();
            d.setLayout(null);
            d.setVisible(true);
        }
    }

    /**
     * Method where I input all the questions.
     */
    public void createQuestions() {
        for (int k = 0; k < categories.size(); k++) {
            for (int j = 100; j < 600; j += 100) {
                categories.get(k).addQuestion(j, "question", "answer");
            }
        }
    }
    
    

}
