package com.diaolizhi.simpleblog.controller;

import com.diaolizhi.simpleblog.domain.Article;
import com.diaolizhi.simpleblog.domain.MyPageInfo;
import com.diaolizhi.simpleblog.service.impl.ArticleServiceImpl;
import com.diaolizhi.simpleblog.service.impl.CategoryServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/8 12:57
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * 访问首页
     * @param pageNum
     * @param map
     * @param request
     * @return
     */
    @GetMapping("")
    public String test(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                       ModelMap map, HttpServletRequest request) {
//        分页插件
        PageHelper.startPage(pageNum,10, "created_time DESC");
        List<Article> articles = articleService.selectAll();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);

//        文章内容
        articles = pageInfo.getList();

//        导航栏分页
        MyPageInfo myPageInfo = new MyPageInfo();
        int[] navNums = pageInfo.getNavigatepageNums();
        int prePage = pageInfo.getPrePage();
        int nextPage = pageInfo.getNextPage();
        boolean hasPrePage = pageInfo.isHasPreviousPage();
        boolean hasNextPage = pageInfo.isHasNextPage();
        int currentNum = pageInfo.getPageNum();

        myPageInfo.setNavNums(navNums);
        myPageInfo.setHasPrePage(hasPrePage);
        myPageInfo.setHasNextPage(hasNextPage);
        myPageInfo.setPrePage(prePage);
        myPageInfo.setNextPage(nextPage);
        myPageInfo.setCurrentNum(currentNum);


        HashMap<Integer, String> catMap = new HashMap<>();

        for (int i = 0; i < articles.size(); i++) {
            int catId = articles.get(i).getCategory();
            if(null == catMap.get(catId)) {
                String cat = categoryService.selectCatNameById(catId);
                articles.get(i).setCatName(cat);
                catMap.put(catId, cat);
            } else {
                articles.get(i).setCatName(catMap.get(catId));
            }
            String body = articles.get(i).getBody();

            System.out.println(articles.get(i) == articles.get(i));

            String[] ss = body.split("\\[//\\]: <> \\(more\\)");
            System.out.println(articles.get(i).getTitle() + ": " + ss.length);
            body = ss[0];

            body = body.replaceAll("[\\n\\r\\t]+", "<br>");
            articles.get(i).setBody(body);
        }

        map.addAttribute("myPageInfo", myPageInfo);
        map.addAttribute("catMap", catMap);
        map.addAttribute("articles", articles);

        return "/index";
    }

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    /**
     * 进入关于页面
     * @return
     */
    @GetMapping("/about")
    public String about() {
        return "/about/index";
    }

    @GetMapping("/error2")
    public String error() {
        return "/error2";
    }
}
