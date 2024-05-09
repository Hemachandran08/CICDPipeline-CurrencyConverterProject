package com.occ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.occ.model.Currency;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {

	Currency findByCode(String code);

}
