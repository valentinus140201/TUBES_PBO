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
import Controller.*;
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

public class DeleteDokter implements ActionListener{
    
    ControllerDokter control = new ControllerDokter();
    ArrayList<Dokter> dokters= control.getAllDokter();
    String[] listnid;
    JComboBox nid;
    
    JFrame deleteDokter = new JFrame("Delete Dokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    
    JLabel nids = new JLabel("NID");
    JButton delete = new JButton("Delete");
    
    public DeleteDokter(){
        
        deleteDokter.setSize(1200, 620);
        deleteDokter.setLocationRelativeTo(null);
        deleteDokter.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(11,521,1170,50);
        isi.setBounds(11,11,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(321,11,90,30);
        menu.add(menuPasien);
        menuPasien.addActionListener(this);
        
        menuDokter.setBounds(521,11,90,30);
        menu.add(menuDokter);
        menuDokter.addActionListener(this);
        
        menuAdmin.setBounds(721,11,120,30);
        menu.add(menuAdmin);
        menuAdmin.addActionListener(this);

        delete.addActionListener(this);
        
        nids.setBounds(41, 21, 160, 25);
        
        delete.setBounds(101,81,120,30);
        
        listnid = new String[dokters.size()];
        
        for(int i = 0; i < dokters.size(); i++){
            Dokter dokter = dokters.get(i);
            listnid[i] = dokter.getNID();
        }
        
        nid = new JComboBox(listnid);
        nid.setBounds(100, 20, 160, 25);
        
        isi.add(delete);
        isi.add(nids);
        isi.add(nid);
        
        deleteDokter.add(isi);
        deleteDokter.add(menu);
        
        deleteDokter.setUndecorated(true);
        deleteDokter.setVisible(true);
        deleteDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        deleteDokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Pasien": 
                new MenuPasien();
                deleteDokter.setVisible(false);
                break;
            case "Dokter":
                new MenuDokter();
                deleteDokter.setVisible(false);
                break;
            case "Administrasi":
                new MenuAdmin();
                deleteDokter.setVisible(false);
                break;
            case "Delete":
                String strnid = String.valueOf(nid.getSelectedItem());;
                boolean delete = control.deleteDokter(strnid);
                deleteDokter.setVisible(false);
                if(delete == true){
                    deleteDokter.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Hapus");
                    new MenuDokter();
                }
                break;
            default: 
                break;
        }
    }
    
}