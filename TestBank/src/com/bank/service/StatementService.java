package com.bank.service;


import java.util.List;

import com.bank.entity.Transactions;

public interface StatementService {
	
	List<Transactions> loadStatement();
}
