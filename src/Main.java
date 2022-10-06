import java.util.Random;
import java.math.*;
public class Main {

    public static void bruteforce(BigInteger pass){
        BigInteger guess = BigInteger.valueOf(0);
        long start = System.currentTimeMillis();
        while(pass.compareTo(guess)>=0){
            if (pass.compareTo(guess)==0){
                System.out.print("Методом брутфорсу ключ було знайдено за "+(System.currentTimeMillis()-start)+" мілісекунд\n\n");
            return;
            }
            guess=guess.add(BigInteger.valueOf(1));
        }
        return;
    }
    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(2);
        //1 єтап-вивід кількості можливих ключів
        for (int i = 2;i<=4096;i=i*2){
            a = a.multiply(a);
            if (i>=8){
                System.out.print("Кількість ключів для " + i+" бітної послідовності: "+a+" ключів\n");
            }
        }
        //2,3 єтапи-генерація рандомного ключа заданої довжини та його брутфорс(велика кількість часу потрібна для брутфорсу навіть ключа довжиною 64 біта=неможливо буде чекати на відображення кількості можливих ключів з більшою довжиною)
        System.out.print("Генерація рандомного ключа заданої довжини\n");
        a = BigInteger.valueOf(2);
        for (int i = 2;i<=4096;i=i*2){
            a = a.multiply(a);
            if (i>=8){
                BigInteger RESULT =  new BigInteger(a.bitLength(), new Random());
                if (RESULT.compareTo(a) >= 0)
                    RESULT = RESULT.mod(a);
                String tohex = RESULT.toString(16);
                int nules_tocomp = tohex.length();
                System.out.print("Рандомний ключ довжиною "+i+" біт : 0x");
                while (nules_tocomp<(i/4)){
                    System.out.print("0");
                    nules_tocomp++;
                }
                System.out.print(tohex + "\n");
                bruteforce(RESULT);
            }
        }
    }
}