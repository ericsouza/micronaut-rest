### Start the Postgres Database:

```bash
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \
           --name micronaut-db -e POSTGRES_USER=micronaut \
           -e POSTGRES_PASSWORD=micronaut -e POSTGRES_DB=micronaut \
           -p 5432:5432 postgres:11.2
```

### Run micronaunt
```bash
./mvnw mn:run
```

### Insert some fruits to database
```bash
curl -X POST -H "Content-Type: application/json" -d '{"name":"orange"}' http://localhost:8080/fruit && curl -X POST -H "Content-Type: application/json" -d '{"name":"grape"}' http://localhost:8080/fruit && curl -X POST -H "Content-Type: application/json" -d '{"name":"apple"}' http://localhost:8080/fruit
```

#### See the error:
```bash
13:54:43.016 [reactor-tcp-epoll-3] WARN  reactor.core.publisher.FluxUsingWhen - Async resource cleanup failed after cancel
io.r2dbc.postgresql.client.ReactorNettyClient$PostgresConnectionClosedException: Connection closed
	at io.r2dbc.postgresql.client.ReactorNettyClient.lambda$static$1(ReactorNettyClient.java:102)
	at io.r2dbc.postgresql.client.ReactorNettyClient$BackendMessageSubscriber.close(ReactorNettyClient.java:1018)
	at io.r2dbc.postgresql.client.ReactorNettyClient.drainError(ReactorNettyClient.java:518)
	at io.r2dbc.postgresql.client.ReactorNettyClient.lambda$close$8(ReactorNettyClient.java:191)
	at reactor.core.publisher.MonoDefer.subscribe(MonoDefer.java:44)
	at reactor.core.publisher.Mono.subscribe(Mono.java:3987)
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.drain(MonoIgnoreThen.java:173)
	at reactor.core.publisher.MonoIgnoreThen.subscribe(MonoIgnoreThen.java:56)
	at reactor.core.publisher.FluxFromMonoOperator.subscribe(FluxFromMonoOperator.java:83)
	at reactor.core.publisher.FluxUsingWhen$UsingWhenSubscriber.cancel(FluxUsingWhen.java:342)
	at reactor.core.publisher.FluxUsingWhen$ResourceSubscriber.cancel(FluxUsingWhen.java:253)
	at reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:81)
	at reactor.core.publisher.FluxUsingWhen$UsingWhenSubscriber.onNext(FluxUsingWhen.java:358)
	at reactor.core.publisher.FluxUsingWhen$UsingWhenSubscriber.onNext(FluxUsingWhen.java:358)
	at reactor.core.publisher.FluxContextWrite$ContextWriteSubscriber.onNext(FluxContextWrite.java:107)
	at reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:82)
	at reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:82)
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:127)
	at reactor.core.publisher.FluxFilterFuseable$FilterFuseableSubscriber.onNext(FluxFilterFuseable.java:118)
	at reactor.core.publisher.Operators$MonoSubscriber.complete(Operators.java:1784)
	at reactor.core.publisher.MonoFlatMap$FlatMapInner.onNext(MonoFlatMap.java:249)
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:127)
	at reactor.core.publisher.Operators$ScalarSubscription.request(Operators.java:2346)
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.request(FluxMapFuseable.java:169)
	at reactor.core.publisher.MonoFlatMap$FlatMapInner.onSubscribe(MonoFlatMap.java:238)
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onSubscribe(FluxMapFuseable.java:96)
	at reactor.core.publisher.MonoJust.subscribe(MonoJust.java:54)
	at reactor.core.publisher.InternalMonoOperator.subscribe(InternalMonoOperator.java:64)
	at reactor.core.publisher.MonoFlatMap$FlatMapMain.onNext(MonoFlatMap.java:157)
	at reactor.core.publisher.Operators$MonoSubscriber.complete(Operators.java:1784)
	at reactor.core.publisher.MonoFlatMap$FlatMapInner.onNext(MonoFlatMap.java:249)
	at reactor.core.publisher.Operators$MonoSubscriber.complete(Operators.java:1784)
	at reactor.core.publisher.MonoFlatMap$FlatMapInner.onNext(MonoFlatMap.java:249)
	at reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:82)
	at reactor.core.publisher.FluxHandle$HandleSubscriber.onNext(FluxHandle.java:118)
	at reactor.core.publisher.MonoFlatMapMany$FlatMapManyInner.onNext(MonoFlatMapMany.java:250)
	at reactor.core.publisher.FluxHandleFuseable$HandleFuseableSubscriber.onNext(FluxHandleFuseable.java:184)
	at reactor.core.publisher.FluxFilterFuseable$FilterFuseableConditionalSubscriber.onNext(FluxFilterFuseable.java:337)
	at reactor.core.publisher.FluxContextWrite$ContextWriteSubscriber.onNext(FluxContextWrite.java:107)
	at reactor.core.publisher.FluxPeekFuseable$PeekConditionalSubscriber.onNext(FluxPeekFuseable.java:854)
	at io.r2dbc.postgresql.util.FluxDiscardOnCancel$FluxDiscardOnCancelSubscriber.onNext(FluxDiscardOnCancel.java:86)
	at reactor.core.publisher.FluxCreate$BufferAsyncSink.drain(FluxCreate.java:793)
	at reactor.core.publisher.FluxCreate$BufferAsyncSink.next(FluxCreate.java:718)
	at reactor.core.publisher.FluxCreate$SerializedFluxSink.next(FluxCreate.java:154)
	at io.r2dbc.postgresql.client.ReactorNettyClient$Conversation.emit(ReactorNettyClient.java:735)
	at io.r2dbc.postgresql.client.ReactorNettyClient$BackendMessageSubscriber.emit(ReactorNettyClient.java:986)
	at io.r2dbc.postgresql.client.ReactorNettyClient$BackendMessageSubscriber.onNext(ReactorNettyClient.java:860)
	at io.r2dbc.postgresql.client.ReactorNettyClient$BackendMessageSubscriber.onNext(ReactorNettyClient.java:767)
	at reactor.core.publisher.FluxHandle$HandleSubscriber.onNext(FluxHandle.java:118)
	at reactor.core.publisher.FluxPeekFuseable$PeekConditionalSubscriber.onNext(FluxPeekFuseable.java:854)
	at reactor.core.publisher.FluxMap$MapConditionalSubscriber.onNext(FluxMap.java:220)
	at reactor.core.publisher.FluxMap$MapConditionalSubscriber.onNext(FluxMap.java:220)
	at reactor.netty.channel.FluxReceive.drainReceiver(FluxReceive.java:267)
	at reactor.netty.channel.FluxReceive.onInboundNext(FluxReceive.java:377)
	at reactor.netty.channel.ChannelOperations.onInboundNext(ChannelOperations.java:381)
	at reactor.netty.channel.ChannelOperationsHandler.channelRead(ChannelOperationsHandler.java:94)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:379)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:365)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:357)
	at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:324)
	at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:311)
	at io.netty.handler.codec.ByteToMessageDecoder.callDecode(ByteToMessageDecoder.java:432)
	at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:276)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:379)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:365)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:357)
	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1410)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:379)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:365)
	at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:919)
	at io.netty.channel.epoll.AbstractEpollStreamChannel$EpollStreamUnsafe.epollInReady(AbstractEpollStreamChannel.java:795)
	at io.netty.channel.epoll.EpollEventLoop.processReady(EpollEventLoop.java:480)
	at io.netty.channel.epoll.EpollEventLoop.run(EpollEventLoop.java:378)
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:989)
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base/java.lang.Thread.run(Thread.java:829)
```


### Run basic load test:

```
wrk -t50 -c800 -d30s --latency http://localhost:8080/fruit
```

### See the error:
`13:51:10.625 [reactor-tcp-epoll-6] WARN  i.r.p.client.ReactorNettyClient - Error: SEVERITY_LOCALIZED=FATAL, SEVERITY_NON_LOCALIZED=FATAL, CODE=53300, MESSAGE=sorry, too many clients already, FILE=proc.c, LINE=346, ROUTINE=InitProcess`


#### Info

I'm evaluating the use of a new Java framework with fully reactive functionality. I'm basically choosing between Quarkus or Micronaut. In Quarkus I was able to run the load test above withou any problem.