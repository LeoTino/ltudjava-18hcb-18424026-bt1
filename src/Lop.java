import java.util.List;
import java.util.Map;

public class Lop {
	private List<Map<Integer,SinhVien>> danhSach;
	private String monHoc;
	private String tenLop;
	
	public List<Map<Integer, SinhVien>> getDanhSach() {
		return danhSach;
	}
	public void setDanhSach(List<Map<Integer, SinhVien>> danhSach) {
		this.danhSach = danhSach;
	}
	public String getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	
	public void inDanhSachLop() {
		for (Map<Integer, SinhVien> map : this.danhSach) {
		    for (Map.Entry<Integer, SinhVien> entry : map.entrySet()) {
		        int key = entry.getKey();
		        SinhVien value = entry.getValue();
		        System.out.print("STT: "+ key +", ");
		        value.inSinhVien();
		        System.out.println();
		    }
		}
	}
}
