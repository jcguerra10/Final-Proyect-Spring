package com.icesi.store.finalproyect.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_CLIENTID_SEQUENCE")
    @SequenceGenerator(name = "CLIENT_CLIENTID_SEQUENCE", sequenceName = "CLIENT_CLIENTID_SEQUENCE", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

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