package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.repository.MenuRepository;
import com.alexistdev.mygudang.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MenuServiceImplement implements MenuService {
    @Autowired
    private MenuRepository menuRepository;


    @Override
    public Menu save(MenuDTO menu) throws Exception{
        Menu insertMenu = new Menu();
        Date now = new Date();
        insertMenu.setMenuCode(menu.getMenuCode());
        insertMenu.setDescription(menu.getDescription());
        insertMenu.setUrl(menu.getUrl());
        insertMenu.setLabel(menu.getLabel());
        insertMenu.setCreatedAt(now);
        insertMenu.setUpdatedAt(now);
        insertMenu.setCreatedBy(menu.getCreatedBy());
        insertMenu.setModifiedBy(menu.getModifiedBy());
        return menuRepository.save(insertMenu);
    }
}