

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.junit.Test;



public class RecordreadTest {
	@Test
	public void receiveRecordTest() {
		Recordread recordread = new Recordread();
		List<String> receiveRecordTest = new ArrayList<String>();
		JTextArea area = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002\n2 C1 090-1234-0003\n5 2004/06/04 03:34 003 090-1234-0002\n5 2004/06/04 13:50 010 090-1234-9999");
		receiveRecordTest = recordread.receiveRecord(area);
		assertEquals("1 090-1234-0001",receiveRecordTest.get(0));
		assertEquals("2 C1 090-1234-0002",receiveRecordTest.get(1));
	}

	@Test
	public void recordlinejudgeTest() {
		Recordread recordread = new Recordread();
		List<String> receiveRecordTest = new ArrayList<String>();
		JTextArea area = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002\n2 C1 090-1234-0003\n5 2004/06/04 03:34 003 090-1234-0002\n5 2004/06/04 13:50 010 090-1234-9999");
		receiveRecordTest = recordread.receiveRecord(area);
		CustomerBean recordlinejudgeTest = new CustomerBean();
		recordlinejudgeTest = recordread.recordlinejudge(receiveRecordTest);
		assertEquals("090-1234-0001", recordlinejudgeTest.getPhoneNumber());
		assertEquals("C1 090-1234-0002", recordlinejudgeTest.getValueCampaignInfoList(0));
		assertEquals("C1 090-1234-0003", recordlinejudgeTest.getValueCampaignInfoList(1));
		assertEquals("2004/06/04 03:34 003 090-1234-0002", recordlinejudgeTest.getValueCallInfoList(0));
		assertEquals("2004/06/04 13:50 010 090-1234-9999", recordlinejudgeTest.getValueCallInfoList(1));
	}



}