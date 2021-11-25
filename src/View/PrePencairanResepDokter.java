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
import Controller.ControllerDokter;
import Controller.ControllerTransaksi;
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
import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class PrePencairanResepDokter implements ActionListener{
    
    JFrame prePencairanResepDokter = new JFrame("Pre Pencairan Resep Dokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNik = new JLabel("NIK");
    JTextField textNik = new JTextField();

    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    JButton cari = new JButton("Cari");

    private ControllerDokter control = new ControllerDokter();

    public PrePencairanResepDokter(){
        
        prePencairanResepDokter.setSize(1200, 620);
        prePencairanResepDokter.setLocationRelativeTo(null);
        prePencairanResepDokter.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(320,10,90,30);
        menu.add(menuPasien);
        menuPasien.addActionListener(this);
        
        menuDokter.setBounds(520,10,90,30);
        menu.add(menuDokter);
        menuDokter.addActionListener(this);
        
        menuAdmin.setBounds(720,10,120,30);
        menu.add(menuAdmin);
        menuAdmin.addActionListener(this);
        
        labNik.setBounds(40, 20, 160, 25);
        textNik.setBounds(120, 20, 160, 25);
        
        cari.addActionListener(this);
        cari.setBounds(60, 60, 120, 30);
        
        isi.add(labNik);
        isi.add(textNik);
        isi.add(cari);
        
        prePencairanResepDokter.add(isi);
        prePencairanResepDokter.add(menu);
        prePencairanResepDokter.setUndecorated(true);
        prePencairanResepDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        prePencairanResepDokter.setVisible(true);
        prePencairanResepDokter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Pasien": 
                new MenuPasien();
                prePencairanResepDokter.setVisible(false);
                break;
            case "Dokter":
                new MenuDokter();
                prePencairanResepDokter.setVisible(false);
                break;
            case "Administrasi":
                new MenuAdmin();
                prePencairanResepDokter.setVisible(false);
                break; 
            case "Cari":
                ControllerTransaksi control = new ControllerTransaksi();
                String strnik = textNik.getText();
                ArrayList<Transaksi> listTransaksi = control.getAllTransaksi(strnik);
                prePencairanResepDokter.setVisible(false);
                new PencairanResepDokter(listTransaksi);
                break;
            default: 
                break;
        }
    }
    
}