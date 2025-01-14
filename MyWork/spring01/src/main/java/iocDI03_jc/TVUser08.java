package iocDI03_jc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

//** Java Bean Configuration class를 이용한 DI
//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
//             매개변수로 Java_config_class 를 사용 (JavaConfig01.class)           
//=> Test01 : 스피커 없는 TV

interface TV{
    void powerOn();
    void volumeUp();
    void volumeDown();
    void powerOff();
}

class SsTVi implements TV{
    public SsTVi() {System.out.println("~~ SsTVi 기본생성자 ~~");}
    @Override
    public void powerOn() {System.out.println("~~ SsTvi pownerOff ~~");}
    @Override
    public void volumeUp() {System.out.println("~~ SsTvi volumeDown ~~");}
    @Override
    public void volumeDown() {System.out.println("~~ SsTvi volumeUp ~~");}
    @Override
    public void powerOff() {System.out.println("~~ SsTvi powerOn ~~");}
}

class LgTVi implements TV{
    public LgTVi() { System.out.println("~~ LgTVi 기본생성자 ~~"); }
    @Override
    public void powerOn() {System.out.println("~~ LgTVi pownerOff ~~");}
    @Override
    public void volumeUp() {System.out.println("~~ LgTVi volumeDown ~~");}
    @Override
    public void volumeDown() {System.out.println("~~ LgTVi volumeUp ~~");}
    @Override
    public void powerOff() {System.out.println("~~ LgTVi powerOn ~~");}
}

public class TVUser08 {

    public static void main(String[] args) {
        // 1. 스프링 컨테이너 생성
    	// => AnnotationConfigApplicationContext 사용
        //    매개변수로 Java_Config_class 를 사용 (JavaConfig01.class) 
        //    -> 주의사항 : "" 없이 화일명 적용, 같은 package에 있으므로  package명 생략
        //    -> 참고 : 스프링 프로젝트의 .class 화일 위치 C:\MTest\myWork\spring01\target\classes\iocDI03_jc   
        
    	AbstractApplicationContext sc = new 
        		AnnotationConfigApplicationContext(JavaConfig01.class);
        
        // 2. 필요한 객체를 전달받고 서비스 실행
        TV tv = (TV)sc.getBean("tv");
        if(tv != null) {
            tv.powerOn();
            tv.volumeUp();
            tv.volumeDown();
            tv.powerOff();
        }else System.out.println("** TV를 선택하지 않음 **");

        System.out.println("** Program 정상종료 **");
        sc.close();
    }//main

}//class