import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Lop {
	private Map<Integer,SinhVien> danhSach;
	private String monHoc;
	private String tenLop;
	private ThoiKhoaBieu tkb;
	
	public ThoiKhoaBieu getTkb() {
		return tkb;
	}
	public void setTkb(ThoiKhoaBieu tkb) {
		this.tkb = tkb;
	}

	public Map<Integer, SinhVien> getDanhSach() {
		return danhSach;
	}
	public void setDanhSach(Map<Integer, SinhVien> danhSach) {
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
		for (Map.Entry<Integer, SinhVien> entry : this.danhSach.entrySet()) {
		    int key = entry.getKey();
		    SinhVien value = entry.getValue();
		    System.out.print("STT: "+ key +", ");
		    value.inSinhVien();
		    System.out.println();
		}
	}
	
	public boolean themSinhVien(SinhVien sv) {
		int stt;
		stt = this.danhSach.size() + 1;
		this.danhSach.put(stt, sv);
		return true;
	}
	
	public boolean isExist(List<Lop> ds) {
		boolean kq = false;
		for(Lop l : ds) {
			if(this.tenLop.equals(l.tenLop)) {
				kq = true;
				break;
			}
		}
		return kq;
	}
}
