package com.lr2.lr2webapp.controller;

import com.lr2.lr2webapp.logic.CalculationModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tabulate")
public class TabulationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Отримуємо параметри з форми
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            double h = Double.parseDouble(request.getParameter("h"));

            // Перевірка коректності значень
            if (a >= b) {
                request.setAttribute("error", "a повинно бути менше b!");
                request.getRequestDispatcher("/tabulate.jsp").forward(request, response);
                return;
            }
            if (h <= 0) {
                request.setAttribute("error", "Крок h має бути додатнім числом!");
                request.getRequestDispatcher("/tabulate.jsp").forward(request, response);
                return;
            }

            // Обчислюємо табуляцію
            String table = CalculationModel.tabulate(a, b, h);

            // Передаємо результат на JSP сторінку
            request.setAttribute("table", table);
            request.getRequestDispatcher("/tabulate.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Невірний формат введених даних!");
            request.getRequestDispatcher("/tabulate.jsp").forward(request, response);
        }
    }
}