package theory;

import java.util.Stack;

public class gistogramma {
    static Stack<Integer> stack = new Stack<>();
    static int[] rock = new int[]{2,7,6,9,7,5,7,3,5};
    static int[] left = new int[rock.length];
    static int[] right = new int[rock.length];

    public static void main(String[] args) {
        for(int i = 0; i < rock.length; i++) {
            while (true) {
                if (stack.empty()) {
                    stack.push(0);
                    left[i] = stack.peek() - 1;
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

    }

}
