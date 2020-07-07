package pl.edu.agh.soa;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


@WebService(targetNamespace = "http://soa.agh.edu.pl/", name = "StudentServiceAuth")
@XmlSeeAlso({ObjectFactory.class})
public interface StudentServiceAuth {

    @WebMethod
    @Oneway
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.AddStudent")
    public void addStudent(
        @WebParam(name = "firstName", targetNamespace = "")
        java.lang.String firstName,
        @WebParam(name = "lastName", targetNamespace = "")
        java.lang.String lastName,
        @WebParam(name = "subjects", targetNamespace = "")
        java.util.List<pl.edu.agh.soa.Subject> subjects,
        @WebParam(name = "avatar", targetNamespace = "")
        byte[] avatar
    );

    @WebMethod
    @RequestWrapper(localName = "lastId", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.LastId")
    @ResponseWrapper(localName = "lastIdResponse", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.LastIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int lastId();

    @WebMethod
    @Oneway
    @RequestWrapper(localName = "editStudent", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.EditStudent")
    public void editStudent(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "firstName", targetNamespace = "")
        java.lang.String firstName,
        @WebParam(name = "lastName", targetNamespace = "")
        java.lang.String lastName,
        @WebParam(name = "subjects", targetNamespace = "")
        java.util.List<pl.edu.agh.soa.Subject> subjects,
        @WebParam(name = "avatar", targetNamespace = "")
        byte[] avatar
    );

    @WebMethod
    @Oneway
    @RequestWrapper(localName = "removeStudent", targetNamespace = "http://soa.agh.edu.pl/", className = "pl.edu.agh.soa.RemoveStudent")
    public void removeStudent(
        @WebParam(name = "id", targetNamespace = "")
        int id
    );
}
