package Model;

public class CitizenCandidate extends Citizen {
	private Party candidateInParty;

	public Party getCandidateInParty() {
		return candidateInParty;
	}

	public CitizenCandidate(String fullName, String id, int birthYear, Ballot<? extends Citizen> kalpi,
			Party candidateInParty) {
		super(fullName, id, birthYear, kalpi);
		this.candidateInParty = candidateInParty;
	}

	public CitizenCandidate(String fullName, String id, int birthYear, boolean inQuarentine, int daysInQuarentine,
			Ballot<? extends Citizen> kalpi, Party candidateInParty) {
		super(fullName, id, birthYear, inQuarentine, daysInQuarentine, kalpi);
		this.candidateInParty = candidateInParty;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "CandidateInParty: " + candidateInParty.getPartyName();
	}

}
