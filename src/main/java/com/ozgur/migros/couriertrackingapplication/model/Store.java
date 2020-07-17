package com.ozgur.migros.couriertrackingapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "store")
public class Store {

    @Id
    private Long id;
    private String name;
    private Double lat;
    private Double lng;
}
