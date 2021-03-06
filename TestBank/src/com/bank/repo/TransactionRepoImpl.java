package com.bank.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.entity.Accounts;
import com.bank.entity.Transactions;

@Repository
public class TransactionRepoImpl implements TransactionRepo {
	@Autowired
	private SessionFactory factory;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Transactions> loadStatement() {
		Accounts acc = new Accounts();
		acc.setAccountNo("123456789012");
		Session session = factory.getCurrentSession();
		List<Transactions> stmt = session.createQuery("from Transactions where account_no = '123456789012'").list();
		return stmt;
	}

}
