package kdo6301.DeliverySystem.web.item;

import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.service.item.ItemServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemServiceImp itemservice;

    @GetMapping
    public String items(Model model)
    {
        List<Item> items = itemservice.findAll();
        model.addAttribute("items",items);
        return "items/items";
    }

    @GetMapping("/delete")
    public String delete()
    {
        itemservice.deleteAll();
        return "items/items";
    }

    @GetMapping("/add")
    public String addForm(@ModelAttribute("item") Item item)
    {
        return "items/addForm";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Item item, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "items/addForm";
        }

        itemservice.save(item);
        return "redirect:/items";
    }

}
