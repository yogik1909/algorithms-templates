package sprint3_final.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static class QuickSort {

        public  void sort(int[] array) {
            quickSort(array, 0, array.length - 1);
        }

        private  void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                quickSort(array, low, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, high);
            }
        }

        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, high);
            return i + 1;
        }

        private  void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Player[] players;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
            players = new Player[n];
            for (int i = 0; i < n; i++) {
                String[] player = reader.readLine().split(" ");
                players[i] = new Player(player[0], Integer.parseInt(player[1]), Integer.parseInt(player[2]));
            }
        }


    }
    public static class Player{
        private String login;
        private int solve;
        private int penalty;
        public Player(String login, int solve, int penalty) {
            this.login = login;
            this.solve = solve;
            this.penalty = penalty;
        }

    }
}


