package com.bank.repo;

import java.util.List;

import com.bank.entity.Transactions;

public interface TransactionRepo {

	List<Transactions> loadStatement();
}
