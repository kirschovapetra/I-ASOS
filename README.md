# I-ASOS

Architektúra softvérových systémov (2. ročník ING, zimný semester)

## Dependencies

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

## AOP

<bean id="aspectBean" class="asos.MyAspectBean"/>

<aop:config>
<aop:aspect id="myAspect" ref="aspectBean">
    <aop:pointcut id="pointCut" expression="execution(* asos.*.*())"/>
    <aop:before method="loggingAdviceBefore" pointcut-ref="pointCut"/>
    <aop:after method="loggingAdviceAfter" pointcut-ref="pointCut"/>
</aop:aspect>
</aop:config>
