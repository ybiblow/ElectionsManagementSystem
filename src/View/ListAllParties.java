package View;

import java.util.ArrayList;

import Model.Party;
import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;

public class ListAllParties {
	VBox listAllParties = new VBox(5);
	TreeTableView<Object> tTVP = new TreeTableView<>();

	public ListAllParties() {
		listAllParties.setPadding(new Insets(15));
	}

	public VBox getListAllParties() {
		return listAllParties;
	}

	public void updateTTVP(ArrayList<Party> parties) {
		this.tTVP = new TreeTableView<Object>();
		this.tTVP.setShowRoot(false);

		TreeTableColumn<Object, String> col1 = new TreeTableColumn<>("Party Name");
		col1.setStyle("-fx-alignment: CENTER;");
		TreeTableColumn<Object, String> col2 = new TreeTableColumn<>("Faction");
		col2.setStyle("-fx-alignment: CENTER;");
		TreeTableColumn<Object, Integer> col3 = new TreeTableColumn<>("Est. Year");
		col3.setStyle("-fx-alignment: CENTER;");
		TreeTableColumn<Object, Integer> col4 = new TreeTableColumn<>("Est. Month");
		col4.setStyle("-fx-alignment: CENTER;");
		TreeTableColumn<Object, Integer> col5 = new TreeTableColumn<>("ID");
		col5.setMinWidth(100);
		col5.setStyle("-fx-alignment: CENTER;");
		TreeTableColumn<Object, Integer> col6 = new TreeTableColumn<>("Citizen");
		col6.setMinWidth(130);
		col6.setStyle("-fx-alignment: CENTER;");

		col1.setCellValueFactory(new TreeItemPropertyValueFactory<>("partyName"));
		col2.setCellValueFactory(new TreeItemPropertyValueFactory<>("faction"));
		col3.setCellValueFactory(new TreeItemPropertyValueFactory<>("year"));
		col4.setCellValueFactory(new TreeItemPropertyValueFactory<>("month"));
		col5.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
		col6.setCellValueFactory(new TreeItemPropertyValueFactory<>("fullName"));

		this.tTVP.getColumns().add(col1);
		this.tTVP.getColumns().add(col2);
		this.tTVP.getColumns().add(col3);
		this.tTVP.getColumns().add(col4);
		this.tTVP.getColumns().add(col5);
		this.tTVP.getColumns().add(col6);

		TreeItem<Object> partiesTI = new TreeItem<>(new Party());

		for (int i = 0; i < parties.size(); i++) {
			TreeItem<Object> tmp1 = new TreeItem<Object>(parties.get(i));
			partiesTI.getChildren().add(tmp1);
			for (int j = 0; j < parties.get(i).getCandidates().size(); j++) {
				TreeItem<Object> tmp2 = new TreeItem<Object>(parties.get(i).getCandidates().get(j));
				tmp1.getChildren().add(tmp2);
			}
		}

		this.tTVP.setRoot(partiesTI);
		this.listAllParties.getChildren().clear();
		this.listAllParties.getChildren().add(tTVP);
	}
}
