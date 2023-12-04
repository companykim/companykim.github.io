package www.dream.bbs.News.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import www.dream.bbs.News.model.NewsVO;

public interface NewsRepository extends JpaRepository<NewsVO, String>{
	@Query(nativeQuery = true, value="DELETE \r\n"
			+ "FROM news_crawling\r\n"
			+ "WHERE newsdate < DATE_ADD(NOW(), INTERVAL - 1 MINUTE)")
	List<NewsVO> deleteNewsAll();
}