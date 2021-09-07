public class MatrixChainMultiplication
{
    public static int matrix(int[] arr)
    {
        int n = arr.length-1,i,j,k;
        int v,v2;
        int[][] mat = new int[n][n];
        for(k=0;k<n;k++)
        {
            i = 0;
            j = k;
            
            while(j<n && i<n)
            {
                if(i==j)
                {
                    break;
                }
                    
                else
                {
                     if(j-i==1)
                     {
                         mat[i][j] = arr[i]*arr[j]*arr[j+1];
                     }
                     else
                     {
                         v = mat[i][j-1] + arr[i]*arr[j]*arr[j+1];
                         v2 = mat[i+1][j] + arr[i]*arr[i+1]*arr[j+1];
                         mat[i][j] = Math.min(v,v2);
                     }
                }
                i++;
                j++;
            }
        }
        
        System.out.println("The table is ");
        String s = "";
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                s = mat[i][j]+"";
                if(s.length()==1)
                {
                    System.out.print(mat[i][j]+"   ");
                }
                else if(s.length()==2)
                {
                    System.out.print(mat[i][j]+"  ");
                }
                else
                {
                    System.out.print(mat[i][j]+" ");
                }
            }
            System.out.println();
        }
        
        return mat[0][n-1];
    }
    
    public static void main(String args[]) {
      
      int[] arr = {2,3,6,4,5};
      System.out.println(matrix(arr));
      
    }
}
