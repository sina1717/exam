package service;

import Entity.Account;
import repository.AccountRepository;

import java.util.List;

public class AccountService implements BaseService<Account> {
    private AccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }

    public Account signIn(String username, String password){
        return accountRepository.signIn(username,password);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void update(Account account) {
        accountRepository.update(account);
    }

    @Override
    public void delete(int id) {
        accountRepository.delete(id);
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
