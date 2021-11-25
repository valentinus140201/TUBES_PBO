package View;

import Controller.ControllerTransaksi;
import Model.Singleton;
import Model.Transaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class LihatKeuntungan implements ActionListener{
/**
 *
 * @author hp
 */
    
    JFrame lihatKeuntunganKlinik = new JFrame("Cek Keuntungan Klinik");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("Pasien");
    JButton menuDokter = new JButton("Dokter");
    JButton menuAdmin = new JButton("Administrasi");
    JButton kembaliKeMenu = new JButton("Kembali ke Menu");
    

    public LihatKeuntungan(){
        
        lihatKeuntunganKlinik.setSize(1200, 620);
        lihatKeuntunganKlinik.setLocationRelativeTo(null);
        lihatKeuntunganKlinik.setLayout(null);
        
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
        
        JLabel labidCabang,labKeuntungan;
        
        labidCabang = new JLabel("Nama Cabang : ");
        labKeuntungan = new JLabel("Keuntungan : ");
        
        ArrayList<Transaksi> listTransaksi = ControllerTransaksi.getAllTransaksi("");
        long Keuntungan = 0;
        for (Transaksi transaksi : listTransaksi) {
            Keuntungan += transaksi.getTotal();
        }
        JLabel isilabidCabang = new JLabel(Singleton.getInstance().getCabang().getNama());
        JLabel isilabKeuntungan = new JLabel("Rp. " + Keuntungan);
        
        
        labidCabang.setBounds(40, 20, 160, 30);
        isi.add(labidCabang);
        isilabidCabang.setBounds(120, 20, 160, 30);
        isi.add(isilabidCabang);
        labKeuntungan.setBounds(40, 80, 160, 30);
        isi.add(labKeuntungan);
        isilabKeuntungan.setBounds(120, 80, 160, 30);
        isi.add(isilabKeuntungan);
        
        kembaliKeMenu.addActionListener(this);
        kembaliKeMenu.setBounds(100, 120, 160, 30);
        isi.add(kembaliKeMenu);
        
        lihatKeuntunganKlinik.add(isi);
        lihatKeuntunganKlinik.add(menu);
        
        lihatKeuntunganKlinik.setUndecorated(true);
        lihatKeuntunganKlinik.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        lihatKeuntunganKlinik.setVisible(true);
        lihatKeuntunganKlinik.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Pasien": 
                new MenuPasien();
                lihatKeuntunganKlinik.setVisible(false);
                break;
            case "Dokter":
                new MenuDokter();
                lihatKeuntunganKlinik.setVisible(false);
                break;
            case "Administrasi":
                new MenuAdmin();
                lihatKeuntunganKlinik.setVisible(false);
                break;
            case "Kembali ke Menu":
                lihatKeuntunganKlinik.setVisible(false);
                new MenuAdmin();
                break;
            default: 
                break;
        }
    }
}

