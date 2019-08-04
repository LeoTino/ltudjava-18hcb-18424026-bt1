import java.util.Scanner;

public class Diem {
	private long mssv;
	private String hoTen;
	private double diemGK;
	private double diemCK;
	private double diemKhac;
	private double tongDiem;
	
	
	public long getMssv() {
		return mssv;
	}
	public void setMssv(long mssv) {
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
	
	public void nhapDiem() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập điểm giữa kỳ: ");
		this.diemGK = Double.parseDouble(input.nextLine());
		System.out.println("Nhập điểm cuối kỳ: ");
		this.diemCK = Double.parseDouble(input.nextLine());
		System.out.println("Nhập điểm khác: ");
		this.diemKhac = Double.parseDouble(input.nextLine());
		System.out.println("Nhập điểm tổng: ");
		this.tongDiem = Double.parseDouble(input.nextLine());
	}
}
