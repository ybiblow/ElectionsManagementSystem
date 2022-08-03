package Model;

import java.util.ArrayList;

import Model.Ballot.BallotType;

public class Model {
	private MySet<Citizen> citizens;
	private ArrayList<Party> parties;
	private ArrayList<Ballot<? extends Citizen>> kalpies;

	public Model(MySet<Citizen> citizens, ArrayList<Party> parties, ArrayList<Ballot<? extends Citizen>> kalpies) {
		this.citizens = citizens;
		this.parties = parties;
		this.kalpies = kalpies;
	}

	public MySet<Citizen> getCitizens() {
		return citizens;
	}

	public ArrayList<Party> getParties() {
		return parties;
	}

	public ArrayList<Ballot<? extends Citizen>> getKalpies() {
		return kalpies;
	}

	public void listAllBallots() {
		for (int i = 0; i < kalpies.size(); i++) {
			Manage.setVotingCitizens(citizens, kalpies.get(i));
//			System.out.println(kalpies.get(i).toString());
		}
	}

	public Ballot<? extends Citizen> getKalpi(String kalpii) throws NullPointerException {
		if (kalpii == null) {
			throw new NullPointerException("  Please Choose a Kalpi!  ");
		}
		StringBuffer kalpiID = new StringBuffer();
		kalpiID.append(kalpii.charAt(0));
		for (int i = 1; i < kalpii.length(); i++) {
			if (kalpii.charAt(i) == '.') {
				return kalpies.get(Integer.parseInt(kalpiID.toString()));
			}
			kalpiID.append(kalpii.charAt(i));
		}
		return null;
	}

	public Party getParty(String partyy) {
		if (partyy == null) {
			throw new NullPointerException("  Please Choose a Party!  ");
		}
		StringBuffer partyID = new StringBuffer();
		partyID.append(partyy.charAt(0));
		for (int i = 1; i < partyy.length(); i++) {
			if (partyy.charAt(i) == '.') {
				return parties.get(Integer.parseInt(partyID.toString()));
			}
			partyID.append(partyy.charAt(i));
		}
		return null;
	}

	public void addBallot(String address, String ballotType, ArrayList<Ballot<? extends Citizen>> kalpies) {
		BallotType bType = null;
		if (ballotType.equals("Regular")) {
			bType = BallotType.Regular;
		} else if (ballotType.equals("Corona")) {
			bType = BallotType.Corona;
		} else if (ballotType.equals("Army")) {
			bType = BallotType.Army;
		} else if (ballotType.equals("ArmyCorona")) {
			bType = BallotType.ArmyCorona;
		}
		Manage.addBallot(address, bType, kalpies);
	}

	public void addCitizen(String fullName, String id, int birthYear, boolean inQuarentine, int daysInQuarentine,
			boolean carryWeapon, Ballot<? extends Citizen> kalpi) {
		if (birthYear < 1999) {
			if (inQuarentine && !(kalpi.getBallotType() == BallotType.Corona)) {
				throw new IllegalArgumentException("  Please Choose a \"Corona\" Kalpi!  ");
			} else if (!inQuarentine && !(kalpi.getBallotType() == BallotType.Regular)) {
				throw new IllegalArgumentException("  Please Choose a \"Regular\" Kalpi!  ");
			}
		} else if (birthYear > 1998) {
			if (inQuarentine && !(kalpi.getBallotType() == BallotType.ArmyCorona)) {
				throw new IllegalArgumentException("  Please Choose a \"ArmyCorona\" Kalpi!  ");
			} else if (!inQuarentine && !(kalpi.getBallotType() == BallotType.Army)) {
				throw new IllegalArgumentException("  Please Choose a \"Army\" Kalpi!  ");
			}
		}
		Manage.addCitizen(citizens, fullName, id, birthYear, inQuarentine, daysInQuarentine, carryWeapon, kalpi);

	}

	public void addParty(String partyName, String faction, int estMonth, int estYear) {
		Manage.addParty(this.parties, partyName, faction, estYear, estMonth);
	}

	public void addCitizenCandidate(String fullName, String id, int birthYear, boolean inQuarentine,
			int daysInQuarentine, boolean carryWeapon, Ballot<? extends Citizen> kalpi, Party party) {
		if (birthYear < 1999) {
			if (inQuarentine && !(kalpi.getBallotType() == BallotType.Corona)) {
				throw new IllegalArgumentException("  Please Choose a \"Corona\" Kalpi!  ");
			} else if (!inQuarentine && !(kalpi.getBallotType() == BallotType.Regular)) {
				throw new IllegalArgumentException("  Please Choose a \"Regular\" Kalpi!  ");
			}
		} else if (birthYear > 1998) {
			if (inQuarentine && !(kalpi.getBallotType() == BallotType.ArmyCorona)) {
				throw new IllegalArgumentException("  Please Choose a \"ArmyCorona\" Kalpi!  ");
			} else if (!inQuarentine && !(kalpi.getBallotType() == BallotType.Army)) {
				throw new IllegalArgumentException("  Please Choose a \"Army\" Kalpi!  ");
			}
		}
		Manage.addCitizen(citizens, fullName, id, birthYear, inQuarentine, daysInQuarentine, carryWeapon, kalpi, party);
	}

	public void checkID(String id) throws CitizenIdOutOfBoundExeption, CitizenIdIlligalArgumentExeption {
		try {
			Integer.parseInt(id);
		} catch (NumberFormatException e) {
			throw new CitizenIdIlligalArgumentExeption();
		}
		if (id.length() != 9) {
			throw new CitizenIdOutOfBoundExeption();
		}
	}

	public int daysInQuarentine(String daysInQuarentine) {
		int a = 0;
		try {
			a = Integer.parseInt(daysInQuarentine);
		} catch (Exception e) {
			throw new NumberFormatException("Please Enter Days In Quarentine!");
		}
		return a;
	}

	public int birthYear(String birthYear) {
		int a = 0;
		try {
			a = Integer.parseInt(birthYear);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Please Enter BirthYear!");
		}
		try {
			if (a > 2020 || a < 1910) {
				throw new NumberFormatException("Please Enter a correct BirthYear!");
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException(e.getMessage());
		}
		return a;
	}

	public void OrganizeBallotPreElections() {
		Manage.OrganizeBallotPreElections(citizens, kalpies, parties.size());
	}

	public void CitizenVote(Ballot<? extends Citizen> kalpi, int partyID) {
		Manage.CitizenVote(kalpi, partyID);
	}

	public void OrganizeBallotPostElections() {
		for (int i = 0; i < kalpies.size(); i++) {
			Manage.OrganizeBallotPostElections(kalpies.get(i));
		}
	}
}
