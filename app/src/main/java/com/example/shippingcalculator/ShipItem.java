package com.example.shippingcalculator;

public class ShipItem {

    //Constants for shipping item
    static final Double BASE = 3.00;
    static final Double ADDED = 0.50;
    static final int BASE_WEIGHT = 16;
    static final double EXTRA_OUNCES = 4.0;

    //Private data members
    private Integer mWeight;
    private Double mBaseCost;
    private Double mAddedCost;
    private Double mTotalCost;

    //Constructor
    public ShipItem()
    {
        //Init all members to zero besides base cost assignment to base constant
        mWeight = 0;
        mAddedCost = 0.0;
        mBaseCost = BASE;
        mTotalCost = 0.0;
    }

    //Public weight setter
    public void setWeight(int weight)
    {
        mWeight = weight;
        computeCosts();
    }

    //Calculator for costs
    public void computeCosts()
    {
        mAddedCost = 0.0;
        mBaseCost = BASE;

        if (mWeight <= 0)
            mBaseCost = 0.0;
        else if (mWeight > BASE_WEIGHT)
            //Cast to double and find ceiling
            mAddedCost = Math.ceil((double)(mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;

        //Total is the sum of base and added
        mTotalCost = mBaseCost + mAddedCost;
    }

    //Public getters
    public Double getBaseCost()
    {
        return mBaseCost;
    }

    public Double getAddedCost()
    {
        return mAddedCost;
    }

    public Double getTotalCost()
    {
        return mTotalCost;
    }
}