package games.twinhead.morechests.client.screen;

import games.twinhead.morechests.screen.BasicChestScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BasicChestScreen extends HandledScreen<BasicChestScreenHandler> {

    private static final Identifier TEXTURE =
            new Identifier("minecraft", "textures/gui/container/generic_54.png");

    public BasicChestScreen(BasicChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = 114 + handler.rows * 18;
        this.playerInventoryTitleY = this.backgroundHeight - 93;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = (width - backgroundWidth) / 2;
        int j = ((height - backgroundHeight) / 2);
        //Chest Section
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, handler.rows * 18 + 17);
        //Inventory Section
        context.drawTexture(TEXTURE, i, j + handler.rows * 18 + 17, 0, 126, this.backgroundWidth, 96);

    }

    @Override
    public void render(DrawContext matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
