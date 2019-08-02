import java.util.List;
import java.util.Map;

public class ThoiKhoaBieu {
	private Map<Integer,MonHoc> danhSach;
	
	public Map<Integer, MonHoc> getDanhSach() {
		return danhSach;
	}

	public void setDanhSach(Map<Integer, MonHoc> danhSach) {
		this.danhSach = danhSach;
	}

	public void inThoiKhoaBieu() {
		for (Map.Entry<Integer, MonHoc> entry : this.danhSach.entrySet()) {
			int key = entry.getKey();
	        MonHoc value = entry.getValue();
	        System.out.print("STT: "+ key +", ");
	        value.inMonHoc();
	        System.out.println();
		}
	}
}
