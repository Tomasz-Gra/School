package cesarCipherGrabarczykTomasz;

import java.util.Scanner;

class CesarCipher {

    private StringBuffer encryptedText = new StringBuffer();
    private String userInput = "";

    public static void main(String[] args) {
        CesarCipher cesarCipher = new CesarCipher();
        cesarCipher.execute();
        cesarCipher.changeToBinary();
    }

    private void execute() {

        Scanner askForText = new Scanner(System.in);

        System.out.print("Please enter text you want to convert: ");
        userInput = askForText.nextLine();
        System.out.print("Please enter number that you want to shift by: ");
        int shiftByNumber = askForText.nextInt();

        System.out.format("\nText entered: %s\nShift by: %d\nEncrypted text: %s\n", userInput, shiftByNumber, performEncryption(userInput, shiftByNumber));
    }

    private StringBuffer performEncryption(String userTextInput, int shiftByNumber) {
        for (int i = 0; i < userTextInput.length(); i++) {
            if (Character.isLetter(userInput.charAt(i))) {
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
            } else {
                if (userTextInput.charAt(i) == ' ') {
                    encryptedText.append(' ');
                } else {
                    encryptedText.append((char) (255 - userInput.charAt(i)));
                }
            }
        }

        return encryptedText;
    }

    private void changeToBinary() {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isLetter(userInput.charAt(i))) {
                System.out.format("\nCharacter that is not letter: %s", userInput.charAt(i));
                System.out.format("\nNegated binary string: %s", Integer.toBinaryString(255 - userInput.charAt(i)));
                System.out.format("\nBinary ASCII code: %d", 255 - userInput.charAt(i));

                System.out.println("\nCharacter of negated binary ASCII code: " + (char) (255 - userInput.charAt(i)));
                encryptedText.append((char) (255 - userInput.charAt(i)));
            }
        }
    }
}
