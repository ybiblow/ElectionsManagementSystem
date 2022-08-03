package Controller;

import Model.Ballot;
import Model.Citizen;
import Model.CitizenIdIlligalArgumentExeption;
import Model.CitizenIdOutOfBoundExeption;
import Model.Model;
import Model.Party;
import Model.StringIsEmpty;
import View.View;
import javafx.scene.control.RadioButton;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		addBallot();
		addCitizen();
		addParty();
		addCandidateToParty();
		listAllBallots();
		elections();
		electionsResults();
	}

	private void addBallot() {
		view.getAddBallot().getBtnAddBallot().setOnAction(e -> {

			try {
				String address = view.getAddBallot().getAddress().getText();
				if (address.isEmpty()) {
					throw new StringIsEmpty("  Please Enter Address!  ");
				}
				String ballotType = view.getAddBallot().getCbo().getValue();
				model.addBallot(address, ballotType, model.getKalpies());
				view.getAddBallot().getAddress().clear();
				view.getAddBallot().getLbl().setText("  Ballot Added successfully!  ");
				view.getAddBallot().getLbl().setStyle("-fx-background-color: limegreen ;-fx-font-weight: bold;");
				view.getAddBallot().getCbo().getSelectionModel().clearSelection();
			} catch (NullPointerException eventNull) {
				view.getAddBallot().getAddress().clear();
				view.getAddBallot().getLbl().setText("  Please Choose a Ballot Type!  ");
				view.getAddBallot().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (StringIsEmpty exception) {
				view.getAddBallot().getLbl().setText(exception.getMessage());
				view.getAddBallot().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			}

		});
	}

	private void addCitizen() {
		view.getAddCitizen().getBtnAddCitizen().setOnAction(e -> {
			int daysInQuarentine = 0;
			try {
				String fullName = view.getAddCitizen().getFullName().getText();
				if (fullName.isEmpty()) {
					throw new StringIsEmpty("Please Enter Full Name");
				}
				String id = view.getAddCitizen().getId().getText();
				model.checkID(id);
				int birthYear = model.birthYear(view.getAddCitizen().getBirthYear().getText());
				boolean inQuarentine = view.getAddCitizen().getInQuarentinecbx().isSelected();
				if (inQuarentine) {
					daysInQuarentine = model.daysInQuarentine(view.getAddCitizen().getTfdiq().getText());
				}
				boolean carryWeapon = view.getAddCitizen().getCarryWeaponcbx().isSelected();
				String kalpii = view.getAddCitizen().getCbo().getValue();
				Ballot<? extends Citizen> kalpi = model.getKalpi(kalpii);
				if (birthYear < 1999) {
					carryWeapon = false;
				}
				model.addCitizen(fullName, id, birthYear, inQuarentine, daysInQuarentine, carryWeapon, kalpi);
				view.getAddCitizen().clear();
				view.getAddCitizen().getLbl().setText("  Citizen Added successfully!  ");
				view.getAddCitizen().getLbl().setStyle("-fx-background-color: limegreen ;-fx-font-weight: bold;");
			} catch (CitizenIdOutOfBoundExeption exeption2) {
				view.getAddCitizen().getLbl().setText("  Please Enter a 9 Digits ID!  ");
				view.getAddCitizen().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (CitizenIdIlligalArgumentExeption exeption3) {
				view.getAddCitizen().getLbl().setText("  Please Enter Digits in ID Field!  ");
				view.getAddCitizen().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (StringIsEmpty e1) {
				view.getAddCitizen().getLbl().setText(e1.getMessage());
				view.getAddCitizen().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (NumberFormatException e2) {
				view.getAddCitizen().getLbl().setText(e2.getMessage());
				view.getAddCitizen().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (NullPointerException e3) {
				view.getAddCitizen().getLbl().setText(e3.getMessage());
				view.getAddCitizen().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (Exception exception) {
				view.getAddCitizen().getLbl().setText(exception.getMessage());
				view.getAddCitizen().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			}
		});

	}

	private void addParty() {
		view.getAddParty().getBtnAddParty().setOnAction(e -> {

			try {
				int estYear;
				int estMonth;
				String partyName = view.getAddParty().getPartyName().getText();
				if (view.getAddParty().getPartyName().getText().isEmpty()) {
					throw new StringIsEmpty("  Please Enter Party Name!  ");
				}
				try {
					estMonth = Integer.parseInt(view.getAddParty().getEstMonth().getText());
					if (estMonth < 1 || estMonth > 12) {
						throw new IllegalArgumentException("  Month Should be between 1-12  ");
					}
				} catch (NumberFormatException exeption) {
					throw new NumberFormatException("  Please Enter Month!  ");
				} catch (IllegalArgumentException exeption) {
					throw exeption;
				}
				try {
					estYear = Integer.parseInt(view.getAddParty().getEstYear().getText());
					if (estYear > 2020 || estYear < 1900) {
						throw new IllegalArgumentException("  Please Enter a Correct Year!  ");
					}
				} catch (NumberFormatException exeption) {
					throw new NumberFormatException("  Please Enter Year!  ");
				} catch (IllegalArgumentException exeption) {
					throw exeption;
				}
				String faction = ((RadioButton) view.getAddParty().getTg().getSelectedToggle()).getText();
				model.addParty(partyName, faction, estMonth, estYear);
				view.getAddParty().getLbl().setText("  Party Added successfully!  ");
				view.getAddParty().getLbl().setStyle("-fx-background-color: limegreen ;-fx-font-weight: bold;");
				view.getAddParty().clear();
			} catch (StringIsEmpty exeption) {
				view.getAddParty().getLbl().setText(exeption.getMessage());
				view.getAddParty().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (NullPointerException exeption) {
				view.getAddParty().getLbl().setText("Please Choose a faction! ");
				view.getAddParty().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (NumberFormatException exeption) {
				view.getAddParty().getLbl().setText(exeption.getMessage());
				view.getAddParty().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (IllegalArgumentException exeption) {
				view.getAddParty().getLbl().setText(exeption.getMessage());
				view.getAddParty().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			}
		});
	}

	private void addCandidateToParty() {
		view.getAddCitizenCandidate().getBtnAddCandidateToParty().setOnAction(e -> {
			int birthYear = 0;
			int daysInQuarentine = 0;
			try {
				String fullName = view.getAddCitizenCandidate().getFullName().getText();
				if (fullName.isEmpty()) {
					throw new StringIsEmpty("  Please Enter FullName!  ");
				}
				String id = view.getAddCitizenCandidate().getId().getText();
				model.checkID(id);
				birthYear = model.birthYear(view.getAddCitizenCandidate().getBirthYear().getText());
				boolean InQuarentine = view.getAddCitizenCandidate().getInQuarentinecbx().isSelected();
				if (InQuarentine) {
					try {
						daysInQuarentine = Integer.parseInt(view.getAddCitizenCandidate().getTfdiq().getText());
					} catch (NumberFormatException exception) {
						throw new NumberFormatException("  Please Enter Days In Quarentine!  ");
					}
				}
				boolean carryWeapon = view.getAddCitizenCandidate().getCarryWeaponcbx().isSelected();
				String kalpii = view.getAddCitizenCandidate().getKalpiesCbo().getValue();
				Ballot<? extends Citizen> kalpi = model.getKalpi(kalpii);
				String partyy = view.getAddCitizenCandidate().getPartiesCbo().getValue();
				Party party = model.getParty(partyy);
				if (birthYear < 1999) {
					carryWeapon = false;
				}
				model.addCitizenCandidate(fullName, id, birthYear, InQuarentine, daysInQuarentine, carryWeapon, kalpi,
						party);
				view.getAddCitizenCandidate().clear();
				view.getAddCitizenCandidate().getLbl().setText("  Candidate Added successfully!  ");
				view.getAddCitizenCandidate().getLbl()
						.setStyle("-fx-background-color: limegreen ;-fx-font-weight: bold;");
			} catch (StringIsEmpty exception) {
				view.getAddCitizenCandidate().getLbl().setText(exception.getMessage());
				view.getAddCitizenCandidate().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (NumberFormatException exception) {
				view.getAddCitizenCandidate().getLbl().setText(exception.getMessage());
				view.getAddCitizenCandidate().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (CitizenIdOutOfBoundExeption exception) {
				view.getAddCitizenCandidate().getLbl().setText("  Please Enter a 9 Digits ID!  ");
				view.getAddCitizenCandidate().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (CitizenIdIlligalArgumentExeption exception) {
				view.getAddCitizenCandidate().getLbl().setText("  Please Enter Digits in ID Field!  ");
				view.getAddCitizenCandidate().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (NullPointerException exception) {
				view.getAddCitizenCandidate().getLbl().setText(exception.getMessage());
				view.getAddCitizenCandidate().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (IllegalArgumentException exception) {
				view.getAddCitizenCandidate().getLbl().setText(exception.getMessage());
				view.getAddCitizenCandidate().getLbl().setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			}
		});
	}

	private void listAllBallots() {
		view.getMainMenu().getBt5().setOnAction(e -> {
			model.listAllBallots();
			view.listAllBallots();
		});

	}

	private void elections() {
		this.model.OrganizeBallotPreElections();
		this.view.getMainMenu().getBt8().setOnAction(e -> {
			this.view.runElections();
		});
		this.view.getRunElections().getBtnNo().setOnAction(e -> {
			try {
				this.view.getRunElections().nextCitizen();
			} catch (IllegalArgumentException exception) {
				this.view.setCenter(this.view.getRunElections().getFinishedElections());
				this.model.OrganizeBallotPostElections();
				System.out.println("Organizing Ballots!");
			}
		});
		this.view.getRunElections().getBtnYes().setOnAction(e -> {
			if (this.model.getCitizens().arr.get(this.view.getRunElections().getCount()).isInQuarantine()) {
				this.view.getRunElections().QuarantineCitizen();
			} else {
				this.view.getRunElections().yesClick();
			}
		});
		this.view.getRunElections().getBtnVote().setOnAction(e -> {
			try {
				String stringParty = this.view.getRunElections().getCboParties().getSelectionModel().getSelectedItem();
				Party party = model.getParty(stringParty);
				Ballot<? extends Citizen> kalpi = this.model.getCitizens().arr
						.get(this.view.getRunElections().getCount()).getKalpi();
				int partyID = party.getId();
				this.model.CitizenVote(kalpi, partyID);
				this.view.getRunElections().getCboParties().getSelectionModel().clearSelection();
				try {
					this.view.getRunElections().nextCitizen();
				} catch (IllegalArgumentException exception) {
					this.view.setCenter(this.view.getRunElections().getFinishedElections());
					this.model.OrganizeBallotPostElections();
				}

			} catch (NullPointerException exception) {
				this.view.getRunElections().getExceptionLbl().setText(exception.getMessage());
				this.view.getRunElections().getExceptionLbl()
						.setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			} catch (NumberFormatException exception) {
				this.view.getRunElections().getExceptionLbl().setText("Something Went Bad!");
				this.view.getRunElections().getExceptionLbl()
						.setStyle("-fx-background-color: TOMATO;-fx-font-weight: bold;");
			}

		});
		this.view.getRunElections().getRdb1().setOnAction(e -> {
			this.view.getRunElections().getRdb1().setSelected(false);
			this.view.getRunElections().yesClick();
		});
		this.view.getRunElections().getRdb2().setOnAction(e -> {
			try {
				this.view.getRunElections().nextCitizen();
				this.view.getRunElections().getRdb2().setSelected(false);
			} catch (IllegalArgumentException exception) {
				this.view.setCenter(this.view.getRunElections().getFinishedElections());
				this.model.OrganizeBallotPostElections();
			}
		});
	}

	private void electionsResults() {
		this.view.getMainMenu().getBt9().setOnAction(e -> {
			int[] voting = new int[this.model.getParties().size()];
			for (int i = 0; i < this.model.getParties().size(); i++) {
				for (int j = 0; j < this.model.getKalpies().size(); j++) {
					voting[i] += this.model.getKalpies().get(j).getVotesForParty(i);
				}
			}
			this.view.showElectionsResults(voting);
		});
	}
}
