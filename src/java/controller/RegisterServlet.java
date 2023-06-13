package controller;

import dal.CustomerDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Properties;
import java.util.Random;
import javax.mail.internet.*;
import javax.mail.*;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String repass, pass, name, email;

        pass = request.getParameter("password");
        repass = request.getParameter("repassword");
        name = request.getParameter("name");
        email = request.getParameter("email");

        if (pass.equals(repass)) {
            Account account = new Account(pass, name, email, "user");
            request.getSession().setAttribute("curr", account);
            
              

                // Generate verification code
                String code = generateVerificationCode(6);
                request.getSession().setAttribute("code", code);

                // Send verification email
                sendVerificationEmail(email, code);

                // Redirect to index.html
                response.sendRedirect("emailChk.jsp");
           
            pr.print("Password not matched!");
        
    }}

    private String generateVerificationCode(int length) {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowcase = uppercase.toLowerCase();
        String digit = "0123456789";
        String charset = uppercase + lowcase + digit;
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(charset.length());
            char randomChar = charset.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();
       return randomString ; 
    }

    private void sendVerificationEmail(String toEmail, String code) {
        String username = "ducthongngo513@gmail.com"; // Your email address
        String password = "otuspmyhyncfhrdc"; // Your email password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("New Password");
            message.setText(code);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
