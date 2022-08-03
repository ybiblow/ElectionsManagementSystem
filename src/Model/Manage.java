package Model;

import java.util.ArrayList;

import Model.Ballot.BallotType;

public class Manage {

	public static void hardCodedStart(MySet<Citizen> citizens, ArrayList<Party> parties,
			ArrayList<Ballot<? extends Citizen>> kalpies) {
//		adding parties
		parties.add(new Party("Likud", "Right", 1973, 9));
		parties.add(new Party("Ha-Avoda", "Left", 1968, 1));
		parties.add(new Party("Shas", "Right", 1984, 10));
//		adding kalpies
		kalpies.add(new Ballot<>("Herzliya", BallotType.Regular));
		kalpies.add(new Ballot<>("Tel-Aviv", BallotType.Regular));
		kalpies.add(new Ballot<>("Jerusalem", BallotType.Regular));
		kalpies.add(new Ballot<>("Tel-Nof", BallotType.Army));
		kalpies.add(new Ballot<>("Tel-Aviv", BallotType.Corona));
		kalpies.add(new Ballot<>("Tel-Nof", BallotType.ArmyCorona));
//		adding citizens
		citizens.add(new CitizenCandidate("Benjamin Netanyahu", "193568782", 1949, kalpies.get(1), parties.get(0)));
		citizens.add(new CitizenCandidate("Nir Barkat", "193565784", 1959, kalpies.get(2), parties.get(0)));
		citizens.add(new CitizenCandidate("Amir Peretz", "193565123", 1952, kalpies.get(1), parties.get(1)));
		citizens.add(new CitizenCandidate("Orly Levy", "201978123", 1973, kalpies.get(0), parties.get(1)));
		citizens.add(new CitizenCandidate("Arie Deri", "194625205", 1959, kalpies.get(2), parties.get(2)));
		citizens.add(new CitizenCandidate("Yitzhak Cohen", "194624564", 1951, kalpies.get(2), parties.get(2)));
		citizens.add(new Citizen("Yaacov Biblow", "358429588", 1994, kalpies.get(0)));
		citizens.add(new Citizen("John Smith", "202846963", 1990, true, 14, kalpies.get(4)));
		citizens.add(new Citizen("Jason Born", "182747656", 2001, kalpies.get(3)));
		citizens.arr.get(citizens.arr.size() - 1).carryWeapon();
		citizens.add(new Citizen("Gavriel Israelov", "205478588", 2000, true, 28, kalpies.get(5)));
	}

	public static void addBallot(String address, BallotType bType, ArrayList<Ballot<? extends Citizen>> kalpies) {
		kalpies.add(new Ballot<>(address, bType));
	}

	public static void addCitizen(MySet<Citizen> citizens, String fullName, String id, int birthYear,
			boolean inQuarentine, int daysInQuarentine, boolean carryWeapon, Ballot<? extends Citizen> kalpi) {
		if (inQuarentine) {
			citizens.add(new Citizen(fullName, id, birthYear, inQuarentine, daysInQuarentine, kalpi));
		} else {
			citizens.add(new Citizen(fullName, id, birthYear, kalpi));
		}
		if (carryWeapon) {
			citizens.arr.get(citizens.arr.size() - 1).carryWeapon();
		}
	}

	public static void addCitizen(MySet<Citizen> citizens, String fullName, String id, int birthYear,
			boolean inQuarentine, int daysInQuarentine, boolean carryWeapon, Ballot<? extends Citizen> kalpi,
			Party candidate) {
		if (inQuarentine) {
			citizens.add(
					new CitizenCandidate(fullName, id, birthYear, inQuarentine, daysInQuarentine, kalpi, candidate));
		} else {
			citizens.add(new CitizenCandidate(fullName, id, birthYear, kalpi, candidate));
		}
		if (carryWeapon) {
			citizens.arr.get(citizens.arr.size() - 1).carryWeapon();
		}
	}

	public static void addParty(ArrayList<Party> parties, String partyName, String faction, int year, int month) {
		parties.add(new Party(partyName, faction, year, month));
	}

	public static void OrganizeBallotPreElections(MySet<Citizen> citizens, ArrayList<Ballot<? extends Citizen>> kalpies,
			int numOfParties) {
		for (int i = 0; i < kalpies.size(); i++) {
			kalpies.get(i).setVotes(numOfParties);
			for (int j = 0; j < citizens.arr.size(); j++) {
				if (citizens.arr.get(j).getKalpi().getId() == kalpies.get(i).getId()) {
					kalpies.get(i).increaseNumOfCitizens();
				}
			}
		}

	}

	public static void CitizenVote(Ballot<? extends Citizen> kalpi, int partyID) {
		kalpi.Vote(partyID);

	}

	public static void OrganizeBallotPostElections(Ballot<? extends Citizen> kalpies) {
		kalpies.CalculateVotes();

	}

	public static <T extends Citizen> void setVotingCitizens(MySet<Citizen> citizens, Ballot<? extends Citizen> kalpi) {
		ArrayList<Citizen> votingCitizens = new ArrayList<>();

		for (int i = 0; i < citizens.arr.size(); i++) {
			if (citizens.arr.get(i).getKalpi().getId() == kalpi.getId()) {
				votingCitizens.add(citizens.arr.get(i));
			}
		}
		kalpi.setVotingCitizens(votingCitizens);
	}
}
