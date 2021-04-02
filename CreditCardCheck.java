import java.util.Scanner;

public class CreditCardCheck
{
    public static void main(String[] args){  
        //declare instance variables
        String userCard;
        String validation; 
        String cardType;

        //define allowed credit card string patterns for Visa and MasterCard
        String pattern = "4[0-9]{12}|4[0-9]{15}|5[1-5]{1}[0-9]{14}";

        //Create new scanner object
        Scanner sc = new Scanner(System.in); 

        //Ask for user input of credit card number
        System.out.println("Please enter your Credit Card Number: ");
        userCard = sc.nextLine();

        if (userCard.matches(pattern)){
            
            //Create array with the digits provided in the String 
            int[] cardNoArray = new int [userCard.length()];
            for(int i = 0; i<userCard.length(); i++) 
            {
                cardNoArray[i] = Character.getNumericValue(userCard.charAt(i));
            }
            
            //declare instance variables
            int evenPos;
            int oddPos;
            int oddSum = 0;
            int evenSum = 0;

            //Find all even placed numbers 
            System.out.println("Even Numbers: "); 
            for (int i = cardNoArray.length - 1; i >= 0; i-=2) {
                evenPos = cardNoArray[i];
                System.out.print(evenPos);

                //Sum a even places numbers
                evenSum += cardNoArray[i]; 
            }

            System.out.println(); 
            System.out.println("The sum of the even numbers is: " + evenSum); 

            //Find all odd placed numbers
            System.out.println("Odd Numbers: "); 
            for (int n = 0; n < cardNoArray.length - 1; n +=2) {
                oddPos = cardNoArray[n];
                System.out.print(oddPos);

                //Multiply all odd positioned numbers by 2
                oddPos = oddPos * 2; 

                //If the number has two digits,these digits are summed to result in a single digit
                //The sigle digits are then summed 
                if (oddPos > 9) {
                    oddSum += oddPos / 10;
                    oddSum += oddPos % 10;  

                    //Otherwise, sum all odd placed numbers without further changes   
                } else {
                    oddSum += cardNoArray[n] * 2; 
                }
            }

            System.out.println(); 
            System.out.println("The sum of the odd numbers is: " + oddSum); 

            //Sum of all even and odd positioned digits
            int finalSum = oddSum + evenSum;
            System.out.println("This adds up to: " + finalSum); 

            //mod 10 of finalSum
            int finalSumMod = finalSum % 10; 
            System.out.println("The final mod is: " + finalSumMod); 

            //If the result of modulus 10 is 0 this indicates that the credit card number is valid
            if (finalSumMod == 0) {
                System.out.println("This credit card is valid");
            } else {
                System.out.println("Sorry, this credit card is invalid");

            }
        }
        //If the user input does not match the defined pattern, the card is rejected 
        else {
            System.out.println("The credit card number you have entered is invalid");
        }

    }
}