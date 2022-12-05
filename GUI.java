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

    private JButton book;

    private JButton viewSeats;
    private RegisteredUser userChecker;
  
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

            LinkedList<Movie> movies = MovieAppMain.search(movieSearch);
            // MovieAppMain.getMovies();
          //  int check = 0;
            String check = MovieAppMain.getFoundMovie();
            Movie selected;

            if(check.equals("yes")){

            LinkedList<Movie> Theatres = MovieAppMain.search(movieSearch);

            for(int i=0; i<Theatres.size(); i++){
                System.out.println(Theatres.get(i).getTheatre());
            }
            LinkedList<String> thea = new LinkedList<String>();
                for (int k = 0; k < Theatres.size();  k ++) {
                    if(!thea.contains(Theatres.get(k).getTheatre())){
                        thea.add(Theatres.get(k).getTheatre());
                    }
                }




        String[] arrayTh = thea.toArray(new String[thea.size()]);

        Object th;
        th = JOptionPane.showInputDialog(null, "Please select a Theatre.", 
                    "Theatres", JOptionPane.QUESTION_MESSAGE, null, arrayTh, arrayTh[0]);
    
        
            
            
            Object d;
            Object t;

            LinkedList<String> dates = new LinkedList<String>();
            for (int i = 0; i < Theatres.size(); i ++) {

                if(Theatres.get(i).getTheatre().equals(th)){
                    if(!dates.contains(Theatres.get(i).getDate()))
                    dates.add(Theatres.get(i).getDate());
                }
            
            }

            String[] arrayD = dates.toArray(new String[dates.size()]);

            d = JOptionPane.showInputDialog(null, "Please select a date.", 
                "Dates", JOptionPane.QUESTION_MESSAGE, null, arrayD, arrayD[0]);


                LinkedList<String> times = new LinkedList<String>();
                for (int i = 0; i < Theatres.size(); i ++) {

                    if(Theatres.get(i).getTheatre().equals(th) && Theatres.get(i).getDate().equals(d)){
                        if(!times.contains(Theatres.get(i).getDate()))
                        times.add(Theatres.get(i).getTime());
                    }
                
                }

                String[] arrayt = times.toArray(new String[dates.size()]);

                t = JOptionPane.showInputDialog(null, "Please select a time.", 
                    "Times", JOptionPane.QUESTION_MESSAGE, null, arrayt, arrayt[0]);
                
                    for (int i = 0; i < Theatres.size(); i ++) {
                        // System.out.println("datee  "+ Theatres.get(i).getDate() + "time " + Theatres.get(i).getTime() );
                        if (d.equals(Theatres.get(i).getDate()) && t.equals(Theatres.get(i).getTime())){
                            selected = movies.get(i);
                            System.out.println("amazing!");
                            options(selected);
                            
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
            userChecker = null;
            user1 = new Guest(new GuestPayment());
            searchScreen();
           // searchScreen();
          //  SearchMovie.run();
           // dispose();
        }

        if(event.getSource().equals(register)){
            
            emailreg = new JTextField(10);
            pwreg = new JTextField(10);
            cvv = new JTextField(10);
            cardno = new JTextField(10);
            expiry = new JTextField(10);

      
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Email"));
            myPanel.add(emailreg);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Password"));
            myPanel.add(pwreg);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Card Number"));
            myPanel.add(cardno);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Expiry"));
            myPanel.add(expiry);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("CVV"));
            myPanel.add(cvv);
      
            var enteredEmail = JOptionPane.showInputDialog("Please enter your email: ");

            var enteredPW = JOptionPane.showInputDialog("Please enter your password: ");

            var enteredCardNumber = JOptionPane.showInputDialog("Please enter your card number: ");
         
            var enteredExpiry = JOptionPane.showInputDialog("Please enter the expiry date of the card: ");

            var enteredCVV = JOptionPane.showInputDialog("Please enter the cvv: ");

            MovieAppMain.registerUser(enteredEmail, enteredPW, enteredCardNumber, enteredExpiry, enteredCVV);
            
            RegisteredUser regUser = MovieAppMain.userSearch(enteredEmail, enteredPW);
            user1 = regUser;
            userPortal(regUser);

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
            System.out.println("okkkkkk");
            userChecker = MovieAppMain.userSearch(userEmail, userPW);

            if (userChecker != null){
                user1 = userChecker;
                userPortal(userChecker);
            }
            else{
                isNotAUser();
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
 
          //  paymentScreen();
        }

        if(event.getSource() == pay){
            System.out.println("okthis worked ");
        }

    }
    
    public void isNotAUser(){
        JDialog failureTab = new JDialog(this, "Login Failed");

        JLabel i = new JLabel("Your credentials do not match our records. Please try again or register as a new user");
        i.setFont(new java.awt.Font("Segoe UI", 0, 13)); 
        i.setForeground(new java.awt.Color(0,0,0));


        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.add(i);


        
        failureTab.add(top, BorderLayout.CENTER);

        failureTab.setSize(600,100);
        failureTab.setVisible(true);

    }
    public void options(Movie selected){
        JDialog optionsScreen = new JDialog(this, "Movie Theatre");
        JPanel content = new JPanel(new FlowLayout(4,4,4));

        JLabel i = new JLabel("Select an option");
        i.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        i.setForeground(new java.awt.Color(0,0,0));
        

        JButton search = new JButton("Make Booking");
        search.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                seatScreen(selected);
            }
        });

        JButton cancel = new JButton("Cancel Booking");
        cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
              cancelScreen(selected);
            }
        });

        content.add(i);
        content.add(search);
        content.add(cancel);

        optionsScreen.add(content, BorderLayout.CENTER);
        optionsScreen.setSize(400,300);
        optionsScreen.setVisible(true);

    }
   

    public void cancelScreen(Movie selected){
        JDialog cancelScreen = new JDialog(this, "Ticket Cancellation");
        JPanel content = new JPanel(new FlowLayout(4,4,4));

        JLabel cancelCode = new JLabel("Please enter cancellation code");
        JTextField cancel = new JTextField("", 15);

        JButton cancelBtn = new JButton("Cancel Booking");
        cancelBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String seatCancelled = selected.removeTickets(cancel.getText());
                user1.cancelPayment(cancel.getText(), selected);
                JOptionPane.showMessageDialog(cancelScreen,  seatCancelled);
            }
        });

        content.add(cancelCode);
        content.add(cancel);
        content.add(cancelBtn);
        cancelScreen.add(content);
        cancelScreen.setSize(400,300);
        cancelScreen.setVisible(true);
    }

    public void searchScreen(){
        JLabel i;

        if(userChecker == null){

            i = new JLabel("Logged in a guest. Please search a movie");
            i.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
            i.setForeground(new java.awt.Color(0,0,0));

        }
        else{
           i = new JLabel("Login was successful. Please search a movie");
            i.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
            i.setForeground(new java.awt.Color(0,0,0));

        }
        JDialog searchScreen = new JDialog(this, "Search");

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
    }

    public void userPortal(RegisteredUser user){
        System.out.println("ummmm ");
        System.out.println(user.getMovies());
        JDialog userPortal = new JDialog(this, "User Portal");
      //  userPortal.setLayout((new FlowLayout()));
       
        JPanel userData = new JPanel();
        userData.setLayout(new BoxLayout(userData, BoxLayout.PAGE_AXIS));

        JLabel email = new JLabel(user.getEmail());
        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        email.setForeground(new java.awt.Color(0,0,0));

        JLabel card = new JLabel(user.getCardNumber().substring(0,4)+"*********");
        card.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        card.setForeground(new java.awt.Color(0,0,0));

        JLabel movies = new JLabel(user.getMovies());
        movies.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        movies.setForeground(new java.awt.Color(0,0,0));

        JButton continueNoPay =  new JButton("Browse without paying");
        JButton continuePay =  new JButton("Pay and Browse");
        JButton cont =  new JButton("Browse Movies");
        
        continueNoPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchScreen();
            }
        });

        continuePay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //user.annualFee();
                searchScreen();
            }
        });
        cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchScreen();
            }
        });
        userData.add(email);
        userData.add(card);

        userData.add(movies);

        if(!user.getFeePaid()){
            userData.add(continueNoPay);
            userData.add(continuePay);
        }
        else{
            userData.add(cont);
        }

        userPortal.add(userData, BorderLayout.CENTER);
        
        userPortal.setTitle("User Portal");
        userPortal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        userPortal.setSize(600,600);
        userPortal.setMinimumSize(new Dimension(450,450));
        userPortal.setLocationRelativeTo(null);
        userPortal.setVisible(true);
    }

    public void seatScreen(Movie selected){
        JDialog seatScreen = new JDialog(this, "Seat Map");
        seatScreen.setLayout((new FlowLayout()));
       
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(0,5,4,5));


        Map<String, Boolean> seats = selected.getSeats().getSeats();
        JButton btn = new JButton();
        JTextArea textArea = new JTextArea();

        for (Map.Entry<String, Boolean> s : seats.entrySet()) {
                btn = new JButton(s.getKey());
                if (!s.getValue()) {btn.setEnabled(false);}
                btn.addActionListener(new ActionListener() {
            
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object o = e.getSource();
                        JButton b = null;
                        String buttonText = "";
        
                        if(o instanceof JButton)
                            b = (JButton)o;
        
                        if(b != null)
                            buttonText = b.getText();
        
                        textArea.append(buttonText+ "\n");
                    }
                });
                seatPanel.add(btn);
        }
        
        JPanel submitPanel = new JPanel();
        book = new JButton("Book Seats");
        book.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentScreen(textArea.getText(), selected);
            }
        });

        submitPanel.add(book);
       

        seatPanel.add(textArea);
        
        seatScreen.add(seatPanel, BorderLayout.CENTER);
        seatScreen.add(submitPanel, BorderLayout.SOUTH);

        seatScreen.setTitle("Seat Chart");
        seatScreen.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        seatScreen.setSize(600,600);
        seatScreen.setMinimumSize(new Dimension(450,450));
        seatScreen.setLocationRelativeTo(null);
        seatScreen.setVisible(true);
    }

    public void paymentScreen(String seats, Movie movie){
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
        
        JLabel confirmLabel = new JLabel("Yay!");
        confirmLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        confirmLabel.setForeground(new java.awt.Color(0,0,0));

        JPanel paid = new JPanel();
        paid.setLayout(new FlowLayout());
        paid.add(confirmLabel);

        pay = new JButton("pay");
        pay.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.makePayment(seats, movie);
                if(userChecker!= null) {System.out.println("its not null");userChecker.addMovie(movie, seats, seats);}
               String tickDetails = user1.getTicketDetails(seats, movie);
               JOptionPane.showMessageDialog(paymentTab,  "Successfully processed transaction for: "+seats+"\n"+tickDetails);
            }
        });
        
      //  GridBagConstraints c = new GridBagConstraints();
        content.add(ccInfo);
        content.add(email);
        content.add(pay);


        paymentTab.add(top);
        paymentTab.add(content);
        //  paymentTab.add(email);
        paymentTab.setTitle("Payment");
        paymentTab.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        paymentTab.setSize(600,600);
        paymentTab.setMinimumSize(new Dimension(450,450));
        paymentTab.setLocationRelativeTo(null);
        paymentTab.setVisible(true);

    }

    public void paymentConfirmation(){
        JDialog paymentConfirmation = new JDialog(this, "Payment Confirmation");
        
        JLabel title = new JLabel("Payment Confirmation");
        title.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        title.setForeground(new java.awt.Color(0,0,0));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.add(title);

        JPanel content = new JPanel(new FlowLayout(4,4,4));
        content.setLayout(new FlowLayout());
        content.add(title);
    
        JLabel confirmLabel = new JLabel("Yay!");
        confirmLabel.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        confirmLabel.setForeground(new java.awt.Color(0,0,0));
        
        content.add(confirmLabel);

        paymentConfirmation.add(top);
        paymentConfirmation.add(content);
        //  paymentTab.add(email);
        paymentConfirmation.setTitle("Payment Confirmation");
        paymentConfirmation.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        paymentConfirmation.setSize(600,600);
        paymentConfirmation.setMinimumSize(new Dimension(450,450));
        paymentConfirmation.setLocationRelativeTo(null);
        paymentConfirmation.setVisible(true);
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