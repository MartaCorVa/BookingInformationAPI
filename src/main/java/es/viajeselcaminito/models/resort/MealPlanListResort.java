package es.viajeselcaminito.models.resort;

import java.util.Arrays;

public class MealPlanListResort {

    private MealPlanResort[] regimenes;

    public MealPlanListResort(MealPlanResort[] regimenes) {
        this.regimenes = regimenes;
    }

    public MealPlanResort[] getRegimenes() {
        return regimenes;
    }

    public void setRegimenes(MealPlanResort[] regimenes) {
        this.regimenes = regimenes;
    }

    @Override
    public String toString() {
        return "\nMealPlanListResort{" +
                "regimenes=" + Arrays.toString(regimenes) +
                '}';
    }
}