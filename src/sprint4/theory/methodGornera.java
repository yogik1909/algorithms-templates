package sprint4.theory;

public class methodGornera {
    public static int evaluatePolynomial(int[] coefficients, int x) {
        int result = coefficients[0]; // Начинаем с старшего коэффициента
        for (int i = 1; i < coefficients.length; i++) {
            result = result * x + coefficients[i]; // Применяем алгоритм Горнера
        }
        return result;
    }
}
