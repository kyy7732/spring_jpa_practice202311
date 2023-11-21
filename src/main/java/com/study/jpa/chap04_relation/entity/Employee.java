package com.study.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;
@Setter @Getter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "dept_id") // join할 때 사용할 컬럼은 dept_id이다.
    private Department department;

}


















