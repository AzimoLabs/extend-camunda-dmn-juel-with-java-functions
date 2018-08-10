package com.azimolabs.camunda.config;

import com.azimolabs.camunda.el.extention.juel.compliance.ComplianceFunctionsMapper;
import org.camunda.bpm.engine.impl.cfg.CompositeProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.engine.spring.SpringExpressionManager;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.util.CamundaSpringBootUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CamundaConfiguration {

    private ApplicationContext appContext;

    public CamundaConfiguration(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Bean
    public ProcessEngineConfigurationImpl processEngineConfigurationImpl(List<ProcessEnginePlugin> processEnginePlugins) {
        SpringProcessEngineConfiguration configuration = CamundaSpringBootUtil.springProcessEngineConfiguration();
        configuration.getProcessEnginePlugins().add(new CompositeProcessEnginePlugin(processEnginePlugins));

        SpringExpressionManager expressionManager = new SpringExpressionManager(appContext, configuration.getBeans());

        //register compliance functions mapper
        expressionManager.addFunctionMapper(new ComplianceFunctionsMapper());
        configuration.setExpressionManager(expressionManager);

        return configuration;
    }

}