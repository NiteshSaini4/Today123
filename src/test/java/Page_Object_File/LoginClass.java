package Page_Object_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass 
{
	WebDriver Currentdriver;
	public LoginClass(WebDriver Remotedriver) 
	{
		Currentdriver=Remotedriver;
		PageFactory.initElements( Remotedriver,this);
	}
	@FindBy(id="username") WebElement Username; 
	@FindBy(id="password") WebElement Password; 
	@FindBy(id="submit") WebElement Submit; 
	public void user_Name(String user)
	{
		Username.sendKeys(user);
	}
	public void user_Pass(String pass)
	{
		Password.sendKeys(pass);
	}
	public void user_Sub()
	{
		Submit.click();;
	}

}
