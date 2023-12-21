package org.choongang.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "file")
// 스프링부트에만 있는 기능, 설정에 있는 같은 이름의 것을 자동으로 가져와준다.
public class FileProperties {
    private String url;
    private String path;
}
