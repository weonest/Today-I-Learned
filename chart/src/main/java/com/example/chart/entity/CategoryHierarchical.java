package com.example.chart.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class CategoryHierarchical {
    
    // 외래키 없이 계층형 구조
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String sex;
    private String groupName;
    private int groupId;
    private String boardName;
    private int boardId;
    private int boardLevel;
}
