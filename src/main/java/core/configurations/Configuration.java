package core.configurations;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configurations.properties"
})
public interface Configuration extends Config {

    @Key("browser")
    String getBrowser();

    @Key("url.base")
    String getUrl();

    @Key("api.url.base")
    String getApiURL();
}