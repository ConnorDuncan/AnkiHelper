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
            	if(i >= 3) {
            		String[] leftAndRight = line.split("\t");
					String english = leftAndRight[1].substring(leftAndRight[1].indexOf('(') + 1, leftAndRight[1].indexOf(')'));
            		leftAndRight[1] = leftAndRight[1].substring(0, leftAndRight[1].indexOf('('));
            		//System.out.println(leftAndRight[0]); // This will be index 1 for output
            		//System.out.println(leftAndRight[1]); // This will be index 0 for output
            		//System.out.println(leftAndRight[2]); // This will be index 2 for output
            		String newLine = english + "\t" + leftAndRight[0] + " (" + leftAndRight[1].substring(0, leftAndRight[1].length() - 1) + ")";
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
