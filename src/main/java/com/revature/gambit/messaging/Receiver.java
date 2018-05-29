package com.revature.gambit.messaging;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.revature.gambit.services.BucketService;

/**
 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 * 
 * Kafka Listener for updates regarding creating a new bucket in the bucket-service
 */
@Component
public class Receiver {
	
	private static Logger logger = Logger.getLogger(Receiver.class);
	
	@Autowired
	BucketService bucketService;
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 *
	 * @param payload - listens for a string in the specified topic
	 */
	@KafkaListener(topics = "bucket.create.id.t")
	public void lookUpBucketIdFromSkills(String payload) {
		logger.debug("Receiving payload from bucket service, it contains bucket id: " + payload);
		bucketService.addBucket(Integer.parseInt(payload));	
	}
	
}
