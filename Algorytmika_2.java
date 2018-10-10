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

    //String firstString = "SomeDumbTextsToCompareAndSecondText";
    //String secondString = "SomeEvenDumberTextToCompareText";

    String firstString = "ABABBBBABAAABABABABBABABABAAABBABABASomeDumbTextsToCompareAndSecondText";
    String secondString = "ABBBBABABAABABAABABABABAAABBABABABBABABABAASomeEvenDumberTextToCompareText";

    String originalFirstString = firstString;
    String originalSecondString = secondString;

    private int lengthOfCommonPart = 0;
    private int textPositionFirstString = -1;
    private int textPositionSecondString = -1;
    int numberOfChecks = 50;

    String lines = "---------------------------------------------------------------";

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
        for (int firstIncrement = 0; firstIncrement < getFirstString().length(); firstIncrement++) {
            for (int secondDecrement = getSecondString().length() - 1; secondDecrement >= 0; secondDecrement--) {
                int counter = 0;
                for (int secondIncrement = secondDecrement; secondIncrement < getSecondString().length(); secondIncrement++) {
                    if ((firstIncrement + secondIncrement - secondDecrement) >= getFirstString().length()) break;
                    if (getFirstString().charAt(firstIncrement + secondIncrement - secondDecrement) == getSecondString().charAt(secondIncrement)) {
                        counter++;
                        if (getLengthOfCommonPart() < counter) {
                            setLengthOfCommonPart(counter);
                            setTextPositionFirstString(firstIncrement + secondIncrement - secondDecrement - getLengthOfCommonPart() + 1);
                            setTextPositionSecondString(secondIncrement - getLengthOfCommonPart() + 1);
                        }
                    } else counter = 0;
                }
            }
        }
    }
}

class PrintOnConsole extends CommonStringFinder {
    void printOnConsole() throws InterruptedException {
        if (getTextPositionFirstString() != -1 || getTextPositionSecondString() != -1) {
            System.out.format("Length of common part: \033[1;34m%d\u001B[0m\n\n", getLengthOfCommonPart());

            System.out.format("%s\033[4;36m%s\u001B[0m%s\n", firstString.substring(0, getTextPositionFirstString()), firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()), firstString.substring(getLengthOfCommonPart() + getTextPositionFirstString()));
            System.out.format("%s\033[4;35m%s\u001B[0m%s\n", secondString.substring(0, getTextPositionSecondString()), secondString.substring(getTextPositionSecondString(), getLengthOfCommonPart() + getTextPositionSecondString()), secondString.substring(getLengthOfCommonPart() + getTextPositionSecondString()));

            updatedString.clear();

            listOfCommonStrings.add(firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()));

            updatedString.add(firstString.replaceFirst(firstString.substring(getTextPositionFirstString(), getLengthOfCommonPart() + getTextPositionFirstString()), ":"));
            updatedString.add(secondString.replaceFirst(secondString.substring(getTextPositionSecondString(), getLengthOfCommonPart() + getTextPositionSecondString()), ";"));

            System.out.format("\nCommon part(s) as far: \033[1;34m%s\u001B[0m\n", listOfCommonStrings);
        } else {
            System.out.format("It seems that there's nothing else to compare...\n");
            Thread.sleep(1000);
            System.out.format("Finishing task...\n\n");
            Thread.sleep(1500);

            System.out.format("%s\n\nAll common part(s) of \033[1;36m%s\u001B[0m and \033[1;35m%s\u001B[0m are: \033[1;34m%s\u001B[0m\n\n%s\n\n", lines, originalFirstString, originalSecondString, listOfCommonStrings, lines);
            System.out.print("Author: \033[1;31mTomasz Grabarczyk\u001B[0m\n");
            System.exit(0);
        }
    }
}

class CompareEverything extends PrintOnConsole {
    void compareEverything() throws InterruptedException {
        setFirstString(getFirstString().toLowerCase());
        setSecondString(getSecondString().toLowerCase());

        System.out.print("Performing action...\n");
        Thread.sleep(1000);
        System.out.print("It seems that there is something to compare...\n\n");
        Thread.sleep(1000);

        commonStringFinder();
        printOnConsole();

        for (int i = 0; i < numberOfChecks; i++) {
            setFirstString(updatedString.get(0));
            setSecondString(updatedString.get(1));
            setLengthOfCommonPart(0);
            setTextPositionFirstString(-1);
            setTextPositionSecondString(-1);

            commonStringFinder();

            System.out.print("\nPerforming action...\n");
            Thread.sleep(1000);
            if (getTextPositionFirstString() != -1 || getTextPositionSecondString() != -1) {
                System.out.println("It seems that there is something to compare...\n");
                Thread.sleep(1000);
            }
            printOnConsole();
        }
    }
}
