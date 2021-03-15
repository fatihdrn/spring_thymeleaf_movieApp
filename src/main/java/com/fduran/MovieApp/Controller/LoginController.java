package com.fduran.MovieApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/loginPage")
	public String showMyLoginPage() {

		return "login";

	}


	@GetMapping("/access-denied")
	public String showAccessDenied() {

		return "access-denied";

	}

}
