
import java.util.Scanner;
import java.math.BigInteger;
public  class Main {
    private static final BigInteger MOD = new BigInteger("1000000007");

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       BigInteger a = sc.nextBigInteger();
        BigInteger one = BigInteger.ONE; // 创建一个表示1的BigInteger对象
        a = a.add(one);
       System.out.println(fbnq(a));
    }
    /*创造乘法矩阵实现2*2的矩阵相乘的结果
      也就是说已经实现了矩阵快速幂运算，将快速运算的结果传递至a
      将矩阵f1f2传输到b
      然后三重运算回复结果
     */
     private static BigInteger [][] ejzxc(BigInteger[][] a, BigInteger[][] b)
      {
          BigInteger [][] res = new BigInteger[2][2];
          //盛放结果的矩阵
          for(int i = 0 ; i < 2; i++) {
              for (int j = 0; j < 2; j++) {
                  res[i][j] = BigInteger.ZERO;

                  for (int k = 0; k < 2; k++) {
                      res[i][j] = res[i][j].add(a[i][k].multiply(b[k][j]));
                  }
              }

          }
          return res;
      }
    /*
    创建快速幂运算的函数

     */
    private static BigInteger [][] ksm(BigInteger[][] max, BigInteger n)
    {
        BigInteger [][] res = new BigInteger[][]{

                {BigInteger.ONE, BigInteger.ZERO},
                {BigInteger.ZERO, BigInteger.ONE},
        };
        //初始化结果矩阵
        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)){
                res = ejzxc(res, max);
            }
            max = ejzxc(max, max);
           n= n.shiftRight(1);
        }
        return res;
    }
//斐波那契数列计算
public static BigInteger fbnq(BigInteger n)
{
    if(n.compareTo(BigInteger.ZERO) <= 0)
    {
        return BigInteger.ZERO;
    }
  BigInteger [][] fbnq = new BigInteger[][]{
          {BigInteger.ONE, BigInteger.ONE},
          {BigInteger.ONE, BigInteger.ZERO},
  };
    BigInteger [][] t = ksm(fbnq,n.subtract(BigInteger.ONE));
  return t[0][0].mod(MOD);
}
}














