package net.iizs.btc.bithumbtrader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DummyController {
    @RequestMapping("/foo")
    public String devConsole() {
        return "foo";
    }
}
