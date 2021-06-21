package com.krcombasic.ipe.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //Entity 클래스에서는 절대 Setter 메소드를 만들지 않습니다.
//Setter 가 없는 이 상황에서 어떻게 값을 채워 DB에 삽입해야 할까요?
public class Posts {
    @Id //해당 테이블의 PK를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙, auto_increament 가 되라!
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder //생성자 상단에 선언시 생성자에 포함된 빌더만 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
