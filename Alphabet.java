import java.util.*;

public class Alphabet{
    //omg dynamic programming problem!
    public Alphabet(){
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        //data stores the smallest number of letters needed to add to the substring 0 to x where x is the index in data
        //to make the substring alphabetical (after you do 26 - data point)
        int [] data = new int[input.length()];
        
        //this is the current best answer we have come across and starts at 1 because the input is at least size 1
        int globalMax = 1;
        
        //we want to go through each length of the input and find if adding that extra variable increases the best answer or not
        //storing that data in data reducing the amount of stuff we have to recalculate making the algo faster.
        for(int i = 0; i < input.length(); i++){
            //current best answer for the current substring (0,i) of the input
            int currMax = 1;
            
            //we only want to check chars that are greater than the lest char in the substring because if the
            //char in the substring is less then it has no effect on the current best answer for the 
            //current substring (0,i) so no need to calculate
            for(int j = 0; j < i; j++){
                if(input.charAt(j) < input.charAt(i)){
                    //add 1 since the last char in the substring is larger and will thus increase the answer
                    int smallMax = data[j] + 1;
                    if(smallMax > currMax){
                        currMax = smallMax;
                        
                    }
                }
            }
            //save the data for later use to reduce recalculation
            data[i] = currMax;
            
            //see if we have a new best answer or not
            if(currMax > globalMax){
                globalMax = currMax;
            }
        }
        
        //print out the answer
        System.out.println(26 - globalMax);
    }
    public static void main(String [] args){
        new Alphabet();
    }
}