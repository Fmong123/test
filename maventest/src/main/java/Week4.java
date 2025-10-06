public class Week4 {
    public static int max2Int(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int minArray (int[] array) {
        // Tim gia tri nho nhat cua 1 mang so nguyen
        int min = array[0];
        for (int x : array) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }

    public static String calculateBMI(double weight, double height){
        // Tinh BMI
        double bmi = weight / (height * height);

        bmi = Math.round(bmi * 10.0) / 10.0;

        if (bmi < 18.5) {
            return "Thiếu cân";
        } else if (bmi <= 22.9) {
            return "Bình thường";
        } else if (bmi <= 24.9) {
            return "Thừa cân";
        } else {
            return "Béo phì";
        }
    }
}
