package model;


import java.io.File;
import java.util.ArrayList;

public interface IModel {
	
	
	abstract void updateData(Object a);
	abstract boolean loadData(String string);
	abstract String DataToAString();
	abstract boolean saveData(String string);
	abstract void setCompared();
	abstract boolean getCompared();
	
	
}
