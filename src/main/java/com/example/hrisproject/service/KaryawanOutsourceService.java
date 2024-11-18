package com.example.hrisproject.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import com.example.hrisproject.model.KaryawanOutsource;
import com.example.hrisproject.repository.KaryawanOutsourceRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    
    public ByteArrayOutputStream generateExcel() throws IOException {
        List<KaryawanOutsource> karyawanOutsourceList = karyawanOutsourceRepository.findAll();

        // Membuat workbook baru
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("karyawan_outsource.xlsx");

        // Membuat header
        Row headerRow = sheet.createRow(0);
        String[] columns = {
        	    "periode", "sumber_kandidat", "tanggal_pengiriman", "nama_kandidat", "jenis_kelamin", 
        	    "tempat_lahir", "tanggal_lahir", "usia", "pendidikan", "nama_sekolah", "jurusan", "ipk", 
        	    "nilai", "tahun_lulus", "cabang_di_tuju", "skill", "posisi_yang_dilamar", "no_handphone", 
        	    "email_kandidat", "noktp", "namaayah", "namaibu", "keterangan", "nama_ayah", 
        	    "nama_ibu", "no"
        	};

        for (int i = 0; i < columns.length; i++) {
            headerRow.createCell(i).setCellValue(columns[i]);
        }

        // Menambahkan data
        int rowNum = 1;
        for (KaryawanOutsource karyawan : karyawanOutsourceList) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(karyawan.getPeriode());
            row.createCell(1).setCellValue(karyawan.getSumberKandidat());
            row.createCell(2).setCellValue(karyawan.getTanggalPengiriman().toString());
            row.createCell(3).setCellValue(karyawan.getNamaKandidat());
            row.createCell(4).setCellValue(karyawan.getJenisKelamin());
            row.createCell(5).setCellValue(karyawan.getTempatLahir());
            row.createCell(6).setCellValue(karyawan.getTanggalLahir().toString());
            row.createCell(7).setCellValue(karyawan.getUsia());
            row.createCell(8).setCellValue(karyawan.getPendidikan());
            row.createCell(9).setCellValue(karyawan.getNamaSekolah());
            row.createCell(10).setCellValue(karyawan.getJurusan());
            row.createCell(11).setCellValue(karyawan.getIpk());
            row.createCell(12).setCellValue(karyawan.getNilai());
            row.createCell(13).setCellValue(karyawan.getTahunLulus());
            row.createCell(14).setCellValue(karyawan.getCabangDiTuju());
            row.createCell(15).setCellValue(karyawan.getSkill());
            row.createCell(16).setCellValue(karyawan.getPosisiYangDilamar());
            row.createCell(17).setCellValue(karyawan.getNoHandphone());
            row.createCell(18).setCellValue(karyawan.getEmailKandidat());
            row.createCell(19).setCellValue(karyawan.getNoKTP());
            row.createCell(20).setCellValue(karyawan.getNamaAyah());
            row.createCell(21).setCellValue(karyawan.getNamaIbu());
            row.createCell(22).setCellValue(karyawan.getKeterangan());
            row.createCell(23).setCellValue(karyawan.getNamaAyah());
            row.createCell(24).setCellValue(karyawan.getNamaIbu());
            row.createCell(25).setCellValue(karyawan.getNo());
        }

        // Menyimpan file Excel ke dalam ByteArrayOutputStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out;
    }
}