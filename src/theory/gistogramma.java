package theory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class gistogramma {
    static Stack<Integer> stack = new Stack<>();
    static int[] rock = new int[]{2,7,6,9,7,5,7,3,5};
    //static int[] rock = new int[]{5,3,7,5,7,9,6,7,2};

    static int[] left = new int[rock.length];
    static int[] right = new int[rock.length];

    public static void main(String[] args) {
        for (int i = 0; i < rock.length; i++) {
            while (true) {
                if (stack.empty()) {
                    stack.push(i);
                    left[i] = -1;
                    break;
                }
                int indNextLeftRok = stack.peek();
                int valNextLeftRock = rock[indNextLeftRok];

                if (rock[i] > valNextLeftRock) {
                    left[i] = indNextLeftRok;
                    stack.push(i);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        stack.clear();
        for (int i = rock.length - 1; i >= 0; i--) {
            while (true) {
                if (stack.empty()) {
                    stack.push(i);
                    right[i] = rock.length;
                    break;
                }
                int indNextLeftRok = stack.peek();
                int valNextLeftRock = rock[indNextLeftRok];

                if (rock[i] > valNextLeftRock) {
                    right[i] = indNextLeftRok;
                    stack.push(i);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        int[] summ = new int[rock.length];
        for (int i = 0; i < rock.length; i++){
            summ[i] = rock[i] * (right[i] - left[i] - 1);
        }

        System.out.println(Collections.max(Arrays.stream(summ).boxed().collect(Collectors.toList())));
    }

}
