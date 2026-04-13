package com.dreamsiteco.jobportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass //This enables us to tell bean this class is not an entity but the mapping goes for Entity class (extend)mapped to it to use the records below
@EntityListeners(AuditingEntityListener.class) //This helps us Capture auditing information on persisting and updating entities.



public class BaseEntity {

    @CreatedDate
    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Instant CreatedAt;

    @CreatedBy
    @Column(name = "CREATED_BY" , nullable = false, length = 50, updatable = false)
    private String  createdBy;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false)
    private Instant UpdatedAt;

    @LastModifiedBy
    @Column(name = "UPDATED_BY",length = 50, insertable = false)
    private String UpdatedBy;
}
