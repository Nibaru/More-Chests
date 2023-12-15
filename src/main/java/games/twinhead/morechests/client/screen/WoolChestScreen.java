package games.twinhead.morechests.client.screen;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.WoolChestScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class WoolChestScreen extends HandledScreen<WoolChestScreenHandler> {

    private final Identifier TEXTURE;
    private final List<DyeColor> lightColors = Arrays.asList(DyeColor.WHITE, DyeColor.LIGHT_BLUE, DyeColor.PINK, DyeColor.LIME, DyeColor.YELLOW, DyeColor.ORANGE, DyeColor.LIGHT_GRAY, DyeColor.MAGENTA, DyeColor.CYAN);

    public WoolChestScreen(WoolChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = 114 + handler.rows * 18;
        this.playerInventoryTitleY = this.backgroundHeight - 91;
        TEXTURE = MoreChests.id("textures/gui/container/" + handler.getColor().getName() + "_wool_generic_54.png");
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = (width - backgroundWidth) / 2;
        int j = (height - backgroundHeight) / 2;
        //Chest Section
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, handler.rows * 18 + 17);
        //Inventory Section
        context.drawTexture(TEXTURE, i, j + handler.rows * 18 + 17, 0, 126, this.backgroundWidth, 104);
    }

    @Override
    public void render(DrawContext matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    public void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, this.title, this.titleX, this.titleY, lightColors.contains(handler.getColor()) ? 0x404040 : 0xBDBDBD, false);
        context.drawText(this.textRenderer, this.playerInventoryTitle, this.playerInventoryTitleX, this.playerInventoryTitleY, 0x404040, false);
    }


}
