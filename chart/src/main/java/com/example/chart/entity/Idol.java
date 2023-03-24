package com.example.chart.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)

public class Idol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idolId;

    private String idolName;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "idol")
    private List<Board> boards = new ArrayList<>();

}
