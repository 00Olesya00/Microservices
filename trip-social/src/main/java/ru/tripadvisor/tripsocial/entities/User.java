package ru.tripadvisor.tripsocial.entities;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;

    private String displayName;

    @OneToMany(mappedBy = "user")
    private List<Tour>tours;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;


}

