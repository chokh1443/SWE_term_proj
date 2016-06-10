package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IView {
	public void attachEvent(ActionListener action);
	public void showData(String side, String data);	
	public void switchTextAreaEditable(String side);
	public void highLight(String side, int[] diff);
	public int getCursor(String side);
	public ArrayList<String> StringToData(String side);
}