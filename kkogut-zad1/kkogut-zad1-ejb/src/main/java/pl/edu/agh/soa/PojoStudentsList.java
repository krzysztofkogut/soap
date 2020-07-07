package pl.edu.agh.soa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

class PojoStudentsList {
    private List<Student> students;

    PojoStudentsList(List<Student> students) {
        this.students = students;
    }

    void setStudents(List<Student> students) {
        this.students = students;
    }

    @XmlElementWrapper
    @XmlElement(name = "student")
    List<Student> getStudents() {
        return students;
    }
}