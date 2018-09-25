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

        for (int randomNumber = 0; randomNumber < arrayOfNumbers.length; randomNumber++) {
            arrayOfNumbers[randomNumber] = random.nextInt(100);
            arrayUnsorted[randomNumber] = arrayOfNumbers[randomNumber];
        }
    }

    private void printToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("file.txt");

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

    private void insertionSort(int[] arrayOfNumber) {

        for (int i = 1; i < arrayOfNumber.length; i++) {
            for(int j = i; j > 0; j--){
                if(arrayOfNumber[j-1] > arrayOfNumber[j]){
                    int temp = arrayOfNumber[j];
                    arrayOfNumber[j] = arrayOfNumber[j-1];
                    arrayOfNumber[j-1] = temp;
                }
            }
        }
    }

    private void checkIfEvenOrOdd() {
        for (int checker = 0; checker < arrayOfNumbers.length; checker++) {
            if (arrayOfNumbers[checker] % 2 == 0) {
                evenNumbers[checker] = arrayOfNumbers[checker];
            } else if (arrayOfNumbers[checker] % 2 != 0) {
                oddNumbers[checker] = arrayOfNumbers[checker];
            }
        }

        insertionSort(evenNumbers);
        insertionSort(oddNumbers);
    }

    void printToConsole() throws IOException {
        System.out.println("Array before sorting: ");
        for (int anArrayOfNumber : arrayOfNumbers)
            System.out.print(anArrayOfNumber + " ");

        insertionSort(arrayOfNumbers);

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
