package com.example.hrisproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrisproject.model.KaryawanOutsource;
import com.example.hrisproject.repository.KaryawanOutsourceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KaryawanOutsourceService {

    @Autowired
    private KaryawanOutsourceRepository karyawanOutsourceRepository;

    // Menyimpan karyawan baru
    public KaryawanOutsource saveKaryawan(KaryawanOutsource karyawanOutsource) {
        return karyawanOutsourceRepository.save(karyawanOutsource);
    }

    // Mengambil semua data karyawan
    public List<KaryawanOutsource> getAllKaryawan() {
        return karyawanOutsourceRepository.findAll();
    }

    // Mengambil data karyawan berdasarkan ID
    public Optional<KaryawanOutsource> getKaryawanById(Long no) {
        return karyawanOutsourceRepository.findById(no);
    }

    // Mengupdate data karyawan
    public KaryawanOutsource updateKaryawan(Long no, KaryawanOutsource karyawanOutsource) {
        if (karyawanOutsourceRepository.existsById(no)) {
            karyawanOutsource.setNo(no);
            return karyawanOutsourceRepository.save(karyawanOutsource);
        } else {
            return null;
        }
    }

    // Menghapus data karyawan
    public boolean deleteKaryawan(Long no) {
        if (karyawanOutsourceRepository.existsById(no)) {
            karyawanOutsourceRepository.deleteById(no);
            return true;
        } else {
            return false;
        }
    }
}