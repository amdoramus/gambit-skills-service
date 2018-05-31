package com.revature.gambit.skill;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.gambit.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestDriver.class ,properties="/gambit-skill-service/src/test/resources/bootstrap.yml" , webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes=Application.class)
public class TestDriver {
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(TestDriver.class).run(args);
	}

	@Test
	@Ignore
	public void run() {
	}
}
