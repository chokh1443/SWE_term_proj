package model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.FileModel;
import model.ModelProcessing;

public class ModelProcessingTest {
	String fileAddr = System.getProperty("user.dir")+"\\FileModel.txt";
	String fileAddr2 = System.getProperty("user.dir")+"\\FileModel2.txt";
	FileModel left = new FileModel();
	FileModel right= new FileModel();
	ModelProcessing mp;
	
	@Test
	public void testModelProcessing() {
		left.loadData(fileAddr);
		right.loadData(fileAddr2);
		mp = new ModelProcessing(left,right);
	}

	@Test
	public void testCompare() {
		testModelProcessing();
		mp.compare();
	}

	@Test
	public void testCopyToRight() {
		testCompare();
		mp.copyToRight(0);
	}

	@Test
	public void testCopyToLeft() {
		testCompare();
		mp.copyToLeft(0);
	}

	@Test
	public void testGetLeft() {
		testCompare();
		mp.getLeft();
	}

	@Test
	public void testGetRight() {
		testCompare();
		mp.getRight();
	}

	@Test
	public void testGetLeftArea() {
		testCompare();
		mp.getLeftArea();
	}

	@Test
	public void testGetRightArea() {
		testCompare();
		mp.getRightArea();
	}

}
