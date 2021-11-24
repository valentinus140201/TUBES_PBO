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
import Model.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class HitungGaji implements ActionListener{
    
    JFrame hitungGaji = new JFrame("HITUNG GAJI");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNid = new JLabel ("NID    :");
    JLabel labNama = new JLabel("Nama   :");
    JLabel labGaji = new JLabel("Gaji   :");

    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    
    private ControllerDokter control = new ControllerDokter();

    public HitungGaji(Dokter dokter){
        
        System.out.println(dokter.getNama());
        
        hitungGaji.setSize(1200, 620);
        hitungGaji.setLocationRelativeTo(null);
        hitungGaji.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(11,521,1170,50);
        isi.setBounds(11,11,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(321,11,90,30);
        menuDokter.setBounds(521,11,90,30);
        menuAdmin.setBounds(721,11,120,30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        labNid.setBounds(41, 11, 160, 25);
        labNama.setBounds(41, 51, 160, 25);
        labGaji.setBounds(41, 91, 160, 25);
        
        JLabel nama = new JLabel(dokter.getNama());
        JLabel nid = new JLabel(dokter.getNID());
        JLabel gaji = new JLabel(String.valueOf(dokter.hitungGaji()));
        
        nama.setBounds(121, 11, 160, 25);
        nid.setBounds(121, 51, 160, 25);
        gaji.setBounds(121, 91, 160, 25);
        
        isi.add(labNid);
        isi.add(labNama);
        isi.add(labGaji);
        isi.add(nama);
        isi.add(nid);
        isi.add(gaji);

        hitungGaji.add(isi);
        hitungGaji.add(menu);
        hitungGaji.setUndecorated(true);
        hitungGaji.setVisible(true);
        hitungGaji.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        hitungGaji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Pasien": 
                new MenuPasien();
                hitungGaji.setVisible(false);
                break;
            case "Dokter":
                new MenuDokter();
                hitungGaji.setVisible(false);
                break;
            case "Administrasi":
                new MenuAdmin();
                hitungGaji.setVisible(false);
                break; 
            default: 
                break;
        }
    }
    
}