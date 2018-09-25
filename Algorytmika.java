package Algorytmy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SortRandomNumbersInFile {

    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> evenNumbers = new ArrayList<>();
    private List<Integer> oddNumbers = new ArrayList<>();

    void readFromFile() throws IOException {
        Scanner scanner = new Scanner(new File("sortowanie_3.txt"));
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
            } else if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
    }

    void printToConsole() {
        checkIfEvenOrOdd();

        insertionSortUp(numbers);
        insertionSortUp(evenNumbers);
        insertionSortDown(oddNumbers);

        System.out.print(numbers);
        System.out.println("\nNiemalejaco liczby patrzyste: ");
        System.out.print(evenNumbers);
        System.out.println("\nNierosnąco liczby niepatrzyste: ");
        System.out.print(oddNumbers);
    }
}
