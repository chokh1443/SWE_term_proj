package model;


import java.io.File;
import java.util.ArrayList;

public interface IModel {
	ArrayList<String> Data = new ArrayList<String>();
	
	abstract void updateData(Object a);
	abstract boolean loadData(String string);
	abstract String DataToAString();
	abstract boolean saveData(String string);
	
	
}
