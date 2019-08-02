import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCSV {
	private String pathImport;
	//private String pathExport;

	
	public Lop importLopCSV() throws FileNotFoundException {
		Lop kq = new Lop();
		BufferedReader br = null;
		Map<Integer, SinhVien> dsLop = new HashMap<>();
        try {   
            br = new BufferedReader(new FileReader(this.pathImport));

            String textInALine;
            //bo dong dau
            br.readLine();
            //STT,MSSV,HOTEN,GIOITINH,CMND
            while ((textInALine = br.readLine()) != null) {
                //System.out.println(textInALine);
                String[] words = textInALine.split(",");
                int stt = Integer.parseInt(words[0]);
                SinhVien sv = new SinhVien();
                sv.setMssv(Long.parseLong(words[1]));
                sv.setHoTen(words[2]);
                sv.setGioiTinh(words[3]);
                sv.setCmnd(words[4]);
                
                dsLop.put(stt, sv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        kq.setDanhSach(dsLop);
		return kq;
	}
	
	public ThoiKhoaBieu importTKBCSV() throws FileNotFoundException {
		ThoiKhoaBieu kq = new ThoiKhoaBieu();
		BufferedReader br = null;
		Map<Integer, MonHoc> dsMon = new HashMap<>();
        try {   
            br = new BufferedReader(new FileReader(this.pathImport));

            String textInALine;
            //bo dong dau
            br.readLine();
            //STT,MaMon, TenMH, Phong hoc
            while ((textInALine = br.readLine()) != null) {
                //System.out.println(textInALine);
                String[] words = textInALine.split(",");
                int stt = Integer.parseInt(words[0]);
                MonHoc mh = new MonHoc();
                mh.setMaMon(words[1]);
                mh.setTenMon(words[2]);
                mh.setPhongHoc(words[3]);
                
                Map<Integer,MonHoc> map = new HashMap<>();
                dsMon.put(stt, mh);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        kq.setDanhSach(dsMon);
		return kq;
	}



	public String getPathImport() {
		return pathImport;
	}



	public void setPathImport(String pathImport) {
		this.pathImport = pathImport;
	}
}
