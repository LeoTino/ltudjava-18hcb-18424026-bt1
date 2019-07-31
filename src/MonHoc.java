
public class MonHoc {
	private String maMon;
	private String tenMon;
	private String phongHoc;
	
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public String getPhongHoc() {
		return phongHoc;
	}
	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}
	
	public void inMonHoc() {
		System.out.print("Mã môn học: "+ this.maMon + ", Tên môn học: " + this.tenMon + ", Phòng học: " + this.phongHoc);
	}
}
