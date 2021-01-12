# Jeoprady
## What is Jeoprady? 
Jeoprady is a modified version of the Jeoprady game show. Jeoprady is meant to be a fun game a group of friends can play. Friends can submit questions to the game host, and then guess each others questions. Answering a question correctly would get a player points, and the player with the most points at the ends wins. Players can also submit questions for a double jeoprady, which can be playerd after the intial game is finished. The game itself keeps track of player points, the questions that have been answered, and stores all of the information on each question and how many points each question is worth. Their are a few major diffrences between this version of jeoprady and tradition jeoprady from the game show on TV. First in this jeoprady players do not lose points for guessing. Second this game can be played by any amount of players. Lastly their can be any number of questions per category, and the point values of each question can vary. For more infomation on traditional jeoprady visit [https://en.wikipedia.org/wiki/Jeopardy!].
## Instalation
Jeoprady can be downloaded from this github, and should be able to run immediatly after downloading. Note: the computer downloading this project must have java in order for the project to run. You can start the game by running the main.java file.
## Usage
To intially start the project run the main.java class. For refrence the project using eclipse IDE. If you run main.java immeditly after downloading the project you should see the following screen.

**Editing Players, Category, and Question Points**
Right now, in the default game all of the players have the names of numbers (1-11), and all the categories have a one letter name. Since the game has already started in order to change the players and cateogries you would have to exit the game. Unfortinatly to edit things like player names, number of players, category names, number of categories, number of questions per category, and question point value, you need to go into the code and manually change the values. 
To change the category names, player names, and question point values you need to go into the main.java file and edit the lists cats,and people. You could also make your own lists, but make sure to change the code where your cats and people appear. For example changing a category 

Once the list is edited run main.java. You should see updated category names!

The process is almost exactly the same for changing point values and player names. Edit the lists and run main.java. The player names, and point values for each question should be updated.


Note the number of categories, player's, and questions per category is equal to the number of elements in each of their respective arrays
Now going to back to the orginal board lets say you want to answer a question. Lets say you choose the question from category a for 100 points.


**Clicking on Questions**
Once you click up on the button a popup should appear. This should have all the category and question point value in bold at the top in this case the category is a and the point value is 100. Below this you should have the question itself. In the default game all of the questions are set to be "question". At this point their is two buttons you can press, Go Back, and Show Answer. If you press Go Back the question is removed from the game board, and no points are awareded. 

If you click the show answer button the answer to the question will appear. The default answer to all questions is "answer". Below the answer buttons corresponding to each player name should appear. Clicking on a button will award points to whichevers player's button is pressed. If nobody gets the question right you can still click on the Go Back button and nobody will get points. Lets pretend player 5 got the question right. 


By clicking on player 5 you now come back to the game board. Player 5 will now have 100 points. If player 5 gets more quesstions right the value from those questions will then add to player 5's total score. 

This process applies to other players as well.

**Editing the game board during the game**
Lets say the game host makes a mistake, like for example clicking on the wrong question or giving the wrong player points for a question. This where the edit button in the upper right corner comes in handy. When you press on the edit button you get a modfied version of the board.

Their are a couple options for editing. You can Enable buttons using the edit buttons line. You can change scores using the edit scores line. Explanations for how edit the board appear on the right side of the screen. Below are two examples of enabling the button b 100, and ediing the score of player 7 so that player 6 has 7000 points. 

While in the edit function screen all of the question buttons are disabled, so you do not accidently click on any questions. To finish editing you can go back to the normal game board by pressing the done button that appears right below the edit function. There is no function to disable buttons in the edit screen because this can be done easily in the main game sceeen by clicking on a question, and then clicking the go back button. 

**Editing Questions and Answers**
Like with editing categories and player's edting the questions and answers must be done in the code. If you go to the Jboard2.java file and scroll down to the createQuestions function you should see the loop that is currently being used to set all of the questions with their default values.

To manually set the questions you need to get the cateigory from the category array list and call the addQuestion function. The categories are listed in the list by zero based indexing in the order they are inputed from the main file. For example to get category a from the default game board you would do categories.get(0). To get cateogory c you would do categories.get(2). To make a question in a category you would type the following code categories.get(index of category).addQuestion(question point value, question, answer). For example if you wanted to set the 500 point question for category i to "What is the ninth letter in the alphebet?" you would type the following categories.get(8).addQuestion(500, "What is the ninth letter in the alphebet?", "I"); Below is the version in code.

Note: the question was added before the loop. If you add the question after the loop it will not overwrite the question already present. To change a question after its already added use the set question function. Also ideally when playing the game you will not have the loop function to set the default values of the questions, instead you would have a question for each point value for every category in the game. If all the categories in the game are not full of questions the game will crash. 
Changing the question in the code changes the question on the game board. Using the example from above:



As you can see the question and answer changed from the default for the question i 500. 

**Save and Load**
What if you are playing jeoprady, and you want to stop take a break and play again later? To do this you click the save button in the upper right hand corner. Enter the name that you want to save the game under and click ok. This will document all of the game data in a .txt file. 

If you want to load the game later click run main.java and click on the Load button. Type in the name of the file you want to load, and your saved game will load. 

This function works even if the details of the game in the code are diffrent than the game you want to load. For example if the categories are "a, b, c" in the code you can still load and play a game with categories "1, 2, 3, 4, 5". The questions you have answered and the point for each player in the saved game will also carry over once you load the game.

**Game Data Storage**
When you save or load a game all of the data is saved, and loaded from a .txt file. This file is formated as follows:
* Line 1 = JBoard
* Line 2 = Qvals
* Line 3 = The values for each question seperated by a space for example: 100 200 300 400 500
* Line 4 = Categories
* Line 5 = The name of the first category
* Line 6 = The point value of the first question in the first category
* Line 7 = The first question
* Line 8 = The answer to the first question
* Line 9-X = Lines 6-8 repeat so the point value for the second question the second question, the second answer, ect. all the way until there are no more questions in the category
* Line X + 1 = A blank line to signal the start of a new category
* Line (X + 2)-Y = The process detailed above for every category in the game
* Once the categories and questions have been listed thier is a blank line followed by the line Scoreboard. Lets call the Line that = Scoreboard line Z.
* Line Z + 1 = Score of Player 1 followed by the name of player 1.
* Line Z + 2-W = Score of Player followed by name of player for all the players
* Line W + 1 = CheckBoard
* Line W + 2 = the dimenstions of the board each seprated by a space. The dimensions are number of categories, number of players, number of questions per category.
* Line W + 3 = Buttons
* Line W + 4 = A zeros and ones representing if a question button is enabled or not (1 is enabled). THe values represent the matrix and are ordered by all buttons in the first category, followed by all the buttons in the second category, repeating until the last category. This is all one line. This line is the line in the text file.
Using this formating some could make a game from a .txt file, bypassing the need to edit the code to change the questions, players, categories, ect. Both options are viable, but making .txt files of games from scratch could run into a lot of errors if formating in the .txt file is wrong. Also if the description of the .txt file formating is confusing look at the .txt file's themselves and try saving and loading some games. Playing around with save and load should help the formating of the .txt files become more apparent.

**Double Jeoprady**
Once you finish answering all the questions the double jeoprady button that is normally disabled at the top of the screen will become enabled. 

By clickng on the Double Jeoprady Button you will get a new game board with new questions and categories. Player names and scores will carry over from the old game. 


Note the categories, quetions per category, and points per question can be different than the original game. Other than that the game functions the same as the original game board


**Miscilanious Features**
The while playing the game what happens will be written to a file called gamelog.txt. The game log documents what happens in the game i.e. what question was picked who got that question correct (if anybody), and the players point total after they got a question correct. The game log also shows if double jeoprady was started or if a new game was loaded. The game log is written over every time you run main.java again, so if you want to save a gamelog save it to a different file than gamelog.txt. The gamelog does not show game edits, so if you edit a players score it will not show in the game log.

All of the parts of the game resize if the size of the game window changes, larger if the window size increases, smaller if the window size decreases. If you make the window to small you may not be able to read some parts of the game.
