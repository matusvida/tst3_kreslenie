package sample;

import constants.Constants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Slider slider;

    @FXML
    private Label sizeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().removeAll(choiceBox.getItems());
        choiceBox.getItems().addAll("Stvorec", "Kruh", "Obdlznik");
        choiceBox.getSelectionModel().select("Stvorec");
        getSliderValue();
        getChoiceBoxValue();
    }

    public void getSliderValue(){
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                System.out.println(new_val.doubleValue());
                sizeLabel.setText(String.format("%.2f", new_val));
            }
        });
    }

    public String getChoiceBoxValue(){
        String shapeType = "";
        choiceBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

            }
        });
        return shapeType;
    }
}
