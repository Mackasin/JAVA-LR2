package com.lr2.lr2webapp.controller;

import com.lr2.lr2webapp.logic.CalculationModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class CalculationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double x = Double.parseDouble(request.getParameter("x"));
            int n = Integer.parseInt(request.getParameter("n"));
            double e1 = Double.parseDouble(request.getParameter("e1"));
            double e2 = Double.parseDouble(request.getParameter("e2"));

            if (Math.abs(x) >= 1) {
                request.setAttribute("error", "x має бути в межах (-1, 1)!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }


            double sumN = CalculationModel.approximateSum(x, n);
            double sumE1 = CalculationModel.sumWithEpsilon(x, e1);
            double sumE2 = CalculationModel.sumWithEpsilon(x, e2);
            double exact = CalculationModel.exactValue(x);


            request.setAttribute("sumN", sumN);
            request.setAttribute("sumE1", sumE1);
            request.setAttribute("sumE2", sumE2);
            request.setAttribute("exact", exact);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Невірний формат введених даних!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}