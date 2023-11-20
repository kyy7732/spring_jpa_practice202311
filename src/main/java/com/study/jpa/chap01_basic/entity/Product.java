package com.study.jpa.chap01_basic.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id") // 필드명과 컬럼명을 다르게 하고 싶을때
    private long id;

    @Column(name = "prod_name", nullable = false, unique = true, length = 30) // nullable = false not null unique = true 중복 안됨
    private String name;

    private int price;

    @Enumerated(EnumType.STRING)
    // enumType을 ordinal로 하면 Category를 int형태로 받아온다 기본값
    @Column(length = 6000)
    private Category category;

    @CreationTimestamp // default: current_timestamp(오라클의 sysdate)
    @Column(updatable = false) // update시 쿼리가 돌아가지 않게함
    private LocalDateTime createDate;

    @UpdateTimestamp // 업데이트시 자동으로 날짜 변경
    private LocalDateTime updateDate;

    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }

}
