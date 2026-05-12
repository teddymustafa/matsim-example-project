package org.matsim.analysis;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

public class SimpleEventHandlerExI {
    static void main() {
        EventsManager eventsManager = EventsUtils.createEventsManager();

        SimpleLeaveCounter handler = new SimpleLeaveCounter();
        eventsManager.addHandler(handler);

        SimpleActivityLocations locationHandler = new SimpleActivityLocations();
        eventsManager.addHandler(locationHandler);

        int countBefore = handler.getCounter();

        EventsUtils.readEvents(eventsManager, "output_events.xml.zst");


        int countAfter = handler.getCounter();

        System.out.println("Count before: " + countBefore);
        System.out.println("Count after:" + countAfter);

    }
}
