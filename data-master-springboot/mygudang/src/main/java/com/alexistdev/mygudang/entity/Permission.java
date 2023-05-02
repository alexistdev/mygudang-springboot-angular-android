package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import java.io.Serializable;
import java.util.Date;
import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@Entity
@Table(name="permissions")
public class Permission  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;


    @Column(name="slug")
    private String slug;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdAt;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date updatedAt;

    public Permission() {
    }

    public Permission(int id, Role role, String slug, Date createdAt, Date updatedAt) {
        this.id = id;
        this.role = role;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}