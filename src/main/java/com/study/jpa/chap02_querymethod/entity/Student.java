package com.study.jpa.chap02_querymethod.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter // 실무적 측면에서 setter는 신충하게 선택할 것.
@Getter
@ToString
// 필드에 값이 4개있으면 4개를 전부 비교해서 4개가 다 같아야 일치한다함
@EqualsAndHashCode(of = "id") // 그래서 id만 비교 하라고 of 라는 속성을 사용함
// id 같으면 같은 객체로 인식.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "stu_id")
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid", name = "uid") // name이 generator가 됨
    private String id;

    @Column(name = "stu_name", nullable = false)
    private String name;

    private String city;

    private String major;

}
