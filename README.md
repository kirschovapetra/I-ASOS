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