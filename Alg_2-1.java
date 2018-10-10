package com.grabarczyk.tomasz.algorytmika_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CompareEverything compareEverything = new CompareEverything();
        compareEverything.compareEverything();
    }
}

class Variables {
    List<String> updatedString = new ArrayList<>();
    List<String> listOfCommonStrings = new ArrayList<>();

    String firstString = "SomeDumbTextsToCompareAndSecondText";
    String secondString = "SomeEvenDumberTextToCompareText";

    String originalFirstString = firstString;
    String originalSecondString = secondString;

    private int lengthOfCommonPart = 0;
    private int textPositionFirstString = -1;
    private int textPositionSecondString = -1;

    String getFirstString() {
        return firstString;
    }
    String getSecondString() {
        return secondString;
    }
    int getLengthOfCommonPart() {
        return lengthOfCommonPart;
    }
    int getTextPositionFirstString() {
        return textPositionFirstString;
    }
    int getTextPositionSecondString() {
        return textPositionSecondString;
    }

    void setFirstString(String firstString) {
        this.firstString = firstString;
    }
    void setSecondString(String secondString) {
        this.secondString = secondString;
    }
    void setLengthOfCommonPart(int lengthOfCommonPart) {
        this.lengthOfCommonPart = lengthOfCommonPart;
    }
    void setTextPositionFirstString(int textPositionFirstString) {
        this.textPositionFirstString = textPositionFirstString;
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
                        if (getLengthOfCommonPart() < counter) {
                            setLengthOfCommonPart(counter);
                            setTextPositionFirstString(i + j - k - getLengthOfCommonPart() + 1);
                            setTextPositionSecondString(j - getLengthOfCommonPart() + 1);
                        }
                    } else counter = 0;
                }
            }
        }
    }
}

class PrintOnConsole extends CommonStringFinder {

    void printOnConsole() {
        if (getTextPositionFirstString() != -1 || getTextPositionSecondString() != -1) {
            System.out.format("Starting position in string \033[1;36m%s\u001B[0m: \033[1;36m%d\u001B[0m\nStarting position in string \033[1;35m%s\u001B[0m: \033[1;35m%d\u001B[0m\nLength of common part: \033[1;34m%d\u001B[0m\n\n", firstString, getTextPositionFirstString(), secondString, getTextPositionSecondString(), getLengthOfCommonPart());

            System.out.format("%s\033[4;36m%s\u001B[0m%s\n", firstString.substring(0, getTextPositionFirstString()), firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()), firstString.substring(getLengthOfCommonPart() + getTextPositionFirstString()));
            System.out.format("%s\033[4;35m%s\u001B[0m%s\n", secondString.substring(0, getTextPositionSecondString()), secondString.substring(getTextPositionSecondString(), getLengthOfCommonPart() + getTextPositionSecondString()), secondString.substring(getLengthOfCommonPart() + getTextPositionSecondString()));

            updatedString.clear();

            listOfCommonStrings.add(firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()));

            updatedString.add(firstString.replaceFirst(firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()), ""));
            updatedString.add(secondString.replaceFirst(secondString.substring(getTextPositionSecondString(), getLengthOfCommonPart() + getTextPositionSecondString()), ""));

            System.out.format("\nCommon part(s) as far: \033[1;34m%s\u001B[0m\n", listOfCommonStrings);
        } else {
            System.out.format("\n----------------------------------------------\nIt seems that there's nothing else to compare!\nAll common parts of \033[1;36m%s\u001B[0m and \033[1;35m%s\u001B[0m are: \033[1;34m%s\u001B[0m\n", originalFirstString, originalSecondString, listOfCommonStrings);
            System.exit(0);
        }
    }
}

class PrintPerformingAction extends PrintOnConsole {
    void printPerformingAction() throws InterruptedException {
        setFirstString(getFirstString().toLowerCase());
        setSecondString(getSecondString().toLowerCase());

        System.out.println("\nPerforming action...");
        Thread.sleep(1000);
        System.out.println("It seems that there is something to compare...\n");
        Thread.sleep(1000);

        findCommonString();

        printOnConsole();
    }
}

class CompareEverything extends PrintPerformingAction {
    void compareEverything() throws InterruptedException {
        printPerformingAction();

        for (int i = 0; i < 20; i++) {
            setFirstString(updatedString.get(0));
            setSecondString(updatedString.get(1));
            setLengthOfCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            findCommonString();

            System.out.println("\nPerforming action...");
            Thread.sleep(1000);
            if (getTextPositionFirstString() != -1 || getTextPositionSecondString() != -1) {
                System.out.println("It seems that there is something to compare...\n");
                Thread.sleep(1000);
            }
            printOnConsole();
        }

    }
}
