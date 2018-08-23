package com.diaolizhi.simpleblog.controller;

import com.diaolizhi.simpleblog.domain.Article;
import com.diaolizhi.simpleblog.domain.Comment;
import com.diaolizhi.simpleblog.domain.category;
import com.diaolizhi.simpleblog.service.impl.ArticleServiceImpl;
import com.diaolizhi.simpleblog.service.impl.CategoryServiceImpl;
import com.diaolizhi.simpleblog.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/8 13:10
 */

@Controller
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private CommentServiceImpl commentService;

    /**
     * 发表一篇心的博客
     * @param title
     * @param author
     * @param category
     * @param body
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/article_publish")
    public String articlePublish(String title, String author, String category,
                              String body) {
        Article article = new Article();
        article.setTitle(title);
        article.setAuthor(author);

        category categoryObj = new category();
        Integer i = categoryService.selectCategoryByName(category);
        if(i == null) {
            categoryObj.setCategory_name(category);

            categoryService.insertOneCategory(categoryObj);
            article.setCategory(categoryObj.getId());
        } else {
            categoryService.catNumAddOne(category);
            article.setCategory(i);
        }

        article.setCreated_time(new Date());
        article.setModified_time(new Date());
        article.setBody(body);

        articleService.createArticle(article);

        return "redirect:/";
    }

    /**
     * 修改原有的博客
     * @param id
     * @param title
     * @param author
     * @param category
     * @param body
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/article_modify")
    public String articleModify(int id, String title, String author, String category,
                              String body) {
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setAuthor(author);

        category categoryObj = new category();
        Integer i = categoryService.selectCategoryByName(category);

//        原来的目录 id
        int categoryId = articleService.selectCatIdById(id);

        if(i == null) {
//            如果找不到，说明修改了所在目录，此时原来的目录数量应该减一
            categoryService.catNumMinusOneById(categoryId);

            categoryObj.setCategory_name(category);

            categoryService.insertOneCategory(categoryObj);
            article.setCategory(categoryObj.getId());
        } else if(i != categoryId) {
//            修改了目录，但是目标目录存在，仍然需要修改目录数量
            categoryService.catNumMinusOneById(categoryId);
            categoryService.catNumAddOne(category);
            article.setCategory(i);
        } else if(i == categoryId){
//            没有修改
            article.setCategory(i);
        }

        article.setModified_time(new Date());
        article.setBody(body);

        articleService.updatearticleById(article);

        return "redirect:/article/id/" + id;
    }

    /**
     * 进入编辑页面
     * @return
     */
    @GetMapping("/edit")
    public String edit() {
        return "/editor/examples/edit";
    }

    /**
     * 进入预览页面
     * @param id
     * @param title
     * @param author
     * @param category
     * @param body
     * @param target
     * @param map
     * @return
     */
    @PostMapping("/preview")
    public String preview(int id, String title, String author, String category, String body
        , String target, ModelMap map){

        if(target.equals("article_modify")) {
            map.addAttribute("id", id);
        }

        map.addAttribute("title", title);
        map.addAttribute("author", author);
        map.addAttribute("category", category);
        map.addAttribute("body", body);

//        判断是添加还是修改文章
        map.addAttribute("target", target);

        return "/editor/preview";
    }

    /**
     * 根据 id 访问文章
     * @param id
     * @param map
     * @return
     */
    @GetMapping(path = "/article/id/{id}")
    public String displayArticle(@PathVariable int id, ModelMap map) {

//        文章内容
        Article article = articleService.selectArticleById(id);
        String string = categoryService.selectCatNameById(article.getCategory());
        article.setCatName(string);
        String body = article.getBody();
        article.setBody("");
        map.addAttribute("body", body);
        map.addAttribute("article", article);

//        阅读量 +1
        articleService.addOneViews(id);

        List<Comment> comments = commentService.selectCommentByArtId(id);
        map.addAttribute("comments", comments);

        return "/article/article";
    }

    /**
     * 通过关键字搜索文章
     * @param keyWord
     * @param map
     * @return
     */
    @GetMapping("/search")
    public String search(String keyWord, ModelMap map) {

//      在加 % 之前添加到 map
        map.addAttribute("keyWord", keyWord);

        keyWord = "%" + keyWord + "%";
        List<Article> articles = articleService.selectArticleByKeyWord(keyWord);

        map.addAttribute("articles", articles);

        return "/article/search_res";
    }

    /**
     * 进入修改文章页面
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/modify")
    public String modifyArticle(int id, ModelMap map) {

        Article article = articleService.selectArticleById(id);
        String catName = categoryService.selectCatNameById(article.getCategory());
        article.setCatName(catName);

        map.addAttribute("article", article);

        return "/editor/examples/modify";
    }

    /**
     * 删除一篇文章
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/article/delete")
    public String deleteArticle(int id) {

//        原来的目录 id
        int categoryId = articleService.selectCatIdById(id);
        categoryService.catNumMinusOneById(categoryId);

        articleService.deleteArticleById(id);
        commentService.deleteComByArtId(id);

        return "redirect:/";
    }
}
