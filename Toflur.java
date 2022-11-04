import java.util.*;
public class Toflur{
    public Toflur(){
        //looking at the problem the lowest score is simply calculated
        //by sorting the tiles and then performing the summation given
        
        //we read the input into an array and the sort that array
        //sorting the array takes the most ammount of time
        readInput();
        
        //iterate through the set and calculate the score based on the summation given
        
    }
    public void readInput(){
        Scanner scanner = new Scanner(System.in);
        
        int numberOfTiles = scanner.nextInt();
        
        int []tiles = new int[numberOfTiles];
        
        //read data into array
        for(int i = 0; i < numberOfTiles; i++){
            tiles[i] = scanner.nextInt();
        }
        
        //store data in long because max size could be around 10^12 which is larger than int
        long sum = 0;
        
        //use array sorting method
        Arrays.sort(tiles);
        
        //perform summation on the data
        for(int i = 0; i < numberOfTiles - 1; i++){
            sum += Math.pow(tiles[i] - tiles[i + 1],2);
        }
        
        //output the result
        System.out.println(sum);
    }
    public static void main(String [] args){
        new Toflur();
    }
}