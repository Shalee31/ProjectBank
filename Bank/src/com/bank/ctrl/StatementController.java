package com.bank.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.entity.Transactions;
import com.bank.service.StatementService;

@Controller
public class StatementController {
	@Autowired
	private StatementService service;

	@RequestMapping(value = "createstmt.bank", method = RequestMethod.GET)
	public String generateStatement(@RequestParam("accNo") String accountNo, @RequestParam("start") String startDate, @RequestParam("end") String endDate,
			HttpSession session) {

		List<Transactions> stmt = (List<Transactions>) session.getAttribute("STATEMENT");

		session.setAttribute("ACCNO", accountNo);

		session.setAttribute("START", startDate);

		session.setAttribute("END", endDate);

		if (stmt == null) {
			stmt = service.loadStatement();
			session.setAttribute("STATEMENT", stmt);
		}

		return "displaystmt";
	}

}
