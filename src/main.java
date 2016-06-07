import controll.Controller;
import controll.IController;
import model.FileModel;
import model.ModelProcessing;
import view.View;

public class main {
	public static void main (String[] args){
		FileModel leftModel = new FileModel();
		FileModel rightModel = new FileModel();
		ModelProcessing mProcessing = new ModelProcessing(leftModel, rightModel);
		View mainView = new View();
		
		
		IController a = new Controller(mProcessing, mainView);
		
		
		
		/*  a.loadData("C:\\Users\\Hodong\\Desktop\\소공\\workspace\\simpleMerge\\src\\a.c"); // 아무소스코드나 주소 갖다 넣는곳
		a.DataToAString();
		
		
		Controler(view, model){
			view Iview1 = new view();
			model Imodel = new FileModel();
			
			loadFunction(){
				
			}
		}
		
		
		
		
		model(FileModel1, FileModel2)*/
	}
}
