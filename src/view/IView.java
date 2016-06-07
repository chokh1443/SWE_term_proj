package view;

import java.awt.event.ActionListener;

public interface IView {
	public void attachEvent(ActionListener action);
	public void showData(String side, String data);	
	public void switchTextAreaEditable(String side);
	public void showDiffArea(int[] side, String data);
}