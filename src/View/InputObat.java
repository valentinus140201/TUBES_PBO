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
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import Controller.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InputObat implements ActionListener{
    
    private ControllerObat control = new ControllerObat();
    //frame
    JFrame inputDokter = new JFrame("Input Obat");
    //panel
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    JButton submit = new JButton("Submit");
    
    JLabel labNama = new JLabel("Nama");
    JLabel labBeli = new JLabel("Harga Beli");
    JLabel labJual = new JLabel("Harga Jual");
    JTextField textNama = new JTextField();
    JTextField textBeli = new JTextField();
    JTextField textJual = new JTextField();

    public InputObat(){
        //template
        inputDokter.setSize(1200, 620);
        inputDokter.setLocationRelativeTo(null);
        inputDokter.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(11,521,1170,50);
        isi.setBounds(11,11,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(321,11,90,30);
        menu.add(menuPasien);
        menuDokter.addActionListener(this);
        
        menuDokter.setBounds(521,11,90,30);
        menu.add(menuDokter);
        menuPasien.addActionListener(this);
        
        menuAdmin.setBounds(721,11,120,30);
        menu.add(menuAdmin);
        menuAdmin.addActionListener(this);
        
        labNama.setBounds(41, 11, 160, 25);
        isi.add(labNama);
        textNama.setBounds(121, 11, 160, 25);
        isi.add(textNama);
        
        labBeli.setBounds(41, 61, 160, 25);
        isi.add(labBeli);
        textBeli.setBounds(121, 61, 160, 25);
        isi.add(textBeli);
        
        labJual.setBounds(41, 121, 160, 25);
        isi.add(labJual);
        textJual.setBounds(121, 121, 160, 25);
        isi.add(textJual);
        
        submit.setBounds(80,160,100,25);
        submit.addActionListener(this);
        isi.add(submit);
        
        inputDokter.add(isi);
        inputDokter.add(menu);
        
        inputDokter.setUndecorated(true);
        inputDokter.setVisible(true);
        inputDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        inputDokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        int beli,jual;
        
        switch(command) {
            case "Pasien": 
                new MenuPasien();
                inputDokter.setVisible(false);
                break;
            case "Dokter":
                new MenuDokter();
                inputDokter.setVisible(false);
                break;
            case "Administrasi":
                new MenuAdmin();
                inputDokter.setVisible(false);
                break;
            case "Submit":
                beli = Integer.parseInt(textBeli.getText());
                jual = Integer.parseInt(textJual.getText());
                String strnama = textNama.getText();
                Obat obat = new Obat();
                obat.setIDObat(control.getLastIDObat());
                obat.setNama(strnama);
                obat.setHargaBeli(beli);
                obat.setHargaJual(jual);
                boolean input = control.addObat(obat);
                if(input == true){
                    inputDokter.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Tambah");
                    new MenuAdmin();
                    inputDokter.setVisible(false);
                }                
            default: 
                break;
        }
    }
    
    
}
