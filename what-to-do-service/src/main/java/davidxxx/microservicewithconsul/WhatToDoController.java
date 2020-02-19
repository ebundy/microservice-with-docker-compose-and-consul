package davidxxx.microservicewithconsul;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/what-to-do", produces = MediaType.TEXT_PLAIN_VALUE)
public class WhatToDoController {

  private RestTemplate restTemplate;

  public WhatToDoController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<String> get() {
    ResponseEntity<String> responseEntity =
        restTemplate.getForEntity("http://weather-forecast/forecast", String.class);
    String weather = responseEntity.getBody();
    if ("GOOD".equals(weather)){
      return ResponseEntity.ok("Go out!");
    }
    else{
      return ResponseEntity.ok("Stay at home!");
    }

  }
}
