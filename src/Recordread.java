import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextArea;

public class Recordread {
	//行ごとに分轄してrecordBeanに格納するメソッド
	public List<String> receiveRecord(JTextArea record1) {
		List<String> recordList = new ArrayList<String>();

		String str = record1.getText();
		recordList = Arrays.asList(str.split("\n"));
		for (int i = 0 ; i < recordList.size() ; i++){
		}

		//確認用
		for(String recordCheck :recordList){
		}

		return recordList;
	}

	//まとまりごとに分轄してcustomerBeanに格納するメソッド
	public CustomerBean recordlinejudge(List<String> recordlinejudgeTest) {
		ArrayList<String> judgeList = new ArrayList<String>();
//		ArrayList<CustomerBean> customerBean = new ArrayList<CustomerBean>();
		CustomerBean customerBean = new CustomerBean();
		for(int i = 0; i < recordlinejudgeTest.size(); i++){
			int frirst = Integer.parseInt(recordlinejudgeTest.get(i).substring(0,1));
				if(frirst == 0){

				}else if(frirst == 1){
					customerBean.setPhoneNumber(recordlinejudgeTest.get(i).substring(2));

				}else if(frirst == 2){
					customerBean.setValueCampaignInfoList(recordlinejudgeTest.get(i).substring(2));

				}else if(frirst == 5){
					customerBean.setValueCallInfoList(recordlinejudgeTest.get(i).substring(2));
			}
		}
		return customerBean;
	}
}
