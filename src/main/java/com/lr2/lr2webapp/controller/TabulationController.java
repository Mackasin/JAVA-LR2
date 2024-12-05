package com.lr2.lr2webapp.controller;

import com.lr2.lr2webapp.logic.CalculationModel;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean(name = "tabulationController")
@RequestScoped
public class TabulationController {

    private double a;
    private double b;
    private double h;
    private String error;
    private String table;

    public void tabulate() {
        try {
            if (a >= b) {
                error = "a повинно бути менше b!";
                return;
            }
            if (h <= 0) {
                error = "Крок h має бути додатнім числом!";
                return;
            }

            table = CalculationModel.tabulate(a, b, h);
        } catch (NumberFormatException e) {
            error = "Невірний формат введених даних!";
        }
    }

    // Гетери та сетери
    public double getA() { return a; }
    public void setA(double a) { this.a = a; }
    public double getB() { return b; }
    public void setB(double b) { this.b = b; }
    public double getH() { return h; }
    public void setH(double h) { this.h = h; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public String getTable() { return table; }
    public void setTable(String table) { this.table = table; }
}
