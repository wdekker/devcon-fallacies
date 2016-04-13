package eu.luminis.devcon.fallacy.configuration;

import com.google.common.collect.ImmutableMap;
import com.yammer.tenacity.core.bundle.BaseTenacityBundleConfigurationFactory;
import com.yammer.tenacity.core.config.TenacityConfiguration;
import com.yammer.tenacity.core.properties.TenacityPropertyKey;
import com.yammer.tenacity.core.properties.TenacityPropertyKeyFactory;

import java.util.Map;

/**
 * Created by willem on 16/03/16.
 */
public class UiServicesTenacityBundleConfigurationFactory extends BaseTenacityBundleConfigurationFactory<UiServicesConfiguration> {

    @Override
    public Map<TenacityPropertyKey, TenacityConfiguration> getTenacityConfigurations(UiServicesConfiguration configuration) {
        final ImmutableMap.Builder<TenacityPropertyKey, TenacityConfiguration> builder = ImmutableMap.builder();

//        builder.put(GetSpecialOffersCommand.RecommendationKey.RECOMMENDATION_KEY, configuration.getTenacityConfiguration());

        return builder.build();
    }

    @Override
    public TenacityPropertyKeyFactory getTenacityPropertyKeyFactory(UiServicesConfiguration applicationConfiguration) {
//        return value -> GetSpecialOffersCommand.RecommendationKey.RECOMMENDATION_KEY;
        return null;
    }
}
