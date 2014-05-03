package day01;

import java.security.Provider;
import java.security.Security;

import org.junit.Test;

public class TestSecurity {
	
	@Test
	public void test01(){
		for(Provider provider:Security.getProviders()){
			//打印提供者信息
			System.out.println(provider);
			
			for(Object obj:provider.keySet()){
				System.out.println("key:"+obj);
				System.out.println("value:"+provider.get(obj));
			}
			
		}
	}

}
