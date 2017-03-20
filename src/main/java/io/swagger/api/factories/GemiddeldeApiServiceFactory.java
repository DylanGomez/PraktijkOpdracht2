package io.swagger.api.factories;

import io.swagger.api.GemiddeldeApiService;
import io.swagger.api.impl.GemiddeldeApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-16T10:05:48.620Z")
public class GemiddeldeApiServiceFactory {
    private final static GemiddeldeApiService service = new GemiddeldeApiServiceImpl();

    public static GemiddeldeApiService getGemiddeldeApi() {
        return service;
    }
}
