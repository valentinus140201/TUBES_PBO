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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author hp
 */

public class MenuDokter implements ActionListener{
    JFrame frame = new JFrame("MenuDokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    JButton insertDokter = new JButton("Insert Dokter");
    JButton updateDokter = new JButton("Update Dokter");
    JButton deleteDokter = new JButton("Delete Dokter");
    JButton absensiDokter = new JButton("Absensi Dokter");
    JButton hitungGaji = new JButton("Hitung Gaji");
    
    public MenuDokter(){
        
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
        
        String homesPertama = "MENU DOKTER";
        
        JLabel homePertama;
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(465, 20, 750, 100);
        isi.add(homePertama);
        
        insertDokter.setBounds(475,100,200,50);
        isi.add(insertDokter);
        insertDokter.addActionListener(this);
        
        updateDokter.setBounds(475,180,200,50);
        isi.add(updateDokter);
        updateDokter.addActionListener(this);
        
        deleteDokter.setBounds(475,260,200,50);
        isi.add(deleteDokter);
        deleteDokter.addActionListener(this);
        
        absensiDokter.setBounds(475,340,200,50);
        isi.add(absensiDokter);
        absensiDokter.addActionListener(this);
        
        hitungGaji.setBounds(475,420,200,50);
        isi.add(hitungGaji);
        hitungGaji.addActionListener(this);

        frame.add(isi);
        frame.add(menu);
   
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.setVisible(true);
    }

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
            case "Insert Dokter":
                new InputDokter();
                frame.setVisible(false);
                break;
            case "Update Dokter":
                new PreUpdateDokter();
                frame.setVisible(false);
                break;
            case "Delete Dokter":
                new DeleteDokter();
                frame.setVisible(false);
                break;
            case "Absensi Dokter":
                new ViewAbsensiDokter();
                frame.setVisible(false);
                break;
            case "Hitung Gaji":
                new PreHitungGaji();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
//    public static void main(String[] args){
//        new MenuDokter();
//    }
}
