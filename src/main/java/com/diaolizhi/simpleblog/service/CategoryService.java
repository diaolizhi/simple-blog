package com.diaolizhi.simpleblog.service;

import com.diaolizhi.simpleblog.domain.category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    /**
     * 通过名字查找分类，如果不存在将会返回 null
     * @param category_name
     * @return
     */
    Integer selectCategoryByName(String category_name);

    /**
     * 添加一个分类
     * @param category
     * @return
     */
    int insertOneCategory(category category);

    /**
     * 通过 id 查询分类名称
     * @param id
     * @return
     */
    String selectCatNameById(int id);

    /**
     * 该分类下的文章数目 +1
     * @param category_name
     */
    void catNumAddOne(String category_name);

    /**
     * 查询所有分类
     * @return
     */
    List<category> selectAllCat();

    /**
     * 目录下文章数量 -1
     * @param id
     */
    void catNumMinusOneById(int id);

}
