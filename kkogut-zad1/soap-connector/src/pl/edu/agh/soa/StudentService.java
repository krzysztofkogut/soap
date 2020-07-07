package pl.edu.agh.soa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


@WebService(targetNamespace = "http://soa.agh.edu.pl/", name = "StudentService")
@XmlSeeAlso({ObjectFactory.class})
public interface StudentService {

    @WebMethod
    @RequestWrapper(localName = "getStudent", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudent")
    @ResponseWrapper(localName = "getStudentResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentResponse")
    @WebResult(name = "return", targetNamespace = "")
    public pl.edu.agh.soa.Student getStudent(
        @WebParam(name = "id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "getStudentsByLastName", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsByLastName")
    @ResponseWrapper(localName = "getStudentsByLastNameResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsByLastNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public pl.edu.agh.soa.PojoStudentsList getStudentsByLastName(
        @WebParam(name = "lastName", targetNamespace = "")
        java.lang.String lastName
    );

    @WebMethod
    @RequestWrapper(localName = "getStudentAvatar", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentAvatar")
    @ResponseWrapper(localName = "getStudentAvatarResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentAvatarResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getStudentAvatar(
        @WebParam(name = "id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "getStudents", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudents")
    @ResponseWrapper(localName = "getStudentsResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public pl.edu.agh.soa.StudentsList getStudents();

    @WebMethod
    @RequestWrapper(localName = "getStudentsByFirstName", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsByFirstName")
    @ResponseWrapper(localName = "getStudentsByFirstNameResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsByFirstNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public pl.edu.agh.soa.PojoStudentsList getStudentsByFirstName(
        @WebParam(name = "firstName", targetNamespace = "")
        java.lang.String firstName
    );

    @WebMethod
    @RequestWrapper(localName = "getStudentsBySubject", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsBySubject")
    @ResponseWrapper(localName = "getStudentsBySubjectResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.GetStudentsBySubjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public pl.edu.agh.soa.PojoStudentsList getStudentsBySubject(
        @WebParam(name = "subjectName", targetNamespace = "")
        java.lang.String subjectName
    );
}
