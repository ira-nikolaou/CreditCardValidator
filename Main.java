import javax.swing.JOptionPane;

public class Main
{
    private static boolean isValid = false;

    public static void main(String[] args)
    {
        String cdNumber = JOptionPane.showInputDialog(null, "Enter your card Number please?");
        int size = cdNumber.length();
        int [] cardNumber = new int [size];
        for(int i=0; i<size; i++) 
        {
            cardNumber[i] = Character.getNumericValue(cdNumber.charAt(i));
        }
        
        isValid = isValidCreditCardNumber(cardNumber);

        if(isValid) {
            JOptionPane.showMessageDialog(null, "Thank you, your card is valid");
        }
        else {
            JOptionPane.showMessageDialog(null, "Not a correct visa card number");
        }
    }

    public static boolean isValidCreditCardNumber(int [] creditCardNumber)
    {
        int index, temp;
        int sumOfOddPositionedDigits = 0;
        int sumOfEvenPositionedDigits = 0;

        for (index = 0; index < creditCardNumber.length; index += 2)
        {
            temp = creditCardNumber[index] * 2;
            if (temp < 10) {
                sumOfOddPositionedDigits += temp;
            }
            else {
                sumOfOddPositionedDigits += (temp % 10) + 1;
            }
        }  

        for (index = 1; index < creditCardNumber.length; index += 2)
        {
            sumOfEvenPositionedDigits += creditCardNumber[index];
        }

        temp = (sumOfOddPositionedDigits + sumOfEvenPositionedDigits) % 10;

        if (temp == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}