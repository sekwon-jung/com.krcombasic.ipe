package com.krcombasic.ipe.springboot.service.posts;

import com.krcombasic.ipe.springboot.domain.posts.Posts;
import com.krcombasic.ipe.springboot.domain.posts.PostsRepository;
import com.krcombasic.ipe.springboot.web.dto.PostsListResponseDto;
import com.krcombasic.ipe.springboot.web.dto.PostsResponseDto;
import com.krcombasic.ipe.springboot.web.dto.PostsSaveRequestDto;
import com.krcombasic.ipe.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                // .map(posts -> new PostsListResponseDto(posts)) 와 같고
                // 뜻은 postsRepository 결과로 넘어온 Posts 의 Stream 을
                // map 을 통해 PostsListResponseDto 로 변환
                // -> List 로 반환하는 메소드이다.
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당게시글이 없습니다. id=" + id )
        );
        postsRepository.delete(posts);
    }



    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
