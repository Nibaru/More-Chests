package games.twinhead.morechests.client.screen;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.GoldChestScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GoldChestScreen extends HandledScreen<GoldChestScreenHandler> {

    public final int rows = 6;
    public final int columns = 12;

    private static final Identifier TEXTURE =
            MoreChests.id("textures/gui/container/generic_6x12.png");

    public GoldChestScreen(GoldChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = 113 + this.rows * 18;
        this.playerInventoryTitleY = this.backgroundHeight - 93;
        this.playerInventoryTitleX = this.backgroundWidth - 141;
        this.backgroundWidth = 230;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = (width - backgroundWidth) / 2;
        int j = (height - backgroundHeight) / 2;
        //drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.rows * 18 + 17);
        context.drawTexture(TEXTURE, i, j + this.rows * 18 + 17, 0, 126, this.backgroundWidth, 96);
    }

    @Override
    public void render(DrawContext matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
