import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Lop l = new Lop();
        FileCSV fLop = new FileCSV();
        fLop.setPathImport("Lop.csv");
        l = fLop.importLopCSV();
        SinhVien sv =new SinhVien();
        sv.setHoTen("tét");
        l.setTenLop("18HCB");
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
        System.out.println();
        System.out.println();
        List<Lop> dsLop = new ArrayList<>();
        l.setTkb(tkb);
        dsLop = genLopTheoTkb(l);
        for(Lop temp : dsLop) {
        	System.out.println(temp.getTenLop()+"-"+temp.getMonHoc());
        	temp.inDanhSachLop();
        }
    }
	
	
	public static List<Lop> genLopTheoTkb(Lop l){
		List<Lop> kq = new ArrayList<>();
		ThoiKhoaBieu tkb = l.getTkb();
		for (Map.Entry<Integer, MonHoc> entry : l.getTkb().getDanhSach().entrySet()) {
			Lop temp = new Lop();
			temp.setDanhSach(l.getDanhSach());
			temp.setTenLop(l.getTenLop());
	    	MonHoc mh = entry.getValue();
		    temp.setMonHoc(mh.getMaMon());
		    kq.add(temp);
		}
		
		return kq;
	}
}
