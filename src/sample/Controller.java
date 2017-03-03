package sample;

import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Shape;
import Shapes.Triangle;
import constants.Constants;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Slider slider;

    @FXML
    private Label sizeLabel, errorLabel;

    @FXML
    private Button drawButton;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField xValue, yValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringProperty shapeType = new SimpleStringProperty();
        DoubleProperty size = new SimpleDoubleProperty();
        choiceBox.getItems().removeAll(choiceBox.getItems());
        choiceBox.getItems().addAll("Stvorec", "Kruh", "Obdlznik");
        choiceBox.getSelectionModel().select("Stvorec");


        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                sizeLabel.setText(String.format("%.2f", new_val));
                size.set(new_val.doubleValue());
            }
        });
//
//        choiceBox.valueProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                shapeType.set(choiceBox.getValue().toString());
//            }
//        });
    }

    @FXML
    private void handleButtonAction(){
        double size = Double.valueOf(sizeLabel.getText());
        Color paint = colorPicker.getValue();
        if(xValue.getText().equals(null) || yValue.getText().equals(null)){
            errorLabel.setText("nastavte suradnice");
        } else {
            double x = Double.valueOf(xValue.getText());
            double y = Double.valueOf(yValue.getText());
            getChoice(size, x, y, paint);
        }
    }

    private void getChoice(double size, double x, double y, Color paint){
        switch (choiceBox.getValue().toString()) {
            case Constants.CIRCLE: {
                Shape circle = new Circle(size, x, y, paint, 5);
                circle.draw(canvas);
            }
            break;

            case Constants.RECTANGLE: {
                Rectangle rectangle = new Rectangle(size, 5, 5, paint, 5);
            }
            break;

            case Constants.TRIANGLE: {
                Triangle triangle = new Triangle(size, 5, 5, paint, 5);
            }
            break;
        }

    }
}
