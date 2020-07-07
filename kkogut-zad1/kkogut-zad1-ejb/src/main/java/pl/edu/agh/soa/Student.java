package pl.edu.agh.soa;

import javax.imageio.ImageIO;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@XmlRootElement
class Student {

    private int id;
    private String firstName;
    private String lastName;
    private byte[] avatar;
    private List<Subject> subjects;

    Student() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.subjects = new ArrayList<>();
        this.avatar = null;
    }

    Student(int id, String firstName, String lastName, List<Subject> subjects, byte[] avatar) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;

        if (avatar == null) {
            try {
                BufferedImage bImage = ImageIO.read(new File("/home/kris/Obrazy/avatar.jpg"));
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bImage, "jpg", bos);
                this.avatar = Base64.getEncoder().encode(bos.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.avatar = avatar;
        }
    }

    void setId(int id) {
        this.id = id;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @XmlAttribute
    int getId() {
        return id;
    }

    @XmlElement
    String getFirstName() {
        return firstName;
    }

    @XmlElement
    String getLastName() {
        return lastName;
    }

    @XmlElement
    String getAvatar() {
        return new String(avatar);
    }

    @XmlElementWrapper
    @XmlElement(name = "subject")
    List<Subject> getSubjects() {
        return subjects;
    }
}
