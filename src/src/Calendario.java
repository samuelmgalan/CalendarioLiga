package src;

public class Calendario {

	//Algoritmo: http://www.delphiaccess.com/forum/c-c-49/fixture-todos-contra-todos-en-c/
	
	private int[] equipos;
	private String[][] matriz1,matriz2,jornadas;
	
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
				if(cont==(N-1)) cont=0;
			}
		}
		
		//matriz2
		cont = N-2;
		for(int i=0;i<N-1;i++){
			for(int j=0;j<N/2;j++){
				if(j==0) matriz2[i][j] = String.valueOf(N);
				else {
					matriz2[i][j] = String.valueOf(equipos[cont]);
					cont--;
					if(cont==-1) cont = N-2;
				}
			}
		}
		
		
		//Elaboro la matriz final de enfrentamientos por jornada
		/*  J1	1vs6	2vs5	3vs4
			J2	4vs6	5vs3	1vs2
			J3	2vs6	3vs1	4vs5
			J4	5vs6	1vs4	2vs3
			J5	3vs6	4vs2	5vs1
		 */
		jornadas = new String[N-1][N/2];
		for(int i=0;i<N-1;i++){
			for(int j=0;j<N/2;j++){
				if(j==0){
					if(i%2==0) jornadas[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
					else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
				}
				else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
				System.out.print(jornadas[i][j]);
				if(j==(N/2)-1) System.out.println();
			}
		}
		/**
		 *  6-1 2-5 3-4 
			4-6 5-3 1-2 
			6-2 3-1 4-5 
			5-6 1-4 2-3 
			6-3 4-2 5-1 
		 */
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Calendario(8);
	}
	
}
