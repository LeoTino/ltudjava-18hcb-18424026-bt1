import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class TaiKhoan {
	private String username;
	private String password;
	private String tenLop;
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public TaiKhoan nhapTaiKhoan() {
		System.out.println("================Đăng nhập===============");
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập username: ");
		String username = input.nextLine();
		System.out.println("Nhập password: ");
		String password = input.nextLine();
		this.username = username;
		this.password = password;
		return this;
	}
	
	public int checkDangNhap(List<TaiKhoan> ds) {
		int kq = 0; // dang nhap sai
		for(TaiKhoan tk : ds) {
			if(this.username.equals(tk.getUsername()) && this.password.equals(tk.getPassword())) {
				String role = this.role;
				if("sv".equals(tk.getRole())) {
					kq = 2;
				}
				else if("giaovu".equals(tk.getRole())) {
					kq = 1;
				}
				else {
					kq = 0;
				}
			}
		}
		return kq;
	}
	
	public boolean checkExist(List<TaiKhoan> ds) {
		boolean kq = false;
		for(TaiKhoan tk : ds) {
			if(this.username.equals(tk.getUsername())) {
				kq = true;
				break;
			}
		}
		return kq;
	}
}
