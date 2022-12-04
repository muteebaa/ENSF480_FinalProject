/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: michele pham <a href="mailto:michele.pham@ucalgary.ca">
 * michele.pham@ucalgary.ca</a>
 * @authour: samira khan <a href="mailto:samira.khan@ucalgary.ca">
 * samira.khan@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.*;

public class MovieAppMain{
    private static GUI gui;
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private static Connection dbConnect;
    private ResultSet results;

     // this is a linked list of all the movies in the database 
     private static LinkedList<Movie> movies = new LinkedList<Movie>();

     // this is a linked list of all the theatres in the database 
     private static LinkedList<Theatre> theatres = new LinkedList<Theatre>();
    
     ////////////////////////////////////////////////////////////////////
    /*
     * Start of Methods required to access and manipulate the SQL Databse. 
     */
    ////////////////////////////////////////////////////////////////////
    public MovieAppMain(String url, String user, String pw){
        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

	//Must create a connection to the database, no arguments, no return value    
    public void initializeConnection(){
        try{
            dbConnect = DriverManager.getConnection(getDburl(),getUsername(),getPassword()); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }             
    }

    String getUsername(){
        return this.USERNAME;
    }
    
    String getDburl(){
        return this.DBURL;
    }

    String getPassword(){
        return this.PASSWORD;
    }

    // we dont really need this right now but i left it here so we can borrow the code if we want to remove movies later on

/*    public static void deleteFood(String id){
        try{
            
            String str = "DELETE FROM available_food WHERE ItemID = ?";
            PreparedStatement statement = dbConnect.prepareStatement(str);  
            
            statement.setString(1,id);
            int len = statement.executeUpdate();
            
            if(len == 0){
                System.out.println("No updating done");
               }
            
            
            statement.close();}
            
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            
    }           
*/

    /* this method stores all our data from the database into the linked lists */
    public String storeData(String tableName){     

        StringBuilder comp = new  StringBuilder();         

        if(tableName.equals("projectData")){
            try{
                Statement statement = dbConnect.createStatement();  
                results = statement.executeQuery("SELECT Theatre, Movie, dateM, dayM, timeM, Seats, Item from projectData");
                int i = 0;
                boolean flag = false;
                while(results.next()){
                    // a movie object is created and added to the linked list
                    Movie mov = new Movie(results.getString("Item"),results.getString("Movie"), results.getString("dateM"),results.getString("Movie"),results.getString("Seats"), results.getString("Theatre") );
                    movies.add(mov);
                    
                    // if its not the first item in the database then we will traverse through the linked list of theatres
                    if (i != 0){
                             
                        for (int x = 0; x<theatres.size(); x++) {
                            // if a theatre is already found to be in the linked list, then the movie object will be appended to it
                            // i did it this way because it makes sense to have multiple movie objects since each will have different timings but,
                            // it doesnt make sense to have multiple theatre objects --- 1 theatre has 0..* movies
                            if (theatres.get(x).getName().contains(results.getString("Theatre"))) {
                                theatres.get(x).addMovie(mov);
                                flag = true;
                                break;
                            }
                        }

                        // if the flag is false this means that the theatre isnt already in the list so we go ahead and add it
                        if (flag == false){
                            Theatre th = new Theatre(results.getString("Theatre"));
                            th.addMovie(mov);
                            theatres.add(th);
                        }
                    }

                    // this is for the first item in the database
                    else {
                        Theatre th = new Theatre(results.getString("Theatre"));
                        th.addMovie(mov);
                        theatres.add(th);
                    }

                    // flag is reset to false 
                    flag = false;

                    // set to 1 after the first item is added, so consecutive runs will go through the first if statement
                    i = 1;
                }
                statement.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            String str = comp.toString();
            return str.trim();
        }

        else{
            String str = "Wrong input";
            return str;
        }
    }
    ////////////////////////////////////////////////////////////////////
    /*
     * End of Methods required to access and manipulate the SQL Databse. 
     */
    ////////////////////////////////////////////////////////////////////
    
    // this is the search function used to search for a movie
    public static String search(String movieName){
        System.out.println();
        String details = "Search results for "+ movieName;
        // traverses through the theatres list and searches each theatre for a movie
        // you can see how the display happens in the theatre/movie classes
        for(int i=0; i<theatres.size(); i++){
            details += theatres.get(i).searchMovies(movieName);
        }

        return details;
    }
    public static void main(String[] args) throws FileNotFoundException {
        GUI gui = new GUI();
        
        //Use the following account information: Username = user1, Password = ensf
        MovieAppMain myJDBC = new MovieAppMain("jdbc:mysql://localhost:3306/MovieTheater","root","");
        myJDBC.initializeConnection();

        System.out.println("------------------------------");
        System.out.println();
        
        System.out.println(myJDBC.storeData("projectData"));
 
        /// i used these print statements to make sure the linked lists were correct and to test the search method
       /* System.out.println("--------------movies----------------");
        for(int i=0; i<movies.size(); i++){
            System.out.println(movies.get(i).getName());
        }

        System.out.println("--------------theatres----------------");
        for(int i=0; i<theatres.size(); i++){
            System.out.println("-----------------------------");
            System.out.println(theatres.get(i).getName());
            System.out.println("------movies-------");
            theatres.get(i).getMovies();
        } 
        System.out.println("--------test search for wakanda----");
        search("Wakanda Forever");
        */
        GUI.run();
        // this is all old stuff from the last project in case we want to use it
    /*     String[][] clients = {
            {clientDetails[0][0],clientDetails[0][1],clientDetails[0][2],clientDetails[0][3],clientDetails[0][4],clientDetails[0][5],clientDetails[0][6]},
            {clientDetails[1][0],clientDetails[1][1],clientDetails[1][2],clientDetails[1][3],clientDetails[1][4],clientDetails[1][5],clientDetails[1][6]},
            {clientDetails[2][0],clientDetails[2][1],clientDetails[2][2],clientDetails[2][3],clientDetails[2][4],clientDetails[2][5],clientDetails[2][6]},
            {clientDetails[3][0],clientDetails[3][1],clientDetails[3][2],clientDetails[3][3],clientDetails[3][4],clientDetails[3][5],clientDetails[3][6]}

        };
       
        var clientData = new Client(clients);
 
        for (int i = 0; i < allFoodDetails.size(); i++){
            String[] k = allFoodDetails.get(i);
            foodObj = new Food(k[0], k[1], k[2], k[3], k[4], k[5], k[6]);

            allFoodObj.add(foodObj);          
        }
        Inventory inv = new Inventory(allFoodObj);
        
        try {
    		FileWriter myWriter = new FileWriter("Order.txt", true);
		
			myWriter.write("\n");
			myWriter.write("Group 11 Final Project - ENSF 409" + "\n" + "Names: Shahzill Naveed, Muteeba Jamal, Ahsan Zia, Hridika Banik");
			myWriter.write("\n");
		       
            myWriter.close();
			
		} catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}

        */

    }
}