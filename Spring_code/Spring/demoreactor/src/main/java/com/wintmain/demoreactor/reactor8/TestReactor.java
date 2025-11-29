package com.wintmain.demoreactor.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-29 13:56:53
 */
public class TestReactor {
    public static void main(String[] args) {
        //just方法直接声明
        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);

        //其他方法
//        Integer[] array = {1,2,3,4};
//        Flux.fromArray(array);
//
//        List<Integer> list = Arrays.asList(array);
//        Flux.fromIterable(list);
//
//        Stream<Integer> stream = list.stream();
//        Flux.fromStream(stream);
//
//        Flux.error(new RuntimeException("chu"));

    }
}
