package co.za.ehealth.eg.auth.service;

import co.za.ehealth.eg.auth.entity.UserAccount;
import co.za.ehealth.eg.auth.repo.UserAccountRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends GenericService<UserAccountRepository, UserAccount, String> {

    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository repository) {
        super(repository);
        userAccountRepository = repository;
    }

    @Override
    public UserAccount update(String id, UserAccount item) {
        UserAccount userAccount = userAccountRepository.getOne(id);
        userAccount.setAccountType(item.getAccountType());
        userAccount.setUserName(item.getUserName());
        return userAccountRepository.save(userAccount);
    }

}
