package com.techproed.springboot_demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
 	If you use @Scope("prototype"), SpringBoot stops creating object inside the container
 	at the beginning. If you do not use @Scope("prototyp"), SpringBoot will make the object
 	ready when you run the application.
 */

@Component
@Scope("prototype")  // This stops using "Singleton Design Pattern", it means object will be
public class Laptop { // created in every getBean() usage

	
	private Battery b;
	private int price;
	@Qualifier("bS")
	@Autowired			  // bS object is used by laptop object,
	private BatteryS bS;  //  to tell SpringBoot to use an object by another object use @Autowired
						  // @Autowired selects the objects by using data types as default
						  // but if you want you can tell to @Autowired to use object names
						  // by using @Qualifier annotation and change the @Component to @Component("bS")
						  // in BatteryS Class
	Laptop(){
		System.out.println("Laptop is created");
	}
	
	public Battery getB() {
		return b;
	}
	public void setB(Battery b) {
		this.b = b;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public BatteryS getbS() {
		return bS;
	}

	public void setbS(BatteryS bS) {
		this.bS = bS;
	}
	
	public void turnOnLaptop() {
		bS.use();
		System.out.println("Laptop is turned on...");
	}
	
}