package model;

public class Customer {
    private String id;
    private String nama;
    private String alamat;
    private String nomorHp;

    // Constructor
    public Customer(String id, String nama, String alamat, String nomorHp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorHp = nomorHp;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }
}
