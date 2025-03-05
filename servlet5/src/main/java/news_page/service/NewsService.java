package news_page.service;

import java.util.List;

import news_page.entity.NewsEntity;
import news_page.repository.NewsRepository;

public class NewsService {
	// init repository to reference repository to implement querying db
	private NewsRepository newsRepo = new NewsRepository();
	
	public List<NewsEntity> getNews(){
		// refer to repository
		return newsRepo.findAll();
	}
}
