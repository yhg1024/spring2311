package configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
public class FileProperty {
    @Value("file.url")
    private String url;
    @Value("file.path")
    private String path;
}
