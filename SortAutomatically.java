package Algorytmy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SortAutomatically {

        private List<Integer> numbers = new ArrayList<>();
        private List<Integer> evenNumbers = new ArrayList<>();
        private List<Integer> oddNumbers = new ArrayList<>();
        private List<Integer> positiveNumbers = new ArrayList<>();
        private List<Integer> negativeNumbers = new ArrayList<>();

        private void clear() {
            numbers.clear();
            evenNumbers.clear();
            oddNumbers.clear();
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

    private void readFromFirstFile() throws IOException {
        Scanner scanner = new Scanner(new File("sortowanie_1.txt"));
        while(scanner.hasNextInt()){
            numbers.add(scanner.nextInt());
        }
    }

        private void writeToFirstFile() throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sorted_1.txt"));

            writer.write("Niemalejaco liczby patrzyste: \n");
            for (int a : evenNumbers)
                writer.write(String.valueOf(a) + " ");

            writer.write("\n\n");
            writer.write("Nierosnąco liczby niepatrzyste: \n");
            for (int a : oddNumbers)
                writer.write(String.valueOf(a) + " ");

            writer.close();
        }

        void executeFirstScript() throws IOException {
            readFromFirstFile();

            checkIfEvenOrOdd();

            insertionSortUp(evenNumbers);
            insertionSortDown(oddNumbers);

            writeToFirstFile();
        }

    private void readFromSecondFile() throws IOException {
        clear();

        Scanner scanner = new Scanner(new File("sortowanie_2.txt"));
        while(scanner.hasNextInt()){
            numbers.add(scanner.nextInt());
        }
    }

    private void writeToSecondFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_2.txt"));

        writer.write("Niemalejaco liczby patrzyste: \n");
        for (int a : evenNumbers)
            writer.write(String.valueOf(a) + " ");

        writer.write("\n\n");
        writer.write("Nierosnąco liczby niepatrzyste: \n");
        for (int a : oddNumbers)
            writer.write(String.valueOf(a) + " ");

        writer.close();
    }

    void executeSecondScript() throws IOException {
        readFromSecondFile();

        checkIfEvenOrOdd();

        insertionSortUp(evenNumbers);
        insertionSortDown(oddNumbers);

        writeToSecondFile();
    }


    private void readFromThirdFile() throws IOException {
        clear();

        Scanner scanner = new Scanner(new File("sortowanie_3.txt"));
        while(scanner.hasNextInt()){
            numbers.add(scanner.nextInt());
        }
    }

    private void writeToThirdFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_3.txt"));

        writer.write("Niemalejaco liczby patrzyste: \n");
        for (int a : evenNumbers)
            writer.write(String.valueOf(a) + " ");

        writer.write("\n\n");
        writer.write("Nierosnąco liczby niepatrzyste: \n");
        for (int a : oddNumbers)
            writer.write(String.valueOf(a) + " ");

        writer.close();
    }

    void executeThirdScript() throws IOException {
        readFromThirdFile();

        checkIfEvenOrOdd();

        insertionSortUp(evenNumbers);
        insertionSortDown(oddNumbers);

        writeToThirdFile();
    }
}
