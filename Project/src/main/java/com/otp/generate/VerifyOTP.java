package com.otp.generate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyOTP
 */
@WebServlet("/VerifyOTP")
public class VerifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		// Retrieve the OTP stored in the session
        Integer storedOtp = (Integer) session.getAttribute("otp");
        
        // Retrieve the OTP entered by the user from the request
        String otpParam = request.getParameter("otp");
        int enteredOtp = 0;
        
        // Check if the entered OTP is valid (not null and numeric)
        if (otpParam != null) {
            try {
                enteredOtp = Integer.parseInt(otpParam);
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid OTP format. Please try again.");
                return; // Exit the method if parsing fails
            }
        } else {
            response.getWriter().println("OTP not provided. Please try again.");
            return;
        }

        // Compare the entered OTP with the one stored in the session
        if (storedOtp != null && enteredOtp == storedOtp) {
            session.setAttribute("storeotp", true);
            response.sendRedirect("welcome.jsp");
        } else {
            response.getWriter().println("Invalid OTP. Please try again.");
        }
    }
}
