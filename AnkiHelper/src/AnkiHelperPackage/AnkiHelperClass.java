package AnkiHelper.src.AnkiHelperPackage;
import java.util.*;
import java.io.*;
public class AnkiHelperClass {
	public static void main(String[] args) {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile)); BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if(i >= 2) {
					String[] leftAndRight = line.split("\t");
					int index = leftAndRight[2].indexOf('(');
					leftAndRight[1] = leftAndRight[2].substring(0, index - 1);
					leftAndRight[2] = leftAndRight[2].substring(index);
					String newLine = leftAndRight[1] + "\t" + leftAndRight[0] + " " + leftAndRight[2];
					bufferedWriter.write(newLine);
					bufferedWriter.newLine();
					i++;
				}
				else {
					bufferedWriter.write(line);
					bufferedWriter.newLine();
					i++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error opening the file. Make sure the 'input.txt' is in the root folder of the project directory. Also make sure read/write permissions are enabled.");
		}

	}
}