package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notes")
public class Notes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="note_id")
    private Integer note_id;
    @Column(name="text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id", referencedColumnName = "user_id")
    private Users creator;

    public Notes() {
    }



    public Integer getNote_id() {
        return note_id;
    }

    public void setNote_id(Integer note_id) {
        this.note_id = note_id;
    }

    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




    @Override
    public String toString() {
        return "notes{" +
                "note_id='" + note_id + '\'' +
                ", creator_id='" + creator + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
