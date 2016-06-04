package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class FileModel implements IModel{
	
	
	
	
	
	public boolean loadData(String address){//This function called when load a file
		Scanner loader = null;
		
		
		try { // try to open Scanner
			loader = new Scanner(new File(address));
		} catch (FileNotFoundException e) {
			System.out.println("Load failed in FileModel.loadData()");
			e.printStackTrace();
			return false; //fail to read 
		}
		
		
		while(loader.hasNextLine()){ //Load file into ArrayList<String> Data
			Data.add(loader.nextLine());
		}

		/*
		for(int i =0; i<Data.size(); i++){//for the real quik test to make sure read.
			System.out.println(Data.get(i));
		}*/
		
		loader.close();
		return true; //done
	}
	
	public String DataToAString(){
		String result="";
		
		for(int i =0; i < Data.size(); i++){
			result += Data.get(i);
			result +="\n";
		}
		
		System.out.println(result); // quik test
		
		return result;
	}

	
	public void updateData(Object a) {
	
		
	}
	

}
