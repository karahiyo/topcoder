class Test {
    public static void main(String[] args) {
        int[] as = {0, 1, 2};

        int i = 2;
        int j = 3;
        while(as[i-1] >= as[--j]);
        System.out.println(i + ", " + j);

        for(i=0; i<as.length; i++)
            System.out.println(as[i]);
        
    }
}
