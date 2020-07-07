package pl.edu.agh.soa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@XmlRootElement
class StudentsList {

    final static StudentsList studentsList;

    static {
        studentsList = new StudentsList();
    }

    private int uniqueStudentId;
    private List<Student> students;

    private StudentsList() {
        uniqueStudentId = 1;

        List<Subject> subjectsMock = new ArrayList<Subject>() {{
            add(new Subject(1, "Math"));
            add(new Subject(2, "English"));
            add(new Subject(3, "PE"));
        }};

        students = new ArrayList<>();
        students.add(new Student(uniqueStudentId++, "Krzysztof", "Kogut", subjectsMock, null));
        students.add(new Student(uniqueStudentId++, "Jan", "Kowalski", subjectsMock, null));
        students.add(new Student(uniqueStudentId++, "Jakub", "Nowak", subjectsMock, null));
        students.add(new Student(uniqueStudentId++, "Miłosz", "Kowalczyk", subjectsMock, null));
        students.add(new Student(uniqueStudentId++, "Piotr", "Wójcik", subjectsMock, null));
        students.add(new Student(uniqueStudentId++, "Paweł", "Wiśniewski", subjectsMock, null));
    }

    void add(String firstName, String lastName, List<Subject> subjects, byte[] avatar) {
        students.add(new Student(uniqueStudentId++, firstName, lastName, subjects, avatar));
    }

    void remove(int id) {
        if (id < 0) {
            return;
        }
        students.removeIf(student -> student.getId() == id);
    }

    void edit(int id, String firstName, String lastName, List<Subject> subjects, byte[] avatar) {
        Student student = this.get(id);

        if (student == null) {
            return;
        }

        if (firstName != null && !firstName.equals("")) {
            student.setFirstName(firstName);
        }
        if (lastName != null && !lastName.equals("")) {
            student.setLastName(lastName);
        }
        if (subjects != null) {
            if (subjects.size() == 1 && subjects.get(0).getId() == -1) {
                student.setSubjects(null);
            } else {
                student.setSubjects(subjects);
            }
        }
        if (avatar != null && avatar.length > 0) {
            student.setAvatar(avatar);
        }
    }

    Student get(int id) {
        if (id < 0) {
            return null;
        }

        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    void setStudents(List<Student> students) {
        this.students = students;
    }

    @XmlElementWrapper
    @XmlElement(name = "student")
    List<Student> getStudents() {
        return students;
    }

    String getStudentAvatar(int id) {
        Student student = this.get(id);
        return student != null ? student.getAvatar() : null;
    }

    PojoStudentsList getStudentsByFirstName(String firstName, boolean caseSensitive) {
        return new PojoStudentsList(filterBy(firstName, "firstName", caseSensitive));
    }

    PojoStudentsList getStudentsByLastName(String lastName, boolean caseSensitive) {
        return new PojoStudentsList(filterBy(lastName, "lastName", caseSensitive));
    }

    PojoStudentsList getStudentsBySubject(String subjectName) {
        final Pattern pattern = Pattern.compile(Pattern.quote(subjectName), Pattern.CASE_INSENSITIVE);

        List<Student> result = students
                .stream().filter(student -> student.getSubjects() != null && student.getSubjects()
                        .stream().anyMatch(subject -> pattern.matcher(subject.getName()).find())).collect(Collectors.toList());

        return new PojoStudentsList(result);
    }

    private List<Student> filterBy(String name, String fieldName, boolean caseSensitive) {
        final Pattern pattern = Pattern.compile(Pattern.quote(name), caseSensitive ? 0 : Pattern.CASE_INSENSITIVE);

        return students
                .stream().filter(student -> {
                    try {
                        Field field = student.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        return pattern.matcher((String) field.get(student)).find();
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                }).collect(Collectors.toList());
    }
}
