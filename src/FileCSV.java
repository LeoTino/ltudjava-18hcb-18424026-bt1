import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCSV {
	private String pathImport;
	//private String pathExport;

	
	public Lop importLopCSV() throws FileNotFoundException {
		Lop kq = new Lop();
		BufferedReader br = null;

        try {   
            br = new BufferedReader(new FileReader(this.pathImport));

            String textInALine;
            //bo dong dau
            br.readLine();
            //STT,MSSV,HOTEN,GIOITINH,CMND
            while ((textInALine = br.readLine()) != null) {
                //System.out.println(textInALine);
                String[] words = textInALine.split(",");
                for(String w : words) {
                	System.out.println(w);
                }
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
		return kq;
	}



	public String getPathImport() {
		return pathImport;
	}



	public void setPathImport(String pathImport) {
		this.pathImport = pathImport;
	}
}
