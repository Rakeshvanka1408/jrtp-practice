package in.ashokit.service;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportService {

	public void generateReport() {
		log.info("this is info : method started");
		try {
			int i = 10/0;
			
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		log.info("This is info : method is ended");
	}
}
