package com.carbook.configurations;

import springfox.documentation.service.AuthorizationScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
//@Slf4j
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
//		List<SecurityScheme> schemeList = new ArrayList<SecurityScheme>();
//    	schemeList.add(securitySchema());
    	
//    	List<SecurityContext> contextList = new ArrayList<SecurityContext>();
//    	contextList.add(securityContext());
    	
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
                .enableUrlTemplating(false)
                .pathMapping("/")
//	            .genericModelSubstitutes(ResponseEntity.class)
	            .useDefaultResponseMessages(false);
//	            .securitySchemes(schemeList)
//	            .securityContexts(contextList);
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("My REST API",
				"Some custom description of API.",
				"API TOS",
				"Terms of service URL",
                new springfox.documentation.service.Contact("name", "url", "contact@contact.com"),
				"License of API",
				"API license URL",
				null);
		return apiInfo;
	}

//	private ApiKey securitySchema() {
////		return new BasicAuth("Authorization");
////	    return new ApiKey(ServiceConst.AUTHORIZATION, "profile_id", "header");
//	}
//
//	private SecurityContext securityContext() {
//		Set<String> securedRestMethodControllerPaths = getSecuredRestMethodControllerPaths();
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(input -> {
//                    if (securedRestMethodControllerPaths.contains(input)) {
//                        return true;
//                    }
//                    return false;
//                }).build();
//	}
//
	private List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope = new AuthorizationScope("api", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    List<SecurityReference> securityReference = new ArrayList<SecurityReference>();
	    securityReference.add(new SecurityReference("Authorization", authorizationScopes));
	    return securityReference;
	}

	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl");
	}
//
//	private Set<String> getSecuredRestMethodControllerPaths() {
//		Set<Class<?>> restControllers = new Reflections(ServiceConst.CONTROLLER_PACKAGE).getTypesAnnotatedWith(RestController.class);
//		return restControllers.stream()
//			.map(clazz -> {
//				RequestMapping classRequestMapping = clazz.getAnnotation(RequestMapping.class);
//				if (classRequestMapping == null) {
//					return null;
//				}
//
//				String basePath = classRequestMapping.value()[0];
//
//				@SuppressWarnings("unchecked")
//				Set<Method> securedMethods = ReflectionUtils.getAllMethods(clazz, ReflectionUtils.withAnnotation(Secured.class));
//				if (securedMethods.isEmpty()) {
//					return null;
//		        }
//
//				return securedMethods.stream()
//					.map(securedMethod -> {
//						RequestMapping methodRequestMapping = securedMethod.getAnnotation(RequestMapping.class);
//						if (methodRequestMapping == null) {
//							return null;
//						}
//
//						String[] value = methodRequestMapping.value();
//						if (value == null || value.length == 0) {
//							return null;
//						}
//
//						String methodPath = value[0];
//                        String path = ("/" + basePath + "/" + methodPath).replaceAll("//", "/");
//                        if (path.endsWith("/")) {
//                            path = path.substring(0, path.length() - 1);
//                        }
//                        log.info("Rest clazz: {}, secured method: {}, path: '{}'", clazz, securedMethod, path);
//						return path;
//					})
//					.filter(path -> !StringUtils.isBlank(path))
//					.collect(Collectors.toSet());
//			})
//			.filter(securedPath -> securedPath != null)
//			.flatMap(Set::stream)
//			.collect(Collectors.toSet());
//    }
}
