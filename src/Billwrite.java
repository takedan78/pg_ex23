import java.util.ArrayList;

public class Billwrite {


	//顧客ごとの請求額計算メソッド
	public ArrayList<String> billmath(CustomerBean customerBeanbill) {
		ArrayList<String> billresult = new ArrayList<String>();
		ArrayList<String> familydiscountnumber = new ArrayList<String>();

		//加入サービスの特定と基本料金の計算
		for (int i = 0; i < customerBeanbill.getCampaignInfoList().size(); i++){
			String servicetype = customerBeanbill.getValueCampaignInfoList(i).substring(0,2);
			if(servicetype.equals("C1")){
				customerBeanbill.setBasicCharge(1100);
				familydiscountnumber.add(customerBeanbill.getValueCampaignInfoList(i).substring(3,16));
			}else if(servicetype == "E1"){
				customerBeanbill.setNooncampaignflag(true);
				customerBeanbill.setBasicCharge(customerBeanbill.getBasicCharge()+200);
			}
		}

		//通話記録の特定と通話料金の計算
		for (int i = 0; i < customerBeanbill.getCallInfoList().size(); i++){
			int callUnitPrice = 20;
			int time = Integer.parseInt(customerBeanbill.getValueCallInfoList(i).substring(11,13));
			int callMinute = Integer.parseInt(customerBeanbill.getValueCallInfoList(i).substring(17,20));
			String phonenum = customerBeanbill.getValueCallInfoList(i).substring(21,34);

			//割引計算
			if(customerBeanbill.getNooncampaignflag() && time>=8 && time<=17 ){
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
			customerBeanbill.setCallpriceAmount(customerBeanbill.getCallpriceAmount()+(callUnitPrice * callMinute));
		}
		billresult.add("1 " + customerBeanbill.getPhoneNumber());
		billresult.add("5 " + String.valueOf(customerBeanbill.getBasicCharge()));
		billresult.add("7 " + String.valueOf(customerBeanbill.getCallpriceAmount()));
		billresult.add("9 ====================");
//		System.out.println("1 "+ customerBeanbill.getPhoneNumber());
//		System.out.println("5 "+ String.valueOf(basicCharge));
//		System.out.println("7 "+ String.valueOf(callpriceAmount));
		return billresult;
	}

}
