package com.training.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.training.common.constant.Constants;
import com.training.common.util.CommonUtil;

/**
 * Add configuration for application on start up
 * 
 * @author Red Devil
 * @since 2020-02-20
 */
@Configuration
@ComponentScan(basePackages = "com.training")
public class ServletContextInitializerConfig implements ServletContextInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.setProperty(Constants.PROP_KEY_ROOT_FOLDER, CommonUtil.readProperties(Constants.PROP_KEY_ROOT_FOLDER, "config/application.properties"));
		
	}
	
}