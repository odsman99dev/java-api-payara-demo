package fish.payara.micro.sample;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.info.Info;

@ApplicationPath("v1")
@org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition(info = @Info(title = "Mi App", version = "1.0"))
public class ApplicationV1 extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();

        // Registrar el filtro CORS
        resources.add(CorsFilter.class);

        // Agregar tus recursos REST
        this.adminResources(resources);

        return resources;
    }

    private void adminResources(Set<Class<?>> resources) {
        resources.add(fish.payara.micro.sample.rest.SampleRest.class);
    }
}
