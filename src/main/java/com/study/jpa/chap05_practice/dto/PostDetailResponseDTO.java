package com.study.jpa.chap05_practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.jpa.chap05_practice.entity.HashTag;
import com.study.jpa.chap05_practice.entity.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDetailResponseDTO {

    private String writer;
    private String title;
    private String content;
    private List<String> hashTags;

    @JsonFormat(pattern = "yyyy/MM/dd") // 제이슨으로 가져올 때 이 타입으로 매핑해서 줌 이 라이브러리 사용
    private LocalDateTime regDate;

    // 엔터티를 DTO로 변환하는 생성자
    public PostDetailResponseDTO(Post post) {
        this.writer = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.regDate = post.getCreateDate();
        this.hashTags = post.getHashTags() // getHashTags에서 getTagName만 리스트에 담에서 보내겠다.
                            .stream()
                            .map(HashTag::getTagName) // ht -> ht.getTagName()
                            .collect(Collectors.toList());
    }

}
