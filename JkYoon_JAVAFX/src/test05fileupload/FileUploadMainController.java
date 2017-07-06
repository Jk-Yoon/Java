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
 * @desciption : ���Ͼ��ε� Controller �� �ٿ�ε带 ���� �Ѵ�.
 * 
 * 
 * 
 * 
 * 
 */
public class FileUploadMainController implements Initializable {
 
	// ���� ������ ������ ��ü
	File _file;
	// ���� ���ε� �Ǿ����� �˷��ִ� label
	@FXML Label label;
	// ���ϸ� ���� textFiled
	@FXML TextField txtField;
	// ���Ͽ��� ��ư
	@FXML Button btnOpen;
	// ���� ���ε� ��ư
	@FXML Button btnUpload;
	
	@FXML Hyperlink linkDown;
	
	// imageView ���� ���ε��� �̹����� ����
	@FXML ImageView viewImage;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// �ʱ�ȭ �̺�Ʈ
		initEvent();
		
	}

	/**
	 * @method : initEvent
	 * @parmam : 
	 * @return : void
	 * @description : �ʱ�ȭ �̺�Ʈ
	 */
	private void initEvent() {
		 System.out.println("initEvent()");
		 // ���Ͽ��� �̺�Ʈ
        btnOpen.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
            	System.out.println("111111111111");
            	// ������ �ٷ�� FX�� ������Ʈ
                FileChooser fileChooser = new FileChooser();
                // ����ó����ġ
                fileChooser.setInitialDirectory(new File("D:/"));
                //���� Ȯ���� ����
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
                //���� Ȯ���� ����
                fileChooser.getExtensionFilters().add(extFilter);
                
                //Stage stage = (Stage) txtField.getScene().getWindow();
                
                _file = fileChooser.showOpenDialog(null);
                
                if(_file!=null){
                	txtField.setText(_file.getName());
                }
                
                Image image = null;
                // ������ ���
				image = new Image(_file.toURI().toString());
                
                // �̹��� �� ����
                viewImage.setImage(image);
                
                System.out.println("file.getParent() = "+_file.getParent());
                System.out.println("file.toString() : " + _file.toString());
                System.out.println("file : " + _file);
            }
        });
        
       // ���� ���ε� �̺�Ʈ
       btnUpload.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent arg0) {
        	   System.out.println("2222");
        	   try {
        		   if(_file != null){
        			   // ���� ���ε� �޼ҵ�
        			   fileUpload();
        		   }else{
        			   txtField.setText("������ �������� �ʽ��ϴ�.");
        		   }
        		   
            		
        	   } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
        	   }
           }

       });
       
       // ���� �ٿ�ε� �̺�Ʈ
       linkDown.setOnAction(new EventHandler<ActionEvent>(){
    	   @Override
	       public void handle(ActionEvent arg0) {
    		   System.out.println("linkDown.setOnAction");
    		   FileChooser fileChooser = new FileChooser();
    		   
               //Ȯ���ڸ� �����Ѵ�.
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
	 * @description : ���Ͼ��ε� 
	 */
	private void fileUpload() throws Exception {
		
		BufferedInputStream dis = new BufferedInputStream(new FileInputStream(_file));
		// ������ src/test05fileupload/��ġ�� �ø���.
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/test05fileupload/"+_file.getName()));
		
		int b = 0;
		while((b = dis.read())!=-1){
          // FileOutputStream�� ���� �����͸� ����Ѵ�.
			bos.write(b);
		}
		
		bos.close();
		label.setText("���Ͼ��ε尡 �Ǿ����ϴ�.");
		linkDown.setText(_file.getName());
		System.out.println("���Ͼ��ε尡 �Ǿ����ϴ�.");
		
	}
	
	
	/**
	 * @method : fileDownload
	 * @parmam : 
	 * @return : void
	 * @throws Exception 
	 * @description : ���� �ٿ�ε�
	 */
	private void fileDownload(File file) throws Exception {
		System.out.println("src/test05fileupload/"+_file.getName());
		
		BufferedInputStream dis = new BufferedInputStream(new FileInputStream("src/test05fileupload/"+_file.getName()));
		
		//Ȯ���ڰ� ������ �ȵǴ� ���󶧹��� �־���.
		String extension = _file.getName().substring(_file.getName().lastIndexOf('.'), _file.getName().length());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file+extension));
		int b = 0;
		while((b = dis.read())!=-1){
          // FileOutputStream�� ���� �����͸� ����Ѵ�.
			bos.write(b);
          
		}
		bos.close();
	}

}
