package com.grabarczyk.tomasz.algorytmika_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LoopAll loopAll = new LoopAll();
        loopAll.loopAll();
    }
}

class Variables {
    List<String> listOfCommonStrings = new ArrayList<>();
    List<String> deleteCommonElement = new ArrayList<>();

    String firstString = "ABABBBABAAABABABAABBAABBABABABABABBAAABBAABAB";
    String secondString = "ABBABABABAABBAAAAABABABAABBABABABABAABABABBBA";

    private int stringCommonPart = 0;
    private int textPositionFirstString = -1;
    private int textPositionSecondString = -1;

    String getFirstString() {
        return firstString;
    }
    String getSecondString() {
        return secondString;
    }
    int getStringCommonPart() {
        return stringCommonPart;
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
    void setStringCommonPart(int stringCommonPart) {
        this.stringCommonPart = stringCommonPart;
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
        System.out.format("Starting position in \u001B[34m%s\u001B[0m string: %d\nStarting position in \u001B[34m%s\u001B[0m string: %d\nLength of common part: %d\n", firstString, getTextPositionFirstString(), secondString, getTextPositionSecondString(), getStringCommonPart());

        System.out.println();
        System.out.println(firstString.substring(0, getTextPositionFirstString()) + "\u001B[34m" + firstString.substring(getTextPositionFirstString(), getStringCommonPart() + getTextPositionFirstString()) + "\u001B[0m" + firstString.substring(getStringCommonPart() + getTextPositionFirstString()));
        System.out.println(secondString.substring(0, getTextPositionSecondString()) + "\u001B[34m" + secondString.substring(getTextPositionSecondString(), getStringCommonPart() + getTextPositionSecondString()) + "\u001B[0m" + secondString.substring(getStringCommonPart() + getTextPositionSecondString()));

        listOfCommonStrings.clear();

        deleteCommonElement.add(firstString.substring(getTextPositionFirstString(), getStringCommonPart() + getTextPositionFirstString()));

        listOfCommonStrings.add(firstString.replace(firstString.substring(getTextPositionFirstString(), getStringCommonPart() + getTextPositionFirstString()), ""));
        listOfCommonStrings.add(secondString.replace(secondString.substring(getTextPositionSecondString(), getStringCommonPart() + getTextPositionSecondString()), ""));

        System.out.format("\nCommon part(s) as far: \u001B[34m%s\u001B[0m\n", deleteCommonElement);

    }
}

class PrintCommonStrings extends PrintOnConsole {
    void printCommonStrings() throws InterruptedException {
        System.out.println("\nPerforming action...");
        Thread.sleep(2000);
        System.out.println("It seems that there is something to compare...\n");
        Thread.sleep(1500);

        findCommonString();

        printOnConsole();
    }
}

class LoopAll extends PrintCommonStrings {
    void loopAll() throws InterruptedException {
        printCommonStrings();

        for (int i = 0; i < 20; i++) {
            setFirstString(listOfCommonStrings.get(0));
            setSecondString(listOfCommonStrings.get(1));

            if (getFirstString().isEmpty() || getSecondString().isEmpty()) {
                Thread.sleep(1500);
                System.out.format("\n----------------------------------------------\nIt seems that there's nothing else to compare!\nAll common parts of given strings: \u001B[34m%s\u001B[0m\n", deleteCommonElement);
                break;
            } else {
                setStringCommonPart(0);
                setTextPositionFirstString(-1);
                setTextPositionSecondString(-1);

                findCommonString();
            }

            System.out.println("\nPerforming action...");
            Thread.sleep(2000);
            System.out.println("It seems that there is something to compare...\n");
            Thread.sleep(1500);
            printOnConsole();
        }

    }
}
