package o2oboot.service;

import o2oboot.dto.NewsExecution;
import o2oboot.entity.News;
import o2oboot.entity.NewsCategory;

public interface NewsService {
    int deleteNews(Long newsId);
    int addNews(News news);
    News getNewsById(Long newsId);
    NewsExecution getNewsList(News newsCondition,int rowIndex,int pageSize);
    NewsExecution modifyNews(News newsCondition);
    NewsExecution getNewsListByNewsCategory(Long newsCategoryId,int rowIndex,int pageSize);
    NewsExecution getAllNewsList(int pageIndex,int pageSize);
    NewsExecution getNewsListByName(String newsName,int rowIndex,int pageSize);
}
