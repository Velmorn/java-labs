import java.util.Random;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Передайте розмір масиву як аргумент");
            return;
        }

        int arrLength = Integer.parseInt(args[0]);

        if (arrLength <= 0) {
            System.out.println("Розмір масиву має бути більшим за 0");
            return;
        }

        double[] arr = new double[arrLength];
        double[] finalArr;
        Random randGenerator = new Random();

        System.out.println("Заповнений масив:");
        for (int i = 0; i < arrLength; i++) {
            arr[i] = randGenerator.nextDouble();
            System.out.printf("%.5f ", arr[i]);
        }

        System.out.println();

        finalArr = cbrtOddElements(arr);

        System.out.println("Масив після взяття кубічного корення з елементів із непарними індексами:");
        for (double v : finalArr) {
            System.out.printf("%.5f ", v);
        }
    }

    public static double[] cbrtOddElements(double[] arrToCube) {
        double[] cubedArr = new double[arrToCube.length];

        for (int i = 0; i < arrToCube.length; i++) {
            if (i % 2 != 0) {
                cubedArr[i] = Math.cbrt(arrToCube[i]);
            } else {
                cubedArr[i] = arrToCube[i];
            }
        }

        return cubedArr;
    }
}