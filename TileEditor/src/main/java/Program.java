package main.java;

public class Program {
	
	public static Window mainWindow = new Window();

	public static void main(String[] args) {		
		
		
		mainWindow.renderWindow();
		JsonIO.initJsonIO();

	}

}
