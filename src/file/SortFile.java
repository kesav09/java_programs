package file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortFile {

	public static void main(String[] args) {
		String name = "/Users/gupadhyay/Documents/test_sort";

		SortFile test = new SortFile();
		try {
			test.sortFile(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortFile(String name) throws Exception {
		File file = new File(name);
		FileReader read = new FileReader(file);
		BufferedReader br = new BufferedReader(read);
		List lines = new ArrayList();
		while (br.read() > 0) {
			String test = br.readLine();
			if (test != null)
				lines.add(br.readLine());
		}
		Collections.sort(lines);

		File output = new File("/Users/gupadhyay/Desktop/test_output");
		FileWriter write = new FileWriter(output);

		for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
			String str = (String) iterator.next();
			write.write(str);
		}
		if (read != null)
			read.close();
		if (write != null)
			write.close();

	}
}