# I-ASOS

Architektúra softvérových systémov (2. ročník ING, zimný semester)

https://www.tutorialspoint.com/spring/
https://www.tutorialspoint.com/spring/spring_overview.htm

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
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); // new AnnotationConfigApplicationContext(AppConfig.class);
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

##  Dependency injection

### Setter-based DI

```
<bean id="processor" class="asos.springdemo1.MessageProcessor" >
    <property name="service" ref="service"/>
</bean>
```

### Costructor-based DI

```
<bean id="processor" class="asos.springdemo1.MessageProcessor" >
    <constructor-arg ref="service"/>
</bean>
```

### autowire="constructor"
```
<bean id="processor" class="asos.springdemo1.MessageProcessor" autowire="constructor" />
```

### autowire="byName"
```   
<bean id="processor" class="asos.springdemo1.MessageProcessor" autowire="byName" />
```

### autowire="byType"
```   
<bean id="processor" class="asos.springdemo1.MessageProcessor" autowire="byType" />
```

### Autowiring pomocou anotácí

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

### Component scan
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

### Java based container configuration
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

### Java based <--> xml
```
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
...

@Configuration
class AppConfig {

// sources - vytvoria sa default konstruktorom, nepotrebuju parametre
    @Bean(name="mySourceCon")
    public DataSourceIfc dsConFactory(){return new DataSourceCon();}
    @Bean(name = "mySourceSet")
    public DataSourceIfc dsSetFactory() {return new DataSourceSet();}

// constructor-based - dovnutra ide source, pouzije sa konstruktor
    @Bean(name = "myProcessorCon")
    public DataProcessorCon dpConFactory(@Named("mySourceCon") DataSourceIfc src){
        DataProcessorCon dp = new DataProcessorCon(src);
        return dp;
    }  

// setter-based - dovnutra ide source, pouzije sa setSource()
    @Bean(name = "myProcessorSet")
    public DataProcessorSet dpSetFactory(@Named("mySourceSet") DataSourceIfc src) {
        DataProcessorSet dp = new DataProcessorSet();
        dp.setSource(src);
        return dp;
    }   
}

-----------------------------------------------------------------------------------
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
...

<bean id="mySourceCon" class="asos.DataSourceCon"/>
<bean id="mySourceSet" class="asos.DataSourceSet">

<!-- constructor-based -->
<bean id="myProcessorCon" class="asos.DataProcessorCon">
    <constructor-arg ref="mySourceCon">
</bean>

<!-- setter-based -->
<bean id="myProcessorSet" class="asos.DataProcessorSet">
    <property name="source" ref="mySourceSet">
</bean>

```

## AOP

<b>beans.xml</b>
```
<bean id="aspectBean" class="<aspectBeanClass>"/>
```
``` diff
! <!-- count ako property, CounterAspect musi mat setter -->
! <bean id="counter" class="asos.springdemo1.CounterAspect" >
!    <property name="count" value="0" />
! </bean>
```
```
<aop:config>
<aop:aspect id="myAspect" ref="aspectBean">
    <aop:pointcut id="pointcut" expression="execution(* asos.*.*())"/>
    <aop:before method="<method>" pointcut-ref="pointcut"/>
    <aop:after method="<method>" pointcut-ref="pointcut"/>
    <aop:after-returning method="<method>" pointcut-ref="pointcut" returning="result"/>
    <aop:around method="<method>" pointcut-ref="pointcut"/>
</aop:aspect>
</aop:config>
```
<b>MyAspect.java</b>
```
public void before(JoinPoint jp) {}
```
```
public void after(JoinPoint jp) {}
```
```
// result = navratova hodnota
public void afterReturning(JoinPoint jp, Object result) {}
```
```
// zmena navratovej hodnoty
public Object around(ProceedingJoinPoint jp) throws Throwable {
    Object ret = jp.proceed();
    Object newRet = "NewRet";
    return newRet;
}
```
```
// zmena argumentov
public Object around(ProceedingJoinPoint jp) throws Throwable {
    Object arg = jp.getArgs()[0];
    Object[] newArgs = {"NewArg1"};
    return jp.proceed(newArgs);
}
```

### Expression syntax

https://howtodoinjava.com/spring-aop/aspectj-pointcut-expressions/
https://www.tutorialspoint.com/spring/aop_with_spring.htm

* <b>this</b> - priama trieda ktora vola metodu (musi byt priamo vytvorenia, nie cez proxy triedu)
    ```
    this(<package>.<class>)
    ```
* <b>target</b> - trieda ktora vola metodu 
    ```
    target(<package>.<class>)
    ```
* <b>execution</b> - presny popis metody
    ```
    execution(<return_val> <package>.<class>.<method>(<args>))
    ```
* <b>args</b> - parametre ktore metoda vola
    ```
    args(<arg-name>)
    ```
<b>Examples</b>
```
<!-- všetky arg. -->
execution(* asos.*.*(..))
<!-- bez arg. -->
execution(* asos.*.*())
<!-- int arg. -->
execution(* asos.*.*(int))
```
```
<!-- všetky metódy vsetkych tried v packagi asos -->
execution(* asos.*.*(..))
```
```
<!-- všetky metódy triedy MyOperationBean s menom začínajúcim na m -->
execution(* asos.aop.MyOperationBean.m*(..))
```
```
<!-- metóda MyOperationBean.msg ktora ma argument 'message' -->
execution(* asos.aop.MyOperationBean.msg(String)) and args(message)"
```
```
<!-- všetky metódy MyOperationBean -->
execution(* asos.aop.MyOperationBean.*(..))"
```
```
<!-- logicke spojky -->
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