
public class SinhVien {
	private Long mssv;
	String hoTen;
	String gioiTinh;
	String cmnd;
	
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
		System.out.print("MSSV: "+ this.mssv + ", Ho ten: " + this.hoTen + ", Gioi tinh: " + this.gioiTinh + ", CMND: " + this.cmnd);
	}
}
