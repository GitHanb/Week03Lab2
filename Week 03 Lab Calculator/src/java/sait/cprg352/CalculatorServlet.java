/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hanzh
 */
public class CalculatorServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

        String firstStr = request.getParameter("first");
        String secondStr = request.getParameter("second");
        String operation = request.getParameter("operation");
    
        int result = 0;
        boolean calcPerformed = false;
        boolean error = false;
    
        if (operation!=null)
        {
            if (firstStr!=null && secondStr!=null && !firstStr.equals("") && !secondStr.equals(""))
            {
                int first = Integer.parseInt(firstStr);
                int second = Integer.parseInt(secondStr);

                char operationType = operation.charAt(0);

                switch (operationType)
                {
                    case '+': result = first + second;
                        break;
                    case '-': result = first - second;
                        break;
                    case '*': result = first * second;
                        break;
                    case '%': result = first % second;
                        break;
                }

                calcPerformed = true;
                error = false;
                request.setAttribute("error", error);
                
                request.setAttribute("first", firstStr);
                request.setAttribute("second", secondStr);
                request.setAttribute("operation", operation);
                
                request.setAttribute("result", result);
                request.setAttribute("calcPerformed", calcPerformed);
                
                
            }
            else
            {
                error = true;
                request.setAttribute("error", error);
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/Calculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
