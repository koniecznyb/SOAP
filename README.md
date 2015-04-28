### Konfiguracja JBoss

#### jboss-as/standalone/configuration
##### soap-lab-roles.properties
```
soap=AdminRole
```
##### soap-lab-users.properties
```
soap=as
```
##### standalone.xml

Między ```<security-domains></security-domains>``` dodaj
```
<security-domain name="JBossWS" cache-type="default">
  <authentication>
      <login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule" flag="required">
          <module-option name="usersProperties" value="${jboss.server.config.dir}/soap-lab-users.properties"/>
          <module-option name="rolesProperties" value="${jboss.server.config.dir}/soap-lab-roles.properties"/>
      </login-module>
  </authentication>
</security-domain>
```

#### Generowanie kodu z wsdl

```
wsimport -d generated http://localhost:8080/soa-ejb/Authorization?wsdl -keep -Xauthfile auth.txt
```

gdzie plik auth.txt:

```
http://soap:as@localhost:8080/soa-ejb/Authorization?wsdl
```

##### REST
#### TODO

```
1. WYST WS REST:
    1.1 GET, POST, PUT
    1.2 ZWROT: JSON, PDF, PNG
    1.3 KODY BŁEDOW HTTP!
2. KONSUMPCJA WS REST/JSON:
    2.1 OBJECTFACTORY
```
