package com.example.demo.proxies;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.EventBean;

@FeignClient(name="evenement-service")
public interface EventProxy {
	
	@GetMapping("evenements")
	List<EventBean>getAllEvents();
	
	@GetMapping("evenements/{id}")
	EventBean getEventById(@PathVariable("id") Long id);

}