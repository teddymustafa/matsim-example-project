package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.network.Link;

public class SimpleLeaveCounter implements LinkLeaveEventHandler {
    private int counter = 0;

    @Override
    public void handleEvent(LinkLeaveEvent linkLeaveEvent) {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
