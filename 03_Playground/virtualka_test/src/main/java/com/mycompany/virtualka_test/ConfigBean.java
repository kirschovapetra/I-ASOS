/*
    <bean id="service" class="com.mycompany.virtualka_test.MessageServiceMock"/>
    <bean id="consumer" class="com.mycompany.virtualka_test.MessageConsumerMock"/>
    <bean id="processor" class="com.mycompany.virtualka_test.MessageProcessor" autowire="byType">
<!--        <constructor-arg ref="service"/>
        <constructor-arg name="consumer" ref="consumer"/>-->
    </bean>
    
    <bean id="aspectBean" class="com.mycompany.virtualka_test.MyAspect">
        <property name="count" value="0"/>
        <property name="sum" value="0"/>
    </bean>
    
    <aop:config>
        <aop:aspect id="ass" ref="aspectBean">
            <aop:pointcut id="logAllBefore" expression="execution(* com.mycompany.virtualka_test.*.*(..))"/>
            <aop:pointcut id="logGetMessage" expression="execution(* com.mycompany.virtualka_test.*.getMessage(..))"/>
            <aop:pointcut id="logPutMessage" expression="execution(* com.mycompany.virtualka_test.*.putMessage(..))"/>
            <aop:pointcut id="zacinaNaP" expression="execution(* com.mycompany.virtualka_test.*.p*(..))"/>
->
            
            <!--<aop:before method="countBefore" pointcut-ref="logGetMessage"/>-->
            <aop:before method="before" pointcut-ref="zacinaNaP"/>
            <aop:after-returning method="sumAfter" pointcut-ref="logGetMessage" returning="ret"/>
            <aop:around method="encryptAround" pointcut-ref="logGetMessage"/>
            <aop:around method="decryptAround" pointcut-ref="logPutMessage"/>
            <aop:around method="merajCasAround" pointcut-ref="logGetMessage"/>
        </aop:aspect>
    </aop:config>
 */
package com.mycompany.virtualka_test;

import javax.inject.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author edu
 */
@Configuration
public class ConfigBean {
    @Bean(name = "consumer")
    public MessageConsumerIfc messageConsumerFactory(){return new MessageConsumerMock();}
    @Bean(name = "service")
    public MessageServiceIfc messageSourceFactory(){return new MessageServiceMock();}
    @Bean(name = "aspectBean")
    public MyAspect myAspectFactory() {
        MyAspect asp = new MyAspect();
        asp.setCount(0);
        asp.setSum(0);
        return asp;
    }
    @Bean(name = "processor")
    public MessageProcessor messageProcessorFactory(@Named("service") MessageServiceIfc s, @Named("consumer") MessageConsumerIfc c) {
        return new MessageProcessor(c,s);
    }
    
}
