package View;

import Model.Citizen;
import Model.MySet;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;

public class ListAllCitizens {
	private VBox listallCitizens = new VBox(5);
	private TreeTableView<Object> tTVC = new TreeTableView<Object>();

	public ListAllCitizens() {
		listallCitizens.setPadding(new Insets(15));

	}

	public VBox getListallCitizens() {
		return listallCitizens;
	}

	public void updatetTVC(MySet<Citizen> citizens) {
		this.tTVC = new TreeTableView<Object>();
		this.tTVC.setShowRoot(false);

		TreeTableColumn<Object, String> treeTableColumn1 = new TreeTableColumn<>("Full Name");
		TreeTableColumn<Object, String> treeTableColumn2 = new TreeTableColumn<>("ID");
		TreeTableColumn<Object, Integer> treeTableColumn3 = new TreeTableColumn<>("Birth Year");
		TreeTableColumn<Object, String> treeTableColumn4 = new TreeTableColumn<>("Kalpi");
		TreeTableColumn<Object, Boolean> treeTableColumn5 = new TreeTableColumn<>("inQuarantine");
		TreeTableColumn<Object, Integer> treeTableColumn6 = new TreeTableColumn<>("Days In Quarentine");
		TreeTableColumn<Object, Boolean> treeTableColumn7 = new TreeTableColumn<>("Carry Weapon");

		treeTableColumn1.setCellValueFactory(new TreeItemPropertyValueFactory<>("fullName"));
		treeTableColumn2.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
		treeTableColumn3.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthYear"));
		treeTableColumn4.setCellValueFactory(
				data -> new SimpleStringProperty(((Citizen) data.getValue().getValue()).getKalpi().getAddress()));
		treeTableColumn5.setCellValueFactory(new TreeItemPropertyValueFactory<>("inQuarantine"));
		treeTableColumn6.setCellValueFactory(new TreeItemPropertyValueFactory<>("daysInQuarentine"));
		treeTableColumn7.setCellValueFactory(new TreeItemPropertyValueFactory<>("cWeapon"));

		this.tTVC.getColumns().add(treeTableColumn1);
		treeTableColumn1.setStyle("-fx-alignment: CENTER;");
		this.tTVC.getColumns().add(treeTableColumn2);
		treeTableColumn2.setStyle("-fx-alignment: CENTER;");
		this.tTVC.getColumns().add(treeTableColumn3);
		treeTableColumn3.setStyle("-fx-alignment: CENTER;");
		this.tTVC.getColumns().add(treeTableColumn4);
		treeTableColumn4.setStyle("-fx-alignment: CENTER;");
		this.tTVC.getColumns().add(treeTableColumn5);
		treeTableColumn5.setStyle("-fx-alignment: CENTER;");
		this.tTVC.getColumns().add(treeTableColumn6);
		treeTableColumn6.setStyle("-fx-alignment: CENTER;");
		this.tTVC.getColumns().add(treeTableColumn7);
		treeTableColumn7.setStyle("-fx-alignment: CENTER;");

		TreeItem<Object> citizen = new TreeItem<>(new Citizen());
		for (int i = 0; i < citizens.arr.size(); i++) {
			TreeItem<Object> tmp = new TreeItem<Object>(citizens.arr.get(i));
			citizen.getChildren().add(tmp);
		}
		this.tTVC.setRoot(citizen);
		this.listallCitizens.getChildren().clear();
		this.listallCitizens.getChildren().add(tTVC);
	}
}
