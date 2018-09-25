package Algorytmy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class SortRandomNumbersInFile {

    private int[] arrayOfNumbers = new int[20];
    private int[] arrayUnsorted = new int[20];
    private int[] evenNumbers = new int[20];
    private int[] oddNumbers = new int[20];

    void printToArray() {
        Random random = new Random();

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = random.nextInt(100);
            arrayUnsorted[i] = arrayOfNumbers[i];
        }
    }

    private void printToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\A702387\\Desktop\\School\\src\\text.txt");

        fileWriter.write("Array before sorting: \n");
        for (int printUnsorted : arrayUnsorted)
            fileWriter.write(String.valueOf(printUnsorted + " "));

        fileWriter.write("\n\nArray after sorting: \n");
        for (int printSorted : arrayOfNumbers)
            fileWriter.write(String.valueOf(printSorted + " "));

        fileWriter.write("\n\nEven numbers sorted: \n");
        for (int printEven : evenNumbers)
            if (printEven != 0)
            fileWriter.write(String.valueOf(printEven + " "));

        fileWriter.write("\nOdd numbers sorted: \n");

        for (int printOdd : oddNumbers)
            if (printOdd != 0)
            fileWriter.write(String.valueOf(printOdd + " "));

        fileWriter.close();
    }

    private void bubbleSort(int[] arrayOfNumber) {
        for (int i = 0; i < arrayOfNumber.length; i++) {
            for (int j = 1; j < arrayOfNumber.length - i; j++) {
                if (arrayOfNumber[j - 1] > arrayOfNumber[j]) {
                    int temp = arrayOfNumber[j - 1];
                    arrayOfNumber[j - 1] = arrayOfNumber[j];
                    arrayOfNumber[j] = temp;
                }
            }
        }
    }

    private void checkIfEvenOrOdd() {
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] % 2 == 0) {
                evenNumbers[i] = arrayOfNumbers[i];
            } else if (arrayOfNumbers[i] % 2 != 0) {
                oddNumbers[i] = arrayOfNumbers[i];
            }
        }

        bubbleSort(evenNumbers);
        bubbleSort(oddNumbers);
    }

    void printToConsole() throws IOException {
        System.out.println("Array before sorting: ");
        for (int anArrayOfNumber : arrayOfNumbers)
            System.out.print(anArrayOfNumber + " ");

        bubbleSort(arrayOfNumbers);

        System.out.println("\n");

        System.out.print("Array after sorting: \n");
        for (int sortedNumber : arrayOfNumbers) {
            System.out.print(sortedNumber + " ");
        }

        checkIfEvenOrOdd();

        System.out.println("\n\nSorted even numbers: ");
        for (int even : evenNumbers) {
            if (even != 0)
                System.out.print(even + " ");
        }

        System.out.println("\nSorted odd numbers: ");
        for (int odd : oddNumbers) {
            if (odd != 0)
                System.out.print(odd + " ");
        }

        printToFile();
        System.out.println();
    }

}
