package cesarCipherGrabarczykTomasz;

import java.util.Scanner;

class CesarCipher {

    public static void main(String[] args)
    {
        CesarCipher cesarCipher = new CesarCipher();
        cesarCipher.execute();
    }

    private void execute() {
        Scanner askForText = new Scanner(System.in);

        System.out.println("Please enter text you want to convert: ");
        String userInput = askForText.nextLine();
        System.out.println("Please enter number that you want to shift by: ");
        int shiftByNumber = askForText.nextInt();

        System.out.println("Text entered: " + userInput);
        System.out.println("Shift by: " + shiftByNumber);
        System.out.println("Encrypted text: " + performEncryption(userInput, shiftByNumber));
    }

    private StringBuffer performEncryption(String userTextInput, int shiftByNumber)
    {
        StringBuffer encryptedText = new StringBuffer();

        for (int i = 0; i < userTextInput.length(); i++)
        {
            if (Character.isUpperCase(userTextInput.charAt(i)))
            {
                if (userTextInput.charAt(i) == ' ') {
                    encryptedText.append(' ');
                } else {
                    char characterAtString = (char) (((int) userTextInput.charAt(i) + shiftByNumber - 65) % 26 + 65);
                    encryptedText.append(characterAtString);
                }
            }
            else
            {
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
}
