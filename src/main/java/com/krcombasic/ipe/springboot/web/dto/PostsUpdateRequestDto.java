package com.krcombasic.ipe.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
//    update 기능에서 데이터베이스에 쿼리를 날리는 부분이 없다 .이게 가능한 이유는 'JPA 의 영속성 context' 때문이다.
//    영속성 컨텍스트? 엔티티를 영구 저장하는 환경이다.
}
