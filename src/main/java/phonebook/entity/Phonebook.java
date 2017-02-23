package phonebook.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Admin on 19.02.2017.
 */

@Entity
   @Table(name="phonebook")
   public class Phonebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=50)
    @Column(nullable = false)
    private String name;

    @Column(name = "email")

    private String email;

    private String telNumber;

/*    private String country;

    private String noteAbout;*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

  /*  public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

  /*  public String getNoteAbout() {
        return noteAbout;
    }

    public void setNoteAbout(String noteAbout) {
        this.noteAbout = noteAbout;
    }*/
}
