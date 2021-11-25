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

import Model.Singleton;
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
import java.awt.Font;


public class MenuTransaksi implements ActionListener{
    
    JFrame frame = new JFrame("Menu Transaksi");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PAasien");
    JButton menu_dokter = new JButton("Dokter");
    JButton menu_admin = new JButton("Administrasi");
    JButton obatPasien = new JButton("Pencairan Resep Dokter");
    JButton lihatTransaksi = new JButton("Lihat Semua Transaksi");
    JButton bayarTransaksi = new JButton("Bayar Tagihan");
    JButton lihatKeuntungan = new JButton("Lihat Keuntungan");
    JLabel homePertama;
    
    
    public MenuTransaksi(){
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
       
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menu_pasien.setBounds(320,10,90,30);
        menu.add(menu_pasien);
        menu_pasien.addActionListener(this);
        
        menu_dokter.setBounds(520,10,90,30);
        menu.add(menu_dokter);
        menu_dokter.addActionListener(this);
        
        menu_admin.setBounds(720,10,120,30);
        menu.add(menu_admin);
        menu_admin.addActionListener(this);
        
        String homesPertama = "MENU TRANSAKSI";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(430, 20, 750, 100);
        isi.add(homePertama);
        
        obatPasien.setBounds(475,100,200,50);
        isi.add(obatPasien);
        obatPasien.addActionListener(this);
        
        lihatTransaksi.setBounds(475,180,200,50);
        isi.add(lihatTransaksi);
        lihatTransaksi.addActionListener(this);
        
        bayarTransaksi.setBounds(475,260,200,50);
        isi.add(bayarTransaksi);
        bayarTransaksi.addActionListener(this);
        
        lihatKeuntungan.setBounds(475,340,200,50);
        isi.add(lihatKeuntungan);
        lihatKeuntungan.addActionListener(this);       
        
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
            case "Pencairan Resep Dokter":
                new PrePencairanResepDokter();
                frame.setVisible(false);
                break;
            case "Lihat Semua Transaksi":
                new LihatSemuaTransaksi();
                frame.setVisible(false);
                break;
            case "Bayar Tagihan":
                new PreBayarTagihanNik();
                frame.setVisible(false);
                break;
            case "Lihat Keuntungan":
                new LihatKeuntungan();
                frame.setVisible(false);
                break;    
            default: 
                break;
        }
    }
    
}