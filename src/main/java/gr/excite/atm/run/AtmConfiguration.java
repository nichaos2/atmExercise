package gr.excite.atm.run;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"gr.excite.atm"})
public class AtmConfiguration {

//	@Bean(name = "atm")
//	public Atm getAtm() {
//		return new Atm();
//	}
	
}
