package model;

public class Customer {
	private String id;
	private String nama;
	private String Alamat;
	private String hp;
	private String email; // Added email attribute

	public Customer(String id, String name, String address, String phone, String email) { // Added email parameter
		this.id = id;
		this.nama = name;
		this.Alamat = Alamat;
		this.hp = phone;
		this.email = email;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.nama = email;
	}

	public String getAlamat() {
		return Alamat;
	}

	public void setAlamat(String Alamat) {
		this.Alamat = Alamat;
	}

	public String getNomorHp() {
		return hp;
	}

	public void setHp(String nomor_hp) {
		this.hp = nomor_hp;
	}
}
