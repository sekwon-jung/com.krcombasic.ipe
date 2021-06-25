package com.krcombasic.ipe.springboot.web.dto;

import com.krcombasic.ipe.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
//  Request 와 Response 용 Dto 는 View 를 위한 클래스다.
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title).content(content).author(author).build();
    }
}
