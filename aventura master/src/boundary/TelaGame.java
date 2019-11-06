package boundary;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TelaGame implements Telas {

	Group group = new Group();
	Image image = new Image(getClass().getResourceAsStream("/img.png"));
	Canvas canvas = new Canvas(image.getWidth(), image.getHeight());
	private GraphicsContext ctx = canvas.getGraphicsContext2D();

	private BorderPane paneB = new BorderPane();
	private GridPane paneG = new GridPane();

	private TextField txtEnergia = new TextField();
	private TextField txtHabilidade = new TextField();
	private TextField txtSorte = new TextField();
	private TextArea txtHistoria = new TextArea();
	TableView<String> tableView = new TableView<>();

	@Override
	public Scene gerarTela() {

		paneG.add(new Label("Energia"), 0, 0);
		paneG.add(txtEnergia, 1, 0);
		paneG.add(new Label("Habilidade"), 0, 1);
		paneG.add(txtHabilidade, 1, 1);
		paneG.add(new Label("Sorte"), 0, 2);
		paneG.add(txtSorte, 1, 2);
		txtEnergia.setEditable(false);
		txtHabilidade.setEditable(false);
		txtSorte.setEditable(false);
		txtHistoria.setEditable(false);

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				ctx.drawImage(image, 0, 0);
			}
		}.start();

		paneB.setCenter(canvas);
		paneB.setLeft(paneG);
		paneB.setRight(txtHistoria);
		paneB.setBottom(tableView);
		Scene telaGame = new Scene(paneB, 1000, 800);
		return telaGame;

	}
}