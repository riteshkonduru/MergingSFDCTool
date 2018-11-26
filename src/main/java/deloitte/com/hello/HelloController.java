package deloitte.com.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hello Ritesh, this is your first Spring Boot project.";
	} 

}
