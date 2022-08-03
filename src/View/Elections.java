package View;

import java.util.ArrayList;

import Model.Citizen;
import Model.MySet;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Elections {
	private VBox elections = new VBox(5);
	private VBox finishedElections = new VBox(5);
	private HBox hBox1 = new HBox(5);
	private HBox hBox2 = new HBox(5);

	private ComboBox<String> cboParties;
	private Button btnYes = new Button("Yes");
	private Button btnNo = new Button("No");
	private Button btnvote = new Button("Vote");
	private Label lbl = new Label();
	private Label exceptionLbl = new Label();
	private RadioButton rdb1 = new RadioButton("Yes");
	private RadioButton rdb2 = new RadioButton("No");
	private ToggleGroup tg = new ToggleGroup();

	private ArrayList<Label> labels;
	private int count = 0;

	public Elections() {
		elections.setPadding(new Insets(15));
		hBox1.getChildren().addAll(btnYes, btnNo);
		elections.getChildren().addAll(lbl, hBox1, exceptionLbl);

		rdb1.setToggleGroup(tg);
		rdb2.setToggleGroup(tg);
		this.hBox2.getChildren().addAll(rdb1, rdb2);
		finishedElections.setPadding(new Insets(15));
		Label lbl = new Label("Finished Elections!");
		lbl.setStyle("-fx-font-weight: bold;-fx-font-size:18px;");
		this.finishedElections.getChildren().add(lbl);
	}

	public VBox getElections() {
		return elections;
	}

	public Button getBtnYes() {
		return btnYes;
	}

	public Button getBtnNo() {
		return btnNo;
	}

	public Label getLbl() {
		return lbl;
	}

	public void UpdateElections(MySet<Citizen> citizens) {
		this.count = 0;
		ArrayList<Label> tmp = new ArrayList<>();
		for (int i = 0; i < citizens.arr.size(); i++) {
			tmp.add(new Label(citizens.arr.get(i).getFullName()));
		}
		this.labels = tmp;
		this.lbl.setText(this.labels.get(this.count).getText() + ", Do You Want To Vote?");
		this.elections.getChildren().clear();
		this.elections.getChildren().addAll(this.lbl, this.hBox1, exceptionLbl);

	}

	public void UpdateParties(ArrayList<String> tmp) {
		this.cboParties = new ComboBox<String>(FXCollections.observableArrayList(tmp));
		this.cboParties.setPromptText("Parties");
	}

	public ArrayList<Label> getLabels() {
		return labels;
	}

	public int getCount() {
		return count;
	}

	public void incrementCount() {
		this.count = this.count + 1;
	}

	public void nextCitizen() {
		if (count + 1 < this.labels.size()) {
			this.count = this.count + 1;
			this.lbl.setText(this.labels.get(count).getText() + ", Do You Want To Vote?");
			this.elections.getChildren().clear();
			this.elections.getChildren().addAll(this.lbl, this.hBox1, this.exceptionLbl);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public VBox getFinishedElections() {
		return finishedElections;
	}

	public Button getBtnVote() {
		return btnvote;
	}

	public void yesClick() {
		this.lbl.setText(this.labels.get(this.count).getText() + ", Please Vote:");
		this.elections.getChildren().clear();
		this.elections.getChildren().addAll(this.lbl, this.cboParties, this.btnvote, this.exceptionLbl);

	}

	public Label getExceptionLbl() {
		return exceptionLbl;
	}

	public ComboBox<String> getCboParties() {
		return cboParties;
	}

	public void QuarantineCitizen() {
		this.lbl.setText(this.labels.get(count).getText() + ", are you in wearing a protective suit?");
		this.elections.getChildren().clear();
		this.elections.getChildren().addAll(this.lbl, this.hBox2, this.exceptionLbl);
	}

	public RadioButton getRdb1() {
		return rdb1;
	}

	public RadioButton getRdb2() {
		return rdb2;
	}

}
