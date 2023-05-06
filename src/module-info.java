module javafx_canvas {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
