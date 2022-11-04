import java.util.*;

public class parking{
    int []costs = new int[3];
    
    int []arrivalTimes = new int[3];
    int []departTimes = new int[3];
        
    public parking(){
        //read the input from the file
        readInputs();
        
        System.out.println(calculateCost());
    }
    public void readInputs(){
        Scanner scanner = new Scanner(System.in);
        
        //first 3 costs A,B,C
        costs[0] = scanner.nextInt();
        costs[1] = scanner.nextInt();
        costs[2] = scanner.nextInt();
        
        //info about the three trucks
        for(int i = 0; i < 3; i++){
            arrivalTimes[i] = scanner.nextInt();
            departTimes[i] = scanner.nextInt();
        }
    }
    public int calculateCost(){
        int numberOfTrucks = 0;
        
        int totalCost = 0;
        
        //max index is 100
        for(int i = 0; i <= 100; i++){
            //for all 3 trucks see if they have entered or left parking
            for(int j = 0; j < 3; j++){
                if(arrivalTimes[j] == i){
                    numberOfTrucks++;
                }
                if(departTimes[j] == i){
                    numberOfTrucks--;
                }
            }
            
            //depending on the number of trucks add to the total cost
            if(numberOfTrucks > 0){
                totalCost += numberOfTrucks * costs[numberOfTrucks - 1];
            }
            
        }
        
        return totalCost;
    }
    public static void main(String [] args){
        new parking();
    }
}