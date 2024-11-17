package com.example.hrisproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "karyawan_outsource")
public class KaryawanOutsource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long no;
    
	private String periode;
    private String sumberKandidat;
    private String tanggalPengiriman;
    private String namaKandidat;
    private String jenisKelamin;
    private String tempatLahir;
    private Date tanggalLahir;
    private Integer usia;
    private String pendidikan;
    private String namaSekolah;
    private String jurusan;
    private String ipk;
    private String nilai;
    private String tahunLulus;
    private String cabangDiTuju;
    private String skill;
    private String posisiYangDilamar;
    private Integer noHandphone;
    private String emailKandidat;
    private String noKTP;
    private String namaAyah;
    private String namaIbu;
    private String keterangan;

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getSumberKandidat() {
		return sumberKandidat;
	}
	public void setSumberKandidat(String sumberKandidat) {
		this.sumberKandidat = sumberKandidat;
	}
	public String getTanggalPengiriman() {
		return tanggalPengiriman;
	}
	public void setTanggalPengiriman(String tanggalPengiriman) {
		this.tanggalPengiriman = tanggalPengiriman;
	}
	public String getNamaKandidat() {
		return namaKandidat;
	}
	public void setNamaKandidat(String namaKandidat) {
		this.namaKandidat = namaKandidat;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public Integer getUsia() {
		return usia;
	}
	public void setUsia(Integer usia) {
		this.usia = usia;
	}
	public String getPendidikan() {
		return pendidikan;
	}
	public void setPendidikan(String pendidikan) {
		this.pendidikan = pendidikan;
	}
	public String getNamaSekolah() {
		return namaSekolah;
	}
	public void setNamaSekolah(String namaSekolah) {
		this.namaSekolah = namaSekolah;
	}
	public String getJurusan() {
		return jurusan;
	}
	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	public String getIpk() {
		return ipk;
	}
	public void setIpk(String ipk) {
		this.ipk = ipk;
	}
	public String getNilai() {
		return nilai;
	}
	public void setNilai(String nilai) {
		this.nilai = nilai;
	}
	public String getTahunLulus() {
		return tahunLulus;
	}
	public void setTahunLulus(String tahunLulus) {
		this.tahunLulus = tahunLulus;
	}
	public String getCabangDiTuju() {
		return cabangDiTuju;
	}
	public void setCabangDiTuju(String cabangDiTuju) {
		this.cabangDiTuju = cabangDiTuju;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getPosisiYangDilamar() {
		return posisiYangDilamar;
	}
	public void setPosisiYangDilamar(String posisiYangDilamar) {
		this.posisiYangDilamar = posisiYangDilamar;
	}
	public Integer getNoHandphone() {
		return noHandphone;
	}
	public void setNoHandphone(Integer noHandphone) {
		this.noHandphone = noHandphone;
	}
	public String getEmailKandidat() {
		return emailKandidat;
	}
	public void setEmailKandidat(String emailKandidat) {
		this.emailKandidat = emailKandidat;
	}
	public String getNoKTP() {
		return noKTP;
	}
	public void setNoKTP(String noKTP) {
		this.noKTP = noKTP;
	}
	public String getNamaAyah() {
		return namaAyah;
	}
	public void setNamaAyah(String namaAyah) {
		this.namaAyah = namaAyah;
	}
	public String getNamaIbu() {
		return namaIbu;
	}
	public void setNamaIbu(String namaIbu) {
		this.namaIbu = namaIbu;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}


}