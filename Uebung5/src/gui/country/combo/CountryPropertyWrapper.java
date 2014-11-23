package gui.country.combo;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class CountryPropertyWrapper {
    private SimpleStringProperty name;

    private SimpleStringProperty capital;

    private SimpleLongProperty people;

    private SimpleLongProperty area;

    private Country base;

    public CountryPropertyWrapper(String name, String capital, long people, long area) {
        this(new Country(name, capital, people, area));
    }

    public CountryPropertyWrapper(Country base) {
        this.base = base;
        this.name = new SimpleStringProperty(this.base.getName());
        this.capital = new SimpleStringProperty(this.base.getCapital());
        this.people = new SimpleLongProperty(this.base.getPeople());
        this.area = new SimpleLongProperty(this.base.getArea());
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public SimpleStringProperty getCapital() {
        return capital;
    }

    public SimpleLongProperty getPeople() {
        return people;
    }

    public SimpleLongProperty getArea() {
        return area;
    }

    @Override
    public String toString() {
        return getName().toString();
    }
}
