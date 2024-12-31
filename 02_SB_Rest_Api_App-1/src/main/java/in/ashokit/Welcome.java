package in.ashokit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Welcome {
@GetMapping("/greet")
public String getMsg() {
	return "welcome to ashokit";
}
}
