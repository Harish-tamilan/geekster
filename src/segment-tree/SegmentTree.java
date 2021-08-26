public class SegmentTree {
    
    public static int func(int[] arr, int[] store, int l, int r, int pos)
    {
        if(l==r)
        {
            store[pos] = arr[l];
            return store[pos];
        }
        int m = (l+r)/2;
        store[pos] = Math.min(func(arr, store, l, m, 2*pos+1), func(arr, store, m+1, r, 2*pos+2));
        return store[pos];
    }
    
    public static int lowest(int[] store, int ql, int qr, int l, int r, int pos)
    {
        if(l>qr || r<ql)
        {
            return Integer.MAX_VALUE;
        }
        else if(l>=ql && r<=qr)
        {
            return store[pos];
        }
        else
        {
            int mid = (l+r)/2;
            return Math.min(lowest(store, ql, qr, l, mid, 2*pos+1), lowest(store, ql, qr, mid+1, r, 2*pos+2));
        }
    }
    
    public static int lowest(int[] arr, int l, int r)
    {
        int size, n = arr.length, i=1;
        
        while(n>Math.pow(2,i))
        {
            i++;
        }
        size = (int)Math.pow(2,i);
        size = (2*size-1);
        System.out.println("Size is "+ size);
        int[] store = new int[size];
        func(arr, store, 0, n-1, 0);
        for(int no:store)
            System.out.print(no+" ");
            
        return lowest(store, l, r, 0, n-1, 0);
        
    }
    
    public static void main(String args[]) {
      int[] arr = {-1,2,4,0};
      System.out.println("\n"+lowest(arr,2,2));
    }
}
