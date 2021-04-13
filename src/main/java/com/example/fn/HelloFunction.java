package com.example.fn;

import java.util.function.Function;
import com.fnproject.fn.api.FnFeature;
import com.fnproject.springframework.function.SpringCloudFunctionFeature;
import org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ContextFunctionCatalogAutoConfiguration.class)
@FnFeature(SpringCloudFunctionFeature.class)
public class HelloFunction {
    /*
    @FnConfiguration
    public static void configure(RuntimeContext ctx) {
        ctx.addInvoker(new SpringCloudFunctionInvoker(HelloFunction.class), Phase.Call);
        //ctx.setInvoker(new SpringCloudFunctionInvoker(HelloFunction.class));
    }*/

    // Unused - see https://github.com/fnproject/fdk-java/issues/113
    public void handleRequest() { }
    
    @Bean
    public Function<String, String> function(){
        return value -> "Hello, " + ((value == null || value.isEmpty()) ? "world"  : value ) + "!";
    }

}