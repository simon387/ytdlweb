package ytdlweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*

curl --header "Content-Type: application/json" --request POST --data '{"url": "https://www.youtube.com/watch?v=4V90AmXnguw","type": "mp3"}' --output "asd.mp3" http://localhost:8080/ytdl


 */