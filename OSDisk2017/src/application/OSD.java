package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OSD {
	private String inputData = System.getProperty("user.dir")+"/src/application/data/OSDData.txt";
	private int previous;
	private int current;
	private int cylinders;
	
	private int inputLength;
	private ArrayList<Integer> dataList = new ArrayList<Integer>();
	
	public OSD(int prev, int curr, int cyl, int inputLength){
		
		if(inputLength>cyl){
			System.out.println("InputLength-2 Larger than CYL");
		}
		else{
		this.previous=prev;
		this.current=curr;
		this.cylinders=cyl;
		this.inputLength=inputLength;
		}
	}
	
	public OSD(int prev, int curr, int cyl, String sequence){
		
		this.previous=prev;
		this.current=curr;
		this.cylinders=cyl;
		this.inputLength=0;
		Scanner sc = new Scanner(sequence);
		sc.useDelimiter(",");
		
		while(sc.hasNext()){
			this.dataList.add(Integer.parseInt(sc.next()));
			inputLength++;
		}
		if(inputLength>cyl){
			System.out.println("INPUT LENGTH LONGER THAN CYNLINDERS ALLOW");
		}
		sc.close();
	}
	
	public OSD(){
		FileController fc = new FileController(inputData);
		Scanner sc = new Scanner(fc.printOut());
		
		sc.useDelimiter(";");
		
		this.cylinders=Integer.parseInt(sc.next().replace("&", ""));
		this.previous=Integer.parseInt(sc.next());
		this.dataList.add(this.previous);
		this.current=Integer.parseInt(sc.next());
		this.dataList.add(this.current);
		
		while(sc.hasNext()){
			this.dataList.add(Integer.parseInt(sc.next()));
		}
		sc.close();
	}
	
	public String[] FCFS(){
		String[] toRet = new String[3];
		
		toRet[0]="FCFS\n====\n";
		
		String orderOfAccess = "Order of Access: ";
		
		for(int i=1;i<this.dataList.size();i++){
			orderOfAccess=orderOfAccess+this.dataList.get(i)+", ";
		}
		toRet[1]=orderOfAccess;
		
		String totalDistance="Total Distance = ";
		String higherSequence="";
		
		int total=0;
		
		for(int i=2;i<this.dataList.size();i++){
			int prev = dataList.get(i-1);
			int curr = dataList.get(i);
			if(i==2){
				totalDistance = totalDistance + "|"+prev+"-"+curr+"|";
			}else{
			totalDistance = totalDistance + "+|"+prev+"-"+curr+"|";
			}
			total=total+Math.abs(prev-curr);
			
			if(i==2){
				higherSequence = higherSequence+Math.abs(prev-curr);
			}
			else{
				higherSequence = higherSequence+"+"+Math.abs(prev-curr);
			}
		}
		
		totalDistance = totalDistance +"\n="+ higherSequence + "\n="+total;
		toRet[2]=totalDistance;
		return toRet;
	}
	
	public String[] SSTF(){
		
		String[] toRet = new String[3];
		
		int current = this.dataList.get(1);
		int[] sequence = new int[this.dataList.size()-2];
		
		for(int u=0;u<this.dataList.size()-2;u++){
			sequence[u]=this.dataList.get(u+2);
		}
		int ii=-1;
		for(int i=0;i<sequence.length;i++){
			int minimum=Integer.MAX_VALUE;
			ii=i;
			for(int j=i;j<sequence.length;j++){
				int distance = Math.abs(current-sequence[j]);
				
				if(distance<minimum){
					ii=j;
					minimum=distance;
				}
			}
			int tmp=sequence[i];
			sequence[i]=sequence[ii];
			sequence[ii]=tmp;
			current=sequence[i];
		}
		toRet[0]="SSTF\n====\n";
		
		String orderOfAccess = "Order Of Access: "+this.current;
		
		for(int p=0;p<sequence.length;p++){
			orderOfAccess=orderOfAccess+", "+sequence[p];
		}
		toRet[1]=orderOfAccess;
		
		String totalDistance="Total distance: ";
		String higherSequence="";
		int total=0;
		int prev = this.current;
		int curr = sequence[0];
		
		for(int i=1;i<sequence.length;i++){
			if(i==1){
				totalDistance = totalDistance + "|"+prev+"-"+curr+"|";
			}else{
				totalDistance = totalDistance + "+|"+prev+"-"+curr+"|";
			}
			total=total+Math.abs(prev-curr);
			
			if(i==1){
				higherSequence = higherSequence+Math.abs(prev-curr);
			}
			else{
				higherSequence = higherSequence+"+"+Math.abs(prev-curr);
			}
			prev=sequence[i-1];
			curr=sequence[i];
		}
		toRet[2]=totalDistance+"\n="+higherSequence+"\n="+total;
		return toRet;
	}
	
	public String[] CScan(){
		String[] toRet = new String[3];
		
		ArrayList<Integer>smallerThan = new ArrayList<Integer>();
		ArrayList<Integer>largerThan = new ArrayList<Integer>();
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		
		for(int i=2;i<this.dataList.size();i++){
			sequence.add(this.dataList.get(i));
		}
		for(int i=0; i<sequence.size();i++){
			int nextNum = sequence.get(i);
			if(nextNum < this.current){
				smallerThan.add(nextNum);
			}
			else if(nextNum > this.current){
				largerThan.add(nextNum);
			}
			else{
				largerThan.add(nextNum);
			}
		}
		smallerThan.add(0); //Returns to 0 after reaching the end
		largerThan.add(this.current); //Dont Leave first Num out
		
		largerThan.add(this.getCylinders());
		
		Collections.sort(smallerThan); //Make everything ascending
		Collections.sort(largerThan); //This too, ascending
		
		for(int i = 0; i < smallerThan.size()-1; i++){
			largerThan.add(largerThan.size(), smallerThan.get(i)); //Continues after 0
		}
		
		String orderOfAccess=""+largerThan.get(0);
		
		for(int i=1;i<largerThan.size();i++){
			orderOfAccess=orderOfAccess+", "+largerThan.get(i);
		}
		toRet[0]="CSCAN\n====\n";
		toRet[1]=orderOfAccess;
		return toRet;
	}
	
	public void startData(){
		
		FileController fc = new FileController(inputData);
		
		fc.clearTXT();
		
		ArrayList<String> toWrite = new ArrayList<String>();
		toWrite.add(this.cylinders+"&;");
		
		toWrite.add(this.previous+";");
		toWrite.add(this.current+";");
		
		for(int o=0;o<this.dataList.size();o++){
		toWrite.add(this.dataList.get(o)+";");
		}
		
		fc.appendLine(toWrite);
	}
	
	public void makeData(){
		FileController fc = new FileController(inputData);
		
		fc.clearTXT();
		
		ArrayList<String> toWrite = new ArrayList<String>();
		toWrite.add(this.cylinders+"&;");
		
		toWrite.add(previous+";");
		toWrite.add(current+";");
		int toAdd;

			for(int i=0;i<(inputLength-2);i++){
				toAdd=((int) (Math.random()*cylinders));
				
				if(!toWrite.contains(toAdd+";")&&toAdd!=previous&&toAdd!=current){
					toWrite.add(toAdd+";");
				}
				else{
					i--;
				}
			}
			fc.appendLine(toWrite);
			
			dataList.add(previous);
			dataList.add(current);
			
			for(int i=1;i<toWrite.size();i++){
				dataList.add(Integer.parseInt(toWrite.get(i).replace(";", "")));
			}
		}
	
	public String getDataNicely(){
		FileController ffc = new FileController(inputData);
		return ffc.getDataNicely();
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

	public ArrayList<Integer> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<Integer> dataList) {
		this.dataList = dataList;
	}
}

