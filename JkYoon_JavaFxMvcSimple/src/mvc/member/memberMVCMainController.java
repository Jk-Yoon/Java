package mvc.member;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class memberMVCMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<MemberVO> memTable;

    @FXML
    private TableColumn<?, ?> tcId;

    @FXML
    private TableColumn<?, ?> tcName;

    @FXML
    private TableColumn<?, ?> tcTel;

    @FXML
    private TableColumn<?, ?> tcAddr;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private Label memId;

    @FXML
    private Label memName;

    @FXML
    private Label memTel;

    @FXML
    private Label memAddr;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtAddr;

    @FXML
    private TextField  txtName;
    
    // 취소 버튼을 클릭했을 때 이벤트 처리
    @FXML
    void cancel(ActionEvent event) {
    	txtId.setEditable(false); 	// 읽기 전용 상태로 만든다.
    	txtName.setEditable(false); 
    	txtTel.setEditable(false); 
    	txtAddr.setEditable(false);
    	
    	btnAdd.setDisable(false);
    	btnEdit.setDisable(false);
    	btnDel.setDisable(false);
    	
    	btnOk.setDisable(true);	// 버튼 비활성화
    	btnCancel.setDisable(true);
    	
    	memTable.setDisable(false);
    	
    	strWork = "";
    	
    }
    // 추가 버튼을 클릭했을 때 이벤트 처리
    @FXML	
    void dataAdd(ActionEvent event) {
    	txtId.setEditable(true); 	// 편집 가능 상태로 만든다.
    	txtName.setEditable(true); 
    	txtTel.setEditable(true); 
    	txtAddr.setEditable(true); 
    	
    	btnOk.setDisable(false);	// 버튼 활성화
    	btnCancel.setDisable(false);
    	
    	btnAdd.setDisable(true);
    	btnEdit.setDisable(true);
    	btnDel.setDisable(true);
    	
    	memTable.setDisable(true);
    	
    	txtId.clear();	// TextField의 내용 삭제
    	txtName.clear();
    	txtTel.clear();
    	txtAddr.clear();
    	
    	strWork = "Insert";
    	
    	txtId.requestFocus();	// 포커스 주기
    }

    
    @FXML
    void dataDel(ActionEvent event) {
    	if((memTable.getSelectionModel().getSelectedItem()) != null){
			boolean result = confirm("정말로 삭제하시겠습니까?");
			if(result){
	    		int cnt = service.deleteMember(txtId.getText());
	    		if(cnt > 0){	// DB에 insert 성공
					info("삭제 작업 성공.");
					
					txtId.clear();	// TextField의 내용 삭제
					txtName.clear();
					txtTel.clear();
					txtAddr.clear();
	
					data.remove(memTable.getSelectionModel().getSelectedIndex());
				} else {
					alert("삭제가 취소되었습니다.");
					txtId.clear();	// TextField의 내용 삭제
					txtName.clear();
					txtTel.clear();
					txtAddr.clear();
				}
	    		txtId.setEditable(false); 	// 읽기 전용 상태로 만든다.
	    		txtName.setEditable(false); 
	    		txtTel.setEditable(false); 
	    		txtAddr.setEditable(false);
	    		
	    		btnAdd.setDisable(false);
	    		btnEdit.setDisable(false);
	    		btnDel.setDisable(false);
	    		
	    		btnOk.setDisable(true);	// 버튼 비활성화
	    		btnCancel.setDisable(true);
	    		
	    		memTable.setDisable(false);
	    		
	    		strWork = "";
			} else{
				alert("삭제 작업 실패");
				txtId.clear();	// TextField의 내용 삭제
				txtName.clear();
				txtTel.clear();
				txtAddr.clear();
			}
    	} else {
    		alert("삭제할 데이터가 없습니다.");
    	}
    }

    @FXML
    void dataEdit(ActionEvent event) {
    	strWork = "Update";
    	
    	txtName.setEditable(true); 
    	txtTel.setEditable(true); 
    	txtAddr.setEditable(true); 
    	
    	btnOk.setDisable(false);	// 버튼 활성화
    	btnCancel.setDisable(false);
    	
    	btnAdd.setDisable(true);
    	btnEdit.setDisable(true);
    	btnDel.setDisable(true);
    	
    	memTable.setDisable(true);
    	
//    	txtName.clear();
//    	txtTel.clear();
//    	txtAddr.clear();
    }
    
    // 확인 버튼 클릭 했을 때 이벤트 처리
    @FXML
    void run(ActionEvent event) {
    	if("Insert".equals(strWork)){	// 추가 작업 상태 인지 검사
    		if(txtId.getText().isEmpty()){
//    			txtMsg.setText("아이디를 입력하세요.");
    			alert("아이디를 입력하세요.");
    			txtId.requestFocus(); // 포커스주기
				return;
    		}else if(txtName.getText().isEmpty()){
    			alert("이름을 입력하세요.");
    			txtName.requestFocus(); // 포커스주기
    			return;
    		}else if(txtTel.getText().isEmpty()){
				alert("전화번호를 입력하세요.");
				txtTel.requestFocus(); // 포커스주기
				return;
    		}else if(txtAddr.getText().isEmpty()){
				alert("주소를 입력하세요.");
				txtAddr.requestFocus(); // 포커스주기
				return;
    		} else {
				MemberVO memvo = new MemberVO();
				memvo.setMem_id(txtId.getText());
				memvo.setMem_name(txtName.getText());
				memvo.setMem_tel(txtTel.getText());
				memvo.setMem_addr(txtAddr.getText());
				
				int cnt = service.insertMember(memvo);
				if(cnt > 0){	// DB에 insert 성공
					data.add(memvo);
					info("추가 작업 성공");
					txtId.clear();	// TextField의 내용 삭제
					txtName.clear();
					txtTel.clear();
					txtAddr.clear();
				} else {
					alert("추가 작업 실패");
				}
    		}
    		txtId.setEditable(false); 	// 읽기 전용 상태로 만든다.
    		txtName.setEditable(false); 
    		txtTel.setEditable(false); 
    		txtAddr.setEditable(false);
    		
    		btnAdd.setDisable(false);
    		btnEdit.setDisable(false);
    		btnDel.setDisable(false);
    		
    		btnOk.setDisable(true);	// 버튼 비활성화
    		btnCancel.setDisable(true);
    		
    		memTable.setDisable(false);
    		
    		strWork = "";
    	} else if("Update".equals(strWork)){
    		if(txtName.getText().isEmpty()){
    			alert("이름을 입력하세요.");
    			txtName.requestFocus(); // 포커스주기
    			return;
    		}else if(txtTel.getText().isEmpty()){
				alert("전화번호를 입력하세요.");
				txtTel.requestFocus(); // 포커스주기
				return;
    		}else if(txtAddr.getText().isEmpty()){
				alert("주소를 입력하세요.");
				txtAddr.requestFocus(); // 포커스주기
				return;
    		} else {
				MemberVO memvo = new MemberVO();
				memvo.setMem_id(txtId.getText());
				memvo.setMem_name(txtName.getText());
				memvo.setMem_tel(txtTel.getText());
				memvo.setMem_addr(txtAddr.getText());
				int cnt = service.updateMember(memvo);
				if(cnt > 0){	// DB에 insert 성공
					info("수정 작업 성공");
					txtId.clear();	// TextField의 내용 삭제
					txtName.clear();
					txtTel.clear();
					txtAddr.clear();
					data.set(memTable.getSelectionModel().getSelectedIndex(), memvo);
				} else {
					alert("수정 작업 실패");
					txtId.clear();	// TextField의 내용 삭제
					txtName.clear();
					txtTel.clear();
					txtAddr.clear();
				}
    		}
				txtId.setEditable(false); 	// 읽기 전용 상태로 만든다.
	    		txtName.setEditable(false); 
	    		txtTel.setEditable(false); 
	    		txtAddr.setEditable(false);
	    		
	    		btnAdd.setDisable(false);
	    		btnEdit.setDisable(false);
	    		btnDel.setDisable(false);
	    		
	    		btnOk.setDisable(true);	// 버튼 비활성화
	    		btnCancel.setDisable(true);
	    		
	    		memTable.setDisable(false);
	    		
	    		strWork = "";
    	}
    	
    }
    
    @FXML
    void tableClick(MouseEvent event) {
    	MemberVO mvo = memTable.getSelectionModel().getSelectedItem();
    	txtId.setText(mvo.getMem_id());
    	txtName.setText(mvo.getMem_name());
    	txtTel.setText(mvo.getMem_tel());
    	txtAddr.setText(mvo.getMem_addr());
    }

    
    
    private ObservableList<MemberVO> data;
    private MemberService service;
    private String strWork = "";

    @FXML
    void initialize() {
    	// 이곳에는 이벤트의 설정이나 초기화 작업을 한다.
    	assert memId != null : "fx:id=\"memId\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert memName != null : "fx:id=\"memName\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert memTel != null : "fx:id=\"memTel\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert memAddr != null : "fx:id=\"memAddr\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert txtTel != null : "fx:id=\"txtTel\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert txtAddr != null : "fx:id=\"txtAddr\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert memTable != null : "fx:id=\"memTable\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert tcId != null : "fx:id=\"tcId\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert tcName != null : "fx:id=\"tcName\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert tcTel != null : "fx:id=\"tcTel\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert tcAddr != null : "fx:id=\"tcAddr\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'memberMVCMain.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'memberMVCMain.fxml'.";//===========================================================================================================================
        
        service = MemberService.getInstance();
        
//        tcId.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
//        tcName.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
//        tcTel.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
//        tcAddr.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
        
        // DB자료 가져오기
       // ArrayList<MemberVO> memList = (ArrayList<MemberVO>) service.getAllMemberList();
        
        // 가져온 자료를 ObservableList에 담는다.
//        data = FXCollections.observableArrayList(memList);
//        
//        memTable.setItems(data);
        
    }

    // alert 창
    public void alert(String msg){
//    	Alert alertWarning = new Alert(AlertType.WARNING);
//    	alertWarning.setTitle("경고");
//    	alertWarning.setContentText(msg);
//    	alertWarning.showAndWait();
    }
    
    // 안내 창
    public void info(String msg){
//    	Alert alertinfo = new Alert(AlertType.INFORMATION);
//    	alertinfo.setTitle("확인");
//    	alertinfo.setContentText(msg);
//    	alertinfo.showAndWait();
    }
    
    public boolean confirm(String msg){
//    	Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
//    	alertConfirm.setTitle("Confirm");
//    	alertConfirm.setContentText(msg);
//    	
//    	ButtonType confirmResult = alertConfirm.showAndWait().get();
//		
//    	boolean result = false;
//    	
//		if(confirmResult == ButtonType.OK){
//			result = true;
//		}else{
//			result = false;
//		}
		
		return true;
    }
}
