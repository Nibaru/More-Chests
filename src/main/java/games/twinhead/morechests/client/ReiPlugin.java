package games.twinhead.morechests.client;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.screen.ExclusionZones;

import java.util.List;

public class ReiPlugin implements REIClientPlugin {

    public void registerExclusionZones(ExclusionZones zones) {
        zones.register(NetheriteChestScreen.class, screen -> {
            // screen is OurScreen
            // returns the list of rectangle
            return List.of(new Rectangle(((screen.width - screen.getBackgroundWidth()) / 2) - 24, (screen.height - screen.getBackgroundHeight()) / 2, screen.getBackgroundWidth()+ 46, screen.getBackgroundHeight()));
        });
    }
}
