package com.example;

/*
Java | Javascript | Python | Scala | Kotlin | GO
    First Class Functions
        - A function can be stored in a variable
        - A parameter of a function can be a function
        - The return value of a function can be a function
 */

import com.example.model.Apple;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP_Principles {

    // HOF
    static Predicate<Integer> and(Predicate<Integer> f1, Predicate<Integer> f2) {
        return i->{
            return f1.test(i) && f2.test(i);
        };
    }

    public static void main(String[] args) throws IOException {

        Predicate<Integer> isMax=n -> n > 100;
        Predicate<Integer> isMin=n -> n < 1000;
        Predicate<Integer> isMinAndIsMax=and(isMax,isMin);
        System.out.println(isMinAndIsMax.test(500));

        //---------------------------------------------------------

        Consumer<String> consoleLogger = System.out::println;
        FileWriter fileWriter=new FileWriter("log.txt");
        Consumer<String> fileLogger = log->{
            try{
                fileWriter.write(log+"\n");
                fileWriter.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        };

        String log = "server started";
        //consoleLogger.accept(log);
        //fileLogger.accept(log);
        Consumer<String> consoleAndFileLogger=consoleLogger.andThen(fileLogger);
        consoleAndFileLogger.accept(log);

        //---------------------------------------------------------

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100, "red"));
        apples.add(new Apple(200, "green"));
        apples.add(new Apple(300, "red"));
        apples.add(new Apple(200, "red"));

        Comparator<Apple> byColor = Comparator.comparing(Apple::getColor);
        Comparator<Apple> byWeight = Comparator.comparing(Apple::getWeight);
        Comparator<Apple> byColorAndWeight= byColor.thenComparing(byWeight);

        apples.sort(byColorAndWeight);

        apples.forEach(System.out::println);

        //---------------------------------------------------------

        Consumer<String> helloConsumer = name->{
            System.out.println("Hello "+name);
        };


        Consumer<String> hiConsumer=name->{
            System.out.println("Hi "+name);
        };

        // HOF
        Function<Consumer<String>,Consumer<String>> withEmoji=f->{
            return  name->{
                f.accept(name);
                System.out.println("😀");
            };
        };

//        helloConsumer.accept("John");
//        Consumer<String> helloWithEmoji=withEmoji.apply(helloConsumer);
//        helloWithEmoji.accept("John");


    }
}
