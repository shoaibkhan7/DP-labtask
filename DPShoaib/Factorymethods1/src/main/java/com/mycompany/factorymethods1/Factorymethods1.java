

package com.mycompany.factorymethods1;

import java.util.ArrayList;

public class Factorymethods1 {

    public static void main(String[] args) {
        ArrayList<Shapes> shapes = new ArrayList<>();
        
        // Add shapes to the list using a single factory method
        shapes.add(createShape("triangle"));
        shapes.add(createShape("circle"));
        shapes.add(createShape("square"));
        
        // Draw all shapes
        for(Shapes s : shapes)
            s.draw();
    }
    
     static Shapes createShape(String type) {
        switch(type.toLowerCase()) {
            case "triangle" -> {
                return new Triangle();
            }
            case "circle" -> {
                return new Circle();
            }
            case "square" -> {
                return new Square();
            }
            default -> throw new IllegalArgumentException("Invalid shape type");
        }
    }
}

interface Shapes {
    void draw();
}

class Triangle implements Shapes {
    @Override
    public void draw() {
        System.out.println("Triangle is drawn");
    }
}

class Circle implements Shapes {
    @Override
    public void draw() {
        System.out.println("Circle is drawn");
    }
}

class Square implements Shapes {
    @Override
    public void draw() {
        System.out.println("Square is drawn");
    }
}

