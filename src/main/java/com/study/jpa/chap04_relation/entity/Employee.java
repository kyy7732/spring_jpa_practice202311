package com.study.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;
@Setter @Getter
@EqualsAndHashCode(of = "id")
// jpa 연관관계 매핑에서 연관관계 데이터는 toString에서 제외해야 합니다.
@ToString(exclude = {"department"})
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

    // EAGER: 항상 무조건 조인을 수행.
    // LAZY: 필요한 경우에만 조인을 수행.(실무)
    @ManyToOne(fetch = FetchType.LAZY) // LAZY가 디폴트 값
    @JoinColumn(name = "dept_id") // join할 때 사용할 컬럼은 dept_id이다.
    private Department department;

}


















