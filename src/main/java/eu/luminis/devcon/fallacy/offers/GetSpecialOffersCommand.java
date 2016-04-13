package eu.luminis.devcon.fallacy.offers;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey.Factory;

/**
 * Hystrix Command for executing call the Special Offers service.
 */
public class GetSpecialOffersCommand extends HystrixCommand<Offers> {

    private final SpecialOffersClient specialOffersClient;

    public GetSpecialOffersCommand(SpecialOffersClient specialOffersClient) {
        super(Factory.asKey("Special-Offers"));
        this.specialOffersClient = specialOffersClient;
    }

    @Override
    protected Offers run() throws Exception {
        return specialOffersClient.getOffers();
    }

    @Override
    protected Offers getFallback() {
        return Offers.EMPTY;
    }

}
