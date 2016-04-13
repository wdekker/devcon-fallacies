package eu.luminis.devcon.fallacy;

import eu.luminis.devcon.fallacy.configuration.UiServicesConfiguration;
import eu.luminis.devcon.fallacy.offers.OffersResource;
import eu.luminis.devcon.fallacy.offers.SpecialOffersClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Starting point for the Ui Services.
 */
public class UiServices extends Application<UiServicesConfiguration> {

    public static void main(String[] args) throws Exception {
        new UiServices().run(args);
    }

    @Override
    public String getName() {
        return "Ui Services";
    }

    @Override
    public void initialize(Bootstrap<UiServicesConfiguration> bootstrap) {
//        bootstrap.addBundle(TenacityBundleBuilder.<RecommendationConfiguration>newBuilder().configurationFactory(new RecommendationTenacityBundleConfigurationFactory()).withCircuitBreakerHealthCheck().build());
    }

    @Override
    public void run(UiServicesConfiguration configuration, Environment environment) throws Exception {
        SpecialOffersClient specialOffersClient = buildSpecialOffersClient(configuration);
        environment.jersey().register(new OffersResource(specialOffersClient));
    }

    private SpecialOffersClient buildSpecialOffersClient(UiServicesConfiguration configuration) throws MalformedURLException {
        URL endpoint = new URL(configuration.getSpecialOffersConfiguration().getEndpoint());
        int connectionTimeout = configuration.getSpecialOffersConfiguration().getConnectTimeout();
        int readTimeout = configuration.getSpecialOffersConfiguration().getReadTimeout();
        return new SpecialOffersClient(endpoint, connectionTimeout, readTimeout);
    }
}
