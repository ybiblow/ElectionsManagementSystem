package View;

import java.util.ArrayList;

import Model.Ballot;
import Model.Citizen;
import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;

public class ListAllBallots {
	private VBox listAllBallots = new VBox(5);
	private TreeTableView<Object> treeTableViewBallot = new TreeTableView<Object>();

	public ListAllBallots() {
		listAllBallots.setPadding(new Insets(15));

		listAllBallots.getChildren().add(treeTableViewBallot);
	}

	public void setTreeTableViewBallot(TreeTableView<Object> treeTableViewBallot) {
		this.treeTableViewBallot = treeTableViewBallot;
	}

	public VBox getListAllBallots() {
		return listAllBallots;
	}

	public void updateTreeTableView(ArrayList<Ballot<? extends Citizen>> kalpies) {
		this.treeTableViewBallot = new TreeTableView<>();
		this.treeTableViewBallot.setShowRoot(false);

		TreeTableColumn<Object, String> treeTableColumn1 = new TreeTableColumn<>("Ballot");
		treeTableColumn1.setMinWidth(210);
		TreeTableColumn<Object, String> treeTableColumn2 = new TreeTableColumn<>("BallotType");
		TreeTableColumn<Object, String> treeTableColumn3 = new TreeTableColumn<>("Citizen");
		treeTableColumn3.setMinWidth(120);
		TreeTableColumn<Object, Integer> treeTableColumn4 = new TreeTableColumn<>("ID");
		treeTableColumn4.setMinWidth(70);
		TreeTableColumn<Object, Integer> treeTableColumn5 = new TreeTableColumn<>("Birth Year");
		TreeTableColumn<Object, Boolean> treeTableColumn6 = new TreeTableColumn<>("Quarentine");
		TreeTableColumn<Object, String> treeTableColumn7 = new TreeTableColumn<>("Days In Quarentine");
		TreeTableColumn<Object, Boolean> treeTableColumn8 = new TreeTableColumn<>("Carry Weapon");

		treeTableColumn1.setCellValueFactory(new TreeItemPropertyValueFactory<>("address"));
		treeTableColumn2.setCellValueFactory(new TreeItemPropertyValueFactory<>("BallotType"));
		treeTableColumn3.setCellValueFactory(new TreeItemPropertyValueFactory<>("fullName"));
		treeTableColumn4.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
		treeTableColumn5.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthYear"));
		treeTableColumn6.setCellValueFactory(new TreeItemPropertyValueFactory<>("inQuarantine"));
		treeTableColumn7.setCellValueFactory(new TreeItemPropertyValueFactory<>("daysInQuarentine"));
		treeTableColumn8.setCellValueFactory(new TreeItemPropertyValueFactory<>("cWeapon"));

		treeTableViewBallot.getColumns().add(treeTableColumn1);
		treeTableColumn1.setStyle("-fx-alignment: CENTER;");
		treeTableViewBallot.getColumns().add(treeTableColumn2);
		treeTableColumn2.setStyle("-fx-alignment: CENTER;");
		treeTableViewBallot.getColumns().add(treeTableColumn3);
		treeTableColumn3.setStyle("-fx-alignment: CENTER;");
		treeTableViewBallot.getColumns().add(treeTableColumn4);
		treeTableColumn4.setStyle("-fx-alignment: CENTER;");
		treeTableViewBallot.getColumns().add(treeTableColumn5);
		treeTableColumn5.setStyle("-fx-alignment: CENTER;");
		treeTableViewBallot.getColumns().add(treeTableColumn6);
		treeTableColumn6.setStyle("-fx-alignment: CENTER;");
		treeTableViewBallot.getColumns().add(treeTableColumn7);
		treeTableColumn7.setStyle("-fx-alignment: CENTER;");
		treeTableViewBallot.getColumns().add(treeTableColumn8);
		treeTableColumn8.setStyle("-fx-alignment: CENTER;");

		TreeItem<Object> ballots = new TreeItem<>(new Ballot<Citizen>());

		for (int i = 0; i < kalpies.size(); i++) {
			TreeItem<Object> tmp = new TreeItem<Object>(kalpies.get(i));
			for (int j = 0; j < kalpies.get(i).getVotingCitizens().size(); j++) {
				TreeItem<Object> tmp1 = new TreeItem<Object>(kalpies.get(i).getVotingCitizens().get(j));
				tmp.getChildren().add(tmp1);
			}
			ballots.getChildren().add(tmp);
		}

		treeTableViewBallot.setRoot(ballots);
		this.listAllBallots.getChildren().clear();
		this.listAllBallots.getChildren().add(treeTableViewBallot);

	}

}
