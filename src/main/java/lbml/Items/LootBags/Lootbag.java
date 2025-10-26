package lbml.Items.LootBags;

import necesse.engine.util.GameRandom;
import necesse.inventory.InventoryItem;
import necesse.inventory.container.Container;
import necesse.inventory.container.ContainerActionResult;
import necesse.inventory.container.slots.ContainerSlot;
import necesse.inventory.item.Item;
import necesse.inventory.lootTable.LootTable;
import necesse.level.maps.levelBuffManager.LevelModifiers;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Lootbag extends Item {
    public LootTable lootTable;

    public Lootbag() {
        super(1);
    }

    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public Supplier<ContainerActionResult> getInventoryRightClickAction(Container container, InventoryItem item, int slotIndex, ContainerSlot slot) {
        return () -> {
            ArrayList<InventoryItem> drops = this.getLootTable().getNewList(GameRandom.globalRandom, (Float)container.client.playerMob.getLevel().buffManager.getModifier(LevelModifiers.LOOT), this);
            int dropSize = drops.size() - 1;
            for(int i = 0; i <= dropSize; i++) {
                System.out.println(i);
                System.out.println(dropSize);
                container.getClient().playerMob.getInv().main.addItem(container.client.playerMob.getLevel(), container.client.playerMob, drops.get(i), "buy");
                if (i == dropSize) {
                    System.out.println(item);
                    container.getClient().playerMob.getInv().main.removeItems(container.client.playerMob.getLevel(), container.client.playerMob, item.item, 1, "buy");
                }
            }
            return new ContainerActionResult(-1002911334);
        };
    }
}
