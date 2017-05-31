package IHaveNoIdeaWhatYouDoing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ICreateMyMethodInstead {
	public static void main(String[] args) throws IOException{
		ArrayList<Integer> inteArray = new ArrayList<Integer>();
		FileLoaders fl = new FileLoaders();
		inteArray = fl.loadData(); //Loads all the "data" from the textfile
		
		ArrayList<Integer>updatedArray = CLook(inteArray); //CScan is static method cause lazy :3
		for(int a:updatedArray){
			System.out.print(a + " "); //Prints the array
		}
	}
	
	public ArrayList<Integer>FCFS(ArrayList<Integer> dataList){
		return dataList; //Give him back that already FCFS list
	}
	
	public ArrayList<Integer>SJF(ArrayList<Integer> dataList){
		Collections.sort(dataList); //Shortest so just sort to smallest?
		return dataList;
	}
	
	public static ArrayList<Integer>CScan(ArrayList<Integer> dataList){
		ArrayList<Integer>smallerThan = new ArrayList<Integer>();
		ArrayList<Integer>largerThan = new ArrayList<Integer>();
		
		int firstNum = dataList.get(0);
		for(int i=1; i<dataList.size();i++){
			int nextNum = dataList.get(i);
			if(nextNum < firstNum){
				smallerThan.add(nextNum);
			}
			else if(nextNum > firstNum){
				largerThan.add(nextNum);
			}
			else{
				largerThan.add(nextNum);
			}
		}
		smallerThan.add(0); //Returns to 0 after reaching the end
		largerThan.add(firstNum); //Dont Leave first Num out
		
		//--------Import Max Value here---------//
		//     largerThan.add(*Max Value*);		// Reaches the end before going 0
		//--------------------------------------//
		
		Collections.sort(smallerThan); //Make everything ascending
		Collections.sort(largerThan); //This too, ascending
		
		for(int i = 0; i < smallerThan.size()-1; i++){
			largerThan.add(largerThan.size(), smallerThan.get(i)); //Continues after 0
		}
		
		return largerThan;
	}
	
	public static ArrayList<Integer>CLook(ArrayList<Integer> dataList){
		ArrayList<Integer>smallerThan = new ArrayList<Integer>(); //Same as SCAN but without 2 lines
		ArrayList<Integer>largerThan = new ArrayList<Integer>();
		
		int firstNum = dataList.get(0);
		for(int i=1; i<dataList.size();i++){
			int nextNum = dataList.get(i);
			if(nextNum < firstNum){
				smallerThan.add(nextNum);
			}
			else if(nextNum > firstNum){
				largerThan.add(nextNum);
			}
			else{
				largerThan.add(nextNum);
			}
		}
		largerThan.add(firstNum); //Dont Leave first Num out
		
		Collections.sort(smallerThan); //Make everything ascending
		Collections.sort(largerThan); //This too, ascending
		
		for(int i = 0; i < smallerThan.size()-1; i++){
			largerThan.add(largerThan.size(), smallerThan.get(i)); //Continues after 0
		}
		
		return largerThan;
	}
}
