package com.we.weblog.controller;

import com.we.weblog.controller.core.BaseController;
import com.we.weblog.domain.Post;
import com.we.weblog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * <pre>
 *     标签归档控制器
 * </pre>
 * @author Clay
 * @date 2018/10/30 11:04
 */

@Controller
public class TagController extends BaseController {

    @Resource
    private PostService postService;
    /**
     * 首页视图
     * @return
     */
    @GetMapping("/tags")
    public String tags(){
        return redirectTo("/tags");
    }

    @GetMapping("/tag/{tageName}")
    public String findArticleByTag(@PathVariable("tageName")String tagName){
        Post post = new Post();
        post.setTags(tagName);
        try {
            List<Post> posts = (List<Post>) postService.queryPost(post).getData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return redirectTo("/tags");
    }



//    /**
//     * 捕获点击的博客类别的get请求
//     * @param tag
//     * @param response
//     * @throws IOException
//     */
//    @GetMapping("/tags/{tag}")
//    public void getTagName(@PathVariable String tag,
//                           HttpServletResponse response) throws IOException {
//        if (StringUtils.isEmpty(tag)) {
//            //
//        }
//        tagName = tag;
//        response.sendRedirect("/tagdetail.html");
//    }

}
