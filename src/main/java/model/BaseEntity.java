package model;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BaseGenerator")
    @SequenceGenerator(name="BaseGenerator",sequenceName = "item-seq",allocationSize = 1)
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
