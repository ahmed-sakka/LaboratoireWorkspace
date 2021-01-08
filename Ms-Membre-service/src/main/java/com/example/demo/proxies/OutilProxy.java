package com.example.demo.proxies;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.OutilBean;

@FeignClient(name="outil-service")
public interface OutilProxy {
	@GetMapping(value = "/outils")
	List<OutilBean> listeDesOutils();

	@GetMapping( value = "/outils/{id}")
	OutilBean recupererUneOutil(@PathVariable("id") Long id);

}