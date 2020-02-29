package com.testinium.bookStore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@Entity
@Table(name = "bookstore")
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookStore_name")
    private String bookStoreName;

    @Column(name = "bookStore_city")
    private String city;

    @OneToMany(mappedBy = "bookStore", cascade = CascadeType.ALL)
    private List<BookAndBookStore> bookAndBookStores;



}
