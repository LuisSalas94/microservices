package com.fernando.accounts.service;

import com.fernando.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {
    /**
     * @param mobileNumber - Input Mobile number
     * @return Customer Details based on a given mobileNumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
