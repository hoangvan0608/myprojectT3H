package vn.t3h.java2109.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "myshop", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "des")
    private String des;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "category")
    private int category;

}
