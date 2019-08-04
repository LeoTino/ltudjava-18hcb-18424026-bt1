import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		while (true) {
			TaiKhoan tk = new TaiKhoan();
			tk.nhapTaiKhoan();
			boolean isLogOut = false;
			
			if("giaovu".equals(tk.getUsername()) && "giaovu".equals(tk.getPassword())) {
				while(!isLogOut) {
					System.out.println("================Giáo vụ===============");
					System.out.println("01. Import danh sách lớp");
					System.out.println("02. Thêm một sinh viên");
					System.out.println("03. Import thời khoá biểu");
					System.out.println("04. Huỷ/Đăng kí môn học");
					System.out.println("05. Xem danh sách lớp");
					System.out.println("06. Xem thời khoá biểu");
					System.out.println("07. Import bảng điểm");
					System.out.println("08. Xem bảng điểm");
					System.out.println("09. Sửa điểm");
					System.out.println("10. Đăng xuất");
					System.out.print("Bạn chọn: ");
					Scanner input = new Scanner(System.in);
					int chon = input.nextInt();
					switch (chon) {
					case 1:
						System.out.println("================Giáo vụ===============");
						System.out.println("=========Import danh sách lớp=========");
						
						break;
					case 10:
						isLogOut = true;
						System.out.println("Đã đăng xuất.");
					default:
						System.out.println("Vui lòng nhập vào một số theo menu!");
					}
					//isLogOut = true;
				}
			}
			else if(1==2) {
				
			}
			else {
				System.out.println("Tài khoản không tồn tại. Vui lòng đăng nhập lại!");
			}
		}
		
		
		/*
		 * Lop l = new Lop(); FileCSV fLop = new FileCSV();
		 * fLop.setPathImport("Lop.csv"); l = fLop.importLopCSV(); SinhVien sv =new
		 * SinhVien(); sv.setHoTen("tét"); l.setTenLop("18HCB"); l.themSinhVien(sv);
		 * l.inDanhSachLop(); System.out.println();
		 * 
		 * System.out.println("TKB:"); ThoiKhoaBieu tkb = new ThoiKhoaBieu(); FileCSV
		 * fTKB = new FileCSV(); fTKB.setPathImport("ThoiKhoaBieu.csv"); tkb =
		 * fTKB.importTKBCSV(); tkb.inThoiKhoaBieu();
		 * //System.out.println("tém tém lại giùm cái"); System.out.println();
		 * System.out.println(); List<Lop> dsLop = new ArrayList<>(); l.setTkb(tkb);
		 * dsLop = genLopTheoTkb(l, dsLop); for(Lop temp : dsLop) {
		 * System.out.println(temp.getTenLop()+"-"+temp.getMonHoc());
		 * temp.inDanhSachLop(); }
		 * 
		 * //bang diem BangDiem bd = new BangDiem(); FileCSV fBangDiem = new FileCSV();
		 * fBangDiem.setPathImport("BangDiem.csv"); bd = fBangDiem.importBangDiemCSV();
		 * bd.inBangDiem();
		 */
    }
	
	
	public static List<Lop> genLopTheoTkb(Lop l, List<Lop> ds){
		List<Lop> kq = new ArrayList<>();
		ThoiKhoaBieu tkb = l.getTkb();
		for (Map.Entry<Integer, MonHoc> entry : l.getTkb().getDanhSach().entrySet()) {
			MonHoc mh = entry.getValue();
			if(!l.isExist(ds)) {
				Lop temp = new Lop();
				temp.setDanhSach(l.getDanhSach());
				temp.setTenLop(l.getTenLop());
			    temp.setMonHoc(mh.getMaMon());
			    kq.add(temp);
			}
		}
		
		return kq;
	}
}
