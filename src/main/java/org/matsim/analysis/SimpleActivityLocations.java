package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.ActivityEndEvent;
import org.matsim.api.core.v01.events.handler.ActivityEndEventHandler;
import org.matsim.api.core.v01.population.Person;

public class SimpleActivityLocations implements ActivityEndEventHandler {
    private Id<Person> referencePerson = Id.createPersonId("1");

    @Override
    public void handleEvent(ActivityEndEvent activityEndEvent) {
        if(activityEndEvent.getPersonId().equals(referencePerson)){

        System.out.println(activityEndEvent.getPersonId());
        System.out.println(activityEndEvent.getFacilityId());
        System.out.println(activityEndEvent.getCoord());
        }
    }
}
