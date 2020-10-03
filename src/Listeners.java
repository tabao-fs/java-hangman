import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Listeners implements ActionListener, MouseListener{
	Play game;
	MainMenu menu;
	Logos logo;
	public Listeners(Play game){
		this.game=game;
	}
	public Listeners(MainMenu menu){
		this.menu=menu;
	}
	public Listeners(Logos logo){
		this.logo=logo;
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		//MainMenu
		//lblGame MouseListener
		if(arg0.getSource()==menu.lblGame){
			this.logo = new Logos(this);
			menu.setVisible(false);
			this.logo.randomNumber();
		}
		//lblClose MouseListener
		if(arg0.getSource()==menu.lblClose){
        	Image img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        	int yesOpt = JOptionPane.showConfirmDialog(null,"Would you like to exit the application?", "Close", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(img));
        	if(yesOpt==JOptionPane.YES_OPTION){
        		System.exit(0);
		}
		}
		//lblInfo MouseListener
		if(arg0.getSource()==menu.lblInfo){
			JOptionPane.showMessageDialog(null, "Developer: Abao, Tom", "Information", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//Play
		if(ae.getSource()==this.game.btnMenu){
			MainMenu mnu = new MainMenu();
			this.game.setVisible(false);			
		}
		for(int y=0; y<this.game.abtn.length; y++){
			if(ae.getSource()==this.game.abtn[y]){
				String btnLetter = this.game.abtn[y].getText();
				this.logo.checkGuess(this.game.abtn[y].getText());
				logo.checkGuess(btnLetter);
				this.game.abtn[y].setEnabled(false);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
