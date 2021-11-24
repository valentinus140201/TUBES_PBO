/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerTransaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Model.*;

/**
 *
 * @author hp
 */
public class BayarTagihan implements ActionListener{
    
    JFrame BayarTagihan = new JFrame("BAYAR TAGIHAN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton bayarTagihan = new JButton("BAYAR TAGIHAN");
    Transaksi tempTransaksi;

    public BayarTagihan(Transaksi transaksi){
        
        JLabel labIdTransaksi,labNamaPasien,labTotalTagihan,isilabIdTransaksi,isilabNamaPasien,isilabTotalTagihan;
        
        BayarTagihan.setSize(1200, 620);
        BayarTagihan.setLocationRelativeTo(null);
        BayarTagihan.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(11,521,1170,50);
        isi.setBounds(11,11,1172,500);
        
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
        
        bayarTagihan.setBounds(121,201,150,30);
        bayarTagihan.addActionListener(this);

        labIdTransaksi = new JLabel("Id Transaksi : ");
        labNamaPasien = new JLabel("Nama : ");
        labTotalTagihan = new JLabel("Total Tagihan : ");
        
        isilabIdTransaksi = new JLabel(transaksi.getIdTransaksi());
        isilabNamaPasien = new JLabel(transaksi.getPasien().getNama());
        isilabTotalTagihan = new JLabel("" + transaksi.getTotal());
        
        labIdTransaksi.setBounds(41, 51, 160, 25);
        isilabIdTransaksi.setBounds(121, 51, 160, 25);
        labNamaPasien.setBounds(41, 101, 160, 25);
        isilabNamaPasien.setBounds(121, 101, 160, 25);
        labTotalTagihan.setBounds(41, 151, 160, 25);
        isilabTotalTagihan.setBounds(131, 151, 161, 25);
        
        isi.add(labIdTransaksi);
        isi.add(isilabIdTransaksi);
        isi.add(labNamaPasien);
        isi.add(isilabNamaPasien);
        isi.add(labTotalTagihan);
        isi.add(isilabTotalTagihan);
        
        bayarTagihan.addActionListener(this);
        isi.add(bayarTagihan);
        
        BayarTagihan.add(isi);
        BayarTagihan.add(menu);
        
        BayarTagihan.setUndecorated(true);
        BayarTagihan.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        BayarTagihan.setVisible(true);
        BayarTagihan.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
        tempTransaksi = transaksi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Pasien": 
                new MenuPasien();
                BayarTagihan.setVisible(false);
                break;
            case "Dokter":
                new MenuDokter();
                BayarTagihan.setVisible(false);
                break;
            case "Administrasi":
                new MenuAdmin();
                BayarTagihan.setVisible(false);
                break;
            case "Bayar Tagihan":
                ControllerTransaksi.insertTransaksibyBayarTagihan(tempTransaksi);
                BayarTagihan.setVisible(false);
                new MenuAdmin();
                JOptionPane.showMessageDialog(null, "Pembayaran telah berhasil, Terima Kasih");
                break;
            default: 
                break;
        }
    }
}
