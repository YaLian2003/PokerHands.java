import java.util.Scanner;

//Yangyang Lian CS111B
public class Test {
    public static void main(String[] args) {
        //creating an array of 5 integers to store the values
        int cards[] = new int[5];
        //creating a scanner object to read the input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 numeric cards, no face cards. Use 0 - 9.");
        //defining a variable to store the lowest card entered. using 10 so that any value that user
        //enter will be less than this
        int lowestCard = 10;
        //looping through the array
        for (int i = 0; i < cards.length; i++) {
            //asking for the input
            System.out.print("Card " + (i + 1) + ": ");
            //reading the input, storing it in the array
            cards[i] = sc.nextInt();
            //checking if the card is the lowest card entered so far
            if (cards[i] < lowestCard) {
                //if it is, store the value in the lowestCard variable
                lowestCard = cards[i];
            }
        }
        //checking for Pair
        //looping through 0 - 4
        for (int i = 0; i < cards.length; i++) {
            //looping through i+1 - 4
            for (int j = i+1; j < cards.length; j++) {
                //checking if cards[i] and cards[j] are equal
                if (cards[i] == cards[j]) {
                    //if they are, print Pair
                    System.out.println("Pair!");
                    //exit the program
                    return;
                }
            }
        }
        //now we check if the cards form a "Straight"
        //if it needs to be a "Straight", all values between lowestCard and lowestCard + 4 must be
        //present in the array
        //so looping and checking if all values between lowestCard and lowestCard + 4 are present
        for(int i=lowestCard;i<=(lowestCard+4);i++){
            //initializing a flag variable to false
            boolean found = false;
            //looping through the array
            for(int j=0;j<cards.length;j++){
                //checking if the value is present in the array
                if(cards[j]==i){
                    //found.
                    found=true;
                    break; //exit inner loop
                }
            }
            //if current value is not found, it is not a Straight, so printing a message that
            //the cards are not a Straight or a Pair
            if(!found){
                System.out.println("Not a Pair or Straight!");
                return; //and exiting the program
            }
        }
        //if program reached this point, it means all values between lowestCard and lowestCard + 4 are
        //present in the array, so printing a message that the cards are a Straight
        System.out.println("Straight!");
    }
}
