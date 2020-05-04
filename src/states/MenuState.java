package states;




import main.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import game.*;
import game.gfx.ImageLoader;



//make need to make menu state a JFrame extension so that it functions better and pass a vlaue to game
public class MenuState extends State{
	private boolean switchState;
	JButton button;
	private Dimension screenDimensions;
  private BufferedImage testImage; 

  JFrame myFrame;
  private boolean rendered;
	JPanel menuPanel;
	JTextField playerName;
	JLabel menuLabel;
	ActionListener submitListener;
	private String retrievedPlayerName;
	private Player playerOne;
	private CSVScanner CSVscanner;
	
	JButton submitName;
    JTextField nameInput;
    
   
	Boolean InList;
	
	public MenuState (Handler handler) {
		super(handler);
		this.switchState = false;
		rendered = false;
		
		testImage = ImageLoader.loadImage("/texture/rink.png");
		screenDimensions = new Dimension(testImage.getWidth(), testImage.getHeight());
	
		//initialize menu
		menuLabel = new JLabel("Please enter Player Name, if it does not exist it will be automatically created");
		myFrame = new JFrame("AirHockey Menu");
		
		
		myFrame.setSize(screenDimensions);
		myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
		
		//make elements on menu
		menuPanel = new JPanel((new GridLayout(4,4,4,4)));
		submitName = new JButton("Submit");
		playerName = new JTextField(30);
  
  
  }
	public boolean getSwitchState() {
		return this.switchState;
	}

	public void flipSwitchState() {
		this.switchState = !this.switchState;
	}
	public JFrame getJFrame() {
		return this.myFrame;
	}
	public void showMenu() {
		
		CSVscanner = new CSVScanner();
		submitName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//now we pass this retrieved player name to search algorithm
				
				retrievedPlayerName = playerName.getText();// this is line to do io on player name and win becaus ethat is assumed it goes name wins time in seconds------------------------------
				
				
				
				
				InList = CSVscanner.CSVScanner(retrievedPlayerName);
				
				if(InList) {
					
					//if it is true it should go here which means that it exists in the csv 
					CSVscanner.CSVedit(retrievedPlayerName, 1);
				}
				else {
					CSVScanner.CSVNewInput(retrievedPlayerName, 1);
					// if false need to add a new thing to the csv
				}
				
				
				//create another text field that contains what score to play until
			}
			
		});
		submitName.setVisible(true);
		submitName.setEnabled(true);
		submitName.setSize(40,40);
		menuPanel.add(menuLabel);
		menuPanel.add(playerName);
		menuPanel.add(submitName);
		myFrame.add(menuPanel, BorderLayout.NORTH);
	}
	
	public Player checkPlayerExists(String retrievedPlayerName) {
		//https://stackoverflow.com/questions/15577688/search-a-file-for-a-string-and-return-that-string-if-found
		return playerOne;
	}

	//require button actionlistener, on event e we have to run our search. but for now we can implement a the switch back to 
	//game state
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
	if(!rendered) {
			
			myFrame.setVisible(true);
			showMenu();
			rendered = true;
		}
	}
}
