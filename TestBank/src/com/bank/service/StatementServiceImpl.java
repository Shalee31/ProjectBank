package com.bank.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Transactions;
import com.bank.repo.StatementRepo;
@Service
public class StatementServiceImpl implements StatementService {

	@Autowired
	private StatementRepo stmtRepo;
	
	@Override
	public List<Transactions> loadStatement() {
		List<Transactions> stmt = stmtRepo.loadStatement();
		return stmt;
	}

}
