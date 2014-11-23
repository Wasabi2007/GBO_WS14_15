package gui.people;

public class Person {
    private String vornamen;

    private String nachnamen;

    private String funktion;

    public Person(String vornamen, String nachnamen, String funktion) {
        super();
        this.vornamen = vornamen;
        this.nachnamen = nachnamen;
        this.funktion = funktion;
    }

    public String getVornamen() {
        return this.vornamen;
    }

    public void setVornamen(String vornamen) {
        this.vornamen = vornamen;
    }

    public String getNachnamen() {
        return this.nachnamen;
    }

    public void setNachnamen(String nachnamen) {
        this.nachnamen = nachnamen;
    }

    public String getFunktion() {
        return this.funktion;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    @Override
    public String toString() {
        return this.nachnamen;
    }

}
