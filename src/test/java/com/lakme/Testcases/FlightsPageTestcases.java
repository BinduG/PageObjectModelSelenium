package com.lakme.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lakme.basesetup.BaseSetup;
import com.lakme.pageobjects.FlightsPageRepository;

public class FlightsPageTestcases extends BaseSetup {

	FlightsPageRepository flightspage;

	@BeforeClass
	public void initObjects() {

		flightspage = new FlightsPageRepository();

	}

	@Test(priority=1)
	private void selectOneWayOption() {

		flightspage.clickonewaybutton();

		String actual = flightspage.oneWay.getAttribute("class");

		if(actual.contains("switchAct")) {

			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false, "One way option isn't selected");
		}


	}

	@Test(priority=2)
	private void roundTripOption() {

		flightspage.clickroundTripbutton();

		String actual = flightspage.roundTrip.getAttribute("class");

		if(actual.contains("switchAct")) {

			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false, "Round Trip option isn't selected");
		}


	}

	@Test(priority=3)
	private void multicityOption() {

		flightspage.clickmultiCitybutton();

		String actual = flightspage.multiCity.getAttribute("class");

		if(actual.contains("switchAct")) {

			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false, "MultiCity option isn't selected");
		}	
	}
}
