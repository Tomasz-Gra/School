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
        System.out.println("Starting position in 1st string: " + getTextPositionFirstString() + "\nStarting position in 2nd string: " + getTextPositionSecondString() + "\nLength of common part: " + getStringCommonPart());

        System.out.println();
        System.out.println(firstString.substring(0, getTextPositionFirstString()) + "\u001B[34m" + firstString.substring(getTextPositionFirstString(), getStringCommonPart() + getTextPositionFirstString()) + "\u001B[0m" + firstString.substring(getStringCommonPart() + getTextPositionFirstString()));
        System.out.println(secondString.substring(0, getTextPositionSecondString()) + "\u001B[34m" + secondString.substring(getTextPositionSecondString(), getStringCommonPart() + getTextPositionSecondString()) + "\u001B[0m" + secondString.substring(getStringCommonPart() + getTextPositionSecondString()));

        listOfCommonStrings.clear();

        deleteCommonElement.add(firstString.substring(getTextPositionFirstString(), getStringCommonPart() + getTextPositionFirstString()));

        listOfCommonStrings.add(firstString.replace(firstString.substring(getTextPositionFirstString(), getStringCommonPart() + getTextPositionFirstString()), ""));
        listOfCommonStrings.add(secondString.replace(secondString.substring(getTextPositionSecondString(), getStringCommonPart() + getTextPositionSecondString()), ""));
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
        }

            System.out.println("\nSecond Loop:\n");

            printOnConsole();
    }
}



class ThirdLoop extends SecondLoop {

    void thirdLoop() {
        secondLoop();

        setFirstString(listOfCommonStrings.get(0));
        setSecondString(listOfCommonStrings.get(1));

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            setStringCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            findCommonString();
        }

        System.out.println("\nThird Loop:\n");

        printOnConsole();
    }
}


class FourthLoop extends ThirdLoop{

    void fourthLoop() {
        thirdLoop();

        setFirstString(listOfCommonStrings.get(0));
        setSecondString(listOfCommonStrings.get(1));

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            setStringCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            findCommonString();
        }

        System.out.println("\nFourth Loop:\n");

        printOnConsole();
    }
}


class FifthLoop extends FourthLoop{

    void fifthLoop() {
        fourthLoop();

        setFirstString(listOfCommonStrings.get(0));
        setSecondString(listOfCommonStrings.get(1));

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            setStringCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            findCommonString();
        }

        System.out.println("\nFourth Loop:\n");

        printOnConsole();
    }
}



class SixthLoop extends FifthLoop {

    void sixthLoop() {
        fifthLoop();

        setFirstString(listOfCommonStrings.get(0));
        setSecondString(listOfCommonStrings.get(1));

        if (firstString.isEmpty()) {
            System.out.println("\nThere's nothing else to compare!\n");
            for (String common : deleteCommonElement)
                System.out.format("Common string of %s%s%s and %s%s%s is: %s\n", color, originalFirstString, resetColor, color, originalSecondString, resetColor, common);
            System.exit(0);
        } else {
            setStringCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            findCommonString();
        }

        System.out.println("\nFourth Loop:\n");

        printOnConsole();
    }
}
