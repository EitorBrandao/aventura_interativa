package boundary;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TelaSave implements Telas {

	private BorderPane paneB0 = new BorderPane();
	private GridPane paneG0 = new GridPane();
	private Scene telaSave = new Scene(paneB0, 1000, 800);

	private Button btnSlot1 = new Button("Slot 1");
	private Button btnSlot2 = new Button("Slot 2");
	private Button btnSlot3 = new Button("Slot 3");

	@Override
	public Scene gerarTela() {

		btnSlot1.setPrefSize(100, 50);
		btnSlot2.setPrefSize(100, 50);
		btnSlot3.setPrefSize(100, 50);

		paneG0.add(btnSlot1, 1, 0);
		paneG0.add(btnSlot2, 1, 1);
		paneG0.add(btnSlot3, 1, 2);

		paneB0.setCenter(paneG0);

		return telaSave;
	}

}
