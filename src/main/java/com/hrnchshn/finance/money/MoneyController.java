package com.hrnchshn.finance.money;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyRepository moneyRepository;

    @Autowired
    private AUserRepository userRepository;

    @GetMapping
    public String test(){
        AUser ivan = new AUser();
        ivan = userRepository.saveAndFlush(ivan);

        Money dollar = new Dollar();
        dollar.setAmount(34.5);
        Money euro = new Euro();
        euro.setAmount(45.0);

        dollar = moneyRepository.saveAndFlush(dollar);
        euro = moneyRepository.saveAndFlush(euro);

        dollar.setUser(ivan);
        euro.setUser(ivan);

        ivan.getMonies().add(euro);
        ivan.getMonies().add(dollar);

        userRepository.save(ivan);

        return moneyRepository.findByUser(ivan).toString();

    }
}
