package davidxxx.microservicewithconsul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@RequestMapping(value = "/forecast", produces = MediaType.TEXT_PLAIN_VALUE)
public class WeatherForecastController {

  private static final Logger logger = LoggerFactory.getLogger(WeatherForecastController.class);
  private String instanceId;

  public WeatherForecastController(@Value("${spring.cloud.consul.discovery.instanceId}") String instanceId){
    this.instanceId = instanceId;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<String> get() {
//    logger.info("PERFORMED BY : " + request.getServerName() + ":" + request.getServerPort());
    logger.info("get() from the " + instanceId + " instance");
    int randomInt = new Random().nextInt(2);
    if (randomInt == 0) {
      return ResponseEntity.ok("GOOD");
    } else {
      return ResponseEntity.ok("BAD");
    }

  }
}
