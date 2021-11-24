/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author hp
 */
import Model.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import Controller.*;

public class LoginScreen implements ActionListener{
    
    JFrame frame = new JFrame("Login");
    JPanel menu = new JPanel();
    
    JLabel labUsername = new JLabel("Username");
    JLabel labPassword = new JLabel("Password");
    JTextField textUsername = new JTextField();
    JPasswordField textPassword = new JPasswordField();
    JButton login = new JButton("Login");
    JButton resetButton=new JButton("Reset");
    JCheckBox showPassword=new JCheckBox("Show Password");
    ControllerStaff control = new ControllerStaff();

    
    public LoginScreen(){
        
        frame.setLayout(null);
        frame.setSize(400,600);
        frame.setLocationRelativeTo(null);
        
        menu.setLayout(null);
        menu.setBounds(10,10,360,530);
        menu.setBackground(Color.ORANGE);
        
        labUsername.setBounds(50, 150, 100, 30);
        menu.add(labUsername);
        
        labPassword.setBounds(50, 220, 150, 30);
        menu.add(labPassword);
        
        textUsername.setBounds(150, 150, 150, 30);
        menu.add(textUsername);
        
        textPassword.setBounds(150, 220, 150, 30);
        menu.add(textPassword);
        
        login.setBounds(50, 300, 100, 30);
        menu.add(login);
        login.addActionListener(this);
        
        resetButton.setBounds(200, 300, 100, 30);
        menu.add(resetButton);
        resetButton.addActionListener(this);
        
        showPassword.setBounds(150, 250, 150, 30);
        menu.add(showPassword);
        showPassword.addActionListener(this);
        showPassword.setBackground(Color.ORANGE);
        
        frame.add(menu);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();
        if(command == "Login"){
            Staff staff = control.getStaff(textUsername.getText());
            if(textUsername.getText().equals(staff.getUsername())){
                if(textPassword.getText().equals(staff.getPassword())){
                    Singleton.getInstance().setStaff(staff);
                    Singleton.getInstance().setCabang(control.getCabang(staff.getIdCabang()));
                    frame.setVisible(false);
                    MainMenu mainMenu = new MainMenu();
                }else{
                    JOptionPane.showMessageDialog(null,"Username Atau Password Salah");
                }
            }
            
            if(textUsername.getText().equals("") || textPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Username Atau Password Harus Di isi");
            }
        }
        if (ae.getSource() == resetButton) {
            textUsername.setText("");
            textPassword.setText("");
        }
        if (ae.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                textPassword.setEchoChar((char) 0);
            } else {
                textPassword.setEchoChar('*');
            }
        }
    }
}
