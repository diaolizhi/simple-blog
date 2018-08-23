package com.diaolizhi.simpleblog.service.impl;

import com.diaolizhi.simpleblog.domain.category;
import com.diaolizhi.simpleblog.mapper.CategoryMapper;
import com.diaolizhi.simpleblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/15 11:56
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper mapper;

    @Override
    public Integer selectCategoryByName(String category_name) {
        return mapper.selectCategoryByName(category_name);
    }

    @Override
    public int insertOneCategory(category category) {
        return mapper.insertOneCategory(category);
    }

    @Override
    public String selectCatNameById(int id) {
        return mapper.selectCatNameById(id);
    }

    @Override
    public void catNumAddOne(String category_name) {
        mapper.catNumAddOne(category_name);
    }

    @Override
    public List<category> selectAllCat() {
        return mapper.selectAllCat();
    }

    @Override
    public void catNumMinusOneById(int id) {
        mapper.catNumMinusOneById(id);
    }
}
