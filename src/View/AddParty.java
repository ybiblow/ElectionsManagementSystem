package View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AddParty {
	private VBox addParty = new VBox(5);
	private TextField partyName = new TextField();
	private Text estDate = new Text("Est. Date:");
	private Text faction = new Text("Faction:");
	private TextField estMonth = new TextField();
	private TextField estYear = new TextField();
	private Label lbl = new Label();
	private RadioButton r1 = new RadioButton("Left");
	private RadioButton r2 = new RadioButton("Center");
	private RadioButton r3 = new RadioButton("Right");
	private ToggleGroup tg = new ToggleGroup();
	private Button btnAddParty = new Button("Add Party");
	private Button btnClear = new Button("Clear");

	public AddParty() {
		addParty.setPadding(new Insets(15));

		partyName.setPromptText("Party Name");
		partyName.setMaxWidth(200);

		estYear.setPromptText("Year");
		estYear.setMaxWidth(50);

		estMonth.setPromptText("Month");
		estMonth.setMaxWidth(50);

		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r3.setToggleGroup(tg);

		HBox hBox1 = new HBox(5);
		BorderPane bPane1 = new BorderPane();
		bPane1.setCenter(estDate);
		hBox1.getChildren().addAll(bPane1, estMonth, estYear);

		HBox hBox2 = new HBox(10);
		BorderPane bPane2 = new BorderPane();
		bPane2.setCenter(faction);
		hBox2.getChildren().addAll(bPane2, r1, r2, r3);

		HBox hBox3 = new HBox(5);
		hBox3.getChildren().addAll(btnAddParty, btnClear);
		this.btnClear.setOnAction(e -> clear());
		addParty.getChildren().addAll(partyName, hBox1, hBox2, hBox3, lbl);
	}

	public VBox getAddParty() {
		return addParty;
	}

	public Button getBtnAddParty() {
		return btnAddParty;
	}

	public TextField getPartyName() {
		return partyName;
	}

	public TextField getEstMonth() {
		return estMonth;
	}

	public TextField getEstYear() {
		return estYear;
	}

	public ToggleGroup getTg() {
		return tg;
	}

	public Label getLbl() {
		return lbl;
	}

	public void clear() {

		this.partyName.clear();
		this.estMonth.clear();
		this.estYear.clear();
		this.r1.setSelected(false);
		this.r2.setSelected(false);
		this.r3.setSelected(false);
		this.lbl.setText("");

	}

}
