package view;

import java.awt.event.ActionListener;

public interface IView {
	public void attachEvent(String name, ActionListener action);
}
