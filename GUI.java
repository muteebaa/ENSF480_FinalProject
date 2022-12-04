/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: michele phan zia <a href="mailto:----@ucalgary.ca">
 * ----@ucalgary.ca</a>
 * @authour: samira khan <a href="mailto:-----@ucalgary.ca">
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
    private String movieSearch;
    private String seats;
    private int movID;

    private Guest user1;

	
	// variables required for the GUI
    private JLabel instructions;
    private JLabel instructions1;
    
    private JLabel searchLabel;

    private javax.swing.JPanel jPanel1;

    private JTextField searchInput;

    private JLabel testLabel;
    private JTextField testInput;
    private JTextField movInput;
    
    private JButton submitInfo;
    private JButton purchaseTicket;
    private JButton guestBtn;
  
  //  private JFrame paymentScreen = new JFrame();
    JButton pay;
    
    /*
     * GUI() Constructor
     */ 
    public GUI(){
        super("Group 4 Project");
        setupGUI();
        setSize(400,300);
        
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
       
        testLabel = new JLabel("Buy Tickets:");
        testLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        testLabel.setForeground(new java.awt.Color(0,0,0));
     
        searchInput = new JTextField("Erase and type movie...", 15);
        searchInput.addMouseListener(this);

        movInput = new JTextField("Movie ID...", 15);
        movInput.addMouseListener(this);

        testInput = new JTextField("e.g. a1 a2 a3", 15);
        testInput.addMouseListener(this);

        submitInfo = new JButton("Search");
        submitInfo.addActionListener(this);

        purchaseTicket = new JButton("Purchase");
        purchaseTicket.addActionListener(this);

        guestBtn = new JButton("guest");
        guestBtn.addActionListener(this);

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
    
        clientPanel.add(guestBtn);

        clientPanel.add(searchLabel);
        clientPanel.add(searchInput);
        clientPanel.add(submitInfo);

        clientPanel.add(testLabel);
        clientPanel.add(movInput);
        clientPanel.add(testInput);    
        clientPanel.add(purchaseTicket);


      ///  submitPanel.add(submitInfo);
        exitPanel.add(exit);
       
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
      //  this.add(submitPanel, BorderLayout.SOUTH);
        this.add(exitPanel, BorderLayout.EAST);
    }
    
    /*
     * actionPerformed(ActionEvent event) Method
     * 
     * calls the search method and search results are printed to main
     */ 
    public void actionPerformed(ActionEvent event){
        if(event.getSource().equals(submitInfo)){
            movieSearch = searchInput.getText();  
            JOptionPane.showMessageDialog(this,  MovieAppMain.search(movieSearch));
           
            System.out.println("submit clieckd");
        }

        if(event.getSource() == guestBtn){
            user1 = new Guest(new GuestPayment());
        }
        
        if(event.getSource() == purchaseTicket){
            ///need to throw error if an int isnt entered
            seats = testInput.getText();
            movID = Integer.parseInt(movInput.getText());
 
            paymentScreen();
        }

        if(event.getSource() == pay){
            System.out.println("okthis worked ");
        }

    }

    public void paymentScreen(){
        JDialog paymentTab = new JDialog(this, "Payment");
        
        JLabel title = new JLabel("Payment");
        title.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        title.setForeground(new java.awt.Color(0,0,0));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.add(title);

        JPanel content = new JPanel(new FlowLayout(4,4,4));
        
        JTextField ccInfo = new JTextField("ccinfo...", 15);
        ccInfo.setSize(20,100);
        ccInfo.addMouseListener(this);

        JTextField email = new JTextField("email...", 15);
        email.setSize(20,100);
        email.addMouseListener(this);

        pay = new JButton("pay");
        pay.addActionListener(this);

      //  GridBagConstraints c = new GridBagConstraints();
        content.add(ccInfo);
        content.add(email);
        content.add(pay);


        paymentTab.add(top);
        paymentTab.add(content);
        //  paymentTab.add(email);
        paymentTab.setSize(400,300);
        paymentTab.setVisible(true);


        // user1.makePayment(3, MovieAppMain.get());

        System.out.println("seats: "+seats);
        System.out.println("movie: "+movID);
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
       // X.getContentPane().add(BorderLayout.NORTH, clientPanel);
        X.setVisible(true);
    }     
}