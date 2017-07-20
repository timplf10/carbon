/**
 * 
 */
package birch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tim
 *
 */
public class ReportItemSet {

	private ArrayList<ArrayList<String>> _allRecords;
	private BufferedWriter _bufferedWriter;

	public ReportItemSet() {
		_allRecords = new ArrayList<ArrayList<String>>();
		//_bufferedWriter = new BufferedWriter();
	}

	private String stringAL(ArrayList<String> AL2D) {
		int j;

		String output = "AL2D ";

		for (j = 0; j < AL2D.size(); j++) {
			output += " [" + Integer.toString(j) + "]" + AL2D.get(j) + "+";
		}
		return output;
	}

	private String stringALAL(ArrayList<ArrayList<String>> AL3D) {
		int i;

		String output = "AL3D...\n";

		for (i = 0; i < AL3D.size(); i++) {
			stringAL(AL3D.get(i));
			output += " [" + Integer.toString(i) + "]" + AL3D.get(i) + "\n";
		}
		output += "...AL3D\n";

		return output;
	}

	public String toString() {
		return stringALAL(_allRecords);
	}

	private String toHTML2D(ArrayList<String> AL2D) throws Exception {
		int j;

		if (AL2D.size() < 1) {
			throw new Exception("Malformed Entry");
		}

		String type = AL2D.get(0);

		String output = "";

		{
			if (type.equals("RIR_UNKNOWN")) {
				//System.out.println("Type: " + type + " is RIR_UNKNOWN");
				output = "    <tr> "; // start row
				for (j = 1; j < AL2D.size(); j++) { // n.b. start at col 1
													// rather than 0
					output += "<td>" + AL2D.get(j) + "</td> ";
				}
				output += "</tr>"; // end row
			} else if (type.equals("RIR_SUMMARY_L0")) {
				//System.out.println("Type: " + type + " is RIR_SUMMARY_L0");
				output = "    <tr class=\"SummaryL0\"> <td colspan=\"3\">Grand Total</td> "; // start
																								// row
				for (j = 4; j < AL2D.size(); j++) { // n.b. start at col 4
					output += "<td>" + AL2D.get(j) + "</td> ";
				}
				output += "</tr>"; // end row
			}
			else if (type.equals("RIR_SUMMARY_L1")) {
				//System.out.println("Type: " + type + " is RIR_SUMMARY_L1");
				output = "    <tr class=\"SummaryL1\"> <td colspan=\"3\">L1 Sub Total</td> "; // start
																								// row
				for (j = 4; j < AL2D.size(); j++) { // n.b. start at col 4
					output += "<td>" + AL2D.get(j) + "</td> ";
				}
				output += "</tr>"; // end row
			}
			else if (type.equals("RIR_SUMMARY_L2")) {
				//System.out.println("Type: " + type + " is RIR_SUMMARY_L2");
				output = "    <tr class=\"SummaryL2\"> <td colspan=\"3\">L2 Sub Total</td> "; // start
																								// row
				for (j = 4; j < AL2D.size(); j++) { // n.b. start at col 4
					output += "<td>" + AL2D.get(j) + "</td> ";
				}
				output += "</tr>"; // end row
			}
			else {
				//System.out.println("Type: " + type + " is **DEFAULT**");
				output = "    <tr class=\"SummaryL3\"> <td colspan=\"3\">L3 Sub Total</td> "; // start
																								// row
				for (j = 4; j < AL2D.size(); j++) { // n.b. start at col 4
					output += "<td>" + AL2D.get(j) + "</td> ";
				}
				output += "</tr>"; // end row
			}
		}
		return output;
	}

	private String toHTML3D(ArrayList<ArrayList<String>> AL3D) throws Exception {
		int i;

		String output = "";

		for (i = 0; i < AL3D.size(); i++) {
			output += toHTML2D(AL3D.get(i)) + "\n";
		}

		return output;
	}

	public String toHTML() throws Exception {
		return toHTML3D(_allRecords);
	}
	
	public void readPlainFile(String path, String filename) {
		Charset charset = Charset.forName("US-ASCII");
		Path file = FileSystems.getDefault().getPath(path,
				filename);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {

			String line = null;
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				writeOutputFile(line);
			}
			reader.close();
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
/*	
	Charset charset = Charset.forName("US-ASCII");
	String s = ...;
	try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
	    writer.write(s, 0, s.length());
	} catch (IOException x) {
	    System.err.format("IOException: %s%n", x);
	}
*/	
	public void openOutputFile(String path, String filename) {
		Charset charset = Charset.forName("US-ASCII");
		Path file = FileSystems.getDefault().getPath(path,
				filename);
		try {
			//BufferedWriter _bufferedWriter = Files.newBufferedWriter(file, charset);
			_bufferedWriter = Files.newBufferedWriter(file, charset);
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	public void writeOutputFile(String record) {
		try  {
		_bufferedWriter.write(record, 0, record.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	public void closeOutputFile() {
		try  {
		_bufferedWriter.close();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

	/**
	 * @param args
	 */
	public void readDataFile(String path, String filename) {

		Charset charset = Charset.forName("US-ASCII");
		String[] rowElements;
		int i, j;
		String recon = "";

		Path file = FileSystems.getDefault().getPath(path,
				filename);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {

			String line = null;
			while ((line = reader.readLine()) != null) {

				rowElements = line.split(",");

				recon = "";

				ArrayList<String> singleRecord = new ArrayList<String>();

				for (i = 0; i < rowElements.length; i++) {
					singleRecord.add(rowElements[i]);
					recon += "[" + Integer.toString(i) + "]" + rowElements[i]
							+ "|";
				}
				_allRecords.add(singleRecord);
			}
			reader.close();
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	
	public void process() throws Exception {

		openOutputFile("c:/code/birch/html", "reportXX.htm");
		readPlainFile("c:/code/birch/data", "boilerplate_start01.txt");
		readDataFile("c:/code/birch/data", "ris01.txt");
		//System.out.println(this.toHTML());
		writeOutputFile(this.toHTML());
		readPlainFile("c:/code/birch/data", "boilerplate_end01.txt");
		closeOutputFile();
	}

}
