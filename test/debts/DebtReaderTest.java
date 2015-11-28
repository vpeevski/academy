package debts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class DebtReaderTest {
	
	private final List<List<String>> fileContent = new ArrayList<List<String>>();
	
	@Test
	public void testNotExistingFile() {
		DebtReader reader = new DebtReader();
		try {
			reader.readDebts("resources/debts_bla_bla.txt");
			fail("FileNotFoundException expected");
		} catch (FileNotFoundException fne) {
			assertTrue(true);
		} catch (IOException ioe) {
			fail("Read from file error !");
		}
	}
	
	@Test
	public void testReadFile() throws IOException {
		DebtReader reader = new DebtReader();
		Vector<Vector<String>> debts = reader.readDebts("test/resources/debts_test.txt");
		assertEquals(fileContent, debts);
	}
	
	@Test
	public void testReadEmptyFile() throws IOException {
		DebtReader reader = new DebtReader();
		Vector<Vector<String>> debts = reader.readDebts("test/resources/debtsEmpty_test.txt");
		assertEquals(Collections.EMPTY_LIST, debts);
	}
	
	@Before
	public void initialize () {
		List<String> debt1 = createDebt("ABC123ABC123", "500.00", "14.03.2016", "Длъжник 1", "Кредитор 1");
		List<String> debt2 = createDebt("DULGOVE11MUL", "600.60", "24.11.2014", "Длъжник 2", "Кредитор 1");
		List<String> debt3 = createDebt("RERESDA12343", "704.00", "14.02.2014", "Длъжник 3", "Kreditor 3");
		List<String> debt4 = createDebt("ABC000ABC000", "801.00", "10.11.2015", "Длъжник 4", "Кредитор77");
		List<String> debt5 = createDebt("BEZALEN11SIE", "900.10", "08.03.2015", "Генади МС", "Кредитор 1");
		fileContent.add(debt1);		
		fileContent.add(debt2);		
		fileContent.add(debt3);		
		fileContent.add(debt4);		
		fileContent.add(debt5);		
	}
	
	private List<String> createDebt (String id, String sum, String date, String debtorName, String creditorName) {
		List<String> debt = new ArrayList<String>();
		debt.add(id);
		debt.add(sum);
		debt.add(date);
		debt.add(debtorName);
		debt.add(creditorName);
		return debt;
	}

}
