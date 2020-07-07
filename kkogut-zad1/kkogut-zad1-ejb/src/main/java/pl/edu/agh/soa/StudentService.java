package pl.edu.agh.soa;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import static pl.edu.agh.soa.StudentsList.studentsList;

@Stateless
@WebService
@MTOM(enabled = true, threshold = 2048)
public class StudentService {

    @WebMethod
    public Student getStudent(@WebParam(name = "id") int id) {
        return studentsList.get(id);
    }

    @WebMethod
    public StudentsList getStudents() {
        return studentsList;
    }

    @WebMethod
    public PojoStudentsList getStudentsByFirstName(@WebParam(name = "firstName") String firstName) {
        return studentsList.getStudentsByFirstName(firstName, false);
    }

    @WebMethod
    public PojoStudentsList getStudentsByLastName(@WebParam(name = "lastName") String lastName) {
        return studentsList.getStudentsByLastName(lastName, false);
    }

    @WebMethod
    public PojoStudentsList getStudentsBySubject(@WebParam(name = "subjectName") String subjectName) {
        return studentsList.getStudentsBySubject(subjectName);
    }

    @WebMethod
    public String getStudentAvatar(@WebParam(name = "id") int id) {
        return studentsList.getStudentAvatar(id);
    }
}
