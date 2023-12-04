package www.dream.bbs.webclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import www.dream.bbs.shelter.model.PlaceVO;
import www.dream.bbs.shelter.model.ShelterId;
import www.dream.bbs.shelter.model.ShelterVO;
import www.dream.bbs.shelter.service.ShelterService;

@Service
public class WebClient4News {
	public String callElasticSearch(String urlParam) {
		urlParam = "/news*/_search?q=newstitle=\"지진\" and newstitle=\"해일\"";
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:9200")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		String result = webClient.get().uri(urlParam).retrieve().bodyToMono(String.class).block();
		return result;
	}
}