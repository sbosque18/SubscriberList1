package com.tts.subscriberList1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.subscriberList1.model.Subscriber;
import com.tts.subscriberList1.repository.SubscriberRepository;

@Controller
public class SubscriberController {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@GetMapping (value = "/")
	public String index(Subscriber subscriber) {
		return "subscriber/index";
	}
	@PostMapping(value="/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		Subscriber subscriberToAdd= new Subscriber (subscriber.getFirstName(), subscriber.getLastName(), subscriber.getUserName(), null);
		subscriberRepository.save(subscriberToAdd);
		model.addAttribute("firstName", subscriberToAdd.getFirstName());
		model.addAttribute("lastName", subscriberToAdd.getLastName());
		model.addAttribute("userName", subscriberToAdd.getUserName());
		return "subscriber/result";
	}
}
