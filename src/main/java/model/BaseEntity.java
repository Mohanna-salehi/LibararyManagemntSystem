package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity<ID>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BaseGenerator")
    @SequenceGenerator(name = "BaseGenerator", sequenceName = "item-seq", allocationSize = 1)
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    private Instant createAt;
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
