package clases;
import josx.platform.rcx.*;
import josx.robotics.TimingNavigator;
public class Impresion {
	
	int white=0;
	int black =0;
	int gray =0;
	int contador=0;
	Sensor sensor1 = Sensor.S1;
	Sensor sensor2 = Sensor.S3;
	
	
	
	public Impresion() throws InterruptedException{
	  Button.VIEW.addButtonListener(new ButtonListener() {
		
		@Override
		public void buttonReleased(Button b) {
			contador++;
			
		}
		
		@Override
		public void buttonPressed(Button b) {
			if(contador==0){
				white = sensor1.readValue();
			}else if(contador==1){
				black = sensor1.readValue();
			}else if(contador==2){
				gray = (white+black)/2;
			}else if(contador==3){
				
				
				/*Evento del sensor uno*/
			    sensor1.addSensorListener(new SensorListener() {
					
					@Override
					public void stateChanged(Sensor aSource, int aOldValue, int aNewValue) {
						TimingNavigator robot = new TimingNavigator(Motor.C, Motor.A, 1.6f, 0.54f);
						int error = aNewValue - gray;
				        LCD.showNumber(error);
						motorIzquierdo(error, robot);
					}
				});
			    
			    
			    /*Evento del sensor dos*/
			    sensor2.addSensorListener(new SensorListener() {
					
					@Override
					public void stateChanged(Sensor aSource, int aOldValue, int aNewValue) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
			}//Fin el if 
			
		}
	});
	  
	  
	  Button.RUN.waitForPressAndRelease();
	  
	}//Fin del método constructor
	
	/*Método pause del robot*/
	public void pause (int delay){
		try{
			Thread.sleep(delay);
		}catch (InterruptedException e) {
			
		}
	}//Fin del método pause
	
	
	public void motorIzquierdo(int error, TimingNavigator robot){
		if(error>3){
			Motor.A.setPower(3);
			Motor.C.setPower(3);
			robot.rotate(-25);
			pause(100);
			robot.travel(1);
		}else if(error>=1){
			Motor.A.setPower(2);
			Motor.C.setPower(2);
			robot.rotate(-7);
			pause(100);
			robot.travel(2);
		}else if(error>-1){
			Motor.A.setPower(2);
			Motor.C.setPower(2);
			robot.travel(3);
		}else if(error>=-3){
			Motor.A.setPower(2);
			Motor.C.setPower(2);
			robot.rotate(7);
			pause(100);
			robot.travel(2);
		}else{
			robot.stop();
			Motor.A.setPower(4);
			Motor.C.setPower(4);
			robot.travel(25);
		}
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
	      
	 new Impresion();     
	} //main()
	  
}
