package com.icesi.store.finalproyect.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_CLIENTID_SEQUENCE")
    @SequenceGenerator(name = "CLIENT_CLIENTID_SEQUENCE", sequenceName = "CLIENT_CLIENTID_SEQUENCE", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "Can not be null")
    @ManyToOne(optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Length(min = 2)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}