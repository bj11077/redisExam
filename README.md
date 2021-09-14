## Redis 접근

winpty docker exec -i -t redis_boot redis-cli

ㄴ 윈도우라 winpty붙여서 접근해야됨


## Redis 명령어


### keys *    (모든키 목록)

127.0.0.1:6379> keys *
1) "hello"
1) "accounts:4c3cd5cf-729f-4c85-a7c4-7256eaf28caf"
2) "hello"
3) "accounts"
4) "nn"
   127.0.0.1:6379> hget key field

### get [name]  (키를통해 값을가져옴)
127.0.0.1:6379> get nn --> "jung"
  

### hget [해쉬키] [조회할컬럼]   (해쉬의 특정컬럼조회)

127.0.0.1:6379> hget accounts:4c3cd5cf-729f-4c85-a7c4-7256eaf28caf email  --> "nn@gmail.com"

### hgetall [해쉬키]  (해쉬의 모든값조회)

127.0.0.1:6379> hgetall accounts:4c3cd5cf-729f-4c85-a7c4-7256eaf28caf
1) "_class"   -->클래스값추가로조회
2) "me.redius.redisexam.account.Account" --클래스값추가로조회
3) "email"
4) "nn@gmail.com"
5) "id"
6) "4c3cd5cf-729f-4c85-a7c4-7256eaf28caf"
7) "username"
8) "nnjung"

