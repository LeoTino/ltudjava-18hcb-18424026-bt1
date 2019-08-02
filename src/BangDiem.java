import java.util.Map;

public class BangDiem {
	private Map<Integer, Diem> danhSach;

	public Map<Integer, Diem> getDanhSach() {
		return danhSach;
	}

	public void setDanhSach(Map<Integer, Diem> danhSach) {
		this.danhSach = danhSach;
	}
	
	public void inBangDiem() {
		for (Map.Entry<Integer, Diem> entry : this.danhSach.entrySet()) {
		    int key = entry.getKey();
		    Diem value = entry.getValue();
		    System.out.print("STT: "+ key +", ");
		    value.inDiem();
		    System.out.println();
		}
	}
}