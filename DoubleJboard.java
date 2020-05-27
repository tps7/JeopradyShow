import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

public class DoubleJboard extends JFrame implements ActionListener {
    /**
     * Board Height
     */
    static final int BOARD_HEIGHT = 6;
    /**
     * Board Width
     */
    static final int BOARD_WIDTH = 5;
    /**
     * Screen Width
     */
    private int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    /**
     * Screen Height
     */
    private int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
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
    private JTextField changeScores = new JTextField("");
    private JLabel changeScoresText = new JLabel("Edit Scores");
    /**
     * all game player
     */
    public ArrayList<Player> allPlayers = new ArrayList<Player>();
    /**
     * is the board being edited
     */
    private boolean isEdit = false;
    /**
     * all the categorys for the game
     */
    private category blaine = new category("Blaine");
    private category women = new category("Female Biology");
    private category sexActs = new category("Sex Acts");
    private category fflc = new category("FFLC League History");
    private category football = new category("Football");
    /**
     * all categories in a arrayList
     */
    private ArrayList<category> categorys = new ArrayList<category>();
    //private JLabel ans = new JLabel(answer, SwingConstants.CENTER);

    private ArrayList<JLabel> allScores = new ArrayList<JLabel>();
    //private JLabel ans = new JLabel(answer, SwingConstants.CENTER);
    private JButton finalJ = new JButton("Final Jeoprady"); //Edited

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
    private JButton[] allQButtons = new JButton[9];
    private JLabel ans = new JLabel("", SwingConstants.CENTER);
    private int val;


    /**
     * Construtor
     */
    DoubleJboard(ArrayList<Player> p) {
        allPlayers = p;
    }

    public ArrayList<Player> getPlayers() {
        return allPlayers;
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

    public void setCategorys() {
        categorys.add(blaine);
        categorys.add(women);
        categorys.add(sexActs);
        categorys.add(fflc);
        categorys.add(football);

    }

    public void createQuestions() {
        //Blaine
        blaine.addQuestion(150, "What number did Blaine wear while he played on the Jaguars", "11");
        blaine.addQuestion(300, "Where did Blaine Gabbert go to college", "University of Missouri");
        blaine.addQuestion(750, "Who picked Blaine in the NFL Draft? What spot was he picked at and what year was it?",
                "Jacksonville Jaguars 2011 round 1 pick ten ");
        blaine.addQuestion(450, "Blaine is 29 years old. When is his Birthday (include year)",
                "October 15 1989, Will also accept the answer that since Blaine is a god he predates the big bang");
        blaine.addQuestion(600, "What team is Blaine currently on", "Tampa Bay Buccaneers");

        //Women
        women.addQuestion(150, "What part of the female reproductive system recieves the penis during intercourse?",
        "Vagina");
        women.addQuestion(300, "How long is a menstrual cycle",
                "28 days average will also accept 4-6 weeks or a month");
        women.addQuestion(450, "Name the female reproductive part that carries the eggs from the ovaries to the uterus",
                "fallopian tubes");
        women.addQuestion(600, "At birth how many eggs does a women have",
                "1 million eggs will also accept the answer of zero bc of transgenders");
        women.addQuestion(750, "What are the Bartholins's glands?",
                "glands next to the vaginal opening on each side and produce a fluid (mucus) secretion");

        //SexActs
        sexActs.addQuestion(150, "Define Bukkake",
                "Many guys cumming on a single girl");
        sexActs.addQuestion(300, "<html>Given the definition define the following sex act A daring sexual maneuver <br> midcoitus, one person " +
                "bites the neck of the other, locks their arms and legs down and goes into a deathroll all while maintaining insertion",
                "Alligator fuckhouse");
        sexActs.addQuestion(450, "What is munging?", "<html>Diging up a fresh female corpse in a graveyard and having a gang" +
                "bang. once everybody is done  someone puts there mouth on the Vagina <br> and another jumps onto the stomach shooting all the cum and maggots " +
                "into said persons mouth, this would make a great loser punishment will accept less specific answers</html>");
        sexActs.addQuestion(600, "Define the Sex act charizard",
                "<html>while having sex with a girl with pubic hair light her pubes on fire as you ejaculate, afterwards while whe is flapping " +
                        "her arms about wildly scream YOU DON't HAVE ENOUGH BADGES TO TRAIN ME! and run out of the room</html>");
        sexActs.addQuestion(750, "Define the sex act coyote.",
                "<html>This occurs when you wake up in the room of a nasty wombat and you know you’ve got to give her the slip " +
                        "however you realize that your arm is wrapped around around her. " +
                        "There fore you must gnaw off your own arm to get out of the situation. Can be very painful.</html>");


        //FFLC League History
        fflc.addQuestion(450, "Name all the League Champions in chronological order beginning in 2014 " +
                        "(You will not lose points if you begin in 2013)",
                "Ryan Jack Kyle Joey Joey");
        fflc.addQuestion(750, "Last year we decided draft order via a spelling bee. Name 5 of the 8 categories from last years bee",
                "5 of any of these: Player Names, Hookups, Sex Acts, Timmy Words, Towns in US, Death, Alcohol, Diseases");
        fflc.addQuestion(150, "Who was the Number 1 overall pick last year in our league", "Le'veon bell");
        fflc.addQuestion(300, "Who was the one person who was kicked out of the League", "Brian Goldman");
        fflc.addQuestion(600, "What is the maximum amount of players somone in our League can own?",
                "20. 16 players 4 IR");

        //Football
        football.addQuestion(450, "What year was the first Superbowl", "1967");
        football.addQuestion(600, "Who is the highest paid football player", "Lionel Messi $84 million salary");
        football.addQuestion(750, "<html>No game in the NFL has ever had a score where a team only has one point (like a score of 20-1) <br> " +
                        "however it is possible for a NFL team to put up a single point. explain how an team would go about doing this</html>",
                "<html> One Point Safety, Team A scores a touchdown, but PAT is blocked. Team B runs touchdown back but fumbles into Team A endzone <br>" +
                        "Team A recovers said fumble in there own Endzone and is downed </html>");
        football.addQuestion(300, "What QB set the NFL record for TD's in a single season? How TD's did he/she throw?",
                "Peyton Manning 55");
        football.addQuestion(150, "What two teams were in the 2019 Superbowl and who won?",
                "New England Patriots and Los Angeles Rams. Patriots won");

    }

    /**
     * This methods creates the title and the labels for all the categorys and any other miscilanous things on the board
     */
    public void createboard() { //edited the categories
        //title
        JLabel title = new JLabel("FFLC 89 2019 Double Jeopardy");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("TimesRoman", 1, screenHeight / 25));
        title.setBounds(screenWidth / 2 - ((int) (screenWidth / 2.88)) / 2, screenHeight / 15,
                (int) (screenWidth / 2.88), screenHeight / 18);
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

        //Final Jeoprody button
        finalJ.setBounds((int) (screenWidth / 7.2), screenHeight / 15, (int) (screenWidth / 9.6), screenHeight / 18);
        finalJ.addActionListener(this);
        add(finalJ);

        //Create labels for categories
        int w = screenWidth / 8;
        this.setCategorys();
        for (int k = 0; k < categorys.size(); k++) {
            JLabel subject = new JLabel(categorys.get(k).getCname(), SwingConstants.CENTER);
            subject.setFont(new Font("TimesRoman", 0, screenHeight / 37));
            subject.setBounds(w, screenHeight / 6, (int) (screenWidth / 6.4), screenHeight / 12);
            subject.setBorder(border);
            add(subject);
            w += (int) (screenWidth / 6.4);
        }

    }

    /**
     * This method creates all the Score Buttons
     *
     * @return a 2d array of all the score buttons
     */
    public JButton[][] createbuttons() {  //edited
        JButton[][] buttons = new JButton[5][5];
        int x = screenWidth / 8;
        int y = screenHeight / 6 + screenHeight / 12;
        Integer val = 150;
        String value = val.toString();

        //making all buttons and assigning values
        for (int k = 0; k < buttons.length; k++) {
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[k][j] = new JButton();
                buttons[k][j].setText(value);
                buttons[k][j].setEnabled(true);
                buttons[k][j].addActionListener(this);
                //buttons[k][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                buttons[k][j].setBounds(x, y, (int) (screenWidth / 6.4), screenHeight / 12);
                add(buttons[k][j]);
                val += 150;
                value = val.toString();
                y += screenHeight / 12;
            }
            x += (int) (screenWidth / 6.4);
            val = 150;
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
                allButtons[k][j].setEnabled(true);
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
        if (index < allPlayers.size()) {
            allPlayers.get(index).setScore(score);
            allScores.get(index).setText(Integer.toString(allPlayers.get(index).getScore()));
        }
    }


    /**
     * Creates the scoreboard
     */
    public void createScoreboard() {
        Font f = new Font("TimesRoman", 0, screenHeight / 28);
        int x = screenWidth / 8;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        for (int k = 0; k < allPlayers.size(); k++) {
            JLabel pname = new JLabel(allPlayers.get(k).getName(), SwingConstants.CENTER);
            JLabel scores = new JLabel(Integer.toString(allPlayers.get(k).getScore()), SwingConstants.CENTER);
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

    public void createQButtons() {
        qboard = new JDialog();
        int x = (int) (screenWidth / 9.6);
        int y = screenHeight * 2 / 3;
        for (int k = 0; k < allPlayers.size(); k++) {
            JButton person = new JButton(allPlayers.get(k).getName());
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
        title.setBounds(screenWidth / 2 - ((int) (screenWidth / 3.2)) / 2, screenHeight / 9,
                ((int) (screenWidth / 3.2)), screenHeight / 9);
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

    /**
     * What happens when the button is pressed
     *
     * @param e Action event
     */
    private int val1 = 0;
    private int val2 = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int k = 0; k < allButtons.length; k++) {
            for (int j = 0; j < allButtons[0].length; j++) { //loops are rows through colums
                if (e.getSource() == allButtons[k][j]) {
                    if (isEdit == false) {
                        val1 = k;
                        val2 = j;
                        allButtons[k][j].setVisible(false);
                        val = Integer.parseInt(allButtons[k][j].getText());
                        this.createQBoard(categorys.get(k).getQuestion(j));
                        //val = categorys.get(k).getQuestion(j).getValue();
                    }
                }
            }
        }
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
        if (e.getSource() == submit1) {
            reEnable_Buttons();
        }
        if (e.getSource() == submit2) {
            changeScore();
        }

        //Qboard
        if (e.getSource() == showAns) {
            showAns.setVisible(false);
            ans.setVisible(true);
            for (int k = 0; k < allQButtons.length; k++) {
                allQButtons[k].setVisible(true);
            }
        }
        if (e.getSource() == goBack) {
            qboard.dispose();
            showAns.setVisible(true);
            ans.setVisible(false);
            //allButtons[val1][val2].setEnabled(false);
        }
        for (int k = 0; k < allQButtons.length; k++) {
            if (e.getSource() == allQButtons[k]) {
                allPlayers.get(k).add(val);
                allScores.get(k).setText(Integer.toString(allPlayers.get(k).getScore()));
                qboard.dispose();
                showAns.setVisible(true);
                ans.setVisible(false);
            }
        }
    }
}
