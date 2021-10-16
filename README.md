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

<b>setter-based DI</b>

```
<bean ...>
    <property name="messageService" ref="service" (autowire="byName/byType")/>
</bean>
```

<b>costructor-based DI</b>

```
<bean ...>
    <constructor-arg ref="service" (autowire="constructor")/>
</bean>
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
