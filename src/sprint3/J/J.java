package sprint3.J;

import com.sun.source.tree.IfTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class BubbleSort{
    private int[] arr;
    private int sizeArr;
    private boolean swapWas;
    private boolean sorted;


    public BubbleSort(int[] arr){
        this.arr = arr;
        this.sizeArr = arr.length;
        sorted = false;
    }

    public void printer(){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < sizeArr; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    public void bubbleSorter(){
        for (int out = sizeArr - 1; out >= 1; out--){
            swapWas = false;
            for (int in = 0; in < out; in++){
                if(arr[in] > arr[in + 1])
                    toSwap(in, in + 1);
            }
            if (swapWas) printer();
        }
    }
    private void toSwap(int first, int second){
        long dummy = arr[first];
        arr[first] = arr[second];
        arr[second] = (int) dummy;
        swapWas = true;
        sorted = true;
    }

    public boolean massWasSorted(){
        return sorted;
    }



}
public class J {


    public static void main(String[] args) throws IOException {
        int[] arr;
        int lenMass;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            lenMass = Integer.parseInt(reader.readLine());
            arr = new int[lenMass];
            int i = 0;
            for (String arrEl : reader.readLine().split(" ")) {
                arr[i] = Integer.parseInt(arrEl);
                i++;
            }
        }
        BubbleSort bs = new BubbleSort(arr);
        bs.bubbleSorter();
        if (!bs.massWasSorted()) bs.printer();
    }
}
