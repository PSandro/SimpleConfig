# SimpleConfig

[![Build Status](https://travis-ci.org/PSandro/SimpleConfig.svg?branch=master)](https://travis-ci.org/PSandro/SimpleConfig)

SimpleConfig is a hack for Yaml configs: Normally persisting comments is
not supported with Yaml. SimpleConfig makes it able to use create and read
 **very** simple Configs and persist a comment for each entry.
 
 Status: _Developement_ (Snapshot available)

Maven Repository
-
```
<repository>
  <id>psandro-repo</id>
  <url>https://repo.psandro.eu/repository/maven-public/</url>
</repository>

<dependency>
  <groupId>eu.psandro</groupId>
  <artifactId>simpleconfig</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```
Third Party
-
SimpleConfig uses [snakeYAML](https://bitbucket.org/asomov/snakeyaml) and [Lombok](https://projectlombok.org/)
