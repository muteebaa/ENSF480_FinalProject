import java.util.LinkedList;


public class Theatre {
    private String name;
    private LinkedList<Movie> movies = new LinkedList<Movie>();

    Theatre(String n){
       name = n;
    }

    void addMovie(Movie mov){
        movies.add(mov);
    }

    public String getName(){
        return name;
    }

    public void getMovies(){
        for(int i=0; i<movies.size(); i++){
            System.out.println(movies.get(i).getName());
        } 
    }

    public void searchMovies(String search){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getName().contains(search)){
                movies.get(i).display();
            }
        }
    }

}
