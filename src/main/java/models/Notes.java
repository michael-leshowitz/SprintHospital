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
    @Column(name="creator_id")
    private Integer creator_id;
    @Column(name="text")
    private String text;


    public Notes() {
    }



    public Integer getNote_id() {
        return note_id;
    }

    public void setNote_id(Integer note_id) {
        this.note_id = note_id;
    }

    public Integer getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(Integer creator_id) {
        this.creator_id = creator_id;
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
                ", creator_id='" + creator_id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
