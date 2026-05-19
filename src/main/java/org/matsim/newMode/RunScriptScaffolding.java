package org.matsim.newMode;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.groups.ReplanningConfigGroup;
import org.matsim.core.config.groups.RoutingConfigGroup;
import org.matsim.core.controler.Controller;
import org.matsim.core.controler.ControllerUtils;
import org.matsim.core.scenario.ScenarioUtils;

public class RunScriptScaffolding {
    static void main() {
        Config config = ConfigUtils.loadConfig( "scenarios/equil/config-2026.xml" );

        /*
        * your config changes here
        * things to do
        * add a new replanning strategy SubtourModeChoice (module and strategy) (enable choice)
        * add teleportation parameters for bike
        * */

        ReplanningConfigGroup.StrategySettings SubtourModeChoice = new ReplanningConfigGroup.StrategySettings().setStrategyName("SubtourModeChoice").setWeight(0.1);
        config.replanning().addStrategySettings(SubtourModeChoice);

        config.subtourModeChoice().setModes(new String[]{"car", "bike"});

        // routing parameteers
        RoutingConfigGroup.TeleportedModeParams bikeParams = new RoutingConfigGroup.TeleportedModeParams("bike");
        bikeParams.setBeelineDistanceFactor(1.4);
        bikeParams.setTeleportedModeSpeed(3.04);
        config.routing().addTeleportedModeParams(bikeParams);

        RoutingConfigGroup.TeleportedModeParams walkParams = new RoutingConfigGroup.TeleportedModeParams("bike");
        walkParams.setBeelineDistanceFactor(1.4);
        walkParams.setTeleportedModeSpeed(1.04);
        config.routing().addTeleportedModeParams(walkParams);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        Controller controller = ControllerUtils.createController(scenario);

        controller.run();
    }
}
