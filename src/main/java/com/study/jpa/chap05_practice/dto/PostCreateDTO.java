package com.study.jpa.chap05_practice.dto;

import com.study.jpa.chap05_practice.entity.Post;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreateDTO {

    // 불리는 곳에서 @Validated를 붙여줘야 제대로 동작함
    // @NotNull -> null을 허용하지 않음. "", " "은 허용
    // @NotEmpty -> null, ""을 허용하지 않음. " "은 허용
    @NotBlank // -> null, "", " " 모두를 허용하지 않음.
    @Size(min = 2, max = 5)
    private String writer;

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;
    private String content;
    private List<String> hashTags;
    
    // dto를 엔터티로 변환하는 메서드 toEntity -> 관례
    public Post toEntity() {
        return Post.builder()
                .writer(this.writer)
                .content(this.content)
                .title(this.title)
                // 해시태그는 여기서 넣는게 아니에요~
                // 객체를 받고
                // builder를 이용해서 값을 넣지 않으면 null이 들어간다.
                .build();

    }
}
