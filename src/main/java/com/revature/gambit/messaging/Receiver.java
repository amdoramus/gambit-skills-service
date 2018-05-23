package com.revature.gambit.messaging;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.entities.BucketDTO;
import com.revature.gambit.entities.SkillType;
import com.revature.gambit.entities.SkillTypeBucketId;
import com.revature.gambit.entities.SkillTypeBucketLookup;
import com.revature.gambit.repositories.SkillTypeBucketLookupRepository;


@Component
public class Receiver {
	private static Logger logger = Logger.getLogger(Receiver.class);
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SkillTypeBucketLookupRepository skillTypeLookUpService;
	
	@KafkaListener(topics = "questioncomposition.filter.t")
	public void lookUpBucketIdFromSkills(String payload) {
		logger.debug("Receiving payload from question service, it contains " + payload);
		SkillType skt = new SkillType();
		
		skt.setSkillTypeId(Integer.valueOf(payload));
		
		List<SkillTypeBucketLookup> bucketIdListBySkillsType = skillTypeLookUpService.findSkillTypeBucketLookupsBySkillTypeBucketIdSkillType(skt);
		List<Integer> bucketIdBySkillType = new ArrayList();
		
		Sender sender = new Sender();
		String str = "bucketidlist";	
		for (int i = 0; i<bucketIdListBySkillsType.size(); i++) {
			
			bucketIdBySkillType.add(bucketIdListBySkillsType.get(i).getSkillTypeBucketId().getBucket().getBucketId()) ;
					
		}
		
		sender.publish(str, bucketIdBySkillType);
	}
}
