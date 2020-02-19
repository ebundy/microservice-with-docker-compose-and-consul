package davidxxx.microservicewithconsul;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@RequestMapping(value = "/forecast", produces = MediaType.TEXT_PLAIN_VALUE)
public class WeatherForecastController {


  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<String> get(HttpServletRequest request) {
    System.out.println("PERFORMED BY : " + request.getServerName() + ":" + request.getServerPort());
    int randomInt = new Random().nextInt(2);
    if (randomInt == 0) {
      return ResponseEntity.ok("GOOD");
    } else {
      return ResponseEntity.ok("BAD");
    }

  }
}
