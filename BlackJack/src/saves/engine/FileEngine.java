package saves.engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileEngine implements AutoCloseable {
	private String file;
	private BufferedReader br;
	private BufferedWriter bw;
	private FileReader fr;
	private FileWriter fw;

	public FileEngine(String file) {
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public List<String> readAll() throws IOException {
		List<String> list = new ArrayList<String>();
		br = new BufferedReader(fr = new FileReader(file));
		String line = null;
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		fr.close();
		br.close();
		return list;
	}

	public void writeLine(String line) throws IOException {
		bw = new BufferedWriter(fw = new FileWriter(file, true));
		bw.write(line);
		bw.newLine();
		bw.close();
		fw.close();

	}

	@Override
	public void close() {
		try {
			if (br != null) {
				br.close();
			}
			if (bw != null) {
				bw.close();
			}
			if (fr != null) {
				fr.close();
			}
			if (fw != null) {
				fw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
