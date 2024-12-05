package com.lr2.lr2webapp.controller;

import com.lr2.lr2webapp.logic.CalculationModel;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean(name = "calculationController")
@RequestScoped
public class CalculationController {

    private double x;
    private int n;
    private double e1;
    private double e2;
    private String error;
    private Double sumN;
    private Double sumE1;
    private Double sumE2;
    private Double exact;

    public void calculate() {
        try {
            if (Math.abs(x) >= 1) {
                error = "x має бути в межах (-1, 1)!";
                return;
            }

            sumN = CalculationModel.approximateSum(x, n);
            sumE1 = CalculationModel.sumWithEpsilon(x, e1);
            sumE2 = CalculationModel.sumWithEpsilon(x, e2);
            exact = CalculationModel.exactValue(x);
        } catch (NumberFormatException e) {
            error = "Невірний формат введених даних!";
        }
    }

    // Гетери та сетери
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public int getN() { return n; }
    public void setN(int n) { this.n = n; }
    public double getE1() { return e1; }
    public void setE1(double e1) { this.e1 = e1; }
    public double getE2() { return e2; }
    public void setE2(double e2) { this.e2 = e2; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public Double getSumN() { return sumN; }
    public Double getSumE1() { return sumE1; }
    public Double getSumE2() { return sumE2; }
    public Double getExact() { return exact; }
}
