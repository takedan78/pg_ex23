import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.junit.Test;

public class BillwriteTest {

	@Test
	public void billmathTest(){
		List<String> receiveRecordReturn = new ArrayList<String>();
		CustomerBean recordlinejudgeReturn = new CustomerBean();
		Recordread recordread = new Recordread();
		JTextArea area = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002\n2 C1 090-1234-0003\n5 2004/06/04 03:34 003 090-1234-0002\n5 2004/06/04 13:50 010 090-1234-9999");
		receiveRecordReturn = recordread.receiveRecord(area);
		recordlinejudgeReturn = recordread.recordlinejudge(receiveRecordReturn);

		ArrayList<String> billresultTest = new ArrayList<String>();
		Billwrite billwrite = new Billwrite();
		billresultTest = billwrite.billmath(recordlinejudgeReturn);
		assertEquals("1 090-1234-0001",billresultTest.get(0));
		assertEquals("5 1100",billresultTest.get(1));
		assertEquals("7 230",billresultTest.get(2));
		assertEquals("9 ====================",billresultTest.get(3));
	}

}
