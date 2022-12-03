/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: michele pham zia <a href="mailto:----@ucalgary.ca">
 * ----@ucalgary.ca</a>
 * @authour: samira kham <a href="mailto:-----@ucalgary.ca">
 * ----@ucalgary.ca</a>
 * @version 1.4
 * @since 1.0
 */

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.FlowLayout;

public class GUI extends JFrame implements ActionListener, MouseListener{
	// variables required for implementation
	private int totalFemale;
	private int totalMale;
	private int totalChildrenU8;
	private int totalChildrenO8;
	private int grainC;
	private int fvc;
	private int proC;
	private int OthersC;
	private int CaloriesC;
	private int hamperNumber = 1;
    private String movieSearch;
	
	// variables required ofr the GUI
    private JLabel instructions;
    private JLabel instructions1;
    private JLabel instructions2;
    private JLabel instructions3;
    private JLabel option1;
    private JLabel option2;
    private JLabel searchLabel;
    private JLabel fLabel;
    private JLabel coLabel;
    private JLabel cuLabel;
    private JLabel twgLabel;
    private JLabel fvLabel;
    private JLabel proLabel;
    private JLabel oLabel;
    private JLabel cLabel;
    private javax.swing.JPanel jPanel1;
    private JTextField fInput;
    private JTextField searchInput;
    private JTextField coInput;
    private JTextField cuInput;
    private JTextField twgInput;
    private JTextField fvInput;
    private JTextField proInput;
    private JTextField oInput;
    private JTextField cInput;
    
    /*
     * GUI() Constructor
     */ 
    public GUI(){
        super("Group 4 Project");
        setupGUI();
        setSize(400,200);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    /*
     * setupGUI() Method
     * 
     * Sets up the GUI for users to interact with.
     */ 
     public void setupGUI(){
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new java.awt.Color(30, 31, 38));
        jPanel1.setForeground(new java.awt.Color(153, 255, 102));
        
        instructions = new JLabel("Group 4 Project - ENSF480");
        instructions.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        instructions.setForeground(new java.awt.Color(0,0,0));

        instructions1 = new JLabel("Movie Booking" );
        instructions1.setFont(new java.awt.Font("Segoe UI", 0, 17));
        instructions1.setForeground(new java.awt.Color(0,0,0));

        searchLabel = new JLabel("Search a movie:");
        searchLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        searchLabel.setForeground(new java.awt.Color(0,0,0));
       
        
        searchInput = new JTextField("Erase and type movie...", 15);
       
        searchInput.addMouseListener(this);


        
        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);

        JButton exit = new JButton("Exit");
		exit.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
			System.exit(0);
			}
        });

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, 1));

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        headerPanel.add(instructions1);
    
        clientPanel.add(searchLabel);
        clientPanel.add(searchInput);


        submitPanel.add(submitInfo);
        exitPanel.add(exit);
       
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.SOUTH);
        this.add(exitPanel, BorderLayout.EAST);
    }
    
    /*
     * actionPerformed(ActionEvent event) Method
     * 
     * Once the user inputs data and presses submit, the data is assigned 
     * to the variables we defined above.
     * 
     * Depending on which option the user decided to fill out, the 
     * corresponding Hamper constructor is called to create an object of
     * Hamper.Then an order object is created.
     * 
     * The details of the hamper created or an error messgae is displayed 
     * depending on wether or not a hamper was able to be created. 
     * 
     * There is a popup error message if:
     * 		- both options are filled out,
     * 		- invalid data (e.g. negative numbers) is inputted.
     */ 
    public void actionPerformed(ActionEvent event){
        movieSearch = searchInput.getText();
        
        MovieAppMain.search(movieSearch);
    }

    /*
     * validateInput() Method
     * 
     * Ensures data entered by the user is valid (e.g. not negative values)
     */
    public int validateInput(){
        if(true){
            return 0;
    
        }
        else{
            return 1;
        }
    }

    /*
     * validateOption() Method
     * 
     * Ensures user only inputted data for a single option.
     */
    public int validateOption(){
        if(true ){
            return 2;
        }
        else{
            return 0;
        }
    }
    
   
    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(searchInput))
            searchInput.setText("");
    }
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
      
	/*
	 * run() Method
	 * 
	 * Runs the GUI.
	 */ 
    public static void run() { 
        GUI X = new GUI();
        X.setVisible(true);
    }     
}