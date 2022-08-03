package View;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddCitizen {
	private VBox addCitizen = new VBox(5);
	private HBox hBox = new HBox(5);
	private TextField fullName = new TextField();
	private TextField id = new TextField();
	private TextField birthYear = new TextField();
	private Label inQuarentinelbl = new Label("In Quarentine:");
	private CheckBox inQuarentinecbx = new CheckBox();
	private Label daysInQuarentine = new Label("Days In Quarentine:");
	private TextField tfdiq = new TextField();
	private Label carryWeapon = new Label("Carry Weapon");
	private CheckBox carryWeaponcbx = new CheckBox();
	private ComboBox<String> cbo = new ComboBox<>();
	private Button btnAddCitizen = new Button("Add Citizen");
	private Button btnClear = new Button("Clear");
	private Label lbl = new Label();

	public AddCitizen() {
		addCitizen.setPadding(new Insets(15));

		this.fullName.setPromptText("Enter FullName");
		this.fullName.setMaxWidth(200);

		this.id.setPromptText("Enter ID");
		this.id.setMaxWidth(200);

		this.birthYear.setPromptText("Enter Birth Year");
		this.birthYear.setMaxWidth(200);

		this.inQuarentinelbl.setGraphic(inQuarentinecbx);
		this.inQuarentinelbl.setContentDisplay(ContentDisplay.RIGHT);

		this.tfdiq.setPromptText("Num of Days");
		this.tfdiq.setMaxWidth(92);

		this.daysInQuarentine.setGraphic(tfdiq);
		this.daysInQuarentine.setContentDisplay(ContentDisplay.RIGHT);

		this.carryWeapon.setGraphic(carryWeaponcbx);
		this.carryWeapon.setContentDisplay(ContentDisplay.RIGHT);

		this.inQuarentinecbx.setOnAction(e -> {
			if (this.inQuarentinecbx.isSelected()) {
				addCitizen.getChildren().clear();
				addCitizen.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, daysInQuarentine, carryWeapon,
						cbo, hBox, lbl);
			} else {
				addCitizen.getChildren().clear();
				addCitizen.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, carryWeapon, cbo, hBox, lbl);
			}
		});

		hBox.getChildren().addAll(btnAddCitizen, btnClear);
		btnClear.setOnAction(e -> clear());
		setKalpiesCBO(new ArrayList<String>()); // This method sets the VBox
	}

	public VBox getAddCitizen() {
		return addCitizen;
	}

	public void setKalpiesCBO(ArrayList<String> tmp) {
//		This Method Refreshes the ComboBox & VBox 
		this.cbo = new ComboBox<String>(FXCollections.observableArrayList(tmp));
		this.cbo.setPromptText("Kalpies");

		addCitizen.getChildren().clear();
		addCitizen.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, carryWeapon, cbo, hBox, lbl);
	}

	public TextField getFullName() {
		return fullName;
	}

	public TextField getBirthYear() {
		return birthYear;
	}

	public CheckBox getInQuarentinecbx() {
		return inQuarentinecbx;
	}

	public CheckBox getCarryWeaponcbx() {
		return carryWeaponcbx;
	}

	public TextField getTfdiq() {
		return tfdiq;
	}

	public ComboBox<String> getCbo() {
		return cbo;
	}

	public TextField getId() {
		return id;
	}

	public Label getLbl() {
		return lbl;
	}

	public Button getBtnAddCitizen() {
		return btnAddCitizen;
	}

	public void clear() {
		this.birthYear.clear();
		this.fullName.clear();
		this.id.clear();
		this.inQuarentinecbx.setSelected(false);
		this.tfdiq.clear();
		this.carryWeaponcbx.setSelected(false);
		this.cbo.getSelectionModel().clearSelection();
		addCitizen.getChildren().clear();
		addCitizen.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, carryWeapon, cbo, hBox, lbl);
	}

}
