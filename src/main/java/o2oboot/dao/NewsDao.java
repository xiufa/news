package o2oboot.dao;

import o2oboot.entity.News;

import java.util.List;

public interface NewsDao {
    int insertNews(News news);
    News queryNewsById(Long newsId);
    List<News> queryNewsList(News news);
    int queryNewsCount(News news);
    int updateNews(News news);

}
