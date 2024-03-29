package com.alexistdev.mygudang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.lang.annotation.After;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="roles")
public class Role extends AuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="status")
    private String status;

    @Builder
    public Role(String name, String description, String status, Date createdAt, String createdBy, Date updatedAt, String modifiedBy) {
        super(createdAt, updatedAt, createdBy, modifiedBy);
        this.name = name;
        this.description = description;
        this.status = status;
    }


}
