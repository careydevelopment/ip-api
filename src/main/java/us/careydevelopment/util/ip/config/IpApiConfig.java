package us.careydevelopment.util.ip.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Main config class.
 * 
 * Remember: this class needs to be loaded via AnnotationConfigApplicationContext.
 * 
 * You can see an example of that in the {@link us.careydevelopment.util.ip.service.IpService IpService class}.
 * 
 * @author Brian Carey
 *
 */
@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan("us.careydevelopment.util.ip")
public class IpApiConfig {

    /**
     * Static method available if, for whatever reason, some developer wants to use this package
     * independent of the service.
     */
    public static void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(IpApiConfig.class);
    }
    
    
    /**
     * Necessary to read @Value
     */
    @Bean 
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
