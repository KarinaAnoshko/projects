package by.local.controller.admin;

import by.local.entity.Transfer;
import by.local.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransferController {

    @Autowired
    private TransferService service;

    @GetMapping("/addTransfer")
    public String showTransferForm(Model model) {
        model.addAttribute("transfer", new Transfer());
        return "addTransferForm";
    }

    @PostMapping("/addTransfer")
    public String saveTransfer(@ModelAttribute Transfer transfer){
        service.save(transfer);
        return "home";
    }
}
