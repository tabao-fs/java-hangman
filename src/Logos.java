import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Logos{
	protected String[][] logoNames = {
			{"T","I","M","B","E","R","L","A","N","D"}, 
			{"D","I","L","M","A","H"},
			{"E","T","I","H","A","D"},
			{"B","A","C","A","R","D","I"}, 
			{"C","H","R","Y","S","L","E","R"},	
			{"C","I","T","R","O","E","N"}, 
			{"M","C","L","A","R","E","N"},
			{"H","A","R","V","A","R","D"}, 
			{"S","E","A","T"},
			{"J","A","G","E","R","M","E","I","S","T","E","R"}, 
			{"M","O","N","S","T","E","R"},
			{"M","E","G","A","W","O","R","L","D"}, 
			{"P","E","T","R","O","N","A","S"},
			{"S","A","F","E","W","A","Y"}, 
			{"Q","A","N","T","A","S"},
			{"T","A","R","G","E","T"}};
	protected String[][] lineName = {
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ "},
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ ","_ "}, 
			{"_ ","_ ","_ ","_ ","_ ","_ "},
			{"_ ","_ ","_ ","_ ","_ ","_ "}};
	public int questionNum=0;
	public int qNumber=randomNumber();
	
	Play game;
	MainMenu menu;
	Listeners listen;
	public Logos(Play game){
		this.game=game;
	}
/*	public Logos(MainMenu menu){
		this.menu=menu;
	}*/
	public Logos(Listeners listen){
		this.listen=listen;
		this.game=new Play(this);
	}
	//Shuffle fileName contents
	protected int randomNumber(){
		questionNum = (int)(Math.random()*15);
		return questionNum;
		//System.out.println(qNumber);
		//Play game = new Play();
	}
	protected String[] ansName(){
		return lineName[qNumber];
	}
	protected int guess=6, letters=0;
	
	//Tests the user input from Buttons
	protected void checkGuess(String btnLetter) {
/*		for(int counter=0; counter<logoNames[questionNumber].length; counter++){
			logoNames[questionNumber][counter]=logoNames[questionNumber][counter].replaceAll("\\s", " ");
		}*/
		boolean testLetter = false;
		for(int count=0; count<logoNames[qNumber].length; count++){
			if(btnLetter.charAt(0)==logoNames[qNumber][count].charAt(0)){
				letters++;
				testLetter=true;
				for(int index=0;index<logoNames[qNumber].length;index++){
					if(logoNames[qNumber][index].charAt(0)==btnLetter.charAt(0)){
						lineName[qNumber][index]=lineName[qNumber][index].replace("_", btnLetter);
					}
					this.game.addAnswer(lineName[qNumber]);
				}
			}
			else if(count==(logoNames[qNumber].length-1))
			{
				if(testLetter==false){
				--guess;
					if(guess==0){
						System.out.println("You have run out of guesses. Game Over!");
						this.game.hangMan();
                    	Image img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
                    	int yesOpt = JOptionPane.showConfirmDialog(null,"You have run out of guesses. Game Over!\nWould you like to play again?", "Play", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(img));
                    	if(yesOpt==JOptionPane.YES_OPTION){
                    		this.game.setVisible(false);
                    		randomNumber();
                    	}
                    	else{
                    		game.setVisible(false);
                    		setMainMenu();
                    	}
					}
					else{
						System.out.println("You have "+guess+" more guesses.");
						this.game.hangMan();
					}
				}
			}
		}
		if(letters==logoNames[qNumber].length){
			System.out.println("Congratulations! You got the correct answer.");
			Image img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        	int yesOpt = JOptionPane.showConfirmDialog(null,"Congratulations! You got the correct answer.\nWould you like to play again?", "Play", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(img));
        	if(yesOpt==JOptionPane.YES_OPTION){
        		game.setVisible(false);
        		randomNumber();
        	}
        	else{
        		game.setVisible(false);
        		setMainMenu();
        	}
		}
	}
	protected void setBlanks(){
		
	}
	public void setMainMenu(){
		menu = new MainMenu();
	}
}
