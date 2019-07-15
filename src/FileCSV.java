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
		List dsLop = new ArrayList<>();
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
                
                Map<Integer,SinhVien> map = new HashMap<>();
                map.put(stt, sv);
                dsLop.add(map);
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



	public String getPathImport() {
		return pathImport;
	}



	public void setPathImport(String pathImport) {
		this.pathImport = pathImport;
	}
}
