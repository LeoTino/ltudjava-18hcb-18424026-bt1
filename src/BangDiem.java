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
	
	public void thongKe() {
		System.out.println("Đậu: ");
		int dau = 0;
		int rot = 0;
		for (Map.Entry<Integer, Diem> entry : this.danhSach.entrySet()) {
		    Diem value = entry.getValue();
		    if(value.getTongDiem() > 5) {
		    	value.inDiem();
		    	System.out.println();
		    	dau++;
		    }
		}
		System.out.println("Rớt: ");
		for (Map.Entry<Integer, Diem> entry : this.danhSach.entrySet()) {
		    Diem value = entry.getValue();
		    if(value.getTongDiem() < 5) {
		    	value.inDiem();
		    	System.out.println();
		    	rot++;
		    }
		}
		System.out.println("Số lượng đậu/rớt: " + dau + "/" + rot);
		if(rot == 0) {
			rot = -1;
		}
		System.out.println("Phần trăm đậu/rớt: "+ (dau / rot) * 100 + "%");
	}
}