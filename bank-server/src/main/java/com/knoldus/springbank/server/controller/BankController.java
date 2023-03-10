package com.knoldus.springbank.server.controller;

import com.knoldus.springbank.common.dto.Client;
import com.knoldus.springbank.common.dto.ClientId;
import com.knoldus.springbank.common.dto.DepositRequest;
import com.knoldus.springbank.common.dto.ServiceException;
import com.knoldus.springbank.common.dto.TransactionRequest;
import com.knoldus.springbank.common.dto.WithdrawRequest;
import com.knoldus.springbank.common.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/transfer")
    public void transferFunds(@RequestBody TransactionRequest transactionRequest) throws ServiceException {
        bankService.transferFunds(transactionRequest);
    }

    @PutMapping("/deposit")
    public void deposit(@RequestBody DepositRequest depositRequest) throws ServiceException {
        bankService.deposit(depositRequest);
    }

    @PutMapping("/withdraw")
    public void withDraw(@RequestBody WithdrawRequest withdrawRequest) throws ServiceException {
        bankService.withDraw(withdrawRequest);
    }

    @GetMapping("/info/client/{id}")
    public Client getClientInfo(@PathVariable(value="id") String id) throws ServiceException {
        return bankService.getClientInfo(new ClientId(id));
    }

}
