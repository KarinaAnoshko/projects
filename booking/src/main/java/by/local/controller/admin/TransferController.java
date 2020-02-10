package by.local.controller.admin;

import by.local.entity.Transfer;
import by.local.service.ImageService;
import by.local.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class TransferController {

    private ImageService imageService;
    private TransferService service;

    @Autowired
    public TransferController(TransferService service, ImageService imageService){
        this.imageService = imageService;
        this.service = service;
    }

    @GetMapping("/addTransfer")
    public String showTransferForm(Model model) {
        model.addAttribute("transfer", new Transfer());
        return "addTransferForm";
    }

    @PostMapping("/addTransfer")
    public RedirectView saveTransfer(@ModelAttribute Transfer transfer,
                                     @RequestParam("file") MultipartFile multipartFile) throws IOException {
        imageService.saveImage(multipartFile);
        transfer.setImageName(multipartFile.getOriginalFilename());
        service.save(transfer);
        return new RedirectView("/booking/allTransfers");
    }

    @GetMapping("/allTransfers")
    public String showAll(Model model){
        model.addAttribute("transfers", service.findAll());
        return "allTransfers";
    }

    @PostMapping("/delete")
    public RedirectView removeTransfer(@RequestParam String id){
        service.remove(id);
        return new RedirectView("/booking/allTransfers");
    }

    @GetMapping("/updateTransfer/{id}")
    public String updateTransfer(@PathVariable(name = "id") String id, Model model){
        model.addAttribute("transfer", service.findById(id));
        return "updateTransferForm";
    }



}
