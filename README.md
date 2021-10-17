# I-ASOS

Architektúra softvérových systémov (2. ročník ING, zimný semester)

## Dependencies

```
<dependencies>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>4.3.1.RELEASE</version>
</dependency>
<dependency>
    <groupId>javax.inject</groupId>
    <artifactId>javax.inject</artifactId>
    <version>1</version>
</dependency>
   <!--AOP-->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.8.9</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjtools</artifactId>
    <version>1.8.9</version>
</dependency>
</dependencies>
```

##  Main app

```
public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    MessageProcessor mp = context.getBean("processor", MessageProcessor.class);
    mp.processMessage();
}
```

## beans.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"

       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
          http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd
          http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
">

    <bean id="service" class="asos.MessageServiceMock"/>
    ...
    
</beans>
```

<b>Setter-based DI</b>

```
<bean id="processor" class="asos.springdemo1.MessageProcessor" >
    <property name="service" ref="service"/>
</bean>
```

<b>Costructor-based DI</b>

```
<bean id="processor" class="asos.springdemo1.MessageProcessor" >
    <constructor-arg ref="service"/>
</bean>
```

<b>autowire="constructor"</b>
```
<bean id="processor" class="asos.springdemo1.MessageProcessor" autowire="constructor" />
```

<b>autowire="byName"</b>
```   
<bean id="processor" class="asos.springdemo1.MessageProcessor" autowire="byName" />
```

<b>autowire="byType"</b>
```   
<bean id="processor" class="asos.springdemo1.MessageProcessor" autowire="byType" />
```

<b>Autowiring pomocou anotácí</b>

- Anotáciu @Autowired môžeme použiť pre anotovanie construktora aj setter-metódy
- Pre povinné referencie môžeme použiť aj anotáciu @Required
- Pre nepovinné referencie môžeme použiť @Autowired(required = false))
   
```   
<context:annotation-config/>
<bean id="service" class="asos.springapp1.MessageServiceMock"/>
<bean id="processor" class="asos.springapp1.MessageProcessor"/>

@Autowired
@Required
public void setMessageService(MessageServiceIfc messageService) {
    this.messageService = messageService;
}

```

<b>Component scan</b>
```
// beans.xml
<context:component-scan base-package="edu"/>


// MessageProcessor.java
@Component("processor")
public class MessageProcessor {
    MessageServiceIfc service;

    @Autowired
    @Required
    public MessageProcessor(MessageServiceIfc service) {
        this.service = service;
    }

//    @Autowired
//    @Required
    public void setService(MessageServiceIfc service) {
        this.service = service;
    }
    
    ...  
}

```

<b>Java based container configuration</b>
```

// DemoAppConfig.java
@Configuration
public class DemoAppConfig {
    @Bean(name = "service")
    public MessageServiceIfc serviceFactory() {
        return new MessageServiceMock();
    }

    @Bean(name = "processor")
    public MessageProcessor processorFactory(@Named("service") MessageServiceIfc ms) {
        return new MessageProcessor(ms);
    }
}

// MessageProcessor.java
Named("processor")
public class MessageProcessor {...}

// DemoApp.java
ApplicationContext c = new AnnotationConfigApplicationContext(DemoAppConfig.class);
MessageProcessor mp = c.getBean("processor", MessageProcessor.class);
mp.processMessage();
```

## AOP

```
<bean id="aspectBean" class="<aspectBeanClass>"/>

<aop:config>
<aop:aspect id="myAspect" ref="aspectBean">
    <aop:pointcut id="pointcut" expression="execution(* asos.*.*())"/>
    <aop:before method="<method>" pointcut-ref="pointcut"/>
    <aop:after method="<method>" pointcut-ref="pointcut"/>
</aop:aspect>
</aop:config>
```

### Expression syntax

https://howtodoinjava.com/spring-aop/aspectj-pointcut-expressions/

* this - priama trieda ktora vola metodu (musi byt priamo vytvorenia, nie cez proxy triedu)
* target - trieda ktora vola metodu 
* execution - presny popis metody
* args - parametre ktore metoda vola

```
execution(<return_val> <package>.<class>.<method>(<args>))
```

<b>log. spojky:</b>

```
execution(* asos.*.*(..)) && !target(asos.MessageProcessor)
```

### Recap

novy projekt -> java with maven -> java app
!!! jdk 1.8
!!! pom subor - dependencies, jdk 1.8

src/main/resources - beans.xml  -> aop, context dotiahnut

* property - setterove
    * autowire='byType', 'byName'
        * byType iba 1 bean
        * byName - podla nazvu param. triedy, iba 1 bean

* constructor-arg - konstruktor
    * autowire='constructor'

* aop:config
    * aspect, pointcut, before/after/around/...
