
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextArea;

public class Billamount {

	public static void main(String[] args) {

		Billamount billamount = new Billamount();
		ArrayList<String> recordList0 = new ArrayList<String>();
		JTextArea record0 = new JTextArea("1 090-1234-0001\n2 C1 090-1234-0002");

		ArrayList<String> recordlinejudgeTest = new ArrayList<String>();
		 billamount.recordlinejudge(recordlinejudgeTest);

		 CustomerBean customerBean = new CustomerBean();
		 billamount.billmath(customerBean);

//		ArrayList<String> recordjudgeData = new ArrayList<String>();
//		 billamount.recordlinedivide(recordjudgeData);


	}
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
					System.out.println(customerBean.getPhoneNumber());
				}else if(frirst == 2){
					customerBean.setValueCampaignInfoList(recordlinejudgeTest.get(i).substring(2));
					System.out.println(customerBean.getValueCampaignInfoList(0));
				}else if(frirst == 5){
					customerBean.setValueCallInfoList(recordlinejudgeTest.get(i).substring(2));
					System.out.println(customerBean.getValueCallInfoList(0));
			}
		}
		return customerBean;
	}

	//顧客ごとの請求額計算メソッド
	public ArrayList<String> billmath(CustomerBean customerBeanbill) {
		ArrayList<String> billresult = new ArrayList<String>();
		int basicCharge = 1000;
		int callCharge = 1000;
		int callpriceAmount = 0;
		ArrayList<String> familydiscountnumber = new ArrayList<String>();

		//加入サービスの特定と基本料金の計算
		for (int i = 0; i < customerBeanbill.getCampaignInfoList().size(); i++){
			String servicetype = customerBeanbill.getValueCampaignInfoList(i).substring(0,2);
			if(servicetype.equals("C1")){
				basicCharge = 1100;
				familydiscountnumber.add(customerBeanbill.getValueCampaignInfoList(i).substring(3,16));
			}else if(servicetype == "E1"){
				basicCharge +=100;
			}
		}

		//通話記録の特定と通話料金の計算
		for (int i = 0; i < customerBeanbill.getCallInfoList().size(); i++){
			int callUnitPrice = 20;
			int time = Integer.parseInt(customerBeanbill.getValueCallInfoList(i).substring(11,13).replace("0",""));
			System.out.println(time);
			int callMinute = Integer.parseInt(customerBeanbill.getValueCallInfoList(i).substring(17,20).replace("0",""));
			System.out.println("分"+callMinute);
			String phonenum = customerBeanbill.getValueCallInfoList(i).substring(21,34);
			System.out.println(phonenum);

			//割引計算
			if(time>=8 || time<=17) {
				callUnitPrice -= 5;
				for (String numcheck : familydiscountnumber){
					if(numcheck.equals(phonenum)){
						callUnitPrice /= 2;
					}
				}
			}else{
				for (String numcheck : familydiscountnumber){
					if(numcheck.equals(phonenum)){
						callUnitPrice /= 2;
					}
				}
			}
			callpriceAmount  += callUnitPrice * callMinute;
			System.out.println("料金は"+ callpriceAmount);
		}

		billresult.add("1 " + customerBeanbill.getPhoneNumber());
		billresult.add("5 " + String.valueOf(basicCharge));
		billresult.add("7 " + String.valueOf(callpriceAmount));
		billresult.add("9 ====================");
		return billresult;
	}


}