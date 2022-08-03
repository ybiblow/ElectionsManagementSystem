package View;

import java.util.ArrayList;
import Model.Ballot;
import Model.Citizen;
import Model.MySet;
import Model.Party;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
	private MySet<Citizen> citizens;
	private ArrayList<Ballot<? extends Citizen>> kalpies;
	private ArrayList<Party> parties;
	private Stage primaryStage;
	private Scene scene;
	private BorderPane bPane = new BorderPane();
	private MainMenu mainMenu = new MainMenu(this);
	private AddBallot addBallot = new AddBallot();
	private AddCitizen addCitizen = new AddCitizen();
	private AddParty addParty = new AddParty();
	private AddCitizenCandidate addCitizenCandidate = new AddCitizenCandidate();
	private ListAllBallots listAllBallots = new ListAllBallots();
	private ListAllCitizens listAllCitizens = new ListAllCitizens();
	private ListAllParties listAllParties = new ListAllParties();
	private Elections runElections = new Elections();
	private ElectionsResults electionsResults = new ElectionsResults();

	public View(Stage primaryStage, MySet<Citizen> citizens, ArrayList<Ballot<? extends Citizen>> kalpies,
			ArrayList<Party> parties) {
		this.citizens = citizens;
		this.kalpies = kalpies;
		this.parties = parties;
		this.primaryStage = primaryStage;
		bPane.setPadding(new Insets(30));
		bPane.setLeft(mainMenu.getMainMenu());
		this.scene = new Scene(bPane, 1200, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Elections");
		primaryStage.getIcons().add(new Image("file:src/pictures/israel.png"));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	protected void addBallot() {
		Label lbl = new Label("Add Ballot");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);
		this.bPane.setCenter(this.addBallot.getAddBallotVBox());
	}

	protected void addParty() {
		Label lbl = new Label("Add Party");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);
		this.bPane.setCenter(addParty.getAddParty());
	}

	protected void addCitizen() {
		ArrayList<String> tmp = new ArrayList<>();
		for (int i = 0; i < this.kalpies.size(); i++) {
			tmp.add(this.kalpies.get(i).getId() + ". " + this.kalpies.get(i).getAddress() + " - "
					+ this.kalpies.get(i).getBallotType());
		}
		this.addCitizen.setKalpiesCBO(tmp);
		Label lbl = new Label("Add Citizen");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);
		this.bPane.setCenter(addCitizen.getAddCitizen());
	}

	protected void addCitizenCandidate() {
		ArrayList<String> tmp1 = new ArrayList<>();
		ArrayList<String> tmp2 = new ArrayList<>();
		for (int i = 0; i < this.kalpies.size(); i++) {
			tmp1.add(this.kalpies.get(i).getId() + ". " + this.kalpies.get(i).getAddress() + " - "
					+ this.kalpies.get(i).getBallotType());
		}
		for (int i = 0; i < this.parties.size(); i++) {
			tmp2.add(this.parties.get(i).getId() + ". " + this.parties.get(i).getPartyName());
		}
		this.addCitizenCandidate.setCbo(tmp1, tmp2);
		Label lbl = new Label("Add Candidate");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);
		this.bPane.setCenter(addCitizenCandidate.getAddCitizenCandidate());
	};

	public void listAllBallots() {
		listAllBallots.updateTreeTableView(kalpies);
		Label lbl = new Label("Ballots List");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);
		bPane.setCenter(listAllBallots.getListAllBallots());
	}

	protected void listallCitizens() {
		listAllCitizens.updatetTVC(citizens);
		Label lbl = new Label("Citizens List");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);
		bPane.setCenter(listAllCitizens.getListallCitizens());

	}

	protected void listallParties() {
		for (int i = 0; i < parties.size(); i++) {
			this.parties.get(i).updateCandidates(citizens);
		}
		listAllParties.updateTTVP(parties);
		Label lbl = new Label("Parties List");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);
		bPane.setCenter(listAllParties.getListAllParties());

	}

	public void runElections() {
		Label lbl = new Label("Elections");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);

		this.runElections.UpdateElections(citizens);

		ArrayList<String> strTMP = new ArrayList<>();
		for (int i = 0; i < this.parties.size(); i++) {
			strTMP.add(this.parties.get(i).getId() + ". " + this.parties.get(i).getPartyName());
		}
		this.runElections.UpdateParties(strTMP);
		bPane.setCenter(this.runElections.getElections());
	}

	public void showElectionsResults(int[] voting) {
		Label lbl = new Label("Elections Results");
		lbl.setStyle("-fx-font-size:18px;-fx-text-fill: darkblue;-fx-font-weight: bold");
		BorderPane bPaneTMP = new BorderPane();
		bPaneTMP.setCenter(lbl);
		bPane.setTop(bPaneTMP);

		this.getElectionsResults().updateResults(parties, kalpies, voting);
		this.bPane.setCenter(this.getElectionsResults().getElectionsResults());
	}

	protected void exit() {
		primaryStage.close();
	}

	public ArrayList<Ballot<? extends Citizen>> getKalpies() {
		return kalpies;
	}

	public AddBallot getAddBallot() {
		return addBallot;
	}

	public AddCitizen getAddCitizen() {
		return addCitizen;
	}

	public AddParty getAddParty() {
		return addParty;
	}

	public AddCitizenCandidate getAddCitizenCandidate() {
		return addCitizenCandidate;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public Elections getRunElections() {
		return runElections;
	};

	public void setCenter(VBox vBox) {
		bPane.setCenter(vBox);
	}

	public ElectionsResults getElectionsResults() {
		return electionsResults;
	}

}
