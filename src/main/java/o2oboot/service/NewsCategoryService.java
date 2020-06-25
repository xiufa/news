package o2oboot.service;

import o2oboot.dto.NewsExecution;
import o2oboot.entity.News;
import o2oboot.entity.NewsCategory;

import java.util.List;

public interface NewsCategoryService {
    int addNewsCategory(NewsCategory newsCategory);

    NewsExecution batchAddNewsCategory(List<NewsCategory> list);
    List<NewsCategory> getAllNewsCategory();
    NewsExecution deleteNewsCategoryById(Long newsCategoryId);
    NewsCategory getNewsCategoryById(Long newsCategoryId);





}
