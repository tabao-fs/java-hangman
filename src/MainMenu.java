import java.awt.*;

import javax.swing.*;

public class MainMenu extends JFrame {
	private JPanel panel = new JPanel();
	private JPanel labelPanel = new JPanel();
	private Icon imgGame = new ImageIcon(getClass().getResource("Images/Home-Noose-noHover.png"));
	private Icon imgClose = new ImageIcon(getClass().getResource("Images/Home-Close.png"));
	private Icon imgInfo = new ImageIcon(getClass().getResource("Images/Home-Info.png"));
	JButton btnGame = new JButton("Play");
	JLabel lblGame = new JLabel(imgGame);
	JLabel lblClose = new JLabel(imgClose);
	JLabel lblInfo = new JLabel(imgInfo);
	private ImageIcon iconGUI = new ImageIcon(getClass().getResource("Images/Icon.png"));
	Listeners gameListener;
	
	public MainMenu(){
		super("Hangman");
		this.gameListener = new Listeners(this);
		//setLayout(new BorderLayout());
		lblGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		Icon bg1 = new ImageIcon(getClass().getResource("Images/Home-Background.jpg"));
	    JLabel bg = new JLabel(bg1);
		getContentPane().add(bg);
	    bg.setLayout(new FlowLayout());
	    
		setLayout(new FlowLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		getContentPane().add(panel);
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));
		panel.add(lblGame);
		labelPanel.add(lblClose);
		labelPanel.add(Box.createRigidArea(new Dimension(730,0)));
		labelPanel.add(lblInfo);
		panel.add(Box.createRigidArea(new Dimension(0, 70)));
		panel.add(labelPanel);
		labelPanel.setOpaque(false);
		panel.setOpaque(false);
		bg.add(panel);
		lblGame.setPreferredSize(new Dimension(583, 683));
		
		//lblGame MouseListener
		lblGame.addMouseListener(gameListener);
		
		//Close MouseListener
		lblClose.addMouseListener(gameListener);
		
		//Info MouseListener
		lblInfo.addMouseListener(gameListener);
		
		this.setIconImage(iconGUI.getImage());
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
