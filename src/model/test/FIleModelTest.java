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
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateData() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveData() {
		fail("Not yet implemented");
	}

}
