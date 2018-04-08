package preprocess;

import java.util.*;
import java.io.*;

public class FFMInputStringFields {

	public static void writeFFMInput(String inputFile1, String inputFile2, String outputFile1, String outputFile2) throws IOException{
		String line;
		Map<Integer,Map<String,Long>>fieldIndexValue = new LinkedHashMap<Integer,Map<String,Long>>();
		long max = 0;
		System.out.println("max is: "+max);
		PrintWriter printWriter1 = new PrintWriter(new BufferedWriter(new FileWriter(outputFile1)));
		PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(outputFile2)));

		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile1)))) {
			line = br.readLine();
			String [] header = line.split(",");
			for(int i = 0 ; i < header.length ; i++){
				fieldIndexValue.put(i, new LinkedHashMap<String, Long>());
			}
			long featureCounter = 0;
			while ((line = br.readLine()) != null) {
//				String [] array = line.split("\t");
				String[] array = line.replaceAll("^\"", "").split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
				printWriter1.print(array[array.length-1]+" ");
				for(int i = 0 ; i < array.length - 1; i ++){
					printWriter1.print(i+":");
					Map<String,Long> indexValue = fieldIndexValue.get(i);
					if(indexValue.containsKey(array[i])){
						long value = indexValue.get(array[i]);
						printWriter1.print(value+":"+"1 ");
					}
					else{
						indexValue.put(array[i], featureCounter);
						long value = indexValue.get(array[i]);
						printWriter1.print(value+":"+"1 ");
						featureCounter++;
						fieldIndexValue.put(i,indexValue);
					}
				}
				printWriter1.println();

			}
			max = featureCounter;
			System.out.println("max is: "+max);
		}

		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile2)))) {
			line = br.readLine();
			long featureCounter = max;
			while ((line = br.readLine()) != null) {
				String [] array = line.split("\t");
				printWriter2.print(array[array.length-1]+" ");
				for(int i = 0 ; i < array.length - 1; i ++){
					printWriter2.print(i+":");
					Map<String,Long> indexValue = fieldIndexValue.get(i);

					if(indexValue.containsKey(array[i])){
						long value = indexValue.get(array[i]);
						printWriter2.print(value+":"+"1 ");
					}
					else{
						indexValue.put(array[i], featureCounter);
						long value = indexValue.get(array[i]);
						printWriter2.print(value+":"+"1 ");
						featureCounter++;
						fieldIndexValue.put(i,indexValue);
					}
				}
				printWriter2.println();

			}
		} catch(FileNotFoundException fne) {}
		printWriter1.close();
		printWriter2.close();

	}



}
