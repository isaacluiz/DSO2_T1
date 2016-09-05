package t1.bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	public static void main(String[] args) {

        String livros = "/GitHub/DSO2_T1/livros.csv";
        String logins = "/GitHub/DSO2_T1/logins.csv";
        String emprestimos = "/GitHub/DSO2_T1/emprestimos.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(livros));
            while ((line = br.readLine()) != null) {
            	
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
