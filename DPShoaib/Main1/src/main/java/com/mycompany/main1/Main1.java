

package com.mycompany.main1;


 interface IProduct {
    String getName();
    boolean setPrice(double price);
}

class Phone implements IProduct {
    private double price;

    @Override
    public String getName() {
        return "Apple TouchPad";
    }

    @Override
    public boolean setPrice(double price) {
        this.price = price;
        return true;
    }
}

abstract class ProductAbstractFactory {
    protected abstract IProduct makeProduct();

    public IProduct getObject() {
        IProduct product = makeProduct(); 
        product.setPrice(20.30);
        return product;
    }
}

class PhoneConcreteFactory extends ProductAbstractFactory {
    @Override
    protected IProduct makeProduct() {
        return new Phone(); 
    }
}

public class Main1 {
    public static void main(String[] args) {
        PhoneConcreteFactory factory = new PhoneConcreteFactory();
        
        IProduct phone = factory.getObject();
        System.out.println(phone.getName());
    }
}

