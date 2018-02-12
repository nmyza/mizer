package org.brocom.spring.boot.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Component
@XmlRootElement
public class MyBean implements IBean {
    @Value("${name}")
    private String name;
}
