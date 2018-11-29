package sonosApiManager;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = { "http://taaffe.duckdns.org:5005", "http://taaffe.duckdns.org" })
public class sonosAPIController {

	@GetMapping("sonosApi/{sonosApiCommand}")
	private String sendSonosCommand(@PathVariable String sonosCommand) {
		RestTemplate restTemplate = new RestTemplate();
		SonosRestResponse commandResponse = restTemplate.getForObject("http://taaffe.duckdns.org:5005/" + sonosCommand, SonosRestResponse.class);
		return commandResponse.getStatus();
	}
}
