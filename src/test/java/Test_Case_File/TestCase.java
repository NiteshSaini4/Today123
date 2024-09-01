package Test_Case_File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Object_File.LoginClass;
import Utilities_File.Data_Driven_Testing;

public class TestCase extends BaseClass
{
	@Test(dataProvider = "DataPro")
	void loginCase(String user,String pass)
	{
		driver.get(url);
		LoginClass lc=new LoginClass(driver);
		lc.user_Name(user);
		lc.user_Pass(pass);
		lc.user_Sub();
		
	}
	@DataProvider(name="DataPro")
	public String[][] getData() throws Exception
	{
		String file_name="C:\\Users\\user\\Desktop\\testdata.xlsx";
		int Rows=Data_Driven_Testing.getRow(file_name,"Sheet1");
		int cols=Data_Driven_Testing.getCol(file_name,"Sheet1");
		String s1[][]=new String[Rows][cols];
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				s1[i][j]=Data_Driven_Testing.getCellvalue(file_name,"Sheet1",i,j);
			}
		}
		return s1;
	}
}
