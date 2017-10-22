
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) throws IOException {

		//Recordreadクラス
		Recordread recordread = new Recordread();
		JTextArea area = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002\n2 C1 090-1234-0003\n5 2004/06/04 03:34 003 090-1234-0002\n5 2004/06/04 13:50 010 090-1234-9999");

		List<String> receiveRecord = new ArrayList<String>();
		receiveRecord = recordread.receiveRecord(area);

		CustomerBean recordlinejudge = new CustomerBean();
		recordlinejudge = recordread.recordlinejudge(receiveRecord);

		//Billwriteクラス
		Billwrite billwrite = new Billwrite();
		ArrayList<String> billresult = new ArrayList<String>();
		billresult = billwrite.billmath(recordlinejudge);

		//請求書ファイル出力
		try{
		File file = new File("data/invoice.dat");
		FileWriter bw = new FileWriter(file,true);

		for(String invoice:billresult){
			bw.write(invoice+"\n");
		}
		bw.close();
        } catch(IOException e) {
            System.out.println(e);
        }
	}

}