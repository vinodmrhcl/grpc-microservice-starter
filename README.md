# gRPC microservice starter

## Build

``` mvn clean install ```

## Setup

Run [server/schema/postgresql.sql](server/schema/postgresql.sql) on your database schema to setup a new schema instance and configure data source properties in  [server/src/main/resources/application.properties](server/src/main/resources/application.properties)

## Run

``` mvn spring-boot:run ```

## Test

Import [client/accountmgmt.yaml](client/accountmgmt.yaml) in Postman ( similar API testing tool ) and execute the CRUD operation to verify the result

