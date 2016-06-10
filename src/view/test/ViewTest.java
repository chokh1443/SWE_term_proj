package view.test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Test;

import view.View;

public class ViewTest {
	View v = new View();
	@Test
	public void testMake() {
		v.make();
	}

	@Test
	public void testAttachEvent() {
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		};
		v.attachEvent(action);
	}

	@Test
	public void testShowData() {
		v.showData("left", "abc");
		v.showData("right", "def");
	}

	@Test
	public void testSwitchTextAreaEditable() {
		v.switchTextAreaEditable("left");
		v.switchTextAreaEditable("right");
	}

	@Test
	public void testEnableText() {
		v.enableText("left");
		v.enableText("right");
	}

	@Test
	public void testDisableText() {
		v.disableText("left");
		v.disableText("right");
	}

	@Test
	public void testHighLight() {
		int[] a = {0};
		v.highLight("left", a);
	}

	@Test
	public void testGetCursorString() {
		assertNotNull(v.getCursor("left"));
	}

	@Test
	public void testStringToData() {
		v.StringToData("left");
	}

}
