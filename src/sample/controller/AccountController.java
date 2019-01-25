package sample.controller;

import animatefx.animation.FadeIn;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void mouseLogin(MouseEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/users?" + "user=root&password=password");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username =? AND password =?");
            ps.setString(1, txtUser.getText());
            ps.setString(2, txtPassword.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "You are logged in");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong password or username");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (event.getSource() instanceof Button) {
            if (event.getSource() == btnLogin) {
                new FadeIn(btnLogin).play();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void mouseSignUp(MouseEvent em) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/users?" + "user=root&password=password");
            PreparedStatement pss = con.prepareStatement("INSERT INTO users SET username =? , password =?");
            pss.setString(1, txtUser.getText());
            pss.setString(2, txtPassword.getText());
            pss.executeUpdate();
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Wrong password or username");
        } finally {
            JOptionPane.showMessageDialog(null, "Success . You have created an account.");
        }
        if (em.getSource() instanceof Button) {
            if (em.getSource() == btnSignUp) {
                new FadeIn(btnSignUp).play();
            }
        }
    }
}
