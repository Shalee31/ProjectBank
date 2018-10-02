import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bank.entity.Transactions;
import com.bank.service.StatementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestStatement {

	@Autowired
	private StatementService service;

	@Test
	public void testHibernate() {
		List<Transactions> stmt = service.loadStatement();
		for (Transactions t : stmt) {
			System.out.println(t.getTransactionType() + " : " + t.getBalance() + " : " + t.getTransactionId());
		}
	}
}
