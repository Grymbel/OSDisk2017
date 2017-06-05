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
	private Button btnLoadData;

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
    private TextField tfPrev1;

    @FXML
    private TextField tfCurr1;

    @FXML
    private TextField tfCyl1;

    @FXML
    private TextField tfInputs1;
    
    @FXML
    private Button btnFCFS;

    @FXML
    private Button btnSSTF;

    @FXML
    private Button btnCLook;

    @FXML
    private Button btnCScan;
    
    @FXML
    private Button btnLook;

    @FXML
    private Button btnScan;

    @FXML
    private TextArea taPath;

    @FXML
    private TextArea taDistance;
    
    //Random generation within user defined parameters
    @FXML
    void makeDatas(ActionEvent event) {
    	OSD osd = new OSD(Integer.parseInt(tfPrev.getText()),Integer.parseInt(tfCurr.getText()),Integer.parseInt(tfCyl.getText()),Integer.parseInt(tfInputs.getText()));
		osd.makeData();
		
		taOutput.setText(osd.getDataNicely());
    }
    
    //Formatting user defined input into data usable by this application
    @FXML
    void loadDatas(ActionEvent event) {
    	OSD osd = new OSD(Integer.parseInt(tfPrev1.getText()),Integer.parseInt(tfCurr1.getText()),Integer.parseInt(tfCyl1.getText()),tfInputs1.getText());
    	osd.startData();
    	
    	taOutput.setText(osd.getDataNicely());
    }
    
    //Initiate the FCFS process
    @FXML
    void doFCFS(ActionEvent event) {
    	OSD osd = new OSD();
    	String strings[] = osd.FCFS();
    	
    	taPath.setText(strings[0]+strings[1]);
    	taDistance.setText(strings[2]);
    }

    //Initiate the SSTF process
    @FXML
    void doSSTF(ActionEvent event) {
    	OSD osd = new OSD();
    	String[] strings = osd.SSTF();
    	
    	taPath.setText(strings[0]+strings[1]);
    	taDistance.setText(strings[2]);
    }
    
    //Initiate the CScan process
    @FXML
    void doCScan(ActionEvent event) {
    	OSD osd=new OSD();
    	String[] strings = osd.CScan();
    	
    	taPath.setText(strings[0]+strings[1]);
    	taDistance.setText(strings[2]);
    }

    //Initiate the CLook process
    @FXML
    void doCLook(ActionEvent event) {
    	OSD osd=new OSD();
    	String[] strings = osd.CLook();
    	
    	taPath.setText(strings[0]+strings[1]);
    	taDistance.setText(strings[2]);
    }
    
    //Initiate the Scan Process
    @FXML
    void doScan(ActionEvent event) {
    	OSD osd=new OSD();
    	String[] strings = osd.Scan();
    	
    	taPath.setText(strings[0]+strings[1]);
    	taDistance.setText(strings[2]);
    }

    //Initiate the Look process
    @FXML
    void doLook(ActionEvent event) {
    	OSD osd=new OSD();
    	String[] strings = osd.Look();
    	
    	taPath.setText(strings[0]+strings[1]);
    	taDistance.setText(strings[2]);
    }
}
