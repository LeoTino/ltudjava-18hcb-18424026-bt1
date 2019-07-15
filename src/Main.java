import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Lop l = new Lop();
        FileCSV f = new FileCSV();
        f.setPathImport("Lop.csv");
        l = f.importLopCSV();
        //System.out.println("tém tém lại giùm cái");
    }
}
