package cesarCipherGrabarczykTomasz;

import java.util.Scanner;

class CesarCipher {

    private StringBuffer encryptedText = new StringBuffer();


    public static void main(String[] args) {
        CesarCipher cesarCipher = new CesarCipher();
        cesarCipher.execute();
        cesarCipher.changeToBinary();
    }

    private void execute() {

        Scanner askForText = new Scanner(System.in);

        System.out.print("Please enter text you want to convert: ");
        String userInput = askForText.nextLine();
        System.out.print("Please enter number that you want to shift by: ");
        int shiftByNumber = askForText.nextInt();

        System.out.format("\nText entered: %s\nShift by: %d\nEncrypted text: %s\n", userInput, shiftByNumber, performEncryption(userInput, shiftByNumber));
    }

    private StringBuffer performEncryption(String userTextInput, int shiftByNumber) {
                for (int i = 0; i < userTextInput.length(); i++) {
            if (Character.isUpperCase(userTextInput.charAt(i))) {
                if (userTextInput.charAt(i) == ' ') {
                    encryptedText.append(' ');
                } else {
                    char characterAtString = (char) (((int) userTextInput.charAt(i) + shiftByNumber - 65) % 26 + 65);
                    encryptedText.append(characterAtString);
                }
            } else {
                if (userTextInput.charAt(i) == ' ') {
                    encryptedText.append(' ');
                } else {
                    char characterAtString = (char) (((int) userTextInput.charAt(i) + shiftByNumber - 97) % 26 + 97);
                    encryptedText.append(characterAtString);
                }
            }
        }

        return encryptedText;
    }

    private void changeToBinary() {
        System.out.println();
        char inputCharacter = encryptedText.charAt(0);
        System.out.println("Letter to binary: " + inputCharacter);
        System.out.println("Binary string: " + Integer.toBinaryString((int) inputCharacter));
        System.out.println("Negated binary string: " + Integer.toBinaryString((int) inputCharacter).replace('0', '2').replace('1', '0').replace('2', '1'));
        int negatedBinaryString = Integer.parseInt(Integer.toBinaryString((int) inputCharacter).replace('0', '2').replace('1', '0').replace('2', '1'), 2);
        System.out.println("Negated binary string number: " + negatedBinaryString);
        System.out.println("Character of negated binary string: " + (char) negatedBinaryString);
    }
}
