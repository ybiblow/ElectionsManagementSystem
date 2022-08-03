package View;

import java.util.ArrayList;

import Model.Ballot;
import Model.Citizen;
import Model.Party;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ElectionsResults {
	private VBox electionsResults = new VBox(5);

	public ElectionsResults() {
		this.electionsResults.setPadding(new Insets(15));

	}

	public VBox getElectionsResults() {
		return electionsResults;
	}

	public void updateResults(ArrayList<Party> parties, ArrayList<Ballot<? extends Citizen>> kalpies, int[] voting) {
		this.electionsResults.getChildren().clear();
		for (int i = 0; i < voting.length; i++) {
			Label tmpLbl = new Label(parties.get(i).getPartyName() + ", got: " + voting[i] + ", Kolot");
			this.electionsResults.getChildren().add(tmpLbl);
		}
		for (int i = 0; i < kalpies.size(); i++) {
			Label tmpLbl = new Label(kalpies.get(i).getAddress() + ", " + kalpies.get(i).getBallotType() + ", "
					+ "Percentage of Votes: " + kalpies.get(i).getPerOfVotes() + "%");
			this.electionsResults.getChildren().add(tmpLbl);
		}
	}
}
