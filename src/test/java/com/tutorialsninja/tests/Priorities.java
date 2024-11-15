package com.tutorialsninja.tests;

import org.testng.annotations.Test;

public class Priorities {
@Test(priority=1)
 public void sampleOne() {
	 System.out.println("sampleOne Test Method");
 }
@Test(priority=2)
 public void sampleTwo() {
	 System.out.println("sampleTwo Test Method");
 }
@Test(priority=3)
 public void sampleThree() {
	 System.out.println("sampleThree Test Method");
 }
@Test(priority=4)
 public void sampleFour() {
	 System.out.println("sampleFour Test Method");
 }
}
