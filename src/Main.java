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
		TaiKhoan gv = new TaiKhoan();
		gv.setUsername("giaovu");
		gv.setPassword("giaovu");
		gv.setRole("giaovu");
		List<Lop> dsLop = new ArrayList<>();
		List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
		dsTaiKhoan.add(gv);
		while (true) {	
			TaiKhoan tk = new TaiKhoan();
			tk.nhapTaiKhoan();
			int role = tk.checkDangNhap(dsTaiKhoan);
			boolean isLogOut = false;
			if(role == 1) {
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
					System.out.println("11. Đổi mật khẩu");
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
							dsTaiKhoan = l.genTaiKhoan(dsTaiKhoan);
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
									dsTaiKhoan = temp.genTaiKhoan(dsTaiKhoan);
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
						boolean check3 = false;
						if(isExistLop(tenLop3, dsLop)) {
							ThoiKhoaBieu tkb = new ThoiKhoaBieu(); 
							FileCSV fTkb = new FileCSV();
							fTkb.nhapPathImport();
							tkb = fTkb.importTKBCSV();
							if(!tkb.getDanhSach().isEmpty()) {
								System.out.println("Import thành công!");
								check3 = true;
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
						if(check3 == true) {
							dsLop = genLopTheoTkb(lTemp, dsLop);
						}
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
					case 6:
						System.out.println("================Giáo vụ===============");
						System.out.println("==========Xem thời khoá biểu==========");
						Scanner sc6= new Scanner(System.in);
						System.out.println("Nhập tên lớp: ");
						String tenLop6 = sc6.nextLine();
						if(isExistLop(tenLop6, dsLop)) {
							for(Lop lop : dsLop) {
								if(tenLop6.equals(lop.getTenLop())) {
									if(lop.getTkb() != null) {
										lop.getTkb().inThoiKhoaBieu();
									} else {
										System.out.println("Lớp này không có thời khoá biểu!");
									}
								}
							}
						} else {
							System.out.println("Lớp không tồn tại!");
						}
						break;
					case 7:
						System.out.println("================Giáo vụ===============");
						System.out.println("===========Import bảng điểm===========");
						Scanner sc7= new Scanner(System.in);
						System.out.println("Nhập tên lớp: ");
						String tenLop7 = sc7.nextLine();
						if(isExistLop(tenLop7, dsLop)) {
							BangDiem bd = new BangDiem(); 
							FileCSV fBd = new FileCSV();
							fBd.nhapPathImport();
							bd = fBd.importBangDiemCSV();
							for(Lop lop : dsLop) {
								if(tenLop7.equals(lop.getTenLop())) {
									lop.setBd(bd);
									System.out.println("Import thành công!");
								}
							}
						} else {
							System.out.println("Lớp không tồn tại!");
						}
						break;
					case 8:
						System.out.println("================Giáo vụ===============");
						System.out.println("==========Xem lại bảng điểm===========");
						Scanner sc8= new Scanner(System.in);
						System.out.println("Nhập tên lớp: ");
						String tenLop8 = sc8.nextLine();
						if(isExistLop(tenLop8, dsLop)) {
							for(Lop lop : dsLop) {
								if(tenLop8.equals(lop.getTenLop())) {
									if(lop.getBd() != null) {
										lop.getBd().inBangDiem();
										System.out.println("Thống kê");
										lop.getBd().thongKe();
									} else {
										System.out.println("Lớp này chưa có bảng điểm!");
									}
								}
							}
						} else {
							System.out.println("Lớp không tồn tại!");
						}
						break;
					case 9:
						System.out.println("================Giáo vụ===============");
						System.out.println("============Sửa bảng điểm=============");
						Scanner sc9= new Scanner(System.in);
						System.out.println("Nhập tên lớp: ");
						String tenLop9 = sc9.nextLine();
						if(isExistLop(tenLop9, dsLop)) {
							for(Lop lop : dsLop) {
								if(tenLop9.equals(lop.getTenLop())) {
									if(lop.getBd() != null) {
										System.out.println("Nhập MSSV: ");
										Long mssv = Long.parseLong(sc9.nextLine());
										Iterator<Entry<Integer, Diem>> iter = lop.getBd().getDanhSach().entrySet().iterator();
										boolean check = false;
										while(iter.hasNext()) {
											Entry<Integer, Diem> entry = iter.next();
											if(mssv == entry.getValue().getMssv()) {
												Diem d = new Diem();
												d.setMssv(mssv);
												d.setHoTen(entry.getValue().getHoTen());
												d.nhapDiem();
												entry.setValue(d);
												System.out.println("Sửa điểm thành công ");
												check = true;
											}
										}
										if(check == false) {
											System.out.println("Lỗi! Không sửa được điểm!");
										}
									} else {
										System.out.println("Lớp này chưa có bảng điểm!");
									}
								}
							}
						} else {
							System.out.println("Lớp không tồn tại!");
						}
						break;
					case 10:
						isLogOut = true;
						System.out.println("Đã đăng xuất.");
						break;
					case 11:
						System.out.println("================Giáo vụ===============");
						System.out.println("============Đổi mật khẩu==============");
						System.out.println("Nhập password: ");
						Scanner sc11= new Scanner(System.in);
						String password = sc11.nextLine();
						for(TaiKhoan taikhoan : dsTaiKhoan) {
							if(taikhoan.getUsername().equals(tk.getUsername())) {
								taikhoan.setPassword(password);
								System.out.println("Đổi thành công!");
							}
						}
						break;
					default:
						System.out.println("Chọn bậy!");
						break;
					}
				}
			}
			else if(role == 2) {
				while(!isLogOut) {
					System.out.println("================"+ tk.getUsername() +"===============");
					System.out.println("01. Xem điểm");
					System.out.println("02. Đăng xuất");
					System.out.println("03. Đổi mật khẩu");
					System.out.print("Bạn chọn: ");
					Scanner input = new Scanner(System.in);
					int chon = input.nextInt();
					switch (chon) {
					case 1:
						System.out.println("================"+ tk.getUsername() +"===============");
						System.out.println("==============Xem điểm===============");
						for(Lop lop : dsLop) {
							if(lop.getBd() != null) {
								Iterator<Entry<Integer, Diem>> iter = lop.getBd().getDanhSach().entrySet().iterator();
								while(iter.hasNext()) {
									Entry<Integer, Diem> entry = iter.next();
									Diem diem = entry.getValue();
									if(diem.getMssv() == Long.parseLong(tk.getUsername())) {
										System.out.println(lop.getTenLop());
										diem.inDiem();
										System.out.println();
									}
								}
							}
						}
						break;
					case 2:
						isLogOut = true;
						System.out.println("Đã đăng xuất.");
						break;
					case 3:
						System.out.println("================"+ tk.getUsername() +"===============");
						System.out.println("============Đổi mật khẩu=============");
						System.out.println("Nhập password: ");
						Scanner sc11= new Scanner(System.in);
						String password = sc11.nextLine();
						for(TaiKhoan taikhoan : dsTaiKhoan) {
							if(taikhoan.getUsername().equals(tk.getUsername())) {
								taikhoan.setPassword(password);
								System.out.println("Đổi thành công!");
							}
						}
						break;
					}
				}
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
		Iterator<Entry<Integer, MonHoc>> iter = l.getTkb().getDanhSach().entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, MonHoc> entry = iter.next();
			MonHoc mh = entry.getValue();
			Lop temp = new Lop();
			HashMap<Integer, SinhVien> dsSinhVien = new HashMap<Integer, SinhVien>();
			dsSinhVien.putAll(l.getDanhSach());
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
