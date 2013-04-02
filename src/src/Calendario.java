package src;

public class Calendario {

	//Algoritmo: http://www.delphiaccess.com/forum/c-c-49/fixture-todos-contra-todos-en-c/
	
	private int[] equipos;
	private String[][] matriz1,matriz2;
	
	//Num de jornadas = (N-1)*2, con N = num equipos. (N-1) es una vuelta.
	public Calendario(int N){
		equipos = new int[N];
		//Asigno posiciones del array a los equipos
		for (int i=0;i<N;i++){
			equipos[i] = i+1;
		}
		
		matriz1 = new String[N-1][N/2];
		matriz2 = new String[N-1][N/2];
		//Relleno las matrices
		/*   Matriz 1    	 Matriz 2			 
			1   2   3		6   5   4
			4   5   1		6   3   2
			2   3   4		6   1   5
			5   1   2		6   4   3
			3   4   5		6   2   1
		 */
		int cont = 0;
		//matriz1
		for(int i=0;i<N-1;i++){
			for(int j=0;j<N/2;j++){
				matriz1[i][j] = String.valueOf(equipos[cont]);
				cont++;
				if(cont==5) cont=0;
				System.out.print(matriz1[i][j]);
			}
		}
		//matriz2
		for(int i=0;i<N-1;i++){
			for(int j=0;j<N/2;j++){
				
			}
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Calendario(6);
	}
	
}
