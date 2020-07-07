package pl.edu.agh.soa;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;


@WebServiceClient(name = "StudentServiceAuthService",
                  wsdlLocation = "http://localhost:8080/lab-ejb/StudentServiceAuth?wsdl",
                  targetNamespace = "http://soa.agh.edu.pl/")
public class StudentServiceAuthService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soa.agh.edu.pl/", "StudentServiceAuthService");
    public final static QName StudentServiceAuthPort = new QName("http://soa.agh.edu.pl/", "StudentServiceAuthPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/lab-ejb/StudentServiceAuth?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(StudentServiceAuthService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/lab-ejb/StudentServiceAuth?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public StudentServiceAuthService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public StudentServiceAuthService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StudentServiceAuthService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public StudentServiceAuthService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public StudentServiceAuthService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public StudentServiceAuthService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns StudentServiceAuth
     */
    @WebEndpoint(name = "StudentServiceAuthPort")
    public StudentServiceAuth getStudentServiceAuthPort() {
        return super.getPort(StudentServiceAuthPort, StudentServiceAuth.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StudentServiceAuth
     */
    @WebEndpoint(name = "StudentServiceAuthPort")
    public StudentServiceAuth getStudentServiceAuthPort(WebServiceFeature... features) {
        return super.getPort(StudentServiceAuthPort, StudentServiceAuth.class, features);
    }

}
