# rank-casino

## Endpoints

##### H2 Database web console
```shell script
# use this link to access H2 database management console
http://localhost:8080/h2-console

#JDBC URL: jdbc:h2:mem:casino
```

##### Root [GET]
```shell script
http://localhost:8080/api/v1/player
```

##### Current Player Balance [GET]
```shell script
#http://localhost:8080/api/v1/player/current-balance/{playerId}/{transactionId}
http://localhost:8080/api/v1/player/current-balance/1/1
```

##### Wagering [POST]
```shell script
#http://localhost:8080/api/v1/player/wagering/{playerId}/{transactionId}/wagerAmount
http://localhost:8080/api/v1/player/wagering/1/1/900
```

##### Winning [POST]
```shell script
#http://localhost:8080/api/v1/player/winning/{playerId}/{transactionId}/winAmount
http://localhost:8080/api/v1/player/winning/1/1/900
```

##### GET TRANSACTIONS
```shell script
http://localhost:8080/api/v1/player/transactions/1/wager
```
```shell script
{
    "username": "@mbmkhize",
    "password": "sandton"
}
```