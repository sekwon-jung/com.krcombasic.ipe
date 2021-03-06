package com.krcombasic.ipe.springboot.web;

import com.krcombasic.ipe.springboot.config.auth.LoginUser;
import com.krcombasic.ipe.springboot.config.auth.dto.SessionUser;
import com.krcombasic.ipe.springboot.service.posts.PostsService;
import com.krcombasic.ipe.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    //model 을 이용해 데이터를 가져오고 view 에 데이터를 넘겨 적절한 view 를 생성하는 역할을 한다.
    public String index(Model model, @LoginUser SessionUser user){
// 어느 컨트롤러든지 @LoginUser 만 사용하면 세션 정보를 가져올 수 있게 되었습니다.
        model.addAttribute("posts", postsService.findAllDesc());
        //view 에 전달할 데이터를 key, value 쌍으로 전달할 수 있다.
        //postsService.findAllDesc() 로 가져온 결과를, posts 란 이름으로 index.mustache 에 전달한다.
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save"; //posts-save.mustache 를 호출한다.
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
