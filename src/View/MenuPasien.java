/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Singleton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JRootPane;

/**
 *
 * @author hp
 */
public class MenuPasien implements ActionListener{
    
    JFrame frame = new JFrame("Menu Pasien");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    
    public MenuPasien(){
        
        JButton insertPasienBaru, searchPasien, beliObat, tambahRiwayatPasien, buatJanjiTemu, lihatRiwayatPasien;
        JLabel homePertama;

        insertPasienBaru = new JButton("Insert Pasien Baru");
        searchPasien = new JButton("Cari Pasien");
        beliObat = new JButton("Beli Obat");
        tambahRiwayatPasien = new JButton("Update Riwayat Pasien");
        buatJanjiTemu = new JButton("Janji Appointment");
        lihatRiwayatPasien = new JButton("Lihat Riwayat Pasien");
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
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
        
        String homesPertama = "MENU PASIEN";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(465, 20, 750, 100);
        isi.add(homePertama);
        
        insertPasienBaru.setBounds(475, 100, 200, 50);
        isi.add(insertPasienBaru);
        insertPasienBaru.addActionListener(this);
        
        searchPasien.setBounds(475, 180, 200, 50);
        isi.add(searchPasien);
        searchPasien.addActionListener(this);
        
        tambahRiwayatPasien.setBounds(475, 260, 200, 50);
        isi.add(tambahRiwayatPasien);
        tambahRiwayatPasien.addActionListener(this);
        
        buatJanjiTemu.setBounds(475, 340, 200, 50);
        isi.add(buatJanjiTemu);
        buatJanjiTemu.addActionListener(this);
        
        lihatRiwayatPasien.setBounds(475, 420, 200, 50);
        isi.add(lihatRiwayatPasien);
        lihatRiwayatPasien.addActionListener(this);
        
        frame.add(isi);
        frame.add(menu);
           
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Pasien": 
                new MenuPasien();
                frame.setVisible(false);
                break;
            case "Dokter":
                new MenuDokter();
                frame.setVisible(false);
                break;
            case "Administrasi":
                new MenuAdmin();
                frame.setVisible(false);
                break;
            case "Insert Pasien Baru":
                new ViewInsertPasienBaru();
                break;
            case "Cari Pasien":
                new ViewSearchPasien();
                frame.setVisible(false);
                break;
            case "Update Riwayat Pasien":
                new viewTambahRiwayatPasien();
                frame.setVisible(false);
                break;
            case "Janji Temu":
                new ViewJanjiTemu();
                frame.setVisible(false);
                break;
            case "Lihat Riwayat Pasien":
                new viewLihatRiwayat1Pasien();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
