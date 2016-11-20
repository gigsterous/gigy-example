## About

This is an example project that illustrates creating a RESTful API in Spring Boot.

## Runnning this project

```
mvn spring-boot:run
```

## Get token

```
curl -X POST --user 'gigy:secret' -d 'grant_type=password&username=peter@example.com&password=password' http://localhost:8000/gigy/oauth/token
```

## Example commands

Getting all people from the API:
```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -X GET http://localhost:8000/gigy/people
```

## LICENSE

The code is released under the Apache License 2.0. See LICENSE for details.
