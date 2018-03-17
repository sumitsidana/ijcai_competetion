package preProcess;
import java.util.*;
import java.io.*;

public class WriteFFMInput {

	public static void writeFFMInput(String inputFile1, String inputFile2, String outputFile1, String outputFile2) throws IOException{
		String line;
		Map<String,Map<String,Long>>fieldIndexValue = new LinkedHashMap<String,Map<String,Long>>();
		PrintWriter printWriter1 = new PrintWriter(new BufferedWriter(new FileWriter(outputFile1, true)));
		PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(outputFile2, true)));
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile1)))) {
			line = br.readLine();
			int indextobeignored = -1;
			String [] header = line.split("\t");
			for(int i = 0 ; i < header.length ; i++){
				if(header[i].equals("utcdate")){
					indextobeignored = i;
					continue;
				}
				fieldIndexValue.put(header[i], new LinkedHashMap<String,Long>());
			}
			//			printWriter.println(line);
			while ((line = br.readLine()) != null) {
				String [] array = line.split("\t");
				printWriter1.print(array[array.length-1]+" ");
				for(int i = 0 ; i < array.length - 1; i ++){
					if(i==indextobeignored){
						continue;
					}
					printWriter1.print(i+":");
					Map<String,Long> indexValue = fieldIndexValue.get(header[i]);

					if(indexValue.containsKey(array[i])){
						long value = indexValue.get(array[i]);
						printWriter1.print(value+":"+"1 ");
					}
					else{
						long value = indexValue.size();
						indexValue.put(array[i], value);
						printWriter1.print(value+":"+"1 ");
					}

				}
				printWriter1.println();

			}
			// TODO Auto-generated method stub
		}
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile2)))) {
			line = br.readLine();
			int indextobeignored = -1;
			String [] header = line.split("\t");
			for(int i = 0 ; i < header.length ; i++){
				if(header[i].equals("utcdate")){
					indextobeignored = i;
					continue;
				}
			}
			while ((line = br.readLine()) != null) {
				String [] array = line.split("\t");
				printWriter2.print(array[array.length-1]+" ");
				for(int i = 0 ; i < array.length - 1; i ++){
					if(i==indextobeignored){
						continue;
					}
					printWriter2.print(i+":");
					Map<String,Long> indexValue = fieldIndexValue.get(header[i]);

					if(indexValue.containsKey(array[i])){
						long value = indexValue.get(array[i]);
						printWriter2.print(value+":"+"1 ");
					}
					else{
						long value = indexValue.size();
						indexValue.put(array[i], value);
						printWriter2.print(value+":"+"1 ");
					}
				}
				printWriter2.println();

			}
		}
		printWriter1.close();
		printWriter2.close();
	}
}
