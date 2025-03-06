package com.example.bankmanagementsystem.Controller;

import com.example.bankmanagementsystem.Api.ApiResponse;
import com.example.bankmanagementsystem.Model.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {
    ArrayList<Bank> banks = new ArrayList<>();

    //GET
    @GetMapping("/get")
    public ArrayList<Bank> getBanks() {
        return banks;
    }
    //ADD
    @PostMapping("/add")
    public ApiResponse addBank(@RequestBody Bank bank) {
        banks.add(bank);
        return new ApiResponse("bank added successfully");
    }
    //UPDATE
    @PutMapping("/update/{index}")
    public ApiResponse updateBank(@PathVariable int index,@RequestBody Bank bank) {
        banks.set(index, bank);
        return new ApiResponse("bank updated successfully");
    }
    //DELETE
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteBank(@PathVariable int index) {
        banks.remove(index);
        return new ApiResponse("bank deleted successfully");

    }
    //DEPOSIT
    @PostMapping("/{id}/deposit/{amount}")
    public ApiResponse deposit(@PathVariable int id,@PathVariable double amount) {
        for (int i = 0; i <banks.size() ; i++) {
            if (banks.get(i).getId() == id) {
                banks.get(i).setBalance(banks.get(i).getBalance() + amount);
                return new ApiResponse("bank deposit successfully");
            }
        }
         return new ApiResponse("bank deposit failed");
    }

    //WITHDRAW
    @PostMapping("/{id}/withdraw/{amount}")
    public ApiResponse withdraw(@PathVariable int id,@PathVariable double amount) {
        for (int i = 0; i <banks.size() ; i++) {
            if (banks.get(i).getId() == id) {
                banks.get(i).setBalance(banks.get(i).getBalance() - amount);
                return new ApiResponse("bank withdraw successfully");

            }
        }
        return new ApiResponse("bank withdraw failed");
    }


}
