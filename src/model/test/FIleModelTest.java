package model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.FileModel;

public class FIleModelTest {

	@Test
	public void testLoadData() {
		String fileAddr = System.getProperty("user.dir")+"\\FileModel.txt";
		FileModel model = new FileModel();
		assertTrue(model.loadData(fileAddr));
	}

	@Test
	public void testDataToAString() {
		String fileAddr = System.getProperty("user.dir")+"\\FileModel.txt";
		FileModel model = new FileModel();
		model.loadData(fileAddr);
		assertNotNull(model.DataToAString());
	}


	@Test
	public void testSaveData() {
		String fileAddr = System.getProperty("user.dir")+"\\FileModel.txt";
		FileModel model = new FileModel();
		model.loadData(fileAddr);
		assertTrue(model.saveData(fileAddr));	
	}
}
