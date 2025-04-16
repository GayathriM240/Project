<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>OTP Verification</title>
</head>
<body>
    <h2>Enter OTP</h2>

    <form action="VerifyOTP" method="post">
        <!-- This is for showing the OTP that was generated, only for debugging or testing -->
        <p>Your OTP is: <%= session.getAttribute("otp") %></p>
        
	<input type="text" name="email" placeholder="Enter Email" required="required">
	<input type="submit" value="Submit" /><br>
        <!-- Form input where the user can enter OTP -->
        <input type="text" name="otp" placeholder="Enter OTP" required />
        <input type="submit" value="Verify OTP" />
    </form>
</body>
</html>
