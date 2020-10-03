import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Play extends JFrame{
	private JPanel hobo = new JPanel(); //hang+logo
	private JPanel hang = new JPanel();
	private JPanel logoPic = new JPanel();
	private JPanel ans = new JPanel();
	private JPanel user = new JPanel();
	private JPanel panelMenu = new JPanel();
	JButton[] abtn = new JButton[26];
	private String a="A", b=a;
	private char letter=a.charAt(0);
	private JPanel display = new JPanel();
	JButton btnMenu = new JButton("Menu");
	private JLabel dname = new JLabel();
	private Icon iconLogo, iconMan;
	private ImageIcon iconGUI  = new ImageIcon(getClass().getResource("Images/Icon.png"));
	private JLabel lblMan = new JLabel(iconMan);
	private JLabel lblLogo = new JLabel(iconLogo);
	private JLabel freespace = new JLabel();
	private JLabel freespace2 = new JLabel();
	private Font fnt = new Font("Arial", Font.BOLD, 45);
	Listeners listen;
	Logos logo;
	MainMenu menu;
	
	public Play(final Logos logo){
		super("Hangman");
		this.logo=logo;
		this.listen = new Listeners(this);
		
		//Logo
		//frame.setLayout(new GridLayout(2, 1, 15, 0));
		this.setLayout(new GridLayout(2, 1, 15, 0));
		hobo.setLayout(new GridLayout(1, 2));
		
		//Display Logo
		displayLogo();
		
		//Hangman
		hangMan();
		
		//Hangman+Logo
		hobo.add(hang);
		hobo.add(logoPic);
		
		this.getContentPane().add(hobo);
		
		//Displays the lineName
		StringBuilder bldr = new StringBuilder();
		for(String value : this.logo.lineName[this.logo.qNumber]){
			bldr.append(value);
		}
		String aName = bldr.toString();
		
		btnMenu.setFont(fnt);
		
		//Display Blanks
		dname.setFont(fnt);
		dname.setText(aName);
		display.add(dname);
		
		panelMenu.setLayout(new GridLayout(1,3));
		panelMenu.add(freespace);
		panelMenu.add(btnMenu);
		panelMenu.add(freespace2);
		
		//JPanels
		ans.setLayout(new GridLayout(3,1));
		ans.add(panelMenu);
		ans.add(display);
		ans.add(user);
		getContentPane().add(ans);
		
		//Alphabet Buttons initialization
		user.setLayout(new GridLayout(2,13));
		for(int count=0; count<abtn.length; count++){
			abtn[count]=new JButton(b);
			user.add(abtn[count]);
			letter++;
			b=String.valueOf(letter);
		}
		
		//Menu ActionListener
		btnMenu.addActionListener(listen);
		
		//Alphabet Buttons ActionListener
		for(int y=0; y<abtn.length; y++){
			this.abtn[y].addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent ae){
							for(int z=0; z<abtn.length; z++){
								if(ae.getSource()==abtn[z]){
									String btnLetter = abtn[z].getText();
									logo.checkGuess(btnLetter);
									abtn[z].setEnabled(false);
								}
							}
						}
					});
		}
		
		//JFrame properties
		this.setIconImage(iconGUI.getImage());
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
/*	public Play(Listeners listen){
		super("Hangman");
		this.listen=listen;
	}
	public Play(MainMenu menu){
		super("Hangman");
		this.menu=menu;
	}*/
	
	//Adds Change to GUI
	protected void addAnswer(String[] ansName){
		StringBuilder bldr = new StringBuilder();
		for(String value : ansName){
			bldr.append(value);
		}
		//removes [,,,,] in array
		String aName = bldr.toString();
		dname.setFont(fnt);
		dname.setText(aName);
		display.add(dname);
	}
	
	protected int stage=0;
	//Hangman image
	protected void hangMan(){	
		this.setLayout(new GridLayout(2, 1, 15, 0));
		hobo.setLayout(new GridLayout(1, 2));
		iconMan = new ImageIcon(getClass().getResource("Images/Hangman-Stage-"+stage+".png"));
		lblMan.setIcon(iconMan);
		hang.add(lblMan);
		++stage;
	}
	
	//Logo Image
	protected void displayLogo(){
		this.setLayout(new GridLayout(2, 1, 15, 0));
		hobo.setLayout(new GridLayout(1, 2));
		iconLogo = new ImageIcon(getClass().getResource("Images/"+this.logo.qNumber+".jpg"));
		lblLogo.setIcon(iconLogo);
		logoPic.add(lblLogo);
	}
}