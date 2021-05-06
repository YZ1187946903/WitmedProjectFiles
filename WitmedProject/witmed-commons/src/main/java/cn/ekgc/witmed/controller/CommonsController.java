package cn.ekgc.witmed.controller;

import cn.ekgc.witmed.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("commonsController")
@RequestMapping("/commons")
public class CommonsController {
	@Autowired
	private IdGenerator idGenerator;

	@GetMapping("/id")
	public String createId() throws Exception {
		return idGenerator.createId();
	}
}
