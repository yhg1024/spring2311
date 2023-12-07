package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("models") //models를 포함한 하위 패키지도 등록
public class AppCtx {

}
