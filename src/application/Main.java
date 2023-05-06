package application;
/**
*
* @author leutvag
*/
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    @Override
    public void start(Stage primaryStage) {
        // ������������ �� ������ ��� �� ������ ��� �����
        Button clearButton = new Button("����������");
        clearButton.setOnAction(event -> {
            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });

        // ���������� ��� �����
        canvas = new Canvas(800, 600);
        graphicsContext = canvas.getGraphicsContext2D();

        // �������� ��� ��������� ��� �� ����������������� ���� � ������� ������ �� ����������
        canvas.setOnMousePressed(event -> {
            graphicsContext.beginPath();
            graphicsContext.moveTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });

        // �������� ��� ��������� ��� �� ����������������� ���� � ������� ��������� �� ����������
        canvas.setOnMouseDragged(event -> {
            graphicsContext.lineTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });

        BorderPane root = new BorderPane();
        root.setTop(clearButton);
        root.setCenter(canvas);

        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        primaryStage.setTitle("���������");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
