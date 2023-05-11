package co.za.ehealth.eg.auth.controllers;

import co.za.ehealth.eg.auth.controllers.impl.GenericController;
import co.za.ehealth.eg.auth.entity.UserAccount;
import co.za.ehealth.eg.auth.service.UserAccountService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("account")
public class UserAccountController extends GenericController<UserAccountService, UserAccount, String> {
    public UserAccountController(UserAccountService service) {
        super(service);
    }
}
