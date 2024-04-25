package sprint3_final.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static class QuickSort {

        public static void quickSort(Player[] array, int left, int right) {
            if (left < right) {
                int pivotIndex = partition(array, left, right);
                quickSort(array, left, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, right);
            }
        }

        private static int partition(Player[] array, int low, int right) {
            int middle = low + (right - low) / 2;
            Player pivot = array[middle];
            swap(array, middle, right);
            int i = (low - 1);
            for (int j = low; j < right; j++) {
                if (array[j].compareTo(pivot) < 0) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, right);
            return i + 1;
        }

        private static void swap(Player[] array, int i, int j) {
            Player temp = array[i];
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
        QuickSort.quickSort(players, 0, players.length - 1);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < players.length; i++) {
            sb.append(players[i].login).append("\n");
        }
        System.out.println(sb);



    }
    public static class Player  implements Comparable<Player> {
        private String login;
        private int solve;
        private int penalty;
        public Player(String login, int solve, int penalty) {
            this.login = login;
            this.solve = solve;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Player o) {
            int resCompare;
            resCompare = o.solve - this.solve;
             if (resCompare == 0)
                 resCompare = this.penalty - o.penalty;
             if (resCompare == 0)
                 resCompare = this.login.compareTo(o.login);

            return resCompare;
        }
    }
}


