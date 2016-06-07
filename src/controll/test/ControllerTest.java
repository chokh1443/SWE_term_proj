package controll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import controll.Controller;
import model.FileModel;
import view.View;

public class ControllerTest {
	String fileAddr = System.getProperty("user.dir")+"\\FileModel.txt";
	FileModel left = new FileModel();
	FileModel right = new FileModel();
	View view = new View();
	Controller controller = null; 
	
//	@Test
//	public void testController() {
//		controller = new Controller(left, right, view);
//		assertNotNull(controller);
//	}

//	@Test
//	public void testLoad() {
//		//success of testController() means success of testLoad()
//	}

//	@Test
//	public void testSave() {
//		controller.save("left");
//	}

//	@Test
//	public void testEdit() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testCopyToLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopyToRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompare() {
		fail("Not yet implemented");
	}

}
