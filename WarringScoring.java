import java.util.*;

public class WarringScoring{
    public WarringScoring(){
        Scanner scanner = new Scanner(System.in);
        
        int pointsScored = scanner.nextInt();
        
        //treating Yraglac as player 1
        
        //currentStreak player 1 is on
        int streak1 = 0;
        //currentStreak player 2 is on
        int streak2 = 0;
        //highestStreak player 1 is on
        int highStreak1 = 0;
        //highestStreak player 2 is on
        int highStreak2 = 0;
        //currentScore difference
        int scoreDifference = 0;
        //player 1 highest score difference
        int scoreDiffHigh1 = 0;
        //player 2 highest score difference
        int scoreDiffHigh2 = 0;
        for(int i = 0; i < pointsScored; i++){
            //read in who won the point
            String s = scanner.next();
            
            if(s.equals("Yraglac")){
                //change the score difference between the players
                scoreDifference++;
                //break player 2 streak if they were on a streak
                if(streak2 != 0){
                    streak2 = 0;
                }
                //increment player 1 streak
                streak1++;
                //check if they are on a new streak record
                if(streak1 > highStreak1){
                    highStreak1 = streak1;
                }
            } else {
                //opposite to if player 1 won
                scoreDifference--;
                if(streak1 != 0){
                    streak1 = 0;
                }
                streak2++;
                if(streak2 > highStreak2){
                    highStreak2 = streak2;
                }
            }
            //check if the difference between the players is a new high after the points have been calculated
            if(scoreDifference > scoreDiffHigh1){
                scoreDiffHigh1 = scoreDifference;
            }
            if(scoreDifference < scoreDiffHigh2){
                scoreDiffHigh2 = scoreDifference;
            }
        }

        //check if they both say they both won they both say they both tie, and if they both say they both lost
        if(scoreDiffHigh1 + scoreDiffHigh2 > 0 && highStreak1 > highStreak2){
            System.out.println("Agree");
        }else if(scoreDiffHigh1 + scoreDiffHigh2 == 0 && highStreak1 == highStreak2){
            System.out.println("Agree");
        } else if(scoreDiffHigh1 + scoreDiffHigh2 < 0 && highStreak1 < highStreak2){
            System.out.println("Agree");
        } else { //this means they dont agree
            System.out.println("Disagree");
        }
         
        
    }
    public static void main(String [] args){
        new WarringScoring();
    }
}