package teste;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class TesteCanvas extends Application {
    public static void main(String[] args) {
        TesteCanvas.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group grp = new Group();
        Scene scn = new Scene(grp);

        InputStream caminhoSpace = getClass().getResourceAsStream("teste/space.png");
        Image space = new Image(caminhoSpace);
        Canvas canvas = new Canvas (space.getWidth(), space.getHeight());
        grp.getChildren().add(canvas);
        GraphicsContext ctx = canvas.getGraphicsContext2D();

        InputStream caminhoEarth = getClass().getResourceAsStream("teste/earth.png");
        InputStream caminhoMars = getClass().getResourceAsStream("teste/mars.png");
        InputStream caminhoSun = getClass().getResourceAsStream("teste/sun.png");
        Image earth = new Image(caminhoEarth);
        Image sun = new Image(caminhoSun);
        Image mars = new Image(caminhoMars);

        long nanoTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                double time = nanoTime - now / 10000000.0;
                double time2 = nanoTime - now / 10000000.0 * 1.5;
                double centerx = canvas.getWidth() / 2;
                double centery = canvas.getHeight() / 2;
                double angle = time % 360;
                double angle2 = time2 % 360;
                double angleRad = angle / 180 * Math.PI;
                double angleRad2 = angle2 / 180 * Math.PI;
                double raio = 100.0;
                double earthCornerX = centerx - earth.getWidth() / 2;
                double earthCornerY = centery - earth.getHeight() / 2;
                double earthx = earthCornerX + raio * Math.sin(angleRad);
                double earthy = earthCornerY + raio * Math.cos(angleRad);
                double sunx = centerx - sun.getWidth() / 2;
                double suny = centery - sun.getHeight() / 2;

                double marsCornerX = centerx - mars.getWidth() / 2;
                double marsCornerY = centery - mars.getHeight() / 2;
                double marsx = marsCornerX + 2 * raio * Math.sin(angleRad2);
                double marsy = marsCornerY + 2 * raio * Math.cos(angleRad2);


                ctx.drawImage(space,  0, 0);
                ctx.drawImage(sun,  sunx, suny);
                ctx.drawImage(earth,  earthx, earthy);
                ctx.drawImage(mars,  marsx, marsy);
            }
        }.start();

        stage.setTitle("Sistema Solar");
        stage.setScene(scn);
        stage.show();
    }
}
