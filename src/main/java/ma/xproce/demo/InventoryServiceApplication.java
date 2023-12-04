package ma.xproce.demo;

import lombok.AllArgsConstructor;
import ma.xproce.demo.entities.Creator;
import ma.xproce.demo.entities.Video;
import ma.xproce.demo.repositories.CreatorRepository;
import ma.xproce.demo.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class InventoryServiceApplication {

	private CreatorRepository creatorRepository ;

	private VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CreatorRepository creatorRepository , VideoRepository videoRepository){
		return args -> {
			List<Creator> creators = List.of(
					Creator.builder().id(00l).name("ILYASS SEDIK").email("zakach@gmail.com").build(),
					Creator.builder().id(01l).name("SAFI MOHAMMED RIAD").email("saloum@gmail.com").build()


			);

			creatorRepository.saveAll(creators);

			List<Video> videos = new ArrayList<>();
			videos.add(Video.builder().id(00l).name("steve").url("zakach@gmail.com").description("film naaadi").datePublication(new Date()).build());
			videos.add(Video.builder().id(01l).name("pipi").url("saloum@gmail.com").description("film 3eyyan").datePublication(new Date()).build());


			videoRepository.save(Video.builder().creator(creators.get(0)).build());

		};
	}
}
