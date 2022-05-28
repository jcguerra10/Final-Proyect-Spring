package com.icesi.store.finalproyect.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_STOREID_SEQUENCE")
    @SequenceGenerator(name = "STORE_STOREID_SEQUENCE", sequenceName = "STORE_STOREID_SEQUENCE", allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @OneToMany(mappedBy = "store", orphanRemoval = true)
    private List<Client> clients = new ArrayList<>();

    @Length(message = "Min Length 4 Max Length 50", min = 4, max = 50)
    @NotBlank(message = "Can Not Be Blank")
    @NotNull(message = "Can Not Be Null")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}