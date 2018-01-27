package org.brocom.spring.boot.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MyBean {
    @Value("${name}")
    private String name;
}
