package model;


import java.util.ArrayList;

public interface IModel {
	ArrayList<String> Data = new ArrayList<String>();
	
	abstract void updateData(Object a);
	abstract boolean loadData(String address);
	abstract String DataToAString();
}
