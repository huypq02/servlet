package news_page.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import news_page.entity.NewsEntity;
import news_page.config.*;

public class NewsRepository {
	public List<NewsEntity> findAll(){
		// define list of news
		List<NewsEntity> listNews = new ArrayList<NewsEntity>();
		
		// init connection
		Connection conn = MySqlConfig.getConnection();

		try {
			// prepare sql query
			String query = "SELECT * FROM news";
			PreparedStatement statement = conn.prepareStatement(query);
			
			ResultSet result = statement.executeQuery();
			
			// scan array each rows in db
			while (result.next()) {
				// init model from db data
				NewsEntity newsEntity = new NewsEntity();
				// set value, which get each row in db, are assigned to newsEntity through setter
				newsEntity.setId(result.getInt("id"));
				newsEntity.setTitle(result.getString("title"));
				newsEntity.setContent(result.getString("content"));
				newsEntity.setImage_url(result.getString("image_url"));
				newsEntity.setPublish_date(result.getDate("publish_date"));
				
				// add to array list listNews when scanning each row in db
				listNews.add(newsEntity);
			}
			
		} catch (Exception e) {
			System.out.println("[NewsRepository][findAll] err " + e.getLocalizedMessage() );
		}
		
		return listNews;
	}
}
