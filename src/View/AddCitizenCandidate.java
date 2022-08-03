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

public class AddCitizenCandidate {
	private VBox addCitizenCandidate = new VBox(5);
	private HBox hBox = new HBox(5);
	private Label daysInQuarentine = new Label("Days In Quarentine:");
	private Label carryWeapon = new Label("Carry Weapon");
	private TextField fullName = new TextField();
	private TextField id = new TextField();
	private TextField birthYear = new TextField();
	private TextField tfdiq = new TextField();
	private Label inQuarentinelbl = new Label("In Quarentine:");
	private CheckBox inQuarentinecbx = new CheckBox();
	private CheckBox carryWeaponcbx = new CheckBox();
	private ComboBox<String> kalpiesCbo;
	private ComboBox<String> partiesCbo;
	private Label lbl = new Label();
	private Button btnAddCandidateToParty = new Button("Add Candidate to Party");
	private Button btnClear = new Button("Clear");

	public AddCitizenCandidate() {
		addCitizenCandidate.setPadding(new Insets(15));

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

		this.btnClear.setOnAction(e -> clear());

		this.inQuarentinecbx.setOnAction(e -> {
			if (inQuarentinecbx.isSelected()) {
				addCitizenCandidate.getChildren().clear();
				addCitizenCandidate.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, daysInQuarentine,
						carryWeapon, kalpiesCbo, partiesCbo, hBox, lbl);
			} else {
				addCitizenCandidate.getChildren().clear();
				addCitizenCandidate.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, carryWeapon,
						kalpiesCbo, partiesCbo, hBox, lbl);
			}
		});

		this.hBox.getChildren().addAll(this.btnAddCandidateToParty, btnClear);
		setCbo(new ArrayList<String>(), new ArrayList<String>()); // This method sets the VBox
	}

	public VBox getAddCitizenCandidate() {
		return addCitizenCandidate;
	}

	public Button getBtnAddCandidateToParty() {
		return btnAddCandidateToParty;
	}

	public void setCbo(ArrayList<String> tmp1, ArrayList<String> tmp2) {
//		This Method Refreshes the ComboBoxes & VBox 
		this.kalpiesCbo = new ComboBox<String>(FXCollections.observableArrayList(tmp1));
		kalpiesCbo.setPromptText("Kalpies");
		this.partiesCbo = new ComboBox<String>(FXCollections.observableArrayList(tmp2));
		partiesCbo.setPromptText("Parties");
		addCitizenCandidate.getChildren().clear();
		addCitizenCandidate.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, carryWeapon, kalpiesCbo,
				partiesCbo, hBox, lbl);
	}

	public TextField getFullName() {
		return fullName;
	}

	public TextField getBirthYear() {
		return birthYear;
	}

	public TextField getTfdiq() {
		return tfdiq;
	}

	public CheckBox getInQuarentinecbx() {
		return inQuarentinecbx;
	}

	public CheckBox getCarryWeaponcbx() {
		return carryWeaponcbx;
	}

	public ComboBox<String> getKalpiesCbo() {
		return kalpiesCbo;
	}

	public ComboBox<String> getPartiesCbo() {
		return partiesCbo;
	}

	public TextField getId() {
		return id;
	}

	public Label getLbl() {
		return lbl;
	}

	public void clear() {
		this.fullName.clear();
		this.id.clear();
		this.birthYear.clear();
		this.tfdiq.clear();
		this.kalpiesCbo.getSelectionModel().clearSelection();
		this.partiesCbo.getSelectionModel().clearSelection();
		this.inQuarentinecbx.setSelected(false);
		this.carryWeaponcbx.setSelected(false);
		this.lbl.setText("");
		addCitizenCandidate.getChildren().clear();
		addCitizenCandidate.getChildren().addAll(fullName, id, birthYear, inQuarentinelbl, carryWeapon, kalpiesCbo,
				partiesCbo, hBox, lbl);
	}
}
