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
import java.util.LinkedList;
import java.util.*;
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
    
   // private JLabel searchLabel;

    private javax.swing.JPanel jPanel1;

    private JTextField searchInput;

    private JLabel testLabel;
    private JTextField testInput;
    private JTextField movInput;
    
    private JButton submitInfo;
    private JButton purchaseTicket;
    private JButton guestBtn;


    private JTextField email;   // for login
    private JTextField pw;

    private JTextField emailreg;       // for registering
    private JTextField pwreg;
    private JTextField name;
    private JTextField cardno;
    private JTextField cvv;
    private JTextField expiry;
    private JTextField searchV;

    
    private JButton register;
    private JButton login;
    private JButton guest;
    private JButton searchBtn;

    private JButton viewSeats;
  
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

        instructions1 = new JLabel("\n Movie Booking" );
        instructions1.setFont(new java.awt.Font("Segoe UI", 0, 17));
        instructions1.setForeground(new java.awt.Color(0,0,0));    
        
        // searchLabel = new JLabel("Search a movie:");
        // searchLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        // searchLabel.setForeground(new java.awt.Color(0,0,0));
       
        // testLabel = new JLabel("Buy Tickets:");
        // testLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        // testLabel.setForeground(new java.awt.Color(0,0,0));
     
        // searchInput = new JTextField("Erase and type movie...", 15);
        // searchInput.addMouseListener(this);

        // movInput = new JTextField("Movie ID...", 15);
        // movInput.addMouseListener(this);

        // testInput = new JTextField("(test)number of tickets...", 15);
        // testInput.addMouseListener(this);

        register = new JButton("Sign up here");
        register.addActionListener(this);

        login = new JButton("Login here");
        login.addActionListener(this);

        guest = new JButton("Continue as guest");
        guest.addActionListener(this);

        
        // submitInfo = new JButton("Search");
        // submitInfo.addActionListener(this);

        // viewSeats = new JButton("View available seats");
        // viewSeats.addActionListener(this);

        // purchaseTicket = new JButton("Purchase");
        // purchaseTicket.addActionListener(this);

        // JButton exit = new JButton("Exit");
		// exit.addActionListener (new ActionListener () {
		// 	public void actionPerformed (ActionEvent e) {
		// 	System.exit(0);
		// 	}
        // });

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(3,3,2,2));

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        headerPanel.add(instructions1);
        
        clientPanel.add(guest);
        clientPanel.add(login);
        clientPanel.add(register);

        

        // clientPanel.add(searchLabel);
        // clientPanel.add(searchInput);
        // clientPanel.add(submitInfo);
        // clientPanel.add(viewSeats);


        // clientPanel.add(testLabel);
        // clientPanel.add(movInput);
        // clientPanel.add(testInput);    
        // clientPanel.add(purchaseTicket);

      ///  submitPanel.add(submitInfo);
        // exitPanel.add(exit);
       
        this.add(headerPanel, BorderLayout.CENTER);
        this.add(clientPanel, BorderLayout.SOUTH);
      //  this.add(submitPanel, BorderLayout.SOUTH);
        this.add(exitPanel, BorderLayout.EAST);
    }
    
    /*
     * actionPerformed(ActionEvent event) Method
     * 
     * calls the search method and search results are printed to main
     */ 
    public void actionPerformed(ActionEvent event){
        if(event.getSource().equals(searchBtn)){
            movieSearch = searchV.getText();  
            
            MovieAppMain.search(movieSearch);
            

            //System.out.println("submit clicked");
            //MovieAppMain appmain = new MovieAppMain(movieSearch, movieSearch, movieSearch);

            LinkedList<Movie> movies = MovieAppMain.search(movieSearch);
            // MovieAppMain.getMovies();
          //  int check = 0;
            Movie check = MovieAppMain.getFoundMovie();
            Movie selected;
       //     System.out.println("whats check: " + check);
            if (check != null){
                String[] dates = new String[5];
                int j = 0;
                Object d;
                Object t;

                for (int i = 0; i < movies.size(); i ++) {
                    dates[i] = movies.get(i).getDate();
                
                }

                d = JOptionPane.showInputDialog(null, "Please select a date.", 
                    "Dates", JOptionPane.QUESTION_MESSAGE, null, dates, dates[0]);
                
                if (d == dates[0]){
                    System.out.println("works!");
                }
                String[] times = new String[4];
                if(d instanceof String){
                    
                    int k = 0;
                    for (int i = 0; i < movies.size(); i ++) {
                        if (d == movies.get(i).getDate()){
                            times[i] = movies.get(i).getTime();
                        }
                    }
                    
                 /*    if(t instanceof String){
                        System.out.println("here");
                        Seats seat = new Seats(1);
                      //  seat.init();
                        dispose();
                    }*/

                }
                t = JOptionPane.showInputDialog(null, "Please select a showtime.", 
                "Showtimes", JOptionPane.QUESTION_MESSAGE, null, times, times[0]);

                // finding the movie
                for (int i = 0; i < movies.size(); i ++) {
                    if (d == movies.get(i).getDate() && t == movies.get(i).getTime()){
                        selected = movies.get(i);
                        System.out.println("amazing!");
                        seatScreen(selected);
                        break;

                    }
                    System.out.println("yeah good");
                }

            }
            
            else{
                JOptionPane.showMessageDialog(this,  "Movie not found!");
            }
        }
        
        if(event.getSource().equals(guest)){
            searchScreen();
          //  SearchMovie.run();
           // dispose();
        }

        if(event.getSource().equals(register)){
            // MICHELE'S PLAN B4 SHE DIED: 
            // MAKE IT SO THAT WHEN "SIGN UP HERE" IS CLICKED ANOTHER WINDOW OPENS AND ALLOWS USER TO ENTER STUFF
            // ASK SAMU OR SAYMA

            JOptionPane.showConfirmDialog(this, MovieAppMain.register(),"Registered", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("registered clicked");
        }

        if(event.getSource().equals(login)){
            // FOR SAMU USER HAS LOGGED IN AND UH CANT DO AGAIN??
            email = new JTextField(10);
            pw = new JTextField(10);
      
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Email"));
            myPanel.add(email);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Password"));
            myPanel.add(pw);
      
            var enteredEmail = JOptionPane.showInputDialog("Please enter your email: ");
            var userEmail = enteredEmail;   

            var enteredPW = JOptionPane.showInputDialog("Please enter your password: ");
            var userPW = enteredPW;     
            // HOW TO CONFIRM W DATABASE

            try
            {
                MovieAppMain myJDBC = new MovieAppMain("jdbc:mysql://localhost:3306/ENSF480Final","root","");
                myJDBC.initializeConnection(); 
                
                String query = "SELECT * FROM userdata where Email = '" + userEmail + "' and Password = '" + userPW + "'";
                // execute query 
                // if userEmail == Email and userPW == Password
                    //System.out.println("Log in successful");
                    // button allows user to go to movie search page 
                    // button allows user to go view announcemtns??? (michele thinks this part is bonus)
                // else
                    //System.out.println("Email or password is incorrect. Try again!");

            }

            finally{
                ;
            }
            
           
            System.out.println("login clicked");
        }

    
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

    public void searchScreen(){
        JDialog searchScreen = new JDialog(this, "Search");

        JLabel i = new JLabel("Search a movie");
        i.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        i.setForeground(new java.awt.Color(0,0,0));

        JLabel s = new JLabel("Search a movie:");
        s.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        s.setForeground(new java.awt.Color(0,0,0));

        searchV = new JTextField("Erase and type movie...", 15);
        searchV.addMouseListener(this);

        searchBtn = new JButton("Search");
        searchBtn.addActionListener(this);

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.add(i);

        JPanel content = new JPanel(new FlowLayout(4,4,4));

        content.add(new JLabel("Wakanda Forever"));
        content.add(new JLabel("Smile"));
        content.add(new JLabel("Black Adam"));
        content.add(new JLabel("Strange World"));
        //headerPanel.add(instructions1);
    
        content.add(s);
        content.add(searchV);
        content.add(searchBtn);

        
        searchScreen.add(top, BorderLayout.NORTH);
        searchScreen.add(content, BorderLayout.CENTER);

        searchScreen.setSize(400,300);
        searchScreen.setVisible(true);

        System.out.println("seats: "+seats);
        System.out.println("movie: "+movID);

      //  this.add(submitPanel, BorderLayout.SOUTH);
      //  this.add(exitPanel, BorderLayout.EAST);
       // this.add(moviePanel, BorderLayout.SOUTH);
    }
    public void seatScreen(Movie selected){
        JDialog seatScreen = new JDialog(this, "Seat Map");
        seatScreen.setLayout((new FlowLayout()));
       
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(0,5,4,5));

       
        JButton copyButton = new JButton("Select");
        
        copyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
              //  jListForCopy.setListData(jList.getSelectedValues());
                System.out.println("ok");
                
                
            }
        });

        Map<String, Boolean> seats = selected.getSeats().getSeats();

        for (Map.Entry<String, Boolean> s : seats.entrySet()) {
                
                seatPanel.add(new JButton(s.getKey()));
        }
     //   for (int i = 0; i < seats.size(); i++){
     //       seatPanel.add(new JButton(seats.get(i)));
     //   }

        seatScreen.add(seatPanel, BorderLayout.CENTER);

        seatScreen.setTitle("Seat Chart");
        seatScreen.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        seatScreen.setSize(600,600);
        seatScreen.setMinimumSize(new Dimension(450,450));
        seatScreen.setLocationRelativeTo(null);
        seatScreen.setVisible(true);
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