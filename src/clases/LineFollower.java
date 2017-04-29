package clases;


import josx.platform.rcx.*;
import josx.robotics.TimingNavigator;
public class LineFollower {
	
	int white=0;
	int black =0;
	int gray =0;
	int contador=0,contadorMovimientos=0;
	Sensor sensor1 = Sensor.S1;
	Sensor sensor2 = Sensor.S3;
	boolean sensor1Bandera = true, sensor2Bandera = true;
	String movimientos [] ={"Izquierda","Derecha","Abajo"};
	
	public LineFollower() throws InterruptedException{
	
	sensor1.setTypeAndMode(3, 0X80);
	sensor2.setTypeAndMode(3, 0X80);
	sensor1.activate();
	sensor2.activate();
	  Button.VIEW.addButtonListener(new ButtonListener() {
		
		@Override
		public void buttonReleased(Button b) {
			contador++;
			
		}
		
		@Override
		public void buttonPressed(Button b) {
			if(contador==0){
				white = sensor1.readValue();
				LCD.showNumber(white);
			}else if(contador==1){
				black = sensor1.readValue();
				LCD.showNumber(black);
			}else if(contador==2){
				gray = (white+black)/2;
				LCD.showNumber(gray);
			}else if(contador==3){
				
				
				/*Evento del sensor uno*/
			    sensor1.addSensorListener(new SensorListener() {
					
					@Override
					public void stateChanged(Sensor aSource, int aOldValue, int aNewValue) {
						try{
							
						
						TimingNavigator robot = new TimingNavigator(Motor.C, Motor.A, 5.0f, 2.2f);
						int error = aNewValue - gray;
				        LCD.showNumber(error);
				        if(error<0 && (sensor2.readValue()-gray)<0){
				        	
				        	sensor2Bandera = false;
					        sensor1Bandera = false;
				        	/*String orden = movimientos[contadorMovimientos];
				        	contadorMovimientos++;
				        	if(orden.equals("Izquierda")){
				        		izquierda(robot);
				        	}else if(orden.equals("Derecha")){
				        		derecha(robot);
				        	}else if(orden.equals("Abajo")){
				        		abajo(robot);
				        	}*/
					        arriba(robot);
				        	
				        }else
				        if(sensor1Bandera){
				        	motorIzquierdo(error, robot);	
				        }
						
						
					}catch (Exception e) {
						
					}
					
				}});
			    
			    
			    /*Evento del sensor dos*/
			    sensor2.addSensorListener(new SensorListener() {
					
					@Override
					public void stateChanged(Sensor aSource, int aOldValue, int aNewValue) {
						try{
						TimingNavigator robot = new TimingNavigator(Motor.C, Motor.A, 1.6f, 0.54f);
						int error = aNewValue - gray;
				        LCD.showNumber(error);
				       /*if(error<0 && (sensor1.readValue()-gray)<0){
				    	   
				        	sensor2Bandera = false;
					        sensor1Bandera = false;
				        	cruzeDerecho(robot);
				        }else*/
				        if(sensor2Bandera){
							motorDerecho(error, robot);

				        }
						
					}catch (Exception e) {
						// TODO: handle exception
					}//
				}//Fin clase stateChange
				});
			    
			    
				
				
			}//clase addSensorListener
			
				
			
		}
		
	});
	  
	  
	  Button.RUN.waitForPressAndRelease();
	  
	}//Fin del método constructor
	
	
	
	
	public void motorIzquierdo(int error, TimingNavigator robot){
		if(error>2){
			Motor.A.setPower(3);
			Motor.C.setPower(3);
			robot.rotate(-15);
			pause(15);
			robot.travel(2);
		}else if(error>-2){
			Motor.A.setPower(3);
			Motor.C.setPower(3);
			robot.rotate(-2);
			pause(15);
			robot.travel(3);
		}else{
			robot.stop();
			Motor.A.setPower(5);
			Motor.C.setPower(5);
			robot.rotate(15);
		}
		sensor2Bandera = true;
	}
	
	public void motorDerecho(int error, TimingNavigator robot){
		if(error>2){
			Motor.A.setPower(4);
			Motor.C.setPower(4);
			robot.rotate(15);
			pause(15);
			robot.travel(2);
		}else if(error>-2){
			Motor.A.setPower(4);
			Motor.C.setPower(4);
			robot.rotate(2);
			pause(15);
			robot.travel(3);
		}else{
			robot.stop();
			Motor.A.setPower(5);
			Motor.C.setPower(5);
			robot.rotate(-15);
		}
		sensor1Bandera = true;
	}
	
	
	/****Zona de movmientos********/
	//Derecha
	public void derecha(TimingNavigator robot){
		sensor1Bandera = false;
		Motor.A.setPower(7);
    	Motor.C.setPower(7);
    	robot.travel(7);
    	robot.stop();
    	robot.rotate(-160);
    	pause(15);
    	sensor2Bandera =true;
    	sensor1Bandera =true;
    	
	}
	//Izquierda
	public void izquierda(TimingNavigator robot){
		sensor1Bandera = false;
		Motor.A.setPower(7);
    	Motor.B.setPower(7);
    	robot.travel(7);
    	robot.stop();
    	robot.rotate(160);
    	pause(15);
    	sensor2Bandera =true;
    	sensor1Bandera =true;
	}
	//Abajo
	public void abajo(TimingNavigator robot){
		sensor1Bandera = false;
		Motor.A.setPower(6);
		Motor.B.setPower(6);
		robot.travel(-3);
		robot.stop();
		robot.rotate(270);
		pause(15);
		sensor2Bandera =true;
    	sensor1Bandera =true;
	}
	//Arriba
	public void arriba(TimingNavigator robot){
		sensor1Bandera = false;
		Motor.A.setPower(6);
		Motor.B.setPower(6);
		robot.travel(4);
		pause(15);
		sensor1Bandera = true;
		sensor2Bandera = true;
	}
	
	/*Método pause del robot*/
	public void pause (int delay){
		try{
			Thread.sleep(delay);
		}catch (InterruptedException e) {
			
		}
	}//Fin del método pause 
	
	//Método main
	public static void main(String[] args) throws InterruptedException {
	      
	 new LineFollower();     
	} //main()
	  
}
