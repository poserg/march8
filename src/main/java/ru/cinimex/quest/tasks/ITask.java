package ru.cinimex.quest.tasks;

import javafx.scene.SubScene;

public interface ITask {
	String getAnswer();
	
	String getTitle();
	
	String getHint();
	
	SubScene buildScene();
}
