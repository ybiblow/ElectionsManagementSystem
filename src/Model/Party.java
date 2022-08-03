package Model;

import java.util.ArrayList;

public class Party {
	private static int numOfParties = 0;
	private int id;
	private String partyName, faction;
	private int year, month;
	private ArrayList<Citizen> candidates = new ArrayList<>();

	public Party() {
		super();
//		this.id = numOfParties;
//		numOfParties++;
	}

	public Party(String partyName, String faction, int year, int month) {
		super();
		this.partyName = partyName;
		this.faction = faction;
		this.year = year;
		this.month = month;
		this.id = numOfParties;
		numOfParties++;
	}

	public String getFaction() {
		return faction;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public void printID() {
		System.out.println("ID: " + id + ", " + partyName);
	}

	public String getPartyName() {
		return partyName;
	}

	public int getId() {
		return id;
	}

	public static int getNumOfParties() {
		return numOfParties;
	}

	public void updateCandidates(MySet<Citizen> citizens) {
		ArrayList<Citizen> tmp = new ArrayList<>();
		for (int i = 0; i < citizens.arr.size(); i++) {
			if (citizens.arr.get(i) instanceof CitizenCandidate) {
				if (((CitizenCandidate) citizens.arr.get(i)).getCandidateInParty() == this) {
					tmp.add(citizens.arr.get(i));
				}
			}
		}
		this.candidates = tmp;
	}

	public ArrayList<Citizen> getCandidates() {
		return candidates;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", " + "PartyName: " + partyName + ", " + "Faction: " + faction + ", "
				+ "Foundation Date: " + month + "," + year;
	}

}
