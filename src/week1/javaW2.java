package w1;

public class javaW2 {
    // 29
    public static void DayOfWeek(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 + ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
    }

    //30
    public static void Stats5() {
        double[] arr = new double[5];
        double min = 1000;
        double max = -1000;
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = Math.random();
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
            sum += arr[i];
        }
        double tb = sum / 5;
    }

    //31
    public static void Mecator(double l0, double p, double l) {
        double x = l - l0;
        double y = 0.5 * Math.log1p((1 + Math.sin(p)) / (1- Math.sin(p)));
    }

    //35
    public static void FractalDragon() {
        String dragon0 = "F";
        String nogard0 = "F";
        String dragon1 = dragon0 + "L" + nogard0;
        String nogard1 = dragon0 + "R" + nogard0;
        String dragon2 = dragon1 + "L" + nogard1;
        String nogard2 = dragon1 + "R" + nogard1;
        String dragon3 = dragon2 + "L" + nogard2;
        String nogard3 = dragon2 + "R" + nogard2;
        String dragon4 = dragon3 + "L" + nogard3;
        String nogard4 = dragon3 + "R" + nogard3;
        String dragon5 = dragon4 + "L" + nogard4;

        //System.out.println(dragon0);
        System.out.println(dragon1);
        System.out.println(dragon2);
        System.out.println(dragon3);
        System.out.println(dragon4);
        System.out.println(dragon5);
    }

    public static void main(String[] args) {

    }
}
