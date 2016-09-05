package t1.bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import t1.exceptions.UserNotFoundException;
import t1.view.objects.DadosLogin;

public class CSVReader {

	private static final String livros = "/GitHub/DSO2_T1/livros.csv";
	private static final String logins = "/GitHub/DSO2_T1/logins.csv";
	private static final String emprestimos = "/GitHub/DSO2_T1/emprestimos.csv";
	private static final String cvsSplitBy = ",";
	private static final String comment = "#";

	public static DadosLogin checkDadosLogin(String login)
			throws UserNotFoundException, FileNotFoundException, IOException {
		BufferedReader br = load(livros);

		String lineDados = br.lines().filter(l -> !l.startsWith(comment) && l.startsWith(login+cvsSplitBy)).findFirst().get();

		return null;
	}
s
	private static BufferedReader load(String path) throws FileNotFoundException, IOException {

		return new BufferedReader(new FileReader(path));
	}

}
