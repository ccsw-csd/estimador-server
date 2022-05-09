package com.capgemini.ccsw.estimador.weightcalculator.model;

public class TaskDto {

    String name;

    String elementName;

    Double quantityVerySimple;

    Double quantitySimple;

    Double quantityMedium;

    Double quantityComplex;

    Double reusability;

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name new value of {@link #getname}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return elementName
     */
    public String getElementName() {
        return this.elementName;
    }

    /**
     * @param elementName new value of {@link #getelementName}.
     */
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    /**
     * @return quantityVerySimple
     */
    public Double getQuantityVerySimple() {
        return this.quantityVerySimple;
    }

    /**
     * @param quantityVerySimple new value of {@link #getquantityVerySimple}.
     */
    public void setQuantityVerySimple(Double quantityVerySimple) {
        this.quantityVerySimple = quantityVerySimple;
    }

    /**
     * @return quantitySimple
     */
    public Double getQuantitySimple() {
        return this.quantitySimple;
    }

    /**
     * @param quantitySimple new value of {@link #getquantitySimple}.
     */
    public void setQuantitySimple(Double quantitySimple) {
        this.quantitySimple = quantitySimple;
    }

    /**
     * @return quantityMedium
     */
    public Double getQuantityMedium() {
        return this.quantityMedium;
    }

    /**
     * @param quantityMedium new value of {@link #getquantityMedium}.
     */
    public void setQuantityMedium(Double quantityMedium) {
        this.quantityMedium = quantityMedium;
    }

    /**
     * @return quantityComplex
     */
    public Double getQuantityComplex() {
        return this.quantityComplex;
    }

    /**
     * @param quantityComplex new value of {@link #getquantityComplex}.
     */
    public void setQuantityComplex(Double quantityComplex) {
        this.quantityComplex = quantityComplex;
    }

    /**
     * @return reusability
     */
    public Double getReusability() {
        return this.reusability;
    }

    /**
     * @param reusability new value of {@link #getreusability}.
     */
    public void setReusability(Double reusability) {
        this.reusability = reusability;
    }

}
