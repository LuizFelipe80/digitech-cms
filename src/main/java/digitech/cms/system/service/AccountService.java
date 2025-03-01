package digitech.cms.system.service;

import digitech.cms.system.entity.Account;
import digitech.cms.system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> listAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        return accountOptional.orElse(null);
    }

    public Account updateAccount(Long id, Account account) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            account.setId(id); // Garante que o ID não seja alterado
            return accountRepository.save(account);
        }
        return null;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}