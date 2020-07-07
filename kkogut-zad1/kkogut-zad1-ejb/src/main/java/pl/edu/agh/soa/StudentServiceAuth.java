package pl.edu.agh.soa;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

import static pl.edu.agh.soa.StudentsList.studentsList;

@Stateless
@WebService
@SecurityDomain("kkogut-zad1")
@DeclareRoles({"authuser", "test"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
public class StudentServiceAuth {

    @WebMethod
    @Oneway
    @RolesAllowed("authuser")
    public void addStudent(@WebParam(name = "firstName") String firstName,
                           @WebParam(name = "lastName") String lastName,
                           @WebParam(name = "subjects") List<Subject> subjects,
                           @WebParam(name = "avatar") byte[] avatar) {
        studentsList.add(firstName, lastName, subjects, avatar);
    }

    @WebMethod
    @Oneway
    @PermitAll
    public void editStudent(@WebParam(name = "id") int id,
                            @WebParam(name = "firstName") String firstName,
                            @WebParam(name = "lastName") String lastName,
                            @WebParam(name = "subjects") List<Subject> subjects,
                            @WebParam(name = "avatar") byte[] avatar) {
        studentsList.edit(id, firstName, lastName, subjects, avatar);
    }

    @WebMethod
    @Oneway
    @RolesAllowed("authuser")
    public void removeStudent(@WebParam(name = "id") int id) {
        studentsList.remove(id);
    }

    @WebMethod
    @RolesAllowed("authuser")
    public int lastId() {
        return studentsList.getStudents().get(studentsList.getStudents().size() - 1).getId();
    }
}
