package com.kafka.controller;

/*
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
    import com.kafka.service.KafkaSender;

	@RestController
	@RequestMapping(value = "/java-kafka/")
	public class ApacheKafkaWebController {

		@Autowired
		KafkaSender kafkaSender;

		@GetMapping(value = "/producer")
		public String producer(@RequestParam("message") String message) {
			kafkaSender.send(message);

			return "Message sent to the Kafka Topic java_in_use_topic Successfully";
		}

	}*/


import com.springkafka.kafkaproducer.config.KafkaConfig;
import com.springkafka.kafkaproducer.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserController {

//    private final MessageChannel output;
//
//    public UserController(MessageChannel output) {
//        this.output = output;
//    }

    private final KafkaConfig kafkaConfig;

    public UserController(KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
    }


    @PostMapping("/")
    public ResponseEntity<?> postUser(@RequestBody User user) {
        ((UserController) kafkaConfig.kafka()).send(MessageBuilder.withPayload(user).build());
        return ResponseEntity.ok(user);
    }


	private void send(Message<User> build) {
		// TODO Auto-generated method stub
		
	}
}

