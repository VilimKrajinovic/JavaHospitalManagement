/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.patient;

/**
 *
 * @author amd
 */
public class Lifestyle {

    /**
     * @return the idLifestyle
     */
    public int getIdLifestyle() {
        return idLifestyle;
    }

    /**
     * @param idLifestyle the idLifestyle to set
     */
    public void setIdLifestyle(int idLifestyle) {
        this.idLifestyle = idLifestyle;
    }

    /**
     * @return the isVegetarian
     */
    public boolean isIsVegetarian() {
        return isVegetarian;
    }

    /**
     * @param isVegetarian the isVegetarian to set
     */
    public void setIsVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    /**
     * @return the isSmoker
     */
    public boolean isIsSmoker() {
        return isSmoker;
    }

    /**
     * @param isSmoker the isSmoker to set
     */
    public void setIsSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    /**
     * @return the averageNoOfCigarettes
     */
    public int getAverageNoOfCigarettes() {
        return averageNoOfCigarettes;
    }

    /**
     * @param averageNoOfCigarettes the averageNoOfCigarettes to set
     */
    public void setAverageNoOfCigarettes(int averageNoOfCigarettes) {
        this.averageNoOfCigarettes = averageNoOfCigarettes;
    }

    /**
     * @return the isAlcoholic
     */
    public boolean isIsAlcoholic() {
        return isAlcoholic;
    }

    /**
     * @param isAlcoholic the isAlcoholic to set
     */
    public void setIsAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    /**
     * @return the averageNoOfDrinks
     */
    public int getAverageNoOfDrinks() {
        return averageNoOfDrinks;
    }

    /**
     * @param averageNoOfDrinks the averageNoOfDrinks to set
     */
    public void setAverageNoOfDrinks(int averageNoOfDrinks) {
        this.averageNoOfDrinks = averageNoOfDrinks;
    }

    /**
     * @return the useStimulants
     */
    public String getUseStimulants() {
        return useStimulants;
    }

    /**
     * @param useStimulants the useStimulants to set
     */
    public void setUseStimulants(String useStimulants) {
        this.useStimulants = useStimulants;
    }

    /**
     * @return the consumptionOfCoffeeAndTea
     */
    public int getConsumptionOfCoffeeAndTea() {
        return consumptionOfCoffeeAndTea;
    }

    /**
     * @param consumptionOfCoffeeAndTea the consumptionOfCoffeeAndTea to set
     */
    public void setConsumptionOfCoffeeAndTea(int consumptionOfCoffeeAndTea) {
        this.consumptionOfCoffeeAndTea = consumptionOfCoffeeAndTea;
    }

    /**
     * @return the consumptionOfSoftDrinks
     */
    public int getConsumptionOfSoftDrinks() {
        return consumptionOfSoftDrinks;
    }

    /**
     * @param consumptionOfSoftDrinks the consumptionOfSoftDrinks to set
     */
    public void setConsumptionOfSoftDrinks(int consumptionOfSoftDrinks) {
        this.consumptionOfSoftDrinks = consumptionOfSoftDrinks;
    }

    /**
     * @return the haveRegularMeals
     */
    public boolean isHaveRegularMeals() {
        return haveRegularMeals;
    }

    /**
     * @param haveRegularMeals the haveRegularMeals to set
     */
    public void setHaveRegularMeals(boolean haveRegularMeals) {
        this.haveRegularMeals = haveRegularMeals;
    }

    /**
     * @return the eatsHomeFood
     */
    public boolean isEatsHomeFood() {
        return eatsHomeFood;
    }

    /**
     * @param eatsHomeFood the eatsHomeFood to set
     */
    public void setEatsHomeFood(boolean eatsHomeFood) {
        this.eatsHomeFood = eatsHomeFood;
    }
    
    
    
    
    
    
    private int     idLifestyle;
    private boolean isVegetarian;
    private boolean isSmoker;
    private int     averageNoOfCigarettes;
    private boolean isAlcoholic;
    private int     averageNoOfDrinks;
    private String  useStimulants;
    private int     consumptionOfCoffeeAndTea;
    private int     consumptionOfSoftDrinks;
    private boolean haveRegularMeals;
    private boolean eatsHomeFood;
    
}
