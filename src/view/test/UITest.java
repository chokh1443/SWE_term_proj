package view.test;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.View;

public class UITest {
	
	private FrameFixture demo;

	@Before
	public void setup() {
		demo = new FrameFixture(new View());
	}

	@Test
	public void test() {
		demo.button("editLeft").click();
	}
}
