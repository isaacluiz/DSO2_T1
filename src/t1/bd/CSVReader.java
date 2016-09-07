package t1.bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import t1.exceptions.BookNotFoundException;
import t1.exceptions.UserNotFoundException;
import t1.view.dados.ListaLivrosEmprestados;
import t1.view.objects.DadosLogin;
import t1.view.objects.Livro;

public class CSVReader {

	private static final String LIVROS = "livros.csv";
	private static final String LOGINS = "logins.csv";
	private static final String EMPRESTIMOS = "emprestimos.csv";
	private static final String CVS_SPLIT = ",";
	private static final String COMMENT = "#";

	public static Livro loadDadosLivrosById(String id)
			throws FileNotFoundException, IOException, BookNotFoundException {
		BufferedReader br = load(LIVROS);

		String line = null;
		try {
			line = br.lines().filter(l -> !l.startsWith(COMMENT) && l.startsWith(id + CVS_SPLIT)).findAny().get();
		} catch (NoSuchElementException e) {
			throw new BookNotFoundException();
		}

		String[] lineArray = line.split(CVS_SPLIT);

		Livro livro = new Livro();
		livro.setID(Long.valueOf(lineArray[0]));
		livro.setTituloLivro(lineArray[1]);
		livro.setNomeAutor(lineArray[2]);

		return livro;
	}

	public static ListaLivrosEmprestados loadAllLivrosByUserId(String login)
			throws UserNotFoundException, FileNotFoundException, IOException {
		BufferedReader br = load(EMPRESTIMOS);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Map<String, List<Livro>> map = new HashMap<>();

		br.lines().filter(l -> !l.startsWith(COMMENT)).forEach(line -> {
			String[] lineArray = line.split(CVS_SPLIT);
			Livro livro = null;
			try {
				livro = loadDadosLivrosById(lineArray[0]);
				livro.setDataDevolucao(formatter.parse(lineArray[3]));
				livro.setDataRetirada(formatter.parse(lineArray[2]));

				if (map.get(lineArray[1]) == null) {
					map.put(lineArray[1], new ArrayList<Livro>());
				}
				map.get(lineArray[1]).add(livro);
			} catch (IOException | BookNotFoundException | ParseException e) {
				e.printStackTrace();
			}

		});

		return new ListaLivrosEmprestados(map);
	}

	public static DadosLogin loadDadosLogin(String login)
			throws UserNotFoundException, FileNotFoundException, IOException {
		BufferedReader br = load(LOGINS);

		String lineDados = null;
		try {
			lineDados = br.lines().filter(l -> !l.startsWith(COMMENT) && l.startsWith(login + CVS_SPLIT)).findAny()
					.get();
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException();
		}

		String[] lineDadosArray = lineDados.split(CVS_SPLIT);

		return new DadosLogin(lineDadosArray[0], lineDadosArray[1]);
	}

	private static BufferedReader load(String path) throws FileNotFoundException, IOException {
		return new BufferedReader(new FileReader(path));
	}

}
