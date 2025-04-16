package com.otp.generate;


import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GenerateOTP")
public class GenerateOTP extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int otp = generateOTP();

        // Save OTP in the session
        session.setAttribute("otp", otp);

        // Send OTP via email (you can call your method here for email/SMS sending)
        String userEmail = "gayigayathrim998@gmail.com";  // Replace with the actual user's email
        sendOTPEmail(userEmail, otp);  // Assume you've implemented this to send OTP via email

        // Show a message indicating OTP has been sent
        response.getWriter().println("OTP sent to your email.");
    }
    

    private int generateOTP() {
        SecureRandom random = new SecureRandom();
        return 100000 + random.nextInt(900000);
    }

    private void sendOTPEmail(String userEmail, int otp) {
        // Implement the code to send OTP via email (as shown in the previous response)
    }
}
