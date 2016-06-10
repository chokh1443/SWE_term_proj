package controll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import controll.Controller;
import model.FileModel;
import model.ModelProcessing;
import view.View;

public class ControllerTest {
	//String fileAddr = System.getProperty("user.dir")+"\\FileModel.txt";
	FileModel left = new FileModel();
	FileModel right = new FileModel();
	ModelProcessing mp = new ModelProcessing(left, right);
	View view = new View();
	Controller controller = null; 
	
	@Test
	public void testController() {
		controller = new Controller(mp, view);
		controller.setup();
		assertNotNull(controller);
	}

	@Test
	public void testLoad() {
		//success of testController() means success of testLoad()
	}

	@Test
	public void testSave() {
		//should be tested on GUI side
	}

	@Test
	public void testEdit() {
		//should be tested on GUI side
	}

	@Test
	public void testCopyToLeft() {
		//should be tested on GUI side
	}

	@Test
	public void testCopyToRight() {
		//should be tested on GUI side
	}

	@Test
	public void testCompare() {
		//should be tested on GUI side
	}

}
