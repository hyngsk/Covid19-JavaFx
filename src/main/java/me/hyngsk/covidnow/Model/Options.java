package me.hyngsk.covidnow.Model;

public enum Options {
	All("전체"),
	total("합계"), Lazaretto("검역"),
	Seoul("서울"), Incheon("인천"), Daejeon("대전"),
	Daegu("대구"), Busan("부산"), Ulsan("울산"),
	Gwangju("광주"), Jeju("제주"), Gyeonggi("경기"),Sejong("세종"),
	Gangwon("강원"), CCNorth("충북"), CCSouth("충남"),
	JRNorth("전북"), JRSouth("전남"), GSNorth("경북"), GSSouth("경남");
	private String label;
	Options(String label){
		this.label = label;
	}

	@Override
	public String toString() {
		return label;
	}
}