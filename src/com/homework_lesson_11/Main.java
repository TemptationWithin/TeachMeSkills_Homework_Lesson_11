package com.homework_lesson_11;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Создать коллекцию аррэй лист, наполнить ее элементами типа Интреджер.
 * Сделать с помощью стрима задания:
 * - удалить дубликаты
 * - вывести все четные элементы в определенном диапазоне(например, в диапазоне от 10 до 100)
 * - каждый элемент умножить на 2
 * - отсортировать и вывести на экран первых 4 элемента
 * - вывести количество элементов в стриме
 * - вывести среднее арифметическое всех чисел в стриме
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(-100);
        list.add(-80);
        list.add(150);
        list.add(1590);
        list.add(1590);
        list.add(15);
        list.add(65);
        list.add(88);
        list.add(88);
        list.add(88);
        list.add(139);
        list.add(1);
        list.add(19);
        list.add(59);
        list.add(580);


        // * - удалить дубликаты
        System.out.println(" Список без дубликатов: ");

        Stream<Integer> testStream = list.stream();
        Set<Integer> set = testStream.collect(Collectors.toSet());

        list.removeAll(list);

        set.forEach((a) -> {
                            list.add(a);
                            System.out.println(a);
                            });


        //* - вывести все четные элементы в определенном диапазоне(например, в диапазоне от 10 до 100)
        System.out.println("  ");
        System.out.println(" Четные элементы в пределах от 10 до 100: ");
        Stream<Integer> testStream_2 = list.stream().
                                       filter((a) -> a%2 == 0).
                                       filter((a) -> (a > 9)&(a < 101));
        testStream_2.forEach((a) -> System.out.println(a));


        //* - каждый элемент умножить на 2
        System.out.println("  ");
        System.out.println(" Умноженные на 2 элементы: ");
        Stream<Integer> testStream_3 = list.stream().map((a) -> a*2);
        testStream_3.forEach((a) -> System.out.println(a));


        //* - отсортировать и вывести на экран первых 4 элемента
        System.out.println(" ");
        System.out.println(" Первые 4 отсортированные элемента: ");
        Stream<Integer> testStream_4 = list.stream().sorted();
        testStream_4.limit(4).forEach((s) -> System.out.println(s));


        //* - вывести количество элементов в стриме
        System.out.println(" ");
        System.out.println(" Количество элементов в стриме: ");
        System.out.println(list.stream().count());

        //* - вывести среднее арифметическое всех чисел в стриме
        System.out.println(" ");
        System.out.println(" Среднее арифметическое всех чисел в стриме: ");
        Optional<Integer> sum2 = list.stream().reduce((x, y) -> x+y);
        System.out.println(sum2.get()/list.stream().count());
    }
}
