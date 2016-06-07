package model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.FileModel;

public class FIleModelTest {
	String fileAddr = System.getProperty("user.dir")+"\\FileModel.txt";
	FileModel model = new FileModel();
	
	@Test
	public void testLoadData() {
		assertTrue(model.loadData(fileAddr));
	}

	@Test
	public void testDataToAString() {
		assertNotNull(model.DataToAString());
	}
	@Test
	public void testSaveData() {
		assertTrue(model.saveData(fileAddr));	
	}
}
