package com.example.hrisproject.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hrisproject.model.KaryawanOutsource;
import com.example.hrisproject.repository.KaryawanOutsourceRepository;
import com.example.hrisproject.service.KaryawanOutsourceService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/karyawan-outsource")
public class KaryawanOutsourceController {

    @Autowired
    private KaryawanOutsourceRepository karyawanOutsourceRepository;
    
    @Autowired
    private KaryawanOutsourceService karyawanOutsourceService;
    
    private static final Logger logger = LoggerFactory.getLogger(KaryawanOutsourceController.class);


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
    
    @GetMapping("/generate-excel")
    public ResponseEntity<InputStreamResource> generateExcel() throws IOException {
    	
    	logger.info("KaryawanOutsourceService: {}", karyawanOutsourceService);

        if (karyawanOutsourceService == null) {
            throw new IllegalStateException("KaryawanOutsourceService is not initialized");
        }
        
        ByteArrayOutputStream byteArrayOutputStream = karyawanOutsourceService.generateExcel();
        
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=karyawan_outsource.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
