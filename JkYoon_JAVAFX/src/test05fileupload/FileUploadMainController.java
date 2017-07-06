package test05fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * @class : FileUploadMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : 파일업로드 Controller 와 다운로드를 같이 한다.
 * 
 * 
 * 
 * 
 * 
 */
public class FileUploadMainController implements Initializable {
 
	// 파일 정보를 가지는 객체
	File _file;
	// 파일 업로드 되었는지 알려주는 label
	@FXML Label label;
	// 파일명 넣을 textFiled
	@FXML TextField txtField;
	// 파일열기 버튼
	@FXML Button btnOpen;
	// 파일 업로드 버튼
	@FXML Button btnUpload;
	
	@FXML Hyperlink linkDown;
	
	// imageView 파일 업로드한 이미지를 볼곳
	@FXML ImageView viewImage;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 초기화 이벤트
		initEvent();
		
	}

	/**
	 * @method : initEvent
	 * @parmam : 
	 * @return : void
	 * @description : 초기화 이벤트
	 */
	private void initEvent() {
		 System.out.println("initEvent()");
		 // 파일오픈 이벤트
        btnOpen.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
            	System.out.println("111111111111");
            	// 파일을 다루는 FX의 컨포넌트
                FileChooser fileChooser = new FileChooser();
                // 파일처음위치
                fileChooser.setInitialDirectory(new File("D:/"));
                //파일 확장자 설정
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
                //파일 확장자 설정
                fileChooser.getExtensionFilters().add(extFilter);
                
                //Stage stage = (Stage) txtField.getScene().getWindow();
                
                _file = fileChooser.showOpenDialog(null);
                
                if(_file!=null){
                	txtField.setText(_file.getName());
                }
                
                Image image = null;
                // 파일의 경로
				image = new Image(_file.toURI().toString());
                
                // 이미지 뷰어에 셋팅
                viewImage.setImage(image);
                
                System.out.println("file.getParent() = "+_file.getParent());
                System.out.println("file.toString() : " + _file.toString());
                System.out.println("file : " + _file);
            }
        });
        
       // 파일 업로드 이벤트
       btnUpload.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent arg0) {
        	   System.out.println("2222");
        	   try {
        		   if(_file != null){
        			   // 파일 업로드 메소드
        			   fileUpload();
        		   }else{
        			   txtField.setText("파일이 존재하지 않습니다.");
        		   }
        		   
            		
        	   } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
        	   }
           }

       });
       
       // 파일 다운로드 이벤트
       linkDown.setOnAction(new EventHandler<ActionEvent>(){
    	   @Override
	       public void handle(ActionEvent arg0) {
    		   System.out.println("linkDown.setOnAction");
    		   FileChooser fileChooser = new FileChooser();
    		   
               //확장자를 설정한다.
               FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
               fileChooser.getExtensionFilters().add(extFilter);
               
               //Stage stage = (Stage) txtField.getScene().getWindow();
               
               File file = fileChooser.showSaveDialog(null);
               if(file != null){
            	   
                   System.out.println(file);
                   try {
     	     		  fileDownload(file);
     	     	  } catch (Exception e) {
     					// TODO Auto-generated catch block
     					e.printStackTrace();
     	     	  }
               }
	     	
	        }
       });
	}
	

	/**
	 * @method : fileUpload
	 * @parmam : 
	 * @return : void
	 * @description : 파일업로드 
	 */
	private void fileUpload() throws Exception {
		
		BufferedInputStream dis = new BufferedInputStream(new FileInputStream(_file));
		// 파일을 src/test05fileupload/위치에 올린다.
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/test05fileupload/"+_file.getName()));
		
		int b = 0;
		while((b = dis.read())!=-1){
          // FileOutputStream에 읽은 데이터를 출력한다.
			bos.write(b);
		}
		
		bos.close();
		label.setText("파일업로드가 되었습니다.");
		linkDown.setText(_file.getName());
		System.out.println("파일업로드가 되었습니다.");
		
	}
	
	
	/**
	 * @method : fileDownload
	 * @parmam : 
	 * @return : void
	 * @throws Exception 
	 * @description : 파일 다운로드
	 */
	private void fileDownload(File file) throws Exception {
		System.out.println("src/test05fileupload/"+_file.getName());
		
		BufferedInputStream dis = new BufferedInputStream(new FileInputStream("src/test05fileupload/"+_file.getName()));
		
		//확장자가 저장이 안되는 현상때문에 넣었음.
		String extension = _file.getName().substring(_file.getName().lastIndexOf('.'), _file.getName().length());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file+extension));
		int b = 0;
		while((b = dis.read())!=-1){
          // FileOutputStream에 읽은 데이터를 출력한다.
			bos.write(b);
          
		}
		bos.close();
	}

}
