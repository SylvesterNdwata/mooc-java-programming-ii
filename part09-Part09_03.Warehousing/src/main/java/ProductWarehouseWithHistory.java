/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory productHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.productHistory = new ChangeHistory();
        this.productHistory.add(initialBalance);
    }
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);

        double balance = super.getBalance();

        this.productHistory.add(balance);
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        double amountAfter = super.takeFromWarehouse(amount);

        double balance = super.getBalance();

        this.productHistory.add(balance);

        return amountAfter;
    }

    public String history() {
        return this.productHistory.toString();
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName() + "\nHistory: "
                + this.productHistory.toString() + "\nLargest amount of product: "
                + this.productHistory.maxValue()
                + "\nSmallest amount of product: " + this.productHistory.minValue()
                + "\nAverage: " + this.productHistory.average());
    }
}
