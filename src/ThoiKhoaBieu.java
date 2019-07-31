import java.util.List;
import java.util.Map;

public class ThoiKhoaBieu {
	private List<Map<Integer,MonHoc>> danhSach;

	public List<Map<Integer, MonHoc>> getDanhSach() {
		return danhSach;
	}

	public void setDanhSach(List<Map<Integer, MonHoc>> danhSach) {
		this.danhSach = danhSach;
	}
	
	public void inThoiKhoaBieu() {
		for (Map<Integer, MonHoc> map : this.danhSach) {
		    for (Map.Entry<Integer, MonHoc> entry : map.entrySet()) {
		        int key = entry.getKey();
		        MonHoc value = entry.getValue();
		        System.out.print("STT: "+ key +", ");
		        value.inMonHoc();
		        System.out.println();
		    }
		}
	}
}
