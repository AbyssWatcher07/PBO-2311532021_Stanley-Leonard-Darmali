package model;

public class Order {
String id, id_costumer, id_service, id_user,status, status_pembayaran,tanggal, tanggal_selesai;
int total;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getId_costumer() {
	return id_costumer;
}
public void setId_costumer(String id_costumer) {
	this.id_costumer = id_costumer;
}
public String getId_service() {
	return id_service;
}
public void setId_service(String id_service) {
	this.id_service = id_service;
	
}
public String getstatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getStatus_pembayaran() {
	return status_pembayaran;
}
public String getTanggal() {
	return tanggal;
}
public void setTanggal(String tanggal) {
	this.tanggal = tanggal;
}
public String getTanggal_selesai() {
	return tanggal_selesai;
}
public void setTanggal_selesai(String tanggal_selesai) {
	this.tanggal_selesai = tanggal_selesai;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
}
