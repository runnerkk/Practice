package kh.gangnam.movie.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kh.gangnam.movie.Model.OpenApiDTO.BoxOfficeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public MovieService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Value("${openapi.api-key}")
    private String apikey;
    @Value("${openapi.daily}")
    private String url;

    // TODO 받은 데이터 그대로 반환하기 Open API 요청 -> 바로 반환
    public JsonNode getBoxOfficeData1(String day) throws JsonProcessingException {
        String URL = url +"?key=" + apikey + "&targetDt=" + day;
        String data = restTemplate.getForObject(URL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(data);
    }


    // TODO ResponseEntity 사용 -> 미리 정의해둔 파일로 변환
    public BoxOfficeResponse getBoxOfficeData2(String day) throws JsonProcessingException {
        String URL = url +"?key=" + apikey + "&targetDt=" + day;

        String response = restTemplate.getForObject(URL, String.class);
        return objectMapper.readValue(response, BoxOfficeResponse.class);
    }
}
