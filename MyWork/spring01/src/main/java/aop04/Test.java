package aop04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// ** IOC/DI 적용
	    // => 스프링컨테이너 생성
	    // => 필요한 Bean 을 주입받는다
		
		AbstractApplicationContext sc = new GenericXmlApplicationContext("aop04.xml");
		Programmer programmerB = (Programmer)sc.getBean("boy");
		Programmer programmerG = (Programmer)sc.getBean("girl");
		
		
		try {
			System.out.println("--boy--");
			System.out.println("boy return :" +programmerB.doStudying(20));
			System.out.println("--girl--");
			System.out.println("girl return :" +programmerG.doStudying(40));
		} catch (Exception e) {
			System.out.println("main Exception => " + e.toString());
		}
		sc.close();
		
		
	}
}
