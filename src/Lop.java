import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Lop {
	private HashMap<Integer,SinhVien> danhSach;
	private String monHoc;
	private String tenLop;
	private ThoiKhoaBieu tkb;
	private BangDiem bd;
	
	public ThoiKhoaBieu getTkb() {
		return tkb;
	}
	public void setTkb(ThoiKhoaBieu tkb) {
		this.tkb = tkb;
	}
	
	public HashMap<Integer, SinhVien> getDanhSach() {
		return danhSach;
	}
	public void setDanhSach(HashMap<Integer, SinhVien> danhSach) {
		this.danhSach = danhSach;
	}
	public BangDiem getBd() {
		return bd;
	}
	public void setBd(BangDiem bd) {
		this.bd = bd;
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
	
	public boolean isSinhVienTrongLop(SinhVien sv) {
		boolean kq = false;
		Iterator<Entry<Integer, SinhVien>> iter = this.getDanhSach().entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, SinhVien> temp = iter.next();
			long mssv = temp.getValue().getMssv();
			if(sv.getMssv() == mssv) {
				kq = true;
				break;
			}
		}
		return kq;
	}
	
	public void xoaSinhVien(SinhVien sv) {
		Iterator<Entry<Integer, SinhVien>> iter = this.getDanhSach().entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, SinhVien> temp = iter.next();
			if(temp.getValue().getMssv() == sv.getMssv()) {
				iter.remove();
			}
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
	
	public void nhapTenLop() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập tên lớp ");
		this.tenLop = input.nextLine();
	}
	
	public List<TaiKhoan> genTaiKhoan(List<TaiKhoan> ds) {
		List<TaiKhoan> kq = ds;
		Iterator<Entry<Integer, SinhVien>> iter = this.getDanhSach().entrySet().iterator();
		while( iter.hasNext()) {
			Entry<Integer, SinhVien> entry = iter.next();
			SinhVien sv = entry.getValue();
			TaiKhoan temp = new TaiKhoan();
			String mssv = String.valueOf(sv.getMssv());
			temp.setUsername(mssv);
			temp.setPassword(mssv);
			temp.setRole("sv");
			if(!temp.checkExist(ds)) {
				kq.add(temp);
			}
		}
		return kq;
	}
}
