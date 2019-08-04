import java.util.Scanner;

public class SinhVien {
	private long mssv;
	private String hoTen;
	private String gioiTinh;
	private String cmnd;
	
	public long getMssv() {
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
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
	public void inSinhVien() {
		System.out.print("MSSV: "+ this.mssv + ", Họ tên: " + this.hoTen + ", Giới tính: " + this.gioiTinh + ", CMND: " + this.cmnd);
	}
	
	public void nhapSinhVien() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập MSSV: ");
		this.mssv = Long.parseLong(input.nextLine());
		System.out.println("Nhập họ và tên: ");
		this.hoTen = input.nextLine();
		System.out.println("Nhập giới tính: ");
		this.gioiTinh = input.nextLine();
		System.out.println("Nhập số CMND: ");
		this.cmnd = input.nextLine();
	}
}
