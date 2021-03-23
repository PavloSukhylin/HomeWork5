import java.util.Random;

public class FibonacciTest {
    public static void main(String[] args) {
        int[][] rotate_array = new int[10][10];
        int size = rotate_array.length;
        int temp = 0;
        Random random = new Random();

        for (int i = 0; i < 10; i++) {                     // заполняем матрицу случайными числами
            for (int j = 0; j < 10; j++) {
                rotate_array[i][j] = random.nextInt(2);
            }
        }
        System.out.println("Исходная матрица");            // выводим исходную матрицу
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < size ; j++) {
                System.out.print(rotate_array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Преобразованная матрица:");    // вывод преобразованной матрицы
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < size; j++) {            // во втором цикле  задаем j=i, иначе получим исходную матрицу
                temp = rotate_array[i][j];
                rotate_array[i][j] = rotate_array[j][i]; //индексы i,j меняем местами. переприсвоение
                rotate_array[j][i] = temp;               //через промежуточную переменную
            }
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < size ; j++) {
                System.out.print(rotate_array[i][j] + " ");
            }
            System.out.println();

        }

       // про Фибоначчи) метод определяет, принадлежит ли последовательность целых чисел к числам Фибоначчи
       // N-число Фибоначчи тогда и только тогда, когда выражение 5*х*х + 4 или 5*х*х - 4 -- идеальный квадрат
        int[] array = {89, 21,6765,233,10946};
        System.out.println("Массив для проверки на принадлежность к числам Фибоначчи:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println(areFibNumbers(array) ? "Последовательность принадлежит к числам Фибоначчи" : "Последовательность не принадлежит к числам Фибоначчи");
    }
    private static boolean areFibNumbers(int ... numbers){
     int lenght = numbers.length;
        for (int i = 0; i < lenght; i++) {
            int spos = 5*numbers[i]*numbers[i] + 4;  // вычисляем промежуточное значение формуле 5*х*х+4
            int sneg = 5*numbers[i]*numbers[i] - 4;  // вычисляем промежуточное значение формуле 5*х*х-4
            int spos_sqrt = (int)Math.sqrt(spos);    //
            int sneg_sqrt = (int)Math.sqrt(sneg);    // извлекаем корни
            if ((spos_sqrt*spos_sqrt != spos) && (sneg_sqrt*sneg_sqrt != sneg)){ //проверяем на непринадлежность
                return(false);                                            // к числам Ф. Выходим с false даже по одной цифре
            }
        } return(true);   // если в цикле не вывалилась, значит весь массив- числа Ф. Возвращаем true.

    }
    

}
