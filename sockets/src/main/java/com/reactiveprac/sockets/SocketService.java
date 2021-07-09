package com.reactiveprac.sockets;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;


@Controller
public class SocketService {

    private final ItemRepository repository;
    private final Sinks.Many<Item> itemSink;
    
    public SocketService(ItemRepository repository) {
        this.repository = repository;
        this.itemSink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @MessageMapping("newItems.request-response")
    public Mono<Item> processNewItemsViaRSocketRequestResponse(Item item) {
        return this.repository.save(item)
            .doOnNext(savedItem -> this.itemSink.tryEmitNext(savedItem));
    }

    @MessageMapping("newItems.fire-and-forget")
    public Mono<Void> processNewItemsViaRSocketFireAndForget(Item item) {
        return this.repository.save(item)
            .doOnNext(savedItem -> this.itemSink.tryEmitNext(savedItem)).then();
    }

    @MessageMapping("newItems.request-stream")
    public Flux<Item> findItemsViaRSocketRequestStream() {
        return this.repository.findAll()
            .doOnNext(this.itemSink::tryEmitNext);
    }
}
