package www.dream.bbs.News.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import www.dream.bbs.News.model.NewsVO;
import www.dream.bbs.News.respository.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository newsRepository;

	@Scheduled(cron = "0 0 0 * * *")
	public List<NewsVO> deleteNews() throws InterruptedException {
		List<NewsVO> dsgvs = newsRepository.deleteNewsAll();
		return dsgvs;
	}
}