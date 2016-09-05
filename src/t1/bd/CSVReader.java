package t1.bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import t1.exceptions.UserNotFoundException;
import t1.view.objects.DadosLogin;

public class CSVReader {

	private static final String livros = "livros.csv";
	private static final String logins = "logins.csv";
	private static final String emprestimos = "emprestimos.csv";
	private static final String cvsSplitBy = ",";
	private static final String comment = "#";

	public static DadosLogin loadDadosLogin(String login)
			throws UserNotFoundException, FileNotFoundException, IOException {
		BufferedReader br = load(livros);

		String lineDados = br.lines().filter(l -> !l.startsWith(comment) && l.startsWith(login + cvsSplitBy)).findAny()
				.get();

		if (lineDados == null) {
			throw new UserNotFoundException();
		}

		String[] lineDadosArray = lineDados.split(cvsSplitBy);

		return new DadosLogin(lineDadosArray[0], lineDadosArray[1]);
	}

	private static BufferedReader load(String path) throws FileNotFoundException, IOException {
		return new BufferedReader(new FileReader(path));
	}

}
