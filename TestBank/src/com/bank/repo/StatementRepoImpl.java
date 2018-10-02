package com.bank.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.entity.Transactions;

@Repository
public class StatementRepoImpl implements StatementRepo {
	@Autowired
	private SessionFactory factory;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Transactions> loadStatement() {
		Session session = factory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Transactions.class);
		criteria.add(Restrictions.eq("accountNo", "123456789012"));
		criteria.add(Restrictions.between("timestamp", "20-Jan-2018", "31-Jan-2018"));
		List<Transactions> stmt = criteria.list();
		return stmt;
	}

}
