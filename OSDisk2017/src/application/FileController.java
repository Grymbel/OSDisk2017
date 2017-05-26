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
	
	public void printOut(){
		try{
	         FileReader fr = new FileReader (this.filename);
	         Scanner sc = new Scanner(fr);

			 //read in the file line by line
	         while (sc.hasNextLine()){
	            System.out.println(sc.nextLine());
	         }

	         fr.close();
	         sc.close();
	      }
	      catch (FileNotFoundException exception){
	         System.out.println ("The file " + this.filename + " was not found.");
	      }
	      catch (IOException exception){
	         System.out.println (exception);
	      }
	}
	
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
	
	public void appendLine(ArrayList<String> strings){
		try{
			FileWriter fw = new FileWriter(this.filename,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);

			for(int i =0;i<strings.size();i++){
			outFile.append(strings.get(i)+"\n");
			}
			
			outFile.close();
			System.out.println("Editted: " + this.filename);
	      }
	      catch (IOException exception){
	         System.out.println (exception);
	      }
	}
	
	public ArrayList<String> getData(){
		try{
	         FileReader fr = new FileReader (this.filename);
	         Scanner sc = new Scanner(fr);
	         sc.useDelimiter(";");
	         
	         ArrayList<String> toRet = new ArrayList<String>();

			 //read in the file line by line
	         while (sc.hasNextLine()){
	            toRet.add(sc.next());
	         }

	         fr.close();
	         sc.close();
	         
	         return toRet;
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
	public boolean isMyFileFilled(){
		try{
	         FileReader fr = new FileReader (this.filename);
	         Scanner sc = new Scanner(fr);
	         sc.useDelimiter(";");
	         
			 //read in the file line by line
	         while (sc.hasNextLine()){
	        	 fr.close();
		         sc.close();
		         
		         return true;
	         }
	         sc.close();
	         
	      }
	      catch (FileNotFoundException exception){
	         System.out.println ("The file " + this.filename + " was not found.");
	      }
	      catch (IOException exception){
	         System.out.println (exception);
	      }
		System.out.println("File's Empty");
		return false;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	}
