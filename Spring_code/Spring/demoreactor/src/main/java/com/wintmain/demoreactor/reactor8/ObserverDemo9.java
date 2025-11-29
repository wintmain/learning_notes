package com.wintmain.demoreactor.reactor8;

import java.util.concurrent.Flow;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-29 14:40:45
 */

// Java9+取消了Observer和Observable
//本质上，reactor基于这个实现的
public class ObserverDemo9 {
    public static void main(String[] args) {
        Flow.Publisher<String> publisher = subscriber -> {
            subscriber.onNext("1");
            subscriber.onNext("2");
            subscriber.onError(new RuntimeException("出错了"));
//            subscriber.onComplete();
        };

        publisher.subscribe(new Flow.Subscriber<String>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                subscription.cancel();
            }

            @Override
            public void onNext(String item) {
                System.out.println(item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("出错了");
            }

            @Override
            public void onComplete() {
                System.out.println("publish complete");
            }
        });
    }
}
