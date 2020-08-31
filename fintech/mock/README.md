# Fintech Mock sample

## Endpoints

There is 2 mock services:

* BankBNG: implement the /accounts endpoints with **application/XML** media type 
* BankINP: implement the /accounts endpoints with **application/JSON** media type

## Build

To build the mocks:

```sh
> mvn clean install && mvn meecrowave:bundle 
```

To build the docker image:

`NB: You have to build the mock with meecrowave:bundle before creating the docker image`

```sh
> mvn jib:dockerBuild 
```

## Run

To run the mock without docker:

```sh
> mvn clean install && mvn meecrowave:run 
```

To start a container from the image:

```sh
> docker run -p 8081:8080 --name fintech-bankbng io.yupiik.camel.sample/fintech-mock-bankbng:1.0.0-SNAPSHOT
```

## Test

Then the endpoint is available at:

http://localhost:8081/fintech/mock/bankbng

Using curl:

```sh
curl http://localhost:8081/fintech/mock/bankbng/accounts \
    -H 'Accept: application/xml' \
    -H 'Content-Type: application/xml'
```
