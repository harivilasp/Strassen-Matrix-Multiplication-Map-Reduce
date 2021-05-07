package proj;

import java.io.*;
import java.util.*;

public class Strassen {

    public static void main(String[] args) throws Exception {
        
        int rows = 4;
	    int columns = 4;
		// reading matrix1
        Scanner sc = new Scanner(new File("m1.txt"));
	    int [][] a = new int[rows][columns];
	    while(sc.hasNextLine()) {
	       for (int i=0; i<a.length; i++) {
	          String[] line = sc.nextLine().trim().split(" ");
	          for (int j=0; j<line.length; j++) {
	             a[i][j] = Integer.parseInt(line[j]);
	          }
	       }
	    }
        //reading matrix2
        sc = new Scanner(new File("m2.txt"));
	    int [][] b = new int[rows][columns];
	    while(sc.hasNextLine()) {
	       for (int i=0; i<b.length; i++) {
	          String[] line = sc.nextLine().trim().split(" ");
	          for (int j=0; j<line.length; j++) {
	             b[i][j] = Integer.parseInt(line[j]);
	          }
	       }
	    }
	    int n=4;
		int [][] A11 = new int[n/2][n/2];
		int [][] A12 = new int[n/2][n/2];
		int [][] A21 = new int[n/2][n/2];
		int [][] A22 = new int[n/2][n/2];

		int [][] B11 = new int[n/2][n/2];
		int [][] B12 = new int[n/2][n/2];
		int [][] B21 = new int[n/2][n/2];
		int [][] B22 = new int[n/2][n/2];

		divide(a, A11, 0 , 0);
		divide(a, A12, 0 , n/2);
		divide(a, A21, n/2, 0);
		divide(a, A22, n/2, n/2);

		divide(b, B11, 0 , 0);
		divide(b, B12, 0 , n/2);
		divide(b, B21, n/2, 0);
		divide(b, B22, n/2, n/2);

        		//writing A11
		FileWriter myWriter = new FileWriter("A11.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+A11[i][j]+"\n");
			}
		}
		myWriter.close();
		//writing A12
		myWriter = new FileWriter("A12.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+A12[i][j]+"\n");
			}
		}
		//writing A21
		myWriter.close();
		myWriter = new FileWriter("A21.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+A21[i][j]+"\n");
			}
		}
		myWriter.close();
		//writing A22
		myWriter = new FileWriter("A22.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+A22[i][j]+"\n");
			}
		}
		myWriter.close();
		//writing B11
		myWriter = new FileWriter("B11.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+B11[i][j]+"\n");
			}
		}
		myWriter.close();
		//writing B12
		myWriter = new FileWriter("B12.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+B12[i][j]+"\n");
			}
		}
		myWriter.close();
		//writing B21
		myWriter = new FileWriter("B21.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+B21[i][j]+"\n");
			}
		}
		myWriter.close();
		//writing B22
		myWriter = new FileWriter("B22.txt");
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				myWriter.write(i+"\t"+j+"\t"+B22[i][j]+"\n");
			}
		}
		myWriter.close();
    }

    public static void divide(int[][] p1, int[][] c1, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
			{
				c1[i1][j1] = p1[i2][j2];
			}
	}
	
	public static int [][] add(int [][] A, int [][] B)
	{
		int n = A.length;

		int [][] result = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			result[i][j] = A[i][j] + B[i][j];

		return result;
	}

}
