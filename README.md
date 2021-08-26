
## Spring Boot and Spring Security with JWT including Access and Refresh Tokens personal implementation

This is an implementation of `userservice` from [AmigosCode](https://www.youtube.com/channel/UC2KfmYEM4KCuA1ZurravgYw)

The original example use JPA to connect with the database, this example use
 * Mybatis ORM
 * Mysql 8 Docker container
 * Java 11
 * (Maven) com.auth0 / java-jwt

Check the credits for more information

## DB CONFIGURATION
```
cd db
docker-compose up -d
```

Go to [http://localhost:8085](http://localhost:8085) to use phpmyadmin

```credentials
user:root
password:letmein 
```

In `SQL Script` use the content of the file `db/db.sql` to create the tables for the project


## Credits
- [(Video) / AmigosCode / Spring Boot & Spring Security/JWT / Access / Refresh Tokens](https://www.youtube.com/watch?v=VVn9OG9nfH0)
- [(Repository) Github.com/userservice](https://github.com/getarrays/userservice)
