package ua.org.training.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = Student.TABLE_NAME)
public class Student {

    final static int MIN_VARCHAR_SIZE = 3;
    final static int MAX_VARCHAR_SIZE = 50;

    final static String TABLE_NAME = "student";
    final static String COLUMN_ID = "id";
    final static String COLUMN_GROUP_ID = "group_id";
    final static String COLUMN_FIRST_NAME = "first_name";
    final static String COLUMN_LAST_NAME = "last_name";
    final static String MESSAGE_NAME = "size between "
            + MIN_VARCHAR_SIZE + " and " + MAX_VARCHAR_SIZE;

    private Long id;
    private String firstName;
    private String lastName;
    private Long groupId;

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
            min = MIN_VARCHAR_SIZE,
            max = MAX_VARCHAR_SIZE,
            message = MESSAGE_NAME
    )
    @Column(name = COLUMN_FIRST_NAME)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Size(
            min = MIN_VARCHAR_SIZE,
            max = MAX_VARCHAR_SIZE,
            message = MESSAGE_NAME
    )
    @Column(name = COLUMN_LAST_NAME)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Column(name = COLUMN_GROUP_ID)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
