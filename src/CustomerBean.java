

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerBean implements Serializable {

	private String phoneNumber;
	private ArrayList<String> campaignInfoList = new ArrayList<String>();
	private ArrayList<String> callInfoList = new ArrayList<String>();
	private int basicCharge = 1000;
	private int callCharge = 1000;
	private int callpriceAmount = 0;
	private boolean nooncampaignflag = false;

	CustomerBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ArrayList<String> getCampaignInfoList() {
		return campaignInfoList;
	}

	public void setCampaignInfoList(ArrayList<String> campaignInfoList) {
		this.campaignInfoList = campaignInfoList;
	}

	public String getValueCampaignInfoList(int index) {
		return this.campaignInfoList.get(index);
	}

	public void setValueCampaignInfoList(String value) {
		this.campaignInfoList.add(value);
	}

	public ArrayList<String> getCallInfoList() {
		return callInfoList;
	}

	public void setCallInfoList(ArrayList<String> callInfoList) {
		this.callInfoList = callInfoList;
	}
	public String getValueCallInfoList(int index) {
		return this.callInfoList.get(index);
	}

	public void setValueCallInfoList(String value) {
		this.callInfoList.add(value);
	}
	public int getBasicCharge() {
		return basicCharge;
	}

	public void setBasicCharge(int basicCharge) {
		this.basicCharge = basicCharge;
	}

	public int getCallCharge() {
		return callCharge;
	}

	public void setCallCharge(int callCharge) {
		this.callCharge = callCharge;
	}

	public int getCallpriceAmount() {
		return callpriceAmount;
	}

	public void setCallpriceAmount(int callpriceAmount) {
		this.callpriceAmount = callpriceAmount;
	}

	public boolean getNooncampaignflag() {
		return nooncampaignflag;
	}

	public void setNooncampaignflag(boolean nooncampaignflag) {
		this.nooncampaignflag = nooncampaignflag;
	}
}
