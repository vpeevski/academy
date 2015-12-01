package debts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Vector;

public final class DebtReader {

	public Vector<Vector<String>> readDebts(String path) throws IOException {
		File debtsFile = new File(path);
		FileReader fileReader = new FileReader(debtsFile);
		BufferedReader reader = null;
		String line = new String();
		Vector<Vector<String>> debts = new Vector<Vector<String>>();
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(debtsFile), "UTF8"));
			;
			while ((line = reader.readLine()) != null) {
				String[] lineStr = line.replace("|", ":").split(":");
				Vector<String> vectoLine = new Vector<String> (Arrays.asList(lineStr));
				debts.add(vectoLine);
			}
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

//		File fileDir = new File("resources/debts_out.txt");
//		writeDebts(strBuilder.toString(), fileDir);
		return debts;
	}

	public void writeDebts(String fileContent, File fileDir) throws IOException {
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileDir), "UTF8"));
		try {
			out.append(fileContent);
			out.flush();
		} finally {
			out.close();
		}

	}

}
