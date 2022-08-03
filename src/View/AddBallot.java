package View;


import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddBallot {
	private VBox addBallotVBox;
	private HBox hBox = new HBox(5);
	private Button btnAddBallot = new Button("Add Ballot");
	private Button btnClear = new Button("Clear");
	private TextField address;
	private String bType[] = { "Regular", "Corona", "Army", "ArmyCorona" };
	private ComboBox<String> cbo;
	private Label lbl = new Label();

	public AddBallot() {
		this.addBallotVBox = new VBox(5);
		this.addBallotVBox.setPadding(new Insets(15));

		this.address = new TextField();
		address.setPromptText("Enter Ballot Address");
		address.setMaxWidth(200);

		this.cbo = new ComboBox<String>(FXCollections.observableArrayList(this.bType));
		cbo.setPromptText("Ballot Type");

		btnClear.setOnAction(e -> {
			this.cbo.getSelectionModel().clearSelection();
			this.address.clear();
		});
		this.hBox.getChildren().addAll(this.btnAddBallot, btnClear);

		addBallotVBox.getChildren().addAll(cbo, address, this.hBox, lbl);
	}

	public TextField getAddress() {
		return address;
	}

	public VBox getAddBallotVBox() {
		return addBallotVBox;
	}

	public Button getBtnAddBallot() {
		return btnAddBallot;
	}

	public ComboBox<String> getCbo() {
		return cbo;
	}

	public Label getLbl() {
		return lbl;
	}

	public void setLbl(Label lbl) {
		this.lbl = lbl;
	}

}
