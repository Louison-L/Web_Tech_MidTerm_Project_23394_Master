package model;

public enum EAcademicUnit {
    PROGRAM("Program"),
    FACULTY("Faculty"),
    DEPARTMENT("Department");

    private final String label;

    EAcademicUnit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}