package com.api.daofab;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.daofab.model.ChildDTO;
import com.api.daofab.model.ChildJsonDTO;
import com.api.daofab.model.ChildJsonObject;
import com.api.daofab.model.Parent;
import com.api.daofab.model.ParentDTO;
import com.api.daofab.service.ChildService;
import com.api.daofab.service.ParentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class DaofabApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaofabApplication.class, args);
	}
	
	/** Reads Parent.json and write to parent table in database **/
	@Bean
	CommandLineRunner runner1(ParentService parentService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<ParentDTO> typeReference = new TypeReference<ParentDTO>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Parent.json");
			try {
				ParentDTO dto = mapper.readValue(inputStream,typeReference);
				List<Parent> parents = dto.getData();
				parentService.save(parents);
				System.out.println("Parents Saved!");
			} catch (IOException e){
				System.out.println("Unable to save parents: " + e.getMessage());
			}
		};
	}
	
	/** Reads Child.json and write to child table in database **/
	@Bean
	CommandLineRunner runner2(ChildService childService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<ChildJsonDTO> typeReference = new TypeReference<ChildJsonDTO>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Child.json");
			try {
				ChildJsonDTO dto = mapper.readValue(inputStream,typeReference);
				List<ChildJsonObject> children = dto.getData();
				childService.save(children);
				System.out.println("Children Saved!");
			} catch (IOException e){
				System.out.println("Unable to save children: " + e.getMessage());
			}
		};
	}

}
