import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		while (true) {
			TaiKhoan tk = new TaiKhoan();
			tk.nhapTaiKhoan();
			boolean isLogOut = false;
			List<Lop> dsLop = new ArrayList<>();
			
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
						Lop l = new Lop(); 
						FileCSV fLop = new FileCSV();
						fLop.nhapPathImport();
						l = fLop.importLopCSV();
						if(!l.getDanhSach().isEmpty()) {
							System.out.println("Import thành công!");
							l.nhapTenLop();
							dsLop.add(l);
						}
						else {
							System.out.println("Import thất bại!");
						}
						break;
					case 2:
						System.out.println("================Giáo vụ===============");
						System.out.println("==========Thêm một sinh viên==========");
						System.out.println("Nhập lớp của sinh viên: ");
						Scanner sc2 = new Scanner(System.in);
						String tenLop = sc2.nextLine();
						if(isExistLop(tenLop, dsLop)) {
							System.out.println("Nhập thông tin của sinh viên");
							SinhVien sv = new SinhVien();
							sv.nhapSinhVien();
							boolean check = false;
							for(Lop temp : dsLop) {
								if(tenLop.equals(temp.getTenLop())){
									temp.themSinhVien(sv);
									check = true;
									break;
								}
							}
							if(check) {
								System.out.println("Thêm thành công!");
							}
							else {
								System.out.println("Thêm sinh viên thất bại!");
							}
						}
						else {
							System.out.println("Lớp không tồn tại!");
						}
						break;
					case 3:
						System.out.println("================Giáo vụ===============");
						System.out.println("=========Import thời khoá biểu========");
						System.out.println("Nhập lớp của thời khoá biểu: ");
						Scanner sc3 = new Scanner(System.in);
						String tenLop3 = sc3.nextLine();
						Lop lTemp = new Lop();
						if(isExistLop(tenLop3, dsLop)) {
							ThoiKhoaBieu tkb = new ThoiKhoaBieu(); 
							FileCSV fTkb = new FileCSV();
							fTkb.nhapPathImport();
							tkb = fTkb.importTKBCSV();
							if(!tkb.getDanhSach().isEmpty()) {
								System.out.println("Import thành công!");
								Iterator<Lop> iter = dsLop.iterator();
								while(iter.hasNext()) {
									Lop lop = iter.next();
									if(tenLop3.equals(lop.getTenLop())) {
										lop.setTkb(tkb);
										lTemp = lop;
									}
								}
							}
							else {
								System.out.println("Import thất bại!");
							}
						}
						else {
							System.out.println("Lớp không tồn tại!");
						}
						dsLop = genLopTheoTkb(lTemp, dsLop);
						break;
					case 4:
						System.out.println("================Giáo vụ===============");
						System.out.println("=========Huỷ/Đăng kí môn học==========");
						Scanner sc4= new Scanner(System.in);
						System.out.println("Nhập tên lớp: ");
						String tenLop4 = sc4.nextLine();
						if(isExistLop(tenLop4, dsLop)) {
							System.out.println("Nhập mã môn học: ");
							String maMon = sc4.nextLine();
							String tenLopMon = tenLop4.concat("-").concat(maMon);
							if(isExistLop(tenLopMon, dsLop)) {
								SinhVien sv4 = new SinhVien();
								System.out.println("Nhập thông tin sinh viên");
								sv4.nhapSinhVien();
								for(Lop lop4 : dsLop) {
									if(lop4.getTenLop().equals(tenLopMon)) {
										if(lop4.isSinhVienTrongLop(sv4)) {
											lop4.xoaSinhVien(sv4);
											System.out.println("Đã huỷ sinh viên khỏi môn học này!");
										} else {
											lop4.themSinhVien(sv4);
											System.out.println("Đã thêm sinh viên vào môn học này!");
										}
									}
								}
							} else {
								System.out.println("Không có môn học này!");
							}
						} else {
							System.out.println("Lớp không tồn tại!");
						}
						break;
					case 5:
						System.out.println("================Giáo vụ===============");
						System.out.println("==========Xem danh sách lớp===========");
						for(Lop lop : dsLop) {
							System.out.println(lop.getTenLop());
							lop.inDanhSachLop();
							System.out.println();
						}
						break;
					case 10:
						isLogOut = true;
						System.out.println("Đã đăng xuất.");
						break;
					default:
						System.out.println("Chọn bậy!");
						break;
					}
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
		List<Lop> kq = ds;
		HashMap<Integer, SinhVien> dsSinhVien = new HashMap<>();
		dsSinhVien.putAll(l.getDanhSach());
		Iterator<Entry<Integer, MonHoc>> iter = l.getTkb().getDanhSach().entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, MonHoc> entry = iter.next();
			MonHoc mh = entry.getValue();
			Lop temp = new Lop();
			String tenLop = l.getTenLop() + "-" + mh.getMaMon();
			temp.setDanhSach(dsSinhVien);
			temp.setTenLop(tenLop);
		    temp.setMonHoc(mh.getMaMon());
			if(!temp.isExist(ds)) {				
			    kq.add(temp);
			}
		}
		
		return kq;
	}
	
	public static boolean isExistLop(String tenLop, List<Lop> ds) {
		boolean kq = false;
		for(Lop l : ds) {
			if(tenLop.equals(l.getTenLop())) {
				kq = true;
			}
		}
		return kq;
	}
}
