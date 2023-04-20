package kdo6301.DeliverySystem.web.item;

import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.service.item.ItemSearchCond;
import kdo6301.DeliverySystem.service.item.ItemServiceImp;
import kdo6301.DeliverySystem.service.item.ItemUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemServiceImp itemservice;

    @GetMapping
    public String items(@ModelAttribute("itemSearch") ItemSearchCond itemSearch, Model model) {
        List<Item> items = itemservice.findItems(itemSearch);
        model.addAttribute("items", items);
        return "items/items";
    }
    @GetMapping("/delete")
    public String delete() {
        itemservice.deleteAll();
        return "redirect:/items";
    }

    @GetMapping("/add")
    public String addForm(@ModelAttribute("item") Item item) {
        return "items/addForm";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "items/addForm";
        }
        itemservice.save(item);
        return "redirect:/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Optional<Item> findItem = itemservice.findById(itemId);
        Item item = findItem.get();
        model.addAttribute("item", item);
        return "items/item";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable("itemId") Long itemId, Model model) {
        Optional<Item> findItem = itemservice.findById(itemId);
        Item item = findItem.get();
        model.addAttribute("item", item);
        return "items/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable("itemId") Long itemId, @Valid @ModelAttribute Item item,  BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) {
            return "items/editForm";
        }

        ItemUpdateDto itemUpdateDto = new ItemUpdateDto(item.getItemName(), item.getPrice(), item.getQuantity());
        itemservice.update(itemId,itemUpdateDto);
        return "redirect:";
    }

}


