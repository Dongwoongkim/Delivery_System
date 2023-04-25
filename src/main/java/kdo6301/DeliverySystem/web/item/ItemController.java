package kdo6301.DeliverySystem.web.item;

import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.dto.item.*;
import kdo6301.DeliverySystem.service.item.ItemServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
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
    MessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();

    @GetMapping
    public String items(@ModelAttribute("itemSearch") ItemSearchDTO itemSearchDTO, Model model) {
        List<Item> items = itemservice.findItems(itemSearchDTO);
        model.addAttribute("items", items);
        return "items/items";
    }

    @GetMapping("/add")
    public String addForm(@ModelAttribute("itemAddDTO") ItemAddDTO itemAddDTO) {
        return "items/addForm";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute ItemAddDTO itemAddDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("{}",bindingResult.getAllErrors());
            return "items/addForm";
        }
        itemservice.save(itemAddDTO);
        return "redirect:/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Optional<ItemResponseDTO> findItem = itemservice.findById(itemId);

        if (findItem.isPresent()) {
            ItemResponseDTO itemResponseDTO = findItem.get();
            log.info("item = {}",itemResponseDTO);
            model.addAttribute("itemResponseDTO", Item.toItem(itemResponseDTO));
            return "items/item";
        }
        return "redirect:/items";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable("itemId") Long itemId, Model model) {
        Optional<ItemResponseDTO> findItem = itemservice.findById(itemId);
        if (findItem.isPresent()) {
            ItemResponseDTO itemResponseDTO = findItem.get();
            ItemUpdateDto itemUpdateDto = ItemResponseDTO.toUpdateDto(itemResponseDTO);
            model.addAttribute("itemUpdateDTO", itemUpdateDto);
            return "items/editForm";
        }
        return "redirect:/items";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable("itemId") Long itemId, @Valid @ModelAttribute ItemUpdateDto itemUpdateDto,  BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) {
            return "items/editForm";
        }
        itemservice.update(itemId,itemUpdateDto);
        return "redirect:";
    }

    @GetMapping("/delete")
    public String delete() {
        itemservice.deleteAll();
        return "redirect:/items";
    }
}


