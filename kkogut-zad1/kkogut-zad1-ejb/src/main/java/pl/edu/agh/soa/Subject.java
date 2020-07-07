package pl.edu.agh.soa;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Subject {

    private int id;
    private String name;

    Subject() {
        this.id = 0;
        this.name = "";
    }

    Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    int getId() {
        return id;
    }

    @XmlAttribute
    String getName() {
        return name;
    }
}