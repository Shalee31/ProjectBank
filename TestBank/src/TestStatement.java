import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bank.entity.Transactions;
import com.bank.repo.TransactionRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestStatement {

	@Autowired
	private TransactionRepo stmtRepo;

	@Test
	public void testHibernate() {
		List<Transactions> stmt = stmtRepo.loadStatement();
		for (Transactions t : stmt) {
			System.out.println(t.getBalance());
		}
	}
}
