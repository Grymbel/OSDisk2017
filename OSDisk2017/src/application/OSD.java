package application;

import java.io.File;
import java.util.ArrayList;

public class OSD {
	private String inputData = "OSDData.txt";
	private int previous;
	private int current;
	private int cylinders;
	
	private int inputLength;
	private ArrayList<Integer> dataList = new ArrayList<Integer>();
	
	public OSD(int prev, int curr, int cyl, int inputLength){
		this.previous=prev;
		this.current=curr;
		this.cylinders=cyl;
		this.inputLength=inputLength;

	}
	
	public void makeData(){
		
		FileController fc = new FileController(inputData);
		ArrayList<String> toWrite = new ArrayList<String>();
		toWrite.add(previous+";");
		toWrite.add(current+";");
		int toAdd;

			for(int i=0;i<inputLength;i++){
				toAdd=((int) (Math.random()*cylinders));
				
				if(!toWrite.contains(toAdd)||toAdd==previous||toAdd==current){
					toWrite.add(toAdd+";");
				}
			}
			fc.appendLine(toWrite);
		}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

	public int getInputLength() {
		return inputLength;
	}

	public void setInputLength(int inputLength) {
		this.inputLength = inputLength;
	}
}
