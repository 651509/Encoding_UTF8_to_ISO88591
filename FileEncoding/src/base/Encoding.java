package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class Encoding {
	
	private static final String INPUT_FILENAME = "data/input/texting.txt";
	
	private static final String OUTPUT_FILENAME = "data/output/out_texting.txt";

	public static void main(String[] args) throws IOException {
		Charset iso88591charset = Charset.forName("ISO-8859-1");
		/*String str = "cracking,ä,ö,ü,the,RC,Passages,requireof,time,to,月,understand,水";
		System.out.println(str);
		byte[] try1 = str.getBytes(iso88591charset);
		System.out.println(new String(try1,iso88591charset));*/
		byte[] utf8bytes = null;

		try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILENAME));
				BufferedWriter bw = new BufferedWriter
					    (new OutputStreamWriter(new FileOutputStream(OUTPUT_FILENAME), iso88591charset));) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				utf8bytes = sCurrentLine.getBytes(iso88591charset);
				bw.write(new String(utf8bytes, iso88591charset));
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}