package Model;

import java.util.ArrayList;

public class Ballot<T extends Citizen> {
	private static int numOfBallots = 0;
	private int id, numOfCitizens;
	private float perOfVotes;
	private String address;
	private int votes[]; // index - id of party, cell - number of votes
	private ArrayList<Citizen> votingCitizens;

	private BallotType BallotType;

	public enum BallotType {
		Regular, Army, Corona, ArmyCorona
	}

	public ArrayList<? extends Citizen> getVotingCitizens() {
		return votingCitizens;
	}

	public BallotType getBallotType() {
		return BallotType;
	}

	public Ballot() {
		super();
//		this.id = numOfBallots;
//		numOfBallots++;
	}

	public Ballot(String address, BallotType BallotType) {
		this.address = address;
		this.id = numOfBallots;
		this.BallotType = BallotType;
		numOfBallots++;
	}

	public Ballot(String address) {
		this.address = address;
		this.id = numOfBallots;
		numOfBallots++;
	}

	public static int getNumOfBallots() {
		return numOfBallots;
	}

	public String getAddress() {
		return address;
	}

	public void increaseNumOfCitizens() {
		numOfCitizens++;
	}

	public void printIDAndAddress() {
		System.out.println(id + " " + address + " ");
	}

	public void setVotes(int numOfParties) {
		this.votes = new int[numOfParties];
	}

	public int getId() {
		return id;
	}

	public int getNumOfCitizens() {
		return numOfCitizens;
	}

	public float getPerOfVotes() {
		return perOfVotes;
	}

	public int[] getVotes() {
		return votes;
	}

	public void Vote(int partyID) {
		this.votes[partyID]++;
	}

	public int getVotesForParty(int id) {
		return votes[id];
	}

	public void CalculateVotes() {
		int numOfVotes = 0;
		for (int i = 0; i < votes.length; i++) {
			numOfVotes += votes[i];
		}
		if (numOfCitizens != 0) {
			perOfVotes = numOfVotes * 100 / numOfCitizens;
		} else {
			perOfVotes = 0;
		}

	}

	public void setVotingCitizens(ArrayList<Citizen> votingCitizens) {
		this.votingCitizens = votingCitizens;
	}

	public String toString() {
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < votingCitizens.size(); i++) {
			sbf.append(votingCitizens.get(i).toString() + "\n");
		}
		return "Ballot-Type: " + getBallotType() + ", ID: " + id + ", " + "Address: " + address + "\n"
				+ "Citizens in Kalpi: \n" + sbf;
	}

}
