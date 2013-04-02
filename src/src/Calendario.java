package src;

public class Calendario {

	//http://futbolymates.blogspot.com.es/2009/11/emparejamientos-y-calendario.html
	
	private int[] equipos;
	private String[][] jornadas;
	
	//Num de jornadas = (N-1)*2, con N = num equipos
	public Calendario(int N){
		equipos = new int[N];
		//Asigno posiciones del array a los equipos
		for (int i=0;i<N;i++){
			equipos[i] = i+1;
		}
		
		jornadas = new String[(N-1)*2][N/2];
		//1ª jornada -> jornada[0]
		int local = 0, visitante = N-1;
		for (int j=0;j<N/2;j++){
			jornadas[0][j] = equipos[local]+ "-" +equipos[visitante];
			local++;
			visitante--;
			System.out.println(jornadas[0][j]);
		}
		
		/*
		 Las jornadas pares de la primera vuelta se forman a partir de la jornada anterior
		   con estos cambios:
			El equipo que está el último de la primera columna (equipo comodín) se coloca en
		 el primer lugar de esa misma columna. El resto de los equipos de esa primera columna 
		 bajan un lugar. A continuación se intercambian las dos columnas de las que consta
		  la jornada.
		 */
		for(int i=2;i<N;i=i+2){
			 
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Calendario(8);
	}
	
}
