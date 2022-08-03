
import java.util.ArrayList;
import Controller.Controller;
import Model.Ballot;
import Model.Citizen;
import Model.Manage;
import Model.Model;
import Model.MySet;
import Model.Party;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MySet<Citizen> citizens = new MySet<>();
		ArrayList<Party> parties = new ArrayList<>();
		ArrayList<Ballot<? extends Citizen>> kalpies = new ArrayList<>();
		Manage.hardCodedStart(citizens, parties, kalpies);
		Model model = new Model(citizens, parties, kalpies);
		View view = new View(primaryStage, citizens, kalpies, parties);
		new Controller(model, view);
	}
}