

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerBean implements Serializable {

	private String phoneNumber;
	private ArrayList<String> campaignInfoList = new ArrayList<String>();
	private ArrayList<String> callInfoList = new ArrayList<String>();

	public CustomerBean() {
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




}
