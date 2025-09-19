package com.rays.car;

public class TestCar {
	public static void main(String[] args) throws Exception {
		String tableName = "car";
		new CreateTable("car");
		System.out.println("\n\n");
		new InsertTable(tableName, 1, "Tata", "Punch", 1000, "2024-09-11");
		new InsertTable(tableName, 2, "Tata", "Nexon", 1000, "2024-09-11");
		new InsertTable(tableName, 3, "Tata", "Neno", 100, "2024-09-11");
		new InsertTable(tableName, 4, "Tata", "Harrier", 1000, "2024-09-11");
		new InsertTable(tableName, 5, "Tata", "Altroz", 1000, "2024-09-11");
		System.out.println("\n\n");
		new ShowTable("car");
		System.out.println("\n\n");
		new UpdateTable(tableName, "price", "110", 3);
		System.out.println("\n\n");
		new ShowTable("car");
		System.out.println("\n\n");
		new Delete(tableName, 3);
		System.out.println("\n\n");
		new ShowTable("car");
		System.out.println("\n\n");
		new Delete(tableName);
	}
}
