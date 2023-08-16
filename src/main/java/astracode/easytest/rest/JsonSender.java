package astracode.easytest.rest;

import astracode.easytest.model.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JsonSender {
    private final RestTemplate restTemplate;
    @Value("${serverUrl}")
    private String serverUrl;

    @Autowired
    public JsonSender(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendJsonToServer(TestCase testCase) {
        // Заголовки для JSON-контента
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Создание объекта HttpEntity с JSON-данными и заголовками
        HttpEntity<TestCase> request = new HttpEntity<>(testCase, headers);

        // Выполняем POST-запрос
        ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, request, String.class);

        // Обрабатываем ответ, если необходимо
        System.out.println("Ответ от сервера: " + response.getBody());
    }
}
