package IHaveNoIdeaWhatYouDoing;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoaders {
	final String fileDir = "src/IHaveNoIdeaWhatYouDoing/data.txt";
	
	public ArrayList<Integer> loadData() throws IOException{
		FileReader fr = new FileReader(fileDir);
        Scanner sc = new Scanner(fr);
        sc.useDelimiter(",");
        
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        
        while(sc.hasNext()){
        	arrayList.add(sc.nextInt());
        }
        
        sc.close();
        fr.close();
        
        return arrayList;
	}
	
	public void writeData(ArrayList<Integer> arrayList) throws IOException{
		FileWriter fw = new FileWriter(fileDir,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter outFile = new PrintWriter(bw);
		
		outFile.append("" + arrayList.get(0));
		arrayList.remove(0);
		for(Integer a:arrayList){
			outFile.append("," + a);
		}
		
		outFile.close();
		bw.close();
		fw.close();
	}
}
