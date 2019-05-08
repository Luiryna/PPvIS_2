package Model;

public class Student {
    private String surname;
    private String name;
    private String patronymic;
    private int groupNumb;
    private int missingDueDisease;
    private int missingDueOtherReason;
    private int missingWithoutReason;

    public Student(String surname, String name, String patronymic, int groupNumb, int missingDueDisease, int missingDueOtherReason, int missingWithoutReason){
        this.surname=surname;
        this.name = name;
        this.patronymic = patronymic;
        this.groupNumb=groupNumb;
        this.missingDueDisease=missingDueDisease;
        this.missingDueOtherReason=missingDueOtherReason;
        this.missingWithoutReason=missingWithoutReason;
    }

    public Student(){

    }

    public void setGroupNumb(int groupNumb) {
        this.groupNumb = groupNumb;
    }

    public int getGroupNumb() {
        return groupNumb;
    }

    public void setMissingDueDisease(int missingDueDisease) {
        this.missingDueDisease = missingDueDisease;
    }

    public int getMissingDueDisease() {
        return missingDueDisease;
    }

    public void setMissingDueOtherReason(int missingDueOtherReason) {
        this.missingDueOtherReason = missingDueOtherReason;
    }

    public int getMissingDueOtherReason() {
        return missingDueOtherReason;
    }

    public void setMissingWithoutReason(int missingWithoutReason) {
        this.missingWithoutReason = missingWithoutReason;
    }

    public int getMissingWithoutReason() {
        return missingWithoutReason;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
