package Algorytmy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SortNumbersInFile {

    private int iterator = 0;
    private String[] pathNames = {"sortowanie_1.txt", "sortowanie_2.txt", "sortowanie_3.txt"};
    private String[] saveToFile = {"sorted_1.txt", "sorted_2.txt", "sorted_3.txt"};

    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> evenNumbers = new ArrayList<>();
    private List<Integer> oddNumbers = new ArrayList<>();
    private List<Integer> positiveNumbers = new ArrayList<>();
    private List<Integer> negativeNumbers = new ArrayList<>();

    private void readFromFile() throws IOException {
        Scanner scanner = new Scanner(new File(pathNames[iterator]));
        while(scanner.hasNextInt()){
            numbers.add(scanner.nextInt());
        }
    }

    private void insertionSortUp(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            for(int j = i; j > 0; j--){
                if(numbers.get(j - 1) > numbers.get(j)){
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j - 1));
                    numbers.set(j - 1, temp);
                }
            }
        }
    }

    private void insertionSortDown(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            for(int j = i; j > 0; j--){
                if(numbers.get(j) > numbers.get(j - 1)){
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j - 1));
                    numbers.set(j - 1, temp);
                }
            }
        }
    }

    private void checkIfEvenOrOdd() {
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(saveToFile[iterator]));

        writer.write("Niemalejaco liczby patrzyste: \n");
        for (int a : evenNumbers)
            writer.write(String.valueOf(a) + " ");

        writer.write("\n\n");
        writer.write("Nierosnąco liczby niepatrzyste: \n");
        for (int a : oddNumbers)
            writer.write(String.valueOf(a) + " ");

        writer.close();
    }

    void executeScript() throws IOException {
        while (iterator < 3) {
            readFromFile();

            checkIfEvenOrOdd();

            insertionSortUp(evenNumbers);
            insertionSortDown(oddNumbers);

            writeToFile();

            iterator++;
        }

/*
        readFromFile();

        checkIfEvenOrOdd();

        insertionSortUp(evenNumbers);
        insertionSortDown(oddNumbers);

        writeToFile();
*/
    }
}
