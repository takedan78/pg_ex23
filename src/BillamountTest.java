

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.junit.Test;



public class BillamountTest {

	Billamount billamount = new Billamount();

	@Test
	public void receiveRecordTest() {

		ArrayList<String> recordListTest = new ArrayList<String>();
		JTextArea area = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002\n2 C1 090-1234-0003\n5 2004/06/04 03:34 003 090-1234-0002\n5 2004/06/04 13:50 010 090-1234-9999");
	//	assertEquals("[1 090-1234-0001\n2 C1 090-1234-0002]", billamount.receiveRecord(area));

//		for(String recordCheck :billamount.receiveRecord(area)){
//		assertEquals("[1,090-1234-0001\n2,C1,090-1234-0002]", billamount.recordline(recordCheck));
//		}
	}

//	@Test
//	public void recordlinejudgeTest() {
//		List<String> receiveRecordreturn = new ArrayList<String>();
//		JTextArea area = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002\n2 C1 090-1234-0003\n5 2004/06/04 03:34 003 090-1234-0002\n5 2004/06/04 13:50 010 090-1234-9999");
//		receiveRecordreturn = billamount.receiveRecord(area);
//		assertEquals("[1, 090-1234-0001\n2, C1, 090-1234-0002]", billamount.recordlinejudge(receiveRecordreturn));
//	}

	@Test
	public void billmathTest(){
		List<String> receiveRecordReturn = new ArrayList<String>();
		CustomerBean recordlinejudgeReturn = new CustomerBean();
		JTextArea area = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002\n2 C1 090-1234-0003\n5 2004/06/04 03:34 003 090-1234-0002\n5 2004/06/04 13:50 010 090-1234-9999");
		receiveRecordReturn = billamount.receiveRecord(area);
		recordlinejudgeReturn = billamount.recordlinejudge(receiveRecordReturn);

		String st = null;
		ArrayList<String> billresultTest = new ArrayList<String>();
		billresultTest = billamount.billmath(recordlinejudgeReturn);

			assertEquels("1 090-1234-0001\n",billresultTest.get(0));
			assertEquels("5 1100\n",billresultTest.get(0));
			assertEquels("7 230\n",billresultTest.get(0));
			assertEquels("9 ====================",billresultTest.get(0));

	}

private void assertEquels(String string, String string2) {
	// TODO 自動生成されたメソッド・スタブ

}

}