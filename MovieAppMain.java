/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: michele pham <a href="mailto:---@ucalgary.ca">
 * ---@ucalgary.ca</a>
 * @authour: samira khan <a href="mailto:---@ucalgary.ca">
 * ---@ucalgary.ca</a>
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
   // private static GUI gui;
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private static String[][] clientDetails = new String[5][7]; 


    private static LinkedList<String[]> allFoodDetails = new LinkedList<String[]>();
 //   private static LinkedList<Food> allFoodObj = new LinkedList<Food>();
    private static String[] foodDetails;
    
    // movie details

    private static LinkedList<Movie> movies = new LinkedList<Movie>();
    private static LinkedList<Theatre> theatres = new LinkedList<Theatre>();

    private static Connection dbConnect;
    private ResultSet results;
    
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
    /* 
    public static void deleteFood(String id){
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
    public String storeData(String tableName){     

        StringBuilder comp = new  StringBuilder();         

        if(tableName.equals("projectData")){
            try{
                Statement statement = dbConnect.createStatement();  
                results = statement.executeQuery("SELECT Theatre, Movie, dateM, dayM, timeM, Seats from projectData");
                int i = 0;
                boolean flag = false;
                while(results.next()){
                    
                    Movie mov = new Movie(results.getString("Movie"), results.getString("timeM"),results.getString("Seats"), results.getString("Theatre") );
                    movies.add(mov);

                    if (i != 0){
                             
                        for (int x = 0; x<theatres.size(); x++) {
                            if (theatres.get(x).getName().contains(results.getString("Theatre"))) {
                                theatres.get(x).addMovie(mov);
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false){
                            Theatre th = new Theatre(results.getString("Theatre"));
                            th.addMovie(mov);
                            theatres.add(th);
                        }
                    }
                    else {
                        Theatre th = new Theatre(results.getString("Theatre"));
                        th.addMovie(mov);
                        theatres.add(th);
                    }
                    flag = false;
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
        
        if(tableName.equals("available_food")){
            try{
                Statement statement = dbConnect.createStatement();  
                results = statement.executeQuery("SELECT ItemID, Name, GrainContent, FVContent, ProContent, Other, Calories from available_food");
            
                while(results.next()){
                    foodDetails = new String[7];
                     
                    //foodDetails[0] = results.getString("ItemID");
                    

                    allFoodDetails.add(foodDetails);
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
    
    public static void search(String movieName){
        System.out.println("Search results for "+ movieName);
        for(int i=0; i<theatres.size(); i++){
           
            System.out.println(theatres.get(i).getName());
            theatres.get(i).searchMovies(movieName);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
       GUI gui = new GUI();
      //  Food foodObj;
        
        //Use the following account information: Username = student, Password = ensf
        MovieAppMain myJDBC = new MovieAppMain("jdbc:mysql://localhost/data_cinema","user1","ensf");
        myJDBC.initializeConnection();

        System.out.println("------------------------------");
        System.out.println();
        
        System.out.println(myJDBC.storeData("projectData"));

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
        } */
        System.out.println("--------test search for wakanda----");
        search("Wakanda Forvever");
        
       // System.out.println(myJDBC.clients("available_food"));

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
		GUI.run();

    }
}