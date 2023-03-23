import java.util.Arrays;

/**
 * Псевдокод
 * Данный псевдокод используется для описания алгоритмов.
 *
 * 1. Отступ от левого поля указывает на уровень вложенности.
 * 2. Циклы while, for, repeat и условные конструкции имеют тот же смысл, что и в pascal-е.
 * 3. Символ “--” обозначает комментарий
 * 4. Символ “:=” обозначает присваивание
 * 5. Переменные локальны в рамках процедуры, если не оговорено иначе
 * 6. Индекс массива пишется в квадратных скобках, конструкция A[i] означает i элемент в массиве A
 * 7. Возможно использование объектов, состоящих из нескольких полей, или имеющих несколько атрибутов, значения поля записывается как ИмяПоля[ИмяОбъекта].
 * К примеру, длина массива A записывается как Length[A]; что означают квадратные скобки - выясняется по контексту (переменная, обозначающая массив, или объект является указателем на составляющие его данные). После присвоения y:=x для любого поля f будет выполняться равенство f[y]=f[x]; определение того, что является атрибутом – функция, переменная или что-либо еще, - делается по контексту.
 * 8. Указатель может иметь специальное значение NIL, не указывающее ни на какой объект.
 * 9. Параметры передаются по значению: вызванная процедура получает собственную копию параметров, изменения параметров внутри процедуры снаружи не видно. При передаче объектов копируется указатель на данные, соответствующие этому объекту.
 *
 *
 *
 * Задача
 *
 * Функция сортирующая массив элементов A:
 * Sort(A,p,r)
 * 1 if p < r
 * 2    then q := round_half_down((p+r)/2)
 * 3         Sort(A,p,q)
 * 4         Sort(A,q+1,r)
 * 5         Merge(A,p,q,r)
 *
 * Пример массива:
 * A = (5,2,4,6,1,3,2,6)
 *
 * Примера запуска:
 * Sort(A,1,length[A])
 *
 *
 * Необходимо:
 * Разработать алгоритм функции Merge(A,p,q,r) на любом удобном вам языке, с использованием дополнительной памяти или без нее, как вам будет быстрее или удобнее в реализации.
 * Если у вас получится - с радостью ждем вас для прохождения дополнительного тестирования.
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] A = new int[] {5,2,4,6,4,3,2,6};
        sort(A, 0, A.length-1);
        System.out.println(Arrays.toString(A));
    }

    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r)/2;
            sort(A, p, q);
            sort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int begin, int middle, int end) {
        int firstSubArrayLength = middle - begin + 1;
        int secondSubArrayLength = end - middle;

        int[] firstSubArray = new int[firstSubArrayLength];
        int[] secondSubArray = new int[secondSubArrayLength];

        for (int i = 0; i < firstSubArrayLength; i++) {
            firstSubArray[i] = A[begin + i];
        }

        for (int i = 0; i < secondSubArrayLength; i++) {
            secondSubArray[i] = A[middle + i + 1];
        }

        int i = 0, j = 0, k = begin;

        while (i < firstSubArrayLength && j < secondSubArrayLength) {
            if (firstSubArray[i] <= secondSubArray[j]) {
                A[k++] = firstSubArray[i++];
            } else {
                A[k++] = secondSubArray[j++];
            }
        }

        while (i < firstSubArrayLength) {
            A[k++] = firstSubArray[i++];
        }

        while (j < secondSubArrayLength) {
            A[k++] = secondSubArray[j++];
        }
    }
}
