package com.mycompany.factorymethods;

import java.util.ArrayList;

public class Factorymethods {

    public static void main(String[] args) {
        ArrayList<shapes> shapes = new ArrayList<>();
        Geometry triangleGeometry = new TriangleGeometry();
        Geometry circleGeometry = new CircleGeometry();
        Geometry squareGeometry = new SquareGeometry();
        
        shapes.add(triangleGeometry.createShape());
        shapes.add(circleGeometry.createShape());
        shapes.add(squareGeometry.createShape());
        
        for(shapes s : shapes)
            s.draw();
    }
}

interface shapes {
    void draw();
}

class Triangle implements shapes {
    @Override
    public void draw() {
        System.out.println("Triangle is drawn");
    }
}

class Circle implements shapes {
    @Override
    public void draw() {
        System.out.println("Circle is drawn");
    }
}

class Square implements shapes {
    @Override
    public void draw() {
        System.out.println("Square is drawn");
    }
}

abstract class Geometry {
    public abstract shapes createShape();
}

class TriangleGeometry extends Geometry {
    @Override
    public shapes createShape() {
        return new Triangle();
    }
}

class CircleGeometry extends Geometry {
    @Override
    public shapes createShape() {
        return new Circle();
    }
}

class SquareGeometry extends Geometry {
    @Override
    public shapes createShape() {
        return new Square();
    }
}

