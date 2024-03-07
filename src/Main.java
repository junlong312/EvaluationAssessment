//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String plainText = "Hello World";

        TextEncoderDecoder encoderDecoder = new TextEncoderDecoder();
        String encodedText = encoderDecoder.encode(plainText);
        System.out.println("Encoded: " + encodedText);

        String decodedText = encoderDecoder.decode(encodedText);
        System.out.println("Decoded: " + decodedText);
    }
}