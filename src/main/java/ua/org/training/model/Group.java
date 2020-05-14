package ua.org.training.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = Group.TABLE_NAME)
public class Group {

    final static int GROUP_VARCHAR_SIZE = 5;

    final static String TABLE_NAME = "`group`";
    final static String COLUMN_ID = "id";
    final static String COLUMN_TITLE = "title";
    final static String MESSAGE_TITLE = "";

    private Long id;
    private String title;

    private List<Student> studentsList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(
            min = GROUP_VARCHAR_SIZE,
            max = GROUP_VARCHAR_SIZE,
            message = MESSAGE_TITLE
    )
    @Column(name = COLUMN_TITLE)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Transient
    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
