package model;

public class Customer {
    private String id;
    private String name;
    private String alamat;
    private String nomorHp;

    // Constructor
    public Customer(String id, String name, String alamat, String nomorHp) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
