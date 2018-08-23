package com.diaolizhi.simpleblog.mapper;

import com.diaolizhi.simpleblog.domain.category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/15 11:53
 */
public interface CategoryMapper {

    /**
     * 通过名字查找分类，没找到就会返回 null
     * @param category_name
     * @return
     */
    @Select("SELECT id FROM category WHERE category_name = #{category_name}")
    Integer selectCategoryByName(String category_name);

    /**
     * 添加一个分类
     * @param category
     * @return
     */
    @Insert("INSERT INTO category(category_name, article_num) VALUES(#{category_name}, 1)")
    @Options(useGeneratedKeys=true, keyColumn="id", keyProperty = "id")
    int insertOneCategory(category category);

    /**
     * 通过 id 查找分类的名字
     * @param id
     * @return
     */
    @Select("SELECT category_name FROM category  WHERE id = #{id}")
    String selectCatNameById(int id);

    /**
     * 该分类下的文章数目 +1
     * @param category_name
     */
    @Select("UPDATE category SET article_num = article_num + 1 WHERE category_name = #{category_name}")
    void catNumAddOne(String category_name);

    /**
     * 该分类下的文章数目 -1
     * @param id
     */
    @Select("UPDATE category SET article_num = article_num - 1 WHERE id = #{id}")
    void catNumMinusOneById(int id);

    /**
     * 查询所有分类
     * @return
     */
    @Select("SELECT category_name, article_num FROM category ORDER BY article_num DESC")
    List<category> selectAllCat();
}

