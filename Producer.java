package com.kafka.producer.src;


	//package com.springkafka.kafkaproducer.config;

	import org.springframework.cloud.stream.annotation.Output;
	import org.springframework.messaging.MessageChannel;

	public interface Producer {
		//@Output
	    
	    public MessageChannel kafkaExample();

	}

