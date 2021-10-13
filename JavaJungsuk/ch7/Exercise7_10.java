package ch7;

class MyTv2{
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public void setIsPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	public boolean getIsPowerOn() {
		return isPowerOn;
	}

	public void setChannel(int channel) {
		//매개변수 유효성 검사
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
			return;
		}
		
		prevChannel = this.channel; //현재 채널을 이전채널로 저장해둠
		this.channel = channel;
	}
	
	public int getChannel() {
		return channel;
	}

	public void setVolume(int volume) {
		if(volume > MAX_VOLUME || volume < MIN_VOLUME) {
			return;
		}
		
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);	//기존 setter 재사용
	}
	
}

public class Exercise7_10 {

	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}

}
