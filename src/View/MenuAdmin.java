/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Singleton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author hp
 */
public class MenuAdmin implements ActionListener{
    
    JFrame frame = new JFrame("Menu Admin");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    JButton logout = new JButton("LOG OUT");
    JButton inputObat = new JButton("Input Obat");
    JButton restockObat = new JButton("Restock Obat");
    JButton rujukan = new JButton("Rujukan");
    JButton transaksi = new JButton("Transaksi");
    JLabel homePertama;
    
    public MenuAdmin(){
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(250,10,90,30);
        menu.add(menuPasien);
        menuPasien.addActionListener(this);
        
        menuDokter.setBounds(430,10,90,30);
        menu.add(menuDokter);
        menuDokter.addActionListener(this);
        
        menuAdmin.setBounds(590,10,120,30);
        menu.add(menuAdmin);
        menuAdmin.addActionListener(this);
        
        logout.setBounds(790,10,120,30);
        menu.add(logout);
        logout.addActionListener(this);
        
        String homesPertama = "MENU ADMINISTRASI";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(420, 20, 750, 100);
        isi.add(homePertama);
        
        
        inputObat.setBounds(475,120,200,50);
        isi.add(inputObat);
        inputObat.addActionListener(this);
        
        restockObat.setBounds(475,220,200,50);
        isi.add(restockObat);
        restockObat.addActionListener(this);
        
        rujukan.setBounds(475,320,200,50);
        isi.add(rujukan);
        rujukan.addActionListener(this);
        
        transaksi.setBounds(475,420,200,50);
        isi.add(transaksi);
        transaksi.addActionListener(this);
        
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
            case "Input Obat":
                new InputObat();
                frame.setVisible(false);
                break;
            case "Restock Obat":
                new ReStockObat();
                frame.setVisible(false);
                break;
            case "LOG OUT"    :
                Singleton.getInstance().setStaff(null);
                Singleton.getInstance().setCabang(null);
                frame.setVisible(false);;
                new LoginScreen();
                break;
            case "Rujukan":
                new PreRujukan();
                frame.setVisible(false);
                break;
            case "Transaksi":
                new MenuTransaksi();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
}
