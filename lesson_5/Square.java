package lesson_5;

public interface Square {
    public default double calculateSquare(int... num) {
        if (num.length == 1) {
            return Math.PI * Math.pow(num[0], 2);
        } else if (num.length == 2) {
            return num[0] * num[1];
        } else {
            double p = (double) (num[0] + num[1] + num[2]) / 2;
            return Math.sqrt(p * (p - num[0]) * (p - num[1]) * (p - num[2]));
        }
    }
}



