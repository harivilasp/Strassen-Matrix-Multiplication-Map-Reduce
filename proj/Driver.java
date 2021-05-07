package proj;

public class Driver {

    public static void main(String[] args) throws Exception {
        
        Matmul mul = new Matmul();
        MatrixAddition madd=new MatrixAddition();
        MatrixSubtraction msub=new MatrixSubtraction();
        String A11="/data/A11.txt";
        String A12="/data/A12.txt";
        String A21="/data/A21.txt";
        String A22="/data/A22.txt";
        String B11="/data/B11.txt";
        String B12="/data/B12.txt";
        String B21="/data/B21.txt";
        String B22="/data/B22.txt";
        String p1="/data/p1";
        String p2="/data/p2";
        String p3="/data/p3";
        String p4="/data/p4";
        String p5="/data/p5";
        String p6="/data/p6";
        String p7="/data/p7";
        String c11="/data/c11";
        String c12="/data/c12";
        String c21="/data/21";
        String c22="/data/c22";
        

        // calculating p1
        madd.main(new String[] {A11,A22,"/data/t1p1"});
        madd.main(new String[] {B11,B22,"/data/t2p1"});
        mul.main(new String[] {"/data/t1p1","/data/t2p1",p1});
        
        // calculating p2
        madd.main(new String[]{A21,A22,"/data/t1p2.txt"});
        mul.main(new String[]{"/data/t1p2.txt",B11,p2});
        
        // calculating p3
        msub.main(new String[]{B12,B22,"/data/t1p3.txt"});
        mul.main(new String[]{A11,"/data/t1p3.txt",p3});
        
        // calculating p4
        msub.main(new String[]{B21,B11,"/data/t1p4.txt"});
        mul.main(new String[]{A22,"/data/t1p4.txt",p4});
        
        // calculating p5
        madd.main(new String[]{A11,A12,"/data/t1p5.txt"});
        mul.main(new String[]{"/data/t1p5.txt",B22,p5});
        
        // calculating p6
        msub.main(new String[]{A21,A11,"/data/t1p6.txt"});
        madd.main(new String[]{B11,B12,"/data/t2p6.txt"});
        mul.main(new String[]{"/data/t1p6.txt","/data/t2p6.txt",p6});
        
        // calculating p7
        msub.main(new String[]{A12,A22,"/data/t1p7.txt"});
        madd.main(new String[]{B21,B22,"/data/t2p7.txt"});
        mul.main(new String[]{"/data/t1p7.txt","/data/t2p7.txt",p7});
        
        // calculating c11
        madd.main(new String[]{p1,p7,"/data/t1c1.txt"});
        msub.main(new String[]{p4,p5,"/data/t2c1.txt"});
        madd.main(new String[]{"/data/t1c1.txt","/data/t2c1.txt",c11});
        
        // calculating c12
        madd.main(new String[]{p3,p5,c12});
        
        // calculating c21
        madd.main(new String[]{p2,p4,c21});
        
        // calculating c22
        madd.main(new String[]{p1,p3,"/data/t1c2.txt"});
        msub.main(new String[]{p6,p2,"/data/t2c2.txt"});
        madd.main(new String[]{"/data/t1c2.txt","/data/t2c2.txt",c22});
    }
}
