package com.aldis.burger.service;
import com.aldis.burger.model.Bahan;
import com.aldis.burger.model.Menu;
import com.aldis.burger.model.Transaksi;
import com.aldis.burger.repository.BahanRepository;
import com.aldis.burger.repository.MenuRepository;
import com.aldis.burger.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransaksiService {
    
    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private BahanRepository bahanRepository;

    // list transaksi
    public List<Transaksi> getAll() {
        return transaksiRepository.findAll();
    }

    // transaksi berdasarkan id
    public Optional<Transaksi> getById(Integer id) {
        return transaksiRepository.findById(id);
    }

    // simpan transaksi
    public Transaksi save(Transaksi transaksi) {

        // beli menu berdasarkan id
        Menu menu = menuRepository.findById(transaksi.getId_menu())
            .orElseThrow(() -> new RuntimeException("Menu Tidak Di Temukan"));

        // cek ketersediaan menu
        if (menu.getStok_menu() < 1) {
            throw new RuntimeException("Stok menu tidak tersedia!");
        }

        // hitung harga
        transaksi.setTotal_harga(menu.getHarga() * transaksi.getJumlah_item());

        // stok berkurang
        menu.setStok_menu(menu.getStok_menu() - transaksi.getJumlah_item());

        // update jika stok menu kurang dari 3
        if (menu.getStok_menu() < 3) {
            menu.setTersedia(false);
        }

        // simpan menu update
        menuRepository.save(menu);

        // kurang stok bahan berkurang terkait menu
        List<Bahan> bahanList = bahanRepository.findByIdMenu(transaksi.getId_menu());
        for (Bahan bahan : bahanList) {
            bahan.setStok_bahan(bahan.getStok_bahan() - transaksi.getJumlah_item());

            // update jika stok bahan kurang dari 10 
            if (bahan.getStok_bahan() <10 )  {
                bahan.setTersedia(false);
            }

            bahanRepository.save(bahan);
        }

        // simpan transaksi
        return transaksiRepository.save(transaksi);
    }

    // delet transaksi
    public void delete(Integer id) {
        transaksiRepository.deleteById(id);
    }
}
