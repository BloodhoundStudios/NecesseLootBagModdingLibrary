package lbml.Items.LootBags;

import necesse.entity.mobs.PlayerMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;

import java.util.List;

public class TestLootbag extends Lootbag {
    //public LootTable lootTable = new LootTable(new LootItem("your_item", 1), new ChanceLootItem(0.5F, "your_chance_item", 5));

    public TestLootbag() {
        super();
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }
}
