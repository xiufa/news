package o2oboot.service;

import o2oboot.dto.NewsExecution;
import o2oboot.entity.News;

public interface NewsService {
    int deleteNews(Long newsId);
    int addNews(News news);
    News getNewsById(Long newsId);
    NewsExecution getNewsList(News newsCondition,int rowIndex,int pageSize);
    NewsExecution modifyNews(News newsCondition);
    News getNewsByName(String newsName);
}
