import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Lop l = new Lop();
        FileCSV fLop = new FileCSV();
        fLop.setPathImport("Lop.csv");
        l = fLop.importLopCSV();
        SinhVien sv =new SinhVien();
        sv.setHoTen("tét");
        l.themSinhVien(sv);
        l.inDanhSachLop();
        System.out.println();
        
        System.out.println("TKB:");
        ThoiKhoaBieu tkb = new ThoiKhoaBieu();
        FileCSV fTKB = new FileCSV();
        fTKB.setPathImport("ThoiKhoaBieu.csv");
        tkb = fTKB.importTKBCSV();
        tkb.inThoiKhoaBieu();
        //System.out.println("tém tém lại giùm cái");
    }
}
