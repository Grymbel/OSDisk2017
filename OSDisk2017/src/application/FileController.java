package application;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileController {
	private String filename;
	
	public FileController(String filename){
		this.filename=filename;
	}
	
	//Returns the data from the TXT
	public String printOut(){
		try{
	         FileReader fr = new FileReader (this.filename);
	         Scanner sc = new Scanner(fr);
	         
	         return sc.nextLine();
	      }
	      catch (FileNotFoundException exception){
	         System.out.println ("The file " + this.filename + " was not found.");
	      }
		return null;
	}
	
	//Writes a string to the TXT
	public void appendLine(String toAppend){
		try{
			FileWriter fw = new FileWriter(this.filename,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);

			outFile.append(toAppend+";");
			outFile.close();
			
			System.out.println("Editted: " + this.filename);
	      }
	      catch (IOException exception){
	         System.out.println (exception);
	      }
	   }
	
	//Formats and writes an array list to the TXT
	public void appendLine(ArrayList<String> strings){
		try{
			FileWriter fw = new FileWriter(this.filename,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);

			for(int i =0;i<strings.size();i++){
			outFile.append(strings.get(i));
			}
			
			outFile.close();
			System.out.println("Editted: " + this.filename);
	      }
	      catch (IOException exception){
	         System.out.println (exception);
	      }
	}
	
	//Wipes the TXT clean
	public void clearTXT(){
		try{
			FileWriter fw = new FileWriter(this.filename);
			fw.write("");
			fw.close();
			System.out.println("Cleared: " + this.filename);
	      }
	      catch (IOException exception){
	         System.out.println (exception);
	      }
	}
	
	//Returns a formatted output to display on the UI
	public String getDataNicely(){
		try{
	         FileReader fr = new FileReader (this.filename);
	         Scanner sc = new Scanner(fr);
	         sc.useDelimiter(";");
	         
	         String outLine="";
			 //read in the file line by line
	         
	         int every8 = 0;
	         sc.next();
	         while (sc.hasNext()){
	        	if(every8!=7){
	            outLine = outLine+" "+sc.next();
	            every8++;
	        	}
	        	else if(every8==7){
	        		outLine = outLine+" "+sc.next()+"\n";
		            every8=0;
	        	}
	         }

	         fr.close();
	         sc.close();
	         
	         return outLine;
	      }
	      catch (FileNotFoundException exception){
	         System.out.println ("The file " + this.filename + " was not found.");
	      }
	      catch (IOException exception){
	         System.out.println (exception);
	      }
		System.out.println("Something went wrong");
		return null;
	}
	
	//Getters and setters
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	}
