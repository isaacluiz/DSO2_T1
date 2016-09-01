package t1.bd;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {
	
	private static final char SEPARADOR = ',';

    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, SEPARADOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separadores) throws IOException {
        writeLine(w, values, separadores, ' ');
    }

    //https://tools.ietf.org/html/rfc4180
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public static void writeLine(Writer w, List<String> values, char separadores, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separadores == ' ') {
            separadores = SEPARADOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separadores);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
}
