package Railway.dataProvider;

import org.testng.annotations.DataProvider;

import Railway.pages.bookTicketPage;

public class data {

	@DataProvider(name = "TC01")
	public Object[][] createData1() {
		return new Object[][] { { "test1@grr.la", "12345678" } };
	}

	@DataProvider(name = "TC02")
	public Object[][] createData2() {
		return new Object[][] { { "", "12345678" } };
	}
	
	@DataProvider(name = "TC03")
	public Object[][] createData3() {
		return new Object[][] { { "test1@grr.la", "123456789" } };
	}
	
	@DataProvider(name = "TC04")
	public Object[][] createData4() {
		return new Object[][] { { "test1@grr.la", "123456781" }, { "test1@grr.la", "123456782" }, { "test1@grr.la", "123456783" }, { "test1@grr.la", "123456784" }};
	}
	
	@DataProvider(name = "TC05")
	public Object[][] createData5() {
		return new Object[][] { { "test2@grr.la", "12345678" } };
	}	
	
	@DataProvider(name = "TC07")
	public Object[][] createData7() {
		return new Object[][] { { "test1@grr.la", "12345678" ,"12345678","123456789" } };
	}
	
	@DataProvider(name = "TC08")
	public Object[][] createData8() {
		return new Object[][] { { "test1@grr.la", "" ,"","" } };
	}
	
	@DataProvider(name = "TC09")
	public Object[][] createData9() {
		return new Object[][] { { "test34", "12345678" ,"12345678","12345678" } };
	}
	
	@DataProvider(name = "TC10")
	public Object[][] createData10() {
		return new Object[][] { { "test1", "12345678"} };
	}
	
	@DataProvider(name = "TC11")
	public Object[][] createData11() {
		return new Object[][] { { "test1", "12345678", "123456789"} };
	}
	
	@DataProvider(name = "TC12")
	public Object[][] createData12() {
		return new Object[][] { { "test100@grr.la", "12345678", bookTicketPage.actPlusAndFormatDate(12),"Nha Trang","Huế","Soft bed with air conditioner","1"} };
	}
	
	@DataProvider(name = "TC13")
	public Object[][] createData13() {
		return new Object[][] { { "test33@grr.la", "12345678", bookTicketPage.actPlusAndFormatDate(25),"Nha Trang","Sài Gòn","Soft bed with air conditioner","5"} };
	}
	
	@DataProvider(name = "TC14")
	public Object[][] createData14() {
		return new Object[][] { { "test100@grr.la", "12345678","Đà Nẵng","Sài Gòn"} };
	}
	
	@DataProvider(name = "TC15")
	public Object[][] createData15() {
		return new Object[][] { { "test100@grr.la", "12345678","Quảng Ngãi","Huế"} };
	}
	
	@DataProvider(name = "TC16")
	public Object[][] createData16() {
		return new Object[][] { { "test3@grr.la", "12345678", bookTicketPage.actPlusAndFormatDate(15),"Quảng Ngãi","Sài Gòn","Soft bed with air conditioner","1"} };
	}
}


