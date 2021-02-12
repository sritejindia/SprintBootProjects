package tej.springboot.proxy.DemoSBRoutFilterforProxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import tej.springboot.proxy.DemoSBRoutFilterforProxy.filter.ErrorFilter;
import tej.springboot.proxy.DemoSBRoutFilterforProxy.filter.PostFilter;
import tej.springboot.proxy.DemoSBRoutFilterforProxy.filter.PreFilter;
import tej.springboot.proxy.DemoSBRoutFilterforProxy.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class DemoSbRoutFilterforProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSbRoutFilterforProxyApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}


}
