package repository.impl;

import model.Item;

public class ItemRepositoryImpl extends BaseRepositoryImpl<Long, Item>{

    @Override
    public Class<Item> getEntityClass() {
        return Item.class;
    }
}
