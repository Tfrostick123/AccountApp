package com.frostick.accountapp.repository;

import com.frostick.accountapp.data.impl.AccountImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Account Repository.
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountImpl, Integer> {

}
