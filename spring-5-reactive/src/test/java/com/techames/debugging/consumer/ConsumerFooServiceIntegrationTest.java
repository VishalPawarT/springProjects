package com.techames.debugging.consumer;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.techames.debugging.consumer.model.Foo;
import com.techames.debugging.consumer.service.FooService;
import com.techames.debugging.consumer.utils.ListAppender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

public class ConsumerFooServiceIntegrationTest {

    FooService service = new FooService();

    @Before
    public void clearLogList() {
        Hooks.onOperatorDebug();
        ListAppender.clearEventList();
    }

    @Test
    public void givenFooWithNullId_whenProcessFoo_thenLogsWithDebugTrace() {
        Foo one = new Foo(1, "nameverylong", 8);
        Foo two = new Foo(null, "nameverylong", 4);
        Flux<Foo> flux = Flux.just(one, two);

        service.processFoo(flux);

        Collection<String> allLoggedEntries = ListAppender.getEvents()
            .stream()
            .map(ILoggingEvent::getFormattedMessage)
            .collect(Collectors.toList());

        Collection<String> allSuppressedEntries = ListAppender.getEvents()
            .stream()
            .map(ILoggingEvent::getThrowableProxy)
            .flatMap(t -> {
                return Optional.ofNullable(t)
                    .map(IThrowableProxy::getSuppressed)
                    .map(Arrays::stream)
                    .orElse(Stream.empty());
            })
            .map(IThrowableProxy::getMessage)
            .collect(Collectors.toList());
        assertThat(allLoggedEntries).anyMatch(entry -> entry.contains("The following error happened on processFoo method!"))
            .anyMatch(entry -> entry.contains("| onSubscribe"))
            .anyMatch(entry -> entry.contains("| cancel()"));

        assertThat(allSuppressedEntries).anyMatch(entry -> entry.contains("Assembly trace from producer"))
            .anyMatch(entry -> entry.contains("Error has been observed by the following operator(s)"));
    }

}
