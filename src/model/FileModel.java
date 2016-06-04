package model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class FileModel implements IModel{
	
	public boolean loadData(String fileAddress){//This function called when load a file
		Scanner loader = null;
	
		try { // try to open Scanner
			loader = new Scanner(new File(fileAddress));
		} catch (FileNotFoundException e) {
			System.out.println("Load failed in FileModel.loadData()");
			e.printStackTrace();
			return false; //fail to read 
		}
		
		Data.clear();
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

	@Override
	public boolean saveData(String fileAddress) {
		File file = new File(fileAddress);
		try {
			file.delete();
		} catch (Exception e) {
			System.out.println("Delete failed in FileModel.saveData()");
		}
		
		try { // try to open Scanner
			BufferedWriter out = new BufferedWriter(new FileWriter(fileAddress));
			for(String s : this.Data) {
				out.write(s);
				out.newLine();
				System.out.println("1");
			}
			System.out.println("2");
			out.close();
		} catch (IOException e) {
			System.out.println("Load failed in FileModel.saveData()");
			e.printStackTrace();
			return false; //fail to read 
		}
		return true;
	}
	

}
