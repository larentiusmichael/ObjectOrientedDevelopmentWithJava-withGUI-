package assignment.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class TextDAO extends DAO {

	public TextDAO( String fileName ) {
		super(fileName);
	}

	@Override
	public List<String> readAll() { // read everything from corresponding file
		List<String> lst = new ArrayList<>();
		try( BufferedReader in = new BufferedReader( new FileReader( super.file ) ); ) {
			
			String line;
			while( (line= in.readLine()) != null ) {
				lst.add(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public void write( String record ) { // write (adding record) to corresponding file

		try( PrintWriter out = new PrintWriter( new FileWriter(super.file, true) ); ) {
			out.println( record );
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteAll() { // delete all records from corresponding file

		try( PrintWriter out = new PrintWriter(super.file); ) {
			out.print("");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public int lineNumber() { // count number of lines in the corresponding file
		int lineNumberCount = 1;
		try {
			FileReader fr = new FileReader(super.file);
			LineNumberReader lr = new LineNumberReader(fr);
			try {
				while(lr.readLine() != null) {
					lineNumberCount = lineNumberCount + 1;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lineNumberCount;
	}

}
