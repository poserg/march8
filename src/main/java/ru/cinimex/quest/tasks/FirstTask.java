package ru.cinimex.quest.tasks;

import javafx.scene.Group;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;

public class FirstTask implements ITask {

	@Override
	public String getAnswer() {
		return "Answer";
	}

	@Override
	public String getTitle() {
		return "Title";
	}

	@Override
	public String getHint() {
		return "Hint";
	}

	@Override
	public SubScene buildScene() {
		Group root = new Group();
		
		
		SubScene subScene = new SubScene(root, 500, 400, true, 
                SceneAntialiasing.BALANCED);

		// subScene.setFill(fillPaint);
        // subScene.setCamera(camera);
 
        return subScene;
	}

}
