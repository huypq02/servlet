package news_page.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news_page.entity.NewsEntity;
import news_page.service.NewsService;

@WebServlet(name = "newController", urlPatterns = {"/news"})
public class NewsController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NewsService newsSrv = new NewsService(); // init service to refer to service implement activities of news

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<NewsEntity> listNews = newsSrv.getNews(); // get news to refer to service implementing this activity
				
		req.setAttribute("listNews", listNews); // set attribute for jsp
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
