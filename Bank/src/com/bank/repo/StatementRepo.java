package com.bank.repo;

import java.util.List;

import com.bank.entity.Transactions;

public interface StatementRepo {

	List<Transactions> loadStatement();
}
