package org.matsim.analysis;

import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.Population;
import org.matsim.core.population.PopulationUtils;
import org.matsim.core.router.TripStructureUtils;

import java.util.List;

public class SimpleExperiencedPlansReader {
    static void main() {
        Population population = PopulationUtils.readPopulation("~/Downloads/output_experienced_plans.xml");

        double carTravelTime = 0;
        double carLegCounter = 0;
        for (Person person : population.getPersons().values()) {
            List<Activity> activities = TripStructureUtils.getActivities(person.getSelectedPlan(), TripStructureUtils.StageActivityHandling.StagesAsNormalActivities);
            List<Leg> legs = TripStructureUtils.getLegs(person.getSelectedPlan());
            System.out.println("Person " + person.getId() + " has " + activities.size() + " activities and " + legs.size() + " legs in their experienced plan.");

            for (Leg leg : legs){
                if(leg.getMode().equals("car")){
                    //works for primitive data types only, objects must use .equals()
                    carTravelTime += leg.getTravelTime().seconds();
                    carLegCounter++;
                }
            }
        }

        double sum = 0;
        for (Person person : population.getPersons().values()) {
            double score = person.getSelectedPlan().getScore();
            sum = sum + score;
        }
        double size = population.getPersons().size();
        double avgScore = sum/size;
        System.out.println("Average experienced Plan Score: "+ avgScore);
    }
}
