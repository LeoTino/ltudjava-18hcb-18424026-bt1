
public class Diem {
	private Long mssv;
	private String hoTen;
	private double diemGK;
	private double diemCK;
	private double diemKhac;
	private double tongDiem;
	
	
	public Long getMssv() {
		return mssv;
	}
	public void setMssv(Long mssv) {
		this.mssv = mssv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public double getDiemGK() {
		return diemGK;
	}
	public void setDiemGK(double diemGK) {
		this.diemGK = diemGK;
	}
	public double getDiemCK() {
		return diemCK;
	}
	public void setDiemCK(double diemCK) {
		this.diemCK = diemCK;
	}
	public double getDiemKhac() {
		return diemKhac;
	}
	public void setDiemKhac(double diemKhac) {
		this.diemKhac = diemKhac;
	}
	public double getTongDiem() {
		return tongDiem;
	}
	public void setTongDiem(double tongDiem) {
		this.tongDiem = tongDiem;
	}
	
	public void inDiem() {
		System.out.print("MSSV: "+ this.mssv + ", Họ tên: " + this.hoTen + ", Điểm GK: " + this.diemCK + ", Điểm CK: " + this.diemCK + ", Điểm khác: " + this.diemKhac + ", Điểm tổng: " + this.tongDiem);;
	}
}
