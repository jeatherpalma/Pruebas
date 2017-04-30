package clases;



public class RobotWithForeward {
	
	
	public RobotWithForeward(){
		String cardinalidad = "Norte";
		String [] movimientos ={"Arriba","Izquierda","Derecha","Abajo"};
		int contadorMovimientos =0;
		String movimientoReales [] = new String [movimientos.length];
		
		for (int i = 0; i < movimientoReales.length; i++) {
			if(cardinalidad.equals("Norte")){
				if(movimientos[contadorMovimientos].equals("Izquierda")){
					cardinalidad = "Oeste";
					
					/*Hacer movimiento izquierda*/
					movimientoReales[i] = "izquierda";
					
				}else if(movimientos[contadorMovimientos].equals("derecha")){
					cardinalidad = "Este";
					
					/*Hacer movimiento derecha*/
					movimientoReales[i] = "derecha";
					
				}else if(movimientos[contadorMovimientos].equals("arriba")){
					
					/*Hacer movimiento arriba*/
					movimientoReales[i] = "arriba";
					
				}else if(movimientos[contadorMovimientos].equals("abajo")){
					cardinalidad = "Sur";
					/*Hacer movimiento abajo*/
					
					movimientoReales[i] = "abajo";
				}
			}else if(cardinalidad.equals("Este")){
				
				if(movimientos[contadorMovimientos].equals("arriba")){
					cardinalidad = "Norte";
					/*Hacer movimiento izquierda*/
					movimientoReales[i] = "izquierda";
					
				}else if(movimientos[contadorMovimientos].equals("abajo")){
					cardinalidad = "Sur";
					/*Hacer movimiento derecha*/
					movimientoReales[i] = "derecha";
					
				}else if(movimientos[contadorMovimientos].equals("Izquierda")){
					cardinalidad = "Oeste";
					
					/*Hacer movimiento abajo*/
					
					movimientoReales[i] = "abajo";
				}else if(movimientos[contadorMovimientos].equals("derecha")){
					
					/*Hacer movimiento arriba*/
					
					movimientoReales[i] = "arriba";
				}
			}else if(cardinalidad.equals("Oeste")){
				
				if(movimientos[contadorMovimientos].equals("arriba")){
					cardinalidad = "Norte";
					/*Hacer movimiento derecha*/
					movimientoReales[i] = "derecha";
					
				}else if(movimientos[contadorMovimientos].equals("abajo")){
					cardinalidad = "Sur";
					/*Hacer movimiento izquierda*/
					movimientoReales[i] = "izquierda";
					
				}else if(movimientos[contadorMovimientos].equals("Izquierda")){
					
					/*Hacer movimiento arriba*/
					movimientoReales[i] = "arriba";
					
				}else if(movimientos[contadorMovimientos].equals("derecha")){
					cardinalidad = "Este";
					/*Hacer movimiento abajo*/
					movimientoReales[i] = "abajo";
					
				}
		  }else if(cardinalidad.equals("Sur")){
				
				if(movimientos[contadorMovimientos].equals("arriba")){
					cardinalidad = "Norte";
					/*Hacer movimiento abajo*/
					movimientoReales[i] = "abajo";
					
				}else if(movimientos[contadorMovimientos].equals("abajo")){
					
					/*Hacer movimiento arriba*/
					
					movimientoReales[i] = "arriba";
				}else if(movimientos[contadorMovimientos].equals("Izquierda")){
					cardinalidad = "Oeste";
					/*Hacer movimiento derecha*/
					movimientoReales[i] = "derecha";
					
				}else if(movimientos[contadorMovimientos].equals("derecha")){
					cardinalidad = "Este";
					/*Hacer movimiento izquierda*/
					movimientoReales[i] = "izquierda";
					
				}
		  }
		}
	}
	
	public static void main(String[] args) {
		new RobotWithForeward();
	}
}
