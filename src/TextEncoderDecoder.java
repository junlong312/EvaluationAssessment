//The main logic of the Encoder and Decoder
public class TextEncoderDecoder {
    String referenceTable = ReferenceTable.GlobalReferenceTable;
    OffSetCharacter InputOffSetChar = new OffSetCharacter();
    char inputOffSetChar = InputOffSetChar.offSetCharacter();

    public String encode(String plainText) {
        //Check on the plain text --> if null or empty return
        if (plainText == null || plainText.isEmpty()) return plainText;

        //Retrieve the index of the selected offset character from the reference table
        int offset = referenceTable.indexOf(inputOffSetChar);

        //Converting the plain text to upper case
        String upperPlainText = plainText.toUpperCase();

        StringBuilder encoded = new StringBuilder();
        // Adding offset character at the beginning
        encoded.append(inputOffSetChar);

        // Loop each character in the plain text and retrieve the current index with reference to the reference table
        for (int i = 0; i < upperPlainText.length(); i++) {
            char currentChar = upperPlainText.charAt(i);
            int index = referenceTable.indexOf(Character.toUpperCase(currentChar));

            //For each Character check if the character is in the reference table (ie index > 0)
            if (index != -1) {
                //To ensure that the reference table goes in a loop, we use the %
                //(ie after the last character it will go back to the first character)
                //Also to ensure that the index is always > 0 --> we " + referenceTable.length() "
                int newIndex = (index - offset + referenceTable.length()) % referenceTable.length();
                char newChar = referenceTable.charAt(newIndex);
                //Converting the Encoded Character to Upper Case
                encoded.append(newChar);
            } else { // Character not in the reference table
                encoded.append(currentChar);
            }
        }

        return encoded.toString();
    }

    //For the decode, the logic is similar to encode
    public String decode(String encodedText) {
        if (encodedText == null || encodedText.isEmpty()) return encodedText;

        char offsetChar = encodedText.charAt(0);
        int offset = referenceTable.indexOf(offsetChar);
        StringBuilder decoded = new StringBuilder();

        for (int i = 1; i < encodedText.length(); i++) { // Start from 1 to skip the offset character
            char currentChar = encodedText.charAt(i);
            int index = referenceTable.indexOf(currentChar);

            if (index != -1) { // Character is in the reference table
                int newIndex = (index + offset) % referenceTable.length();
                char newChar = referenceTable.charAt(index);
                decoded.append(Character.isLowerCase(currentChar) ? Character.toUpperCase(newChar) : newChar);
            } else { // Character not in the reference table
                decoded.append(currentChar);
            }
        }

        return decoded.toString();
    }


}

