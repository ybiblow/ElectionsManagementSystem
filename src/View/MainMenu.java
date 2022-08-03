package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenu {
	private VBox mainMenu = new VBox(5);
	private Button bt1 = new Button("1. Add Ballot");
	private Button bt2 = new Button("2. Add Citizen");
	private Button bt3 = new Button("3. Add Party");
	private Button bt4 = new Button("4. Add Candidate to party");
	private Button bt5 = new Button("5. List all Ballots");
	private Button bt6 = new Button("6. List all Citizens");
	private Button bt7 = new Button("7. List all parties");
	private Button bt8 = new Button("8. Elections");
	private Button bt9 = new Button("9. Election Results");
	private Button bt10 = new Button("10. Exit Menu");

	public MainMenu(View view) {
		bt1.setStyle("-fx-alignment: center-left");
		bt1.setMinWidth(153);
		bt1.setOnAction(e -> view.addBallot());

		bt2.setStyle("-fx-alignment: center-left");
		bt2.setMinWidth(153);
		bt2.setOnAction(e -> view.addCitizen());

		bt3.setStyle("-fx-alignment: center-left");
		bt3.setOnAction(e -> view.addParty());
		bt3.setMinWidth(153);

		bt4.setStyle("-fx-alignment: center-left");
		bt4.setMinWidth(153);
		bt4.setOnAction(e -> view.addCitizenCandidate());

		bt5.setStyle("-fx-alignment: center-left");
		bt5.setMinWidth(153);

		bt6.setStyle("-fx-alignment: center-left");
		bt6.setMinWidth(153);
		bt6.setOnAction(e -> view.listallCitizens());

		bt7.setStyle("-fx-alignment: center-left");
		bt7.setMinWidth(153);
		bt7.setOnAction(e -> view.listallParties());

		bt8.setStyle("-fx-alignment: center-left");
		bt8.setMinWidth(153);

		bt9.setStyle("-fx-alignment: center-left");
		bt9.setMinWidth(153);

		bt10.setStyle("-fx-alignment: center-left");
		bt10.setMinWidth(153);
		bt10.setOnAction(e -> view.exit());

		mainMenu.getChildren().addAll(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10);
	}

	public Button getBt5() {
		return bt5;
	}

	public Button getBt8() {
		return bt8;
	}

	public Button getBt9() {
		return bt9;
	}

	public VBox getMainMenu() {
		return mainMenu;
	}

}
