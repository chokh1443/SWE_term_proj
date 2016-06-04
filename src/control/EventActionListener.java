package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FileModel;

public class EventActionListener implements IController{
	ActionListener loadLeftAction;
	ActionListener saveLeftAction;
	ActionListener editLeftAction;
	ActionListener loadRightAction;
	ActionListener saveRightAction;
	ActionListener editRightAction;
	ActionListener copyToLeftAction;
	ActionListener copyToRightAction;
	ActionListener compareAction;
	
	public void setup() {
		loadLeftAction = new ELoadLeft(left);
		
		view.attachEvent("loadLeft",loadLeftAction);
	}
	public class ELoadLeft implements ActionListener {
		FileModel fileModel;
		ELoadLeft(FileModel fm){
			this.fileModel = fm;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			this.fileModel.loadData("test");
		}
		
	}
//	
//	if (name.equals())
//		loadLeft.addActionListener(action);
//	else if(name.equals("saveL"))
//		saveLeft.addActionListener(action);
//	else if(name.equals("editL"))
//		editLeft.addActionListener(action);
//	else if(name.equals("loadR"))
//		loadRight.addActionListener(action);
//	else if(name.equals("saveR"))
//		saveRight.addActionListener(action);
//	else if(name.equals("editR"))
//		editRight.addActionListener(action);
//	else if(name.equals("copy2L"))
//		copyToLeft.addActionListener(action);
//	else if(name.equals("copy2R"))
//		copyToRight.addActionListener(action);
//	else if(name.equals("compare"))
//		compare.addActionListener(action);
}
