package com.example.backend.entities;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Inheritance(
        strategy = InheritanceType.TABLE_PER_CLASS
)
public class AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column(name = "created_on")
    ZonedDateTime createdOn;

    @Column(name = "modified_on")
    ZonedDateTime modifiedOn;
}
