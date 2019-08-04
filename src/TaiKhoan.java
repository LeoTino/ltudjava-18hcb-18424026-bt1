import java.util.Scanner;

public class TaiKhoan {
	private String username;
	private String password;
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
}
