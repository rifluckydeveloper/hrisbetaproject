package com.example.hrisproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hrisproject.model.KaryawanOutsource;
import com.example.hrisproject.repository.KaryawanOutsourceRepository;

import java.util.List;

@RestController
@RequestMapping("/api/karyawan-outsource")
public class KaryawanOutsourceController {

    @Autowired
    private KaryawanOutsourceRepository karyawanOutsourceRepository;

    @GetMapping
    public List<KaryawanOutsource> getAllKaryawan() {
        return karyawanOutsourceRepository.findAll();
    }

    @GetMapping("/{id}")
    public KaryawanOutsource getKaryawanById(@PathVariable Long id) {
        return karyawanOutsourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Karyawan dengan ID " + id + " tidak ditemukan"));
    }

    @PostMapping
    public KaryawanOutsource createKaryawan(@RequestBody KaryawanOutsource karyawanOutsource) {
        return karyawanOutsourceRepository.save(karyawanOutsource);
    }

    @PutMapping("/{id}")
    public KaryawanOutsource updateKaryawan(@PathVariable Long id, @RequestBody KaryawanOutsource karyawanOutsource) {
        if (!karyawanOutsourceRepository.existsById(id)) {
            throw new RuntimeException("Karyawan dengan ID " + id + " tidak ditemukan");
        }
        karyawanOutsource.setNo(id);
        return karyawanOutsourceRepository.save(karyawanOutsource);
    }

    @DeleteMapping("/{id}")
    public void deleteKaryawan(@PathVariable Long id) {
        if (!karyawanOutsourceRepository.existsById(id)) {
            throw new RuntimeException("Karyawan dengan ID " + id + " tidak ditemukan");
        }
        karyawanOutsourceRepository.deleteById(id);
    }
}
