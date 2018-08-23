package com.diaolizhi.simpleblog.controller;

import com.diaolizhi.simpleblog.domain.Article;
import com.diaolizhi.simpleblog.domain.category;
import com.diaolizhi.simpleblog.service.impl.ArticleServiceImpl;
import com.diaolizhi.simpleblog.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/17 13:32
 */

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ArticleServiceImpl articleService;

    /**
     * 显示所有目录
     * @param map
     * @return
     */
    @GetMapping("")
    public String category(ModelMap map) {
        List<category> categories = categoryService.selectAllCat();
        map.addAttribute("categories", categories);
        return "/category/index";
    }

    /**
     * 显示某个目录下的文章
     * @param name
     * @param map
     * @return
     */
    @GetMapping(path = "/{name}")
    public String categoryById(@PathVariable String name, ModelMap map) {

        List<Article> articles = articleService.selectArticleByCat(name);

        map.addAttribute("articles", articles);
        map.addAttribute("name", name);
        return "/category/articles";
    }
}
