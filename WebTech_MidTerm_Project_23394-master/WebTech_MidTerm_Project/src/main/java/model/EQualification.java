package model;

public enum EQualification {
	
	MASTER("Master"),
	PHD("PHD"),
	PROFESSOR("Professor");
	
	private final String label;

	EQualification(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
