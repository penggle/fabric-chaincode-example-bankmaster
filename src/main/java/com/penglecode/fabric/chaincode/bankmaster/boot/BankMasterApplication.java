package com.penglecode.fabric.chaincode.bankmaster.boot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.penglecode.fabric.chaincode.BasePackage;
import com.penglecode.fabric.chaincode.bankmaster.chaincode.BankMasterChaincode;

@SpringBootApplication(scanBasePackageClasses=BasePackage.class)
public class BankMasterApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(BankMasterApplication.class);
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(BankMasterApplication.class)
			.web(WebApplicationType.NONE)
			.run(args);
		LOGGER.info(">>> Starting chaincode, args = {}", Arrays.toString(args));
		args = new String[] {"-i", "bankmaster", "--peerAddress", "172.16.96.15:7051"};
		new BankMasterChaincode().start(args);
	}

}
