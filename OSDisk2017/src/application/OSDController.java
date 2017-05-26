package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OSDController {

	@FXML
    private Button btnMakeData;

    @FXML
    private TextField tfPrev;

    @FXML
    private TextField tfCurr;

    @FXML
    private TextField tfCyl;

    @FXML
    private TextField tfInputs;

    @FXML
    private TextArea taOutput;

    @FXML
    void makeDatas(ActionEvent event) {
    	OSD osd = new OSD(Integer.parseInt(tfPrev.getText()),Integer.parseInt(tfCurr.getText()),Integer.parseInt(tfCyl.getText()),Integer.parseInt(tfInputs.getText()));
		osd.makeData();
		
		taOutput.setText(osd.getDataNicely());
    }
    
	public void initialize(){
		System.out.println("I STARTED!");
	}
}
