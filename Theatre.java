import java.util.LinkedList;


public class Theatre {
    private String name;
    private int exists = 0;
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

    public String searchMovies(String search){
        String movDetails ="";
        exists = 0;
        for(int i=0; i<movies.size(); i++){
            exists = 1;
            if(movies.get(i).getName().contains(search)){
                movDetails+= movies.get(i).details()+"\n";
            }
        }
        return movDetails;
    }

    public int getExist(){
        return exists;
    }

}
