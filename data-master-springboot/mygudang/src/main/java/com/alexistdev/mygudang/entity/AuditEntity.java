package com.alexistdev.mygudang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
public class AuditEntity {

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="modified_by")
    private String modifiedBy;

    public AuditEntity() {
    }
}
