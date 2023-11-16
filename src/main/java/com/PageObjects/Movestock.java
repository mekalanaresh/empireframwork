package com.PageObjects;


import java.beans.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils1;
import com.base.Testbase;


public class Movestock extends Testbase{
		//movefrom
		@FindBy(id="movedFromD")
		WebElement MoveFrom;
		//MoveTo
		@FindBy(id="movedToD")
		WebElement MoveTo;
		//modelno
		@FindBy(id="invId")
		WebElement modelNo;
		//Movingqty
		@FindBy(id="qtymoving")
		WebElement movingqty;
		//add btn
		@FindBy(id="btnAdd")
		WebElement Add;
		//savebtn
		@FindBy(id="btnSave")
		WebElement savebtn;
		//refrence/notes
		@FindBy(id="MoStNot")
		WebElement notes;
		//verification
	 
	public Movestock(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}


	public Movestock() throws Throwable {
		 super();
	}


	public Statement warehousetoshowroom() throws Throwable {
		Utils1.dropdownBy(props.getProperty("Movefrom"),MoveFrom);
		Utils1.dropdownBy(props.getProperty("Moveto"),MoveTo);
		Utils1.dropdownBy(props.getProperty("Modelno"),modelNo);
		movingqty.clear();
		movingqty.sendKeys(props.getProperty("Quantity"));
		notes.sendKeys(props.getProperty("Note"));
		Add.click();
		savebtn.click();
		return  new Statement(Add, null, null);
		
	}
	public Statement showroomtowarehouse() throws Throwable
	{
		Utils1.dropdownBy(props.getProperty("Moveto"),MoveFrom);
		Utils1.dropdownBy(props.getProperty("Movefrom"),MoveTo);
		Utils1.dropdownBy(props.getProperty("Modelno"),modelNo);
		movingqty.clear();
		movingqty.sendKeys(props.getProperty("Quantity"));
		notes.sendKeys(props.getProperty("Notes"));
		Add.click();
		savebtn.click();
		return new Statement(Add, null, null);
		
	}
}
