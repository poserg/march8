package ru.cinimex.quest;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.cinimex.quest.tasks.FirstTask;
import ru.cinimex.quest.tasks.ITask;
import javafx.scene.SubScene;

public class FXMLController implements Initializable {
    
    @FXML private Label taskLbl;
	@FXML private Button checkButton;
	@FXML private TextField answerText;
	
	
	private ITask currentTask;
	private List<ITask> taskList;
	private Iterator<ITask> taskIterator;
	@FXML SubScene subScene;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    	nextTask();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	checkButton.disableProperty().bind(Bindings.isEmpty(answerText.textProperty()));
    	
    	taskList = new ArrayList<>(8);
    	taskList.add(new FirstTask());
    	taskIterator = taskList.iterator();
    	
    	nextTask();
    }

	@FXML public void onEnter() {
		nextTask();
	}
	
	private boolean checkIsResolved() {
		return currentTask == null || currentTask.getAnswer().equals(answerText.getText());
	}
	
	private void nextTask() {
		if (checkIsResolved()) {
			if (taskIterator.hasNext()) {
				currentTask = taskIterator.next();
				
				subScene = currentTask.buildScene();
				taskLbl.setText(currentTask.getTitle());
			} else {
				
			}
		} else {
			
		}
	}
}
