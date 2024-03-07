import java.util.Scanner;

// OffSetCharacter class is for user to select a character to be offset
// In this class, we will check if the user selected Only 1 Character and if the character is in from the reference table
//If we want to update the logic for the input from the user, we can come here to edit
public class OffSetCharacter {

    String referenceTable = ReferenceTable.GlobalReferenceTable;

    public char offSetCharacter (){

        char inputChar;
        while (true) {
            Scanner myChar = new Scanner(System.in);
            System.out.println("Enter offset Character");
            System.out.println("Choose a character from ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./");
            //We change the input character to upper case
            String input = myChar.nextLine().toUpperCase();

            //Check if the input has more than 1 character
            if (input.length() != 1) {
                System.out.println("Invalid Input. Please enter 1 character to offset only");
                continue;
            }

            inputChar = input.charAt(0);
            //Check if the Character selected is in the reference table
            if (referenceTable.indexOf(inputChar) == -1){
                System.out.println("Input Character NOT found in Reference table. Please input again");
            } else {
                break;
            }
        }
        return inputChar;
    }

}
