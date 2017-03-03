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
    private Label sizeLabel;

    @FXML
    private Button drawButton;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

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

        switch (choiceBox.getValue().toString()){
            case Constants.CIRCLE: {
                Circle circle = new Circle(size, 5, 5, paint, 5);
            } break;

            case Constants.RECTANGLE:{
                Rectangle rectangle = new Rectangle(size, 5, 5, paint, 5);
            } break;

            case Constants.TRIANGLE:{
                Triangle triangle = new Triangle(size, 5, 5, paint, 5);
            } break;
        }
    }
}
