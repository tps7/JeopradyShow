/**
 * Class of the player object. This object represents the player who plays the game.
 * This object stores a int score and a string name.
 * @author timothysullivan
 *
 */
public class Player {
    private int score;
    private String name;
    Player() { }
    Player (String names) {
        name = names;
        score = 0;
    }
    Player(String names, int scores) {
        score = scores;
        name = names;
    }

    /**
     * gets score
     * @return players score
     */
    public int getScore() {return score;}

    /**
     * gets player name
     * @return players name
     */
    public String getName() {return name;}

    /**
     * changes players score
     * @param newScore the new player score
     */
    public void setScore(int newScore) {
        score = newScore;
    }

    /**
     * changes players name
     * @param newName new player name
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * adds to players score
     * @param num amount added
     */
    public void add(int num) {
        score += num;
    }
    /**Player Ryan = new Player("Ryan", 0);
    Player Kyle = new Player("Kyle", 0);
    Player Chris = new Player("Chris", 0);
    Player Joey = new Player("Joey", 0);
    Player Leftari = new Player("Leftari", 0);
    Player Kosta = new Player("Kosta", 0);
    Player JackS = new Player("Jack S", 0);
    Player Jared = new Player("Jared", 0);
    Player Jeff = new Player("Jeff", 0);*/
}
