package Model;

public class Citizen implements Comparable<Citizen> {
	private String fullName, id;
	private int birthYear, daysInQuarentine;
	private Ballot<? extends Citizen> kalpi;
	private boolean inQuarantine, cWeapon;

	public Citizen() {
		super();
	}

	public Citizen(String fullName, String id, int birthYear, Ballot<? extends Citizen> kalpi) {
		super();
		this.fullName = fullName;
		this.id = id;
		this.birthYear = birthYear;
		this.inQuarantine = false;
		this.cWeapon = false;
		this.kalpi = kalpi;
	}

	public Citizen(String fullName, String id, int birthYear, boolean inQuarentine, int daysInQuarentine,
			Ballot<? extends Citizen> kalpi) {
		super();
		this.fullName = fullName;
		this.id = id;
		this.birthYear = birthYear;
		this.cWeapon = false;
		this.inQuarantine = inQuarentine;
		this.daysInQuarentine = daysInQuarentine;
		this.kalpi = kalpi;
	}

	public String getId() {
		return id;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public String getFullName() {
		return fullName;
	}

	public int getDaysInQuarentine() {
		return daysInQuarentine;
	}

	public Ballot<? extends Citizen> getKalpi() {
		return kalpi;
	}

	public boolean isCWeapon() {
		return cWeapon;
	}

	public void setDaysInQuarentine(int daysInQuarentine) {
		this.daysInQuarentine = daysInQuarentine;
	}

	/**
	 * Citizen in Quarantine?
	 * 
	 * @return Quarantine status true/false
	 */
	public boolean isInQuarantine() {
		return inQuarantine;
	}

	public void carryWeapon() {
		this.cWeapon = true;
	}

	@Override
	public int compareTo(Citizen o) {
		return this.id.compareTo(o.getId());
	}

	@Override
	public String toString() {
		return "ID: " + id + ", " + "FullName: " + fullName + ", " + "BirthYear: " + birthYear + ", " + "Ballot: "
				+ kalpi.getAddress() + ", Ballot-Type: " + kalpi.getBallotType() + ", " + "inQuarentine: "
				+ inQuarantine;
	}

}
