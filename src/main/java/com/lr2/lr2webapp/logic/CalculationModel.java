package com.lr2.lr2webapp.logic;

public class CalculationModel {

    //ex2
    public static double approximateSum(double x, int n) {
        double sum = 0;
        for (int k = 0; k < n; k++) {
            double term = 1;
            for (int i = 1; i <= k; i++) {
                term *= (2 * i - 1) / (2.0 * i);
            }
            sum += term * Math.pow(x, 2.0 * k);
        }
        return sum;
    }

    public static double sumWithEpsilon(double x, double epsilon) {
        double sum = 0;
        int k = 0;
        while (true) {
            double term = 1;
            for (int i = 1; i <= k; i++) {
                term *= (2 * i - 1) / (2.0 * i);
            }
            term *= Math.pow(x, 2.0 * k);
            if (Math.abs(term) <= epsilon) {
                break;
            }
            sum += term;
            k++;
        }
        return sum;
    }

    public static double exactValue(double x) {
        return 1 / Math.sqrt(1 - x * x);
    }


    //ex2
    public static double function(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("x повинно бути більшим за 0!");
        }
        double lnX = Math.log(x); // Обчислюємо натуральний логарифм x
        return 1 / Math.tan(lnX); // cot(ln(x)) = 1 / tan(ln(x))
    }


    public static String tabulate(double a, double b, double h) {
        StringBuilder table = new StringBuilder();
        for (double x = a; x <= b; x += h) {
            try {
                double y = function(x);
                table.append("x = ").append(x).append(", f(x) = ").append(y).append("<br>");
            } catch (IllegalArgumentException e) {
                table.append("x = ").append(x).append(", f(x) = Некоректне значення (x <= 0)").append("<br>");
            }
        }
        return table.toString();
    }
}
