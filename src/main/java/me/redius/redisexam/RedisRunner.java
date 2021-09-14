package me.redius.redisexam;

import me.redius.redisexam.account.Account;
import me.redius.redisexam.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class RedisRunner implements ApplicationRunner {

    //레디스 템플릿
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 레디스 탬플릿을통해 단순  key , value로 입력가능
        ValueOperations<String,String> values = redisTemplate.opsForValue();
        values.set("nn","jung");
        values.set("hello","world");

        Account account = new Account();
        account.setEmail("nn@gmail.com");
        account.setUsername("nnjung");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println(byId.get().getUsername());
        System.out.println(byId.get().getEmail());
    }
}
