public class Driver {

    public static void main(String[] args) throws Exception {
        
        Matmul mul = new Matmul();
        MatrixAddition madd=new MatrixAddition();
        MatrixSubtraction msub=new MatrixSubtraction();

        // calculating p1
        madd.main({"/data/A11.txt","/data/A22.txt","/data/t1p1.txt",});
        madd.main({"/data/B11.txt","/data/B22.txt","/data/t2p1.txt",});
        mul.main({"/data/t1p1.txt","/data/t2p1.txt","/data/p1.txt",});
        
        // calculating p2
        madd.main({"/data/A21.txt","/data/A22.txt","/data/t1p2.txt",});
        mul.main({"/data/t1p2.txt","/data/B11.txt","/data/p2.txt",});
        
        // calculating p3
        msub.main({"/data/B12.txt","/data/B22.txt","/data/t1p3.txt",});
        mul.main({"/data/A11.txt","/data/t1p3.txt","/data/p3.txt",});
        
        // calculating p4
        msub.main({"/data/B21.txt","/data/B11.txt","/data/t1p4.txt",});
        mul.main({"/data/A22.txt","/data/t1p4.txt","/data/p4.txt",});
        
        // calculating p5
        madd.main({"/data/A11.txt","/data/A12.txt","/data/t1p5.txt",});
        mul.main({"/data/t1p5.txt","/data/B22.txt","/data/p5.txt",});
        
        // calculating p6
        msub.main({"/data/A21.txt","/data/A11.txt","/data/t1p6.txt",});
        madd.main({"/data/B11.txt","/data/B12.txt","/data/t2p6.txt",});
        mul.main({"/data/t1p6.txt","/data/t2p6.txt","/data/p6.txt",});
        
        // calculating p7
        msub.main({"/data/A12.txt","/data/A11.txt","/data/t1p7.txt",});
        madd.main({"/data/B11.txt","/data/B22.txt","/data/t2p7.txt",});
        mul.main({"/data/t1p7.txt","/data/t2p7.txt","/data/p7.txt",});
        
        // calculating c11
        madd.main({"/data/p1.txt","/data/p7.txt","/data/t1c1.txt",});
        msub.main({"/data/p4.txt","/data/p5.txt","/data/t2c1.txt",});
        madd.main({"/data/t1c1.txt","/data/t2c2.txt","/data/c11.txt",});
        
        // calculating c12
        madd.main({"/data/p3.txt","/data/p5.txt","/data/c12.txt",});
        
        // calculating c21
        madd.main({"/data/p2.txt","/data/p4.txt","/data/c21.txt",});
        
        // calculating c22
        madd.main({"/data/p1.txt","/data/p3.txt","/data/t1c2.txt",});
        msub.main({"/data/p6.txt","/data/p2.txt","/data/t2c2.txt",});
        madd.main({"/data/t1c2.txt","/data/t2c2.txt","/data/c22.txt",});
        
    }
}
