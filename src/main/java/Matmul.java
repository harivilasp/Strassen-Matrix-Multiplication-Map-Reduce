public class Matmul {

    public static void main(String[] args) throws Exception {
        CellMultiplication multiplication = new CellMultiplication();
        CellSum sum = new CellSum();

        // parse args
        String firstMatrixInputPath = args[0];
        String secondMatrixInputPath = args[1];
        String subSumOutputPath = args[1]+"temp"+args[2];
        String sumOutputPath = args[2];

        // run the first job
        String[] cellMultiplicationArgs = {firstMatrixInputPath, secondMatrixInputPath, subSumOutputPath};
        multiplication.main(cellMultiplicationArgs);

        // run the second job
        String[] cellSumArgs = {subSumOutputPath, sumOutputPath};
        sum.main(cellSumArgs);
    }
}
