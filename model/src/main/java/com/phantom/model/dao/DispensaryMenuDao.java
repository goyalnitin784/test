package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryMenu;

import java.util.List;

public interface DispensaryMenuDao extends GenericDAO<DispensaryMenu, Long> {
    void saveMenu(DispensaryMenu dispensaryMenu);
    List<DispensaryMenu> getMenuByDispId(int dispId);
    DispensaryMenu getMenuByMenuId(String menuId);
}
