package com.grabarczyk.tomasz.algorytmika_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SixthLoop thirdLoop = new SixthLoop();
        thirdLoop.sixthLoop();
    }

}

class Variables {
    List<String> listOfCommonStrings = new ArrayList<>();
    List<String> deleteCommonElement = new ArrayList<>();

    String originalFirstString = "hellothereworld";
    String originalSecondString = "hellonearthandworld";

    String color = "\u001B[34m";
    String resetColor = "\u001B[0m";


    String firstString = "hellothereworld";
    String secondString = "hellonearthandworld";

    String getFirstString() {
        return firstString;
    }

    void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    String getSecondString() {
        return secondString;
    }

    void setSecondString(String secondString) {
        this.secondString = secondString;
    }

    int stringCommonPart = 0;
    int textPositionFirstString = -1;
    int textPositionSecondString = -1;

    int getStringCommonPart() {
        return stringCommonPart;
    }

    void setStringCommonPart(int stringCommonPart) {
        this.stringCommonPart = stringCommonPart;
    }

    int getTextPositionFirstString() {
        return textPositionFirstString;
    }

    void setTextPositionFirstString(int textPositionFirstString) {
        this.textPositionFirstString = textPositionFirstString;
    }

    int getTextPositionSecondString() {
        return textPositionSecondString;
    }

    void setTextPositionSecondString(int textPositionSecondString) {
        this.textPositionSecondString = textPositionSecondString;
    }



}

/*
class CommonStringFinder extends Variables {
    void findCommonString() {
        for (int i = 0; i < getFirstString().length(); i++) {
            for (int k = getSecondString().length() - 1; k >= 0; k--) {
                int counter = 0;
                for (int j = k; j < getSecondString().length(); j++) {
                    if ((i + j - k) >= getFirstString().length()) break;
                    if (getFirstString().charAt(i + j - k) == getSecondString().charAt(j)) {
                        counter++;
                        if (stringCommonPart < counter) {
                            stringCommonPart = counter;
                            textPositionFirstString = i + j - k - stringCommonPart + 1;
                            textPositionSecondString = j - stringCommonPart + 1;
                        }
                    } else counter = 0;
                }
            }
        }
    }
}
*/

class CommonStringFinder extends Variables {
    void findCommonString() {
        for (int i = 0; i < getFirstString().length(); i++) {
            for (int k = getSecondString().length() - 1; k >= 0; k--) {
                int counter = 0;
                for (int j = k; j < getSecondString().length(); j++) {
                    if ((i + j - k) >= getFirstString().length()) break;
                    if (getFirstString().charAt(i + j - k) == getSecondString().charAt(j)) {
                        counter++;
                        if (getStringCommonPart() < counter) {
                            setStringCommonPart(counter);
                            setTextPositionFirstString(i + j - k - getStringCommonPart() + 1);
                            setTextPositionSecondString(j - getStringCommonPart() + 1);
                        }
                    } else counter = 0;
                }
            }
        }
    }
}

class PrintOnConsole extends CommonStringFinder {

    void printOnConsole() {
        System.out.println("Starting position in 1st string: " + textPositionFirstString + "\nStarting position in 2nd string: " + textPositionSecondString + "\nLength of common part: " + stringCommonPart);

        System.out.println();
        System.out.println(firstString.substring(0, textPositionFirstString) + "\u001B[34m" + firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString) + "\u001B[0m" + firstString.substring(stringCommonPart + textPositionFirstString));
        System.out.println(secondString.substring(0, textPositionSecondString) + "\u001B[34m" + secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString) + "\u001B[0m" + secondString.substring(stringCommonPart + textPositionSecondString));

        deleteCommonElement.add(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString));

        setFirstString(firstString.replace(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString), ""));
        setSecondString(secondString.replace(secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString), ""));

        listOfCommonStrings.add(getFirstString());
        listOfCommonStrings.add(getSecondString());
    }
}

class PrintCommonStrings extends PrintOnConsole {
    void printCommonStrings() {
        findCommonString();

        printOnConsole();
    }
}


class SecondLoop extends PrintCommonStrings{

    void secondLoop() {
        printCommonStrings();

        setFirstString(listOfCommonStrings.get(0));
        setSecondString(listOfCommonStrings.get(1));

        if (getFirstString().isEmpty() || getSecondString().isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            setStringCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            findCommonString();

            System.out.println("\nThird Loop:\n");

            System.out.println("Starting position in 1st string: " + textPositionFirstString + "\nStarting position in 2nd string: " + textPositionSecondString + "\nLength of common part: " + stringCommonPart);

            System.out.println();
            System.out.println(firstString.substring(0, textPositionFirstString) + "\u001B[34m" + firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString) + "\u001B[0m" + firstString.substring(stringCommonPart + textPositionFirstString));
            System.out.println(secondString.substring(0, textPositionSecondString) + "\u001B[34m" + secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString) + "\u001B[0m" + secondString.substring(stringCommonPart + textPositionSecondString));

            listOfCommonStrings.clear();

            deleteCommonElement.add(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString));

            listOfCommonStrings.add(firstString.replace(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString), ""));
            listOfCommonStrings.add(secondString.replace(secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString), ""));
        }
    }
}



class ThirdLoop extends SecondLoop {

    void thirdLoop() {
        secondLoop();

        String firstString = listOfCommonStrings.get(0);
        String secondString = listOfCommonStrings.get(1);

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            int lengthFirstString = firstString.length();
            int lengthSecondString = secondString.length();

            int stringCommonPart = 0;
            int textPositionFirstString = -1;
            int textPositionSecondString = -1;


            for (int i = 0; i < lengthFirstString; i++) {
                for (int k = lengthSecondString - 1; k >= 0; k--) {
                    int counter = 0;
                    for (int j = k; j < lengthSecondString; j++) {
                        if ((i + j - k) >= lengthFirstString) break;
                        if (firstString.charAt(i + j - k) == secondString.charAt(j)) {
                            counter++;
                            if (stringCommonPart < counter) {
                                stringCommonPart = counter;
                                textPositionFirstString = i + j - k - stringCommonPart + 1;
                                textPositionSecondString = j - stringCommonPart + 1;
                            }
                        } else counter = 0;
                    }
                }
            }


            System.out.println("\nThird Loop:\n");

            System.out.println("Starting position in 1st string: " + textPositionFirstString + "\nStarting position in 2nd string: " + textPositionSecondString + "\nLength of common part: " + stringCommonPart);

            System.out.println();
            System.out.println(firstString.substring(0, textPositionFirstString) + "\u001B[34m" + firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString) + "\u001B[0m" + firstString.substring(stringCommonPart + textPositionFirstString));
            System.out.println(secondString.substring(0, textPositionSecondString) + "\u001B[34m" + secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString) + "\u001B[0m" + secondString.substring(stringCommonPart + textPositionSecondString));

            listOfCommonStrings.clear();

            deleteCommonElement.add(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString));

            listOfCommonStrings.add(firstString.replace(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString), ""));
            listOfCommonStrings.add(secondString.replace(secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString), ""));
        }
    }
}


class FourthLoop extends ThirdLoop{

    void fourthLoop() {
        thirdLoop();

        String firstString = listOfCommonStrings.get(0);
        String secondString = listOfCommonStrings.get(1);

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            int lengthFirstString = firstString.length();
            int lengthSecondString = secondString.length();

            int stringCommonPart = 0;
            int textPositionFirstString = -1;
            int textPositionSecondString = -1;


            for (int i = 0; i < lengthFirstString; i++) {
                for (int k = lengthSecondString - 1; k >= 0; k--) {
                    int counter = 0;
                    for (int j = k; j < lengthSecondString; j++) {
                        if ((i + j - k) >= lengthFirstString) break;
                        if (firstString.charAt(i + j - k) == secondString.charAt(j)) {
                            counter++;
                            if (stringCommonPart < counter) {
                                stringCommonPart = counter;
                                textPositionFirstString = i + j - k - stringCommonPart + 1;
                                textPositionSecondString = j - stringCommonPart + 1;
                            }
                        } else counter = 0;
                    }
                }
            }


            System.out.println("\nFourth Loop:\n");

            System.out.println("Starting position in 1st string: " + textPositionFirstString + "\nStarting position in 2nd string: " + textPositionSecondString + "\nLength of common part: " + stringCommonPart);

            System.out.println();
            System.out.println(firstString.substring(0, textPositionFirstString) + "\u001B[34m" + firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString) + "\u001B[0m" + firstString.substring(stringCommonPart + textPositionFirstString));
            System.out.println(secondString.substring(0, textPositionSecondString) + "\u001B[34m" + secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString) + "\u001B[0m" + secondString.substring(stringCommonPart + textPositionSecondString));

            listOfCommonStrings.clear();

            deleteCommonElement.add(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString));

            listOfCommonStrings.add(firstString.replace(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString), ""));
            listOfCommonStrings.add(secondString.replace(secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString), ""));

            System.out.println(listOfCommonStrings);
            System.out.println(deleteCommonElement);
        }
    }
}


class FifthLoop extends FourthLoop{

    void fifthLoop() {
        fourthLoop();

        String firstString = listOfCommonStrings.get(0);
        String secondString = listOfCommonStrings.get(1);

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            int lengthFirstString = firstString.length();
            int lengthSecondString = secondString.length();

            int stringCommonPart = 0;
            int textPositionFirstString = -1;
            int textPositionSecondString = -1;


            for (int i = 0; i < lengthFirstString; i++) {
                for (int k = lengthSecondString - 1; k >= 0; k--) {
                    int counter = 0;
                    for (int j = k; j < lengthSecondString; j++) {
                        if ((i + j - k) >= lengthFirstString) break;
                        if (firstString.charAt(i + j - k) == secondString.charAt(j)) {
                            counter++;
                            if (stringCommonPart < counter) {
                                stringCommonPart = counter;
                                textPositionFirstString = i + j - k - stringCommonPart + 1;
                                textPositionSecondString = j - stringCommonPart + 1;
                            }
                        } else counter = 0;
                    }
                }
            }


            System.out.println("\nFifth Loop:\n");

            System.out.println("Starting position in 1st string: " + textPositionFirstString + "\nStarting position in 2nd string: " + textPositionSecondString + "\nLength of common part: " + stringCommonPart);

            System.out.println();
            System.out.println(firstString.substring(0, textPositionFirstString) + "\u001B[34m" + firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString) + "\u001B[0m" + firstString.substring(stringCommonPart + textPositionFirstString));
            System.out.println(secondString.substring(0, textPositionSecondString) + "\u001B[34m" + secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString) + "\u001B[0m" + secondString.substring(stringCommonPart + textPositionSecondString));

            listOfCommonStrings.clear();

            deleteCommonElement.add(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString));

            listOfCommonStrings.add(firstString.replace(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString), ""));
            listOfCommonStrings.add(secondString.replace(secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString), ""));
        }
    }
}



class SixthLoop extends FifthLoop {

    void sixthLoop() {
        fifthLoop();

        String firstString = listOfCommonStrings.get(0) ;
        String secondString = listOfCommonStrings.get(1);

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            int lengthFirstString = firstString.length();
            int lengthSecondString = secondString.length();

            int stringCommonPart = 0;
            int textPositionFirstString = -1;
            int textPositionSecondString = -1;


            for (int i = 0; i < lengthFirstString; i++) {
                for (int k = lengthSecondString - 1; k >= 0; k--) {
                    int counter = 0;
                    for (int j = k; j < lengthSecondString; j++) {
                        if ((i + j - k) >= lengthFirstString) break;
                        if (firstString.charAt(i + j - k) == secondString.charAt(j)) {
                            counter++;
                            if (stringCommonPart < counter) {
                                stringCommonPart = counter;
                                textPositionFirstString = i + j - k - stringCommonPart + 1;
                                textPositionSecondString = j - stringCommonPart + 1;
                            }
                        } else counter = 0;
                    }
                }
            }


            System.out.println("\nFourth Loop:\n");

            System.out.println("Starting position in 1st string: " + textPositionFirstString + "\nStarting position in 2nd string: " + textPositionSecondString + "\nLength of common part: " + stringCommonPart);

            System.out.println();
            System.out.println(firstString.substring(0, textPositionFirstString) + "\u001B[34m" + firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString) + "\u001B[0m" + firstString.substring(stringCommonPart + textPositionFirstString));
            System.out.println(secondString.substring(0, textPositionSecondString) + "\u001B[34m" + secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString) + "\u001B[0m" + secondString.substring(stringCommonPart + textPositionSecondString));

            listOfCommonStrings.clear();

            deleteCommonElement.add(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString));

            listOfCommonStrings.add(firstString.replace(firstString.substring(textPositionFirstString, stringCommonPart + textPositionFirstString), ""));
            listOfCommonStrings.add(secondString.replace(secondString.substring(textPositionSecondString, stringCommonPart + textPositionSecondString), ""));
        }
    }
}
