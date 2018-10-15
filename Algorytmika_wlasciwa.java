package com.grabarczyk.tomasz.algorytmika_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CompareEverything compareEverything = new CompareEverything();
        compareEverything.compareEverything();
    }
}

class Variables {
    List<String> updatedString = new ArrayList<>();
    List<String> listOfCommonStrings = new ArrayList<>();

    String firstString = "ABAABBAAABBBA";
    String secondString = "AAABAABBABABA";

    String originalFirstString = firstString;
    String originalSecondString = secondString;

    private int lengthOfCommonPart;
    private int textPositionFirstString;
    private int textPositionSecondString;
    int numberOfChecks = 10;

    String getFirstString() { return firstString; }
    String getSecondString() { return secondString; }
    int getLengthOfCommonPart() { return lengthOfCommonPart; }
    int getTextPositionFirstString() { return textPositionFirstString; }
    int getTextPositionSecondString() { return textPositionSecondString; }

    void setFirstString(String firstString) { this.firstString = firstString; }
    void setSecondString(String secondString) { this.secondString = secondString; }
    void setLengthOfCommonPart(int lengthOfCommonPart) { this.lengthOfCommonPart = lengthOfCommonPart; }
    void setTextPositionFirstString(int textPositionFirstString) { this.textPositionFirstString = textPositionFirstString; }
    void setTextPositionSecondString(int textPositionSecondString) { this.textPositionSecondString = textPositionSecondString; }
}

class CommonStringFinder extends Variables {
    void commonStringFinder() {
        for (int i = 0; i < getSecondString().length(); i++) {
            for (int j = getFirstString().length() - 1; j >= 0; j--) {
                int counter = 0;
                for (int k = j; k < getFirstString().length(); k++) {
                    if ((i + k - j) >= getSecondString().length()) break;
                    if (getSecondString().charAt(i + k - j) == getFirstString().charAt(k)) {
                        counter++;
                        if (getLengthOfCommonPart() < counter) {
                            setLengthOfCommonPart(counter);
                            setTextPositionSecondString(i + k - j - getLengthOfCommonPart() + 1);
                            setTextPositionFirstString(k - getLengthOfCommonPart() + 1);
                        }
                    } else counter = 0;
                }
            }
        }
    }
}

class PrintOnConsole extends CommonStringFinder {
    void printOnConsole() {
        if ((getTextPositionFirstString() != -1 || getTextPositionSecondString() != -1) && getLengthOfCommonPart() > 1) {
            System.out.format("Position in 1st string: %s, position in 2nd string: %s, length: %s\n", getTextPositionFirstString(), getTextPositionSecondString(), getLengthOfCommonPart());

            System.out.format("Length of common part: \033[1;34m%d\u001B[0m\n\n", getLengthOfCommonPart());

            System.out.format("%s\033[4;36m%s\u001B[0m%s\n", firstString.substring(0, getTextPositionFirstString()), firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()), firstString.substring(getLengthOfCommonPart() + getTextPositionFirstString()));
            System.out.format("%s\033[4;35m%s\u001B[0m%s\n", secondString.substring(0, getTextPositionSecondString()), secondString.substring(getTextPositionSecondString(), getLengthOfCommonPart() + getTextPositionSecondString()), secondString.substring(getLengthOfCommonPart() + getTextPositionSecondString()));

            updatedString.clear();

            listOfCommonStrings.add(firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()));

            updatedString.add(firstString.replaceFirst(firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()), ""));
            updatedString.add(secondString.replaceFirst(secondString.substring(getTextPositionSecondString(), getLengthOfCommonPart() + getTextPositionSecondString()), "."));
        } else {
            System.out.format("It seems that there's nothing else to compare...\n");
            System.out.format("Finishing task...");

            System.out.format("\n\nAll common part(s) of \033[1;36m%s\u001B[0m and \033[1;35m%s\u001B[0m are: \033[1;34m%s\u001B[0m\n\n", originalFirstString, originalSecondString, listOfCommonStrings);
            System.out.print("Author: \033[1;33mTomasz Grabarczyk\u001B[0m\n");
            System.exit(0);
        }
    }
}

class CompareEverything extends PrintOnConsole {
    void compareEverything() {
        for (int i = 0; i < numberOfChecks; i++) {
            if (i > 0) {
                setFirstString(updatedString.get(0));
                setSecondString(updatedString.get(1));
            }
            setLengthOfCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            commonStringFinder();

            System.out.format("\nPerforming %d. action...\n", i + 1);
            printOnConsole();
        }
    }
}
