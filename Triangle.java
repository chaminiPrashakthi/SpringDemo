package org.springdemo;

import java.util.List;

public class Triangle {

	private List<Point> point; 


	public List<Point> getPoint() {
		return point;
	}


	public void setPoint(List<Point> point) {
		this.point = point;
	}


	public void draw() {
		System.out.println("Points of the triangle are :");
		for(Point points:point)
		{
			System.out.println(points.getX()+" , "+points.getY());
		}
	}
}
