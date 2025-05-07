package com.FinansMate.FinansMate.model;

import com.FinansMate.FinansMate.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends  BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

    private String name;

    @Enumerated(EnumType.STRING)
    private TransactionType category;
}
