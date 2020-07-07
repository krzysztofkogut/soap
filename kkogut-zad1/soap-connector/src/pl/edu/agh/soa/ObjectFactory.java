
package pl.edu.agh.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudent_QNAME = new QName("http://soa.agh.edu.pl/", "addStudent");
    private final static QName _EditStudent_QNAME = new QName("http://soa.agh.edu.pl/", "editStudent");
    private final static QName _LastId_QNAME = new QName("http://soa.agh.edu.pl/", "lastId");
    private final static QName _LastIdResponse_QNAME = new QName("http://soa.agh.edu.pl/", "lastIdResponse");
    private final static QName _RemoveStudent_QNAME = new QName("http://soa.agh.edu.pl/", "removeStudent");
    private final static QName _Subject_QNAME = new QName("http://soa.agh.edu.pl/", "subject");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link EditStudent }
     * 
     */
    public EditStudent createEditStudent() {
        return new EditStudent();
    }

    /**
     * Create an instance of {@link LastId }
     * 
     */
    public LastId createLastId() {
        return new LastId();
    }

    /**
     * Create an instance of {@link LastIdResponse }
     * 
     */
    public LastIdResponse createLastIdResponse() {
        return new LastIdResponse();
    }

    /**
     * Create an instance of {@link RemoveStudent }
     * 
     */
    public RemoveStudent createRemoveStudent() {
        return new RemoveStudent();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "editStudent")
    public JAXBElement<EditStudent> createEditStudent(EditStudent value) {
        return new JAXBElement<EditStudent>(_EditStudent_QNAME, EditStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LastId }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "lastId")
    public JAXBElement<LastId> createLastId(LastId value) {
        return new JAXBElement<LastId>(_LastId_QNAME, LastId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LastIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "lastIdResponse")
    public JAXBElement<LastIdResponse> createLastIdResponse(LastIdResponse value) {
        return new JAXBElement<LastIdResponse>(_LastIdResponse_QNAME, LastIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "removeStudent")
    public JAXBElement<RemoveStudent> createRemoveStudent(RemoveStudent value) {
        return new JAXBElement<RemoveStudent>(_RemoveStudent_QNAME, RemoveStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Subject }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "subject")
    public JAXBElement<Subject> createSubject(Subject value) {
        return new JAXBElement<Subject>(_Subject_QNAME, Subject.class, null, value);
    }

}
