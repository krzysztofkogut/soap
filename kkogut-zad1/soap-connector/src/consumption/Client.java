package consumption;

import pl.edu.agh.soa.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.ws.BindingProvider;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {

    private final StudentService studentService;
    private final StudentServiceAuth studentServiceAuth;

    private Client(StudentServiceService serviceService, StudentServiceAuthService serviceServiceAuth) {
        studentService = serviceService.getStudentServicePort();
        studentServiceAuth = serviceServiceAuth.getStudentServiceAuthPort();
    }

    private void printStudents(List<Student> students) {
        students.forEach(student -> {
            System.out.print("Student <" + student.getId() + "> " + student.getFirstName() +
                    " " + student.getLastName() + " [ ");
            if (student.getSubjects() != null) {
                student.getSubjects().getSubject().forEach(subject -> {
                    System.out.print(subject.getName() + " ");
                });
            }
            System.out.println("]\n");
        });
    }

    private void run() {
        testNotAuthenticated();

        testAvatar(1, true);

        setCredentials((BindingProvider) studentServiceAuth, "user", "password");

        testAuthenticated();
    }

    private Subject newSubject(int id, String name) {
        /*return new Subject() {{
            setId(id);
            setName(name);
        }};*/
        return new Subject(id, name);
    }

    private void testAuthenticated() {

        byte[] encodedAvatar = null;
        try {
            BufferedImage bImage = ImageIO.read(new File("/home/kris/Obrazy/avatar.jpg"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            encodedAvatar = Base64.getEncoder().encode(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add
        studentServiceAuth.addStudent("Mateusz", "Rus", Stream.of(newSubject(123, "Physics")).collect(Collectors.toList()), encodedAvatar);
        printCurrentStudents("Wszyscy studenci + nowo dodany");

        // Avatar test
        testAvatar(studentServiceAuth.lastId(), false);

        // Edit
        studentServiceAuth.editStudent(studentServiceAuth.lastId(), "Mietek", "Kiełbasa", null, null);
        printCurrentStudents("Wszyscy studenci + nowo edytowany");

        try {
            BufferedImage bImage = ImageIO.read(new File("/home/kris/Obrazy/avatar.jpg"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            encodedAvatar = Base64.getEncoder().encode(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Edit + clean subjects
        studentServiceAuth.editStudent(studentServiceAuth.lastId(), "Mietek", "Kiełbasa", Stream.of(newSubject(-1, null)).collect(Collectors.toList()), encodedAvatar);
        printCurrentStudents("Wszyscy studenci + nowo edytowany (bez przedmiotów)");

        // Avatar test
        testAvatar(studentServiceAuth.lastId(), false);

        // Remove
        studentServiceAuth.removeStudent(studentServiceAuth.lastId());
        printCurrentStudents("Wszyscy studenci");
    }

    private void printCurrentStudents(String message) {
        System.out.println("\n" + message + "\n");
        printStudents(studentService.getStudents().getStudents().getStudent());
    }

    private void testNotAuthenticated() {
        System.out.println("Wszyscy studenci\n");
        printStudents(studentService.getStudents().getStudents().getStudent());

        System.out.println("Client: " + studentService.getStudent(1).getFirstName() + "\n");

        System.out.println("\nStudenci, których imiona zawierają w sobie człon \"ma\"\n");
        printStudents(studentService.getStudentsByFirstName("ma").getStudents().getStudent());

        System.out.println("\nStudenci, których nazwiska zawierają w sobie człon \"ra\"\n");
        printStudents(studentService.getStudentsByLastName("ra").getStudents().getStudent());

        System.out.println("\nStudenci, którzy posiadają przedmiot \"Physics\"\n");
        printStudents(studentService.getStudentsBySubject("Physics").getStudents().getStudent());

        try {
            studentServiceAuth.addStudent("Mietek", "Kiełbasa", Stream.of(newSubject(158, "PE")).collect(Collectors.toList()), null);
        } catch (Exception e) {
            System.out.println("\nNie można dodać użytkownika - nie ma autoryzacji :(\n");
        }
    }

    private void testAvatar(int id, boolean exitAfter) {
        byte[] avatarDecoded = Base64.getDecoder().decode(studentService.getStudent(id).getAvatar());

        // Scale image to fit frame size
        BufferedImage bufferedImage = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(avatarDecoded);
        try {
            bufferedImage = ImageIO.read(bais);

            Image scaledImg = bufferedImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);

            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(new JLabel(new ImageIcon(scaledImg)));
            frame.pack();
            frame.setSize(400, 400);
            frame.setMinimumSize(new Dimension(400, 400));
            frame.setVisible(true);
            if (exitAfter) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setCredentials(BindingProvider provider, String username, String password) {
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
    }

    public static void main(String[] args) {
        new Client(new StudentServiceService(), new StudentServiceAuthService()).run();
    }
}
