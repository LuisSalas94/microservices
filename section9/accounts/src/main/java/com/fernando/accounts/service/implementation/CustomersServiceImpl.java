package com.fernando.accounts.service.implementation;

import com.fernando.accounts.dto.AccountsDto;
import com.fernando.accounts.dto.CardsDto;
import com.fernando.accounts.dto.CustomerDetailsDto;
import com.fernando.accounts.dto.LoansDto;
import com.fernando.accounts.entity.Accounts;
import com.fernando.accounts.entity.Customer;
import com.fernando.accounts.exception.ResourceNotFoundException;
import com.fernando.accounts.mapper.AccountsMapper;
import com.fernando.accounts.mapper.CustomerMapper;
import com.fernando.accounts.repository.AccountsRepository;
import com.fernando.accounts.repository.CustomerRepository;
import com.fernando.accounts.service.ICustomersService;
import com.fernando.accounts.service.client.CardsFeignClient;
import com.fernando.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
