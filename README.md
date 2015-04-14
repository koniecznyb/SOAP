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

Miêdzy ```<security-domains></security-domains>``` dodaj
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