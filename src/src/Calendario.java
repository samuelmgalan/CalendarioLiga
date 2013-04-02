package src;

public class Calendario {

	//Algoritmo: http://www.delphiaccess.com/forum/c-c-49/fixture-todos-contra-todos-en-c/
	
	private int[] equipos;
	private String[][] matriz1,matriz2,jornadas,jornadas2;
	
	//Num de jornadas = (N-1)*2, con N = num equipos. (N-1) es una vuelta.
	
	/**
	 * @param N -> numero de equipos
	 */
	public Calendario(int N){
		equipos = new int[N];
		//Asigno posiciones del array a los equipos
		for (int i=0;i<N;i++){
			equipos[i] = i+1;
		}
		
		matriz1 = new String[N-1][N/2];
		matriz2 = new String[N-1][N/2];
		jornadas = new String[N-1][N/2]; //primera vuelta
		jornadas2 = new String[N-1][N/2]; //segunda vuelta
		
		//Relleno las matrices
		/*   Matriz 1    	 Matriz 2			 
			1   2   3		6   5   4
			4   5   1		6   3   2
			2   3   4		6   1   5
			5   1   2		6   4   3
			3   4   5		6   2   1
			
			Resultado:
			
			J1	6vs1	2vs5	3vs4
			J2	4vs6	5vs3	1vs2
			J3	6vs2	3vs1	4vs5
			J4	5vs6	1vs4	2vs3
			J5	6vs3	4vs2	5vs1
		 */
		
		int cont = 0;
		int cont2 = N-2;
		
		for(int i=0;i<N-1;i++){
			for(int j=0;j<N/2;j++){
				//matriz1
				matriz1[i][j] = String.valueOf(equipos[cont]);
				cont++;
				if(cont==(N-1)) cont=0;
				
				//matriz2
				if(j==0) matriz2[i][j] = String.valueOf(N);
				else {
					matriz2[i][j] = String.valueOf(equipos[cont2]);
					cont2--;
					if(cont2==-1) cont2 = N-2;
				}
				
				//Elaboro la matriz final de enfrentamientos por jornada (primera vuelta)
				if(j==0){
					if(i%2==0) jornadas[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
					else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
				}
				else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
				
				
				//segunda vuelta - al reves que la primera
				if(j==0){
					if(i%2==0) jornadas2[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
					else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
				}
				else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
				
			}
		}
		
		//Solo para mostrarlo por consola

		int jorn = 1;
		for(int i=0;i<N-1;i++){
			for(int j=0;j<N/2;j++){
				System.out.print("J"+jorn+" "+jornadas[i][j]); 
				if(j==(N/2)-1) System.out.println();
			}
			jorn++;
		}
		
		System.out.println();
		jorn = N;
		for(int i=0;i<N-1;i++){
			for(int j=0;j<N/2;j++){
				System.out.print("J"+jorn+" "+jornadas2[i][j]);
				if(j==(N/2)-1) System.out.println();
			}
			jorn++;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Calendario(8);
	}
	
}
