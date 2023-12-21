package games.twinhead.morechests.client.screen;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.screen.NetheriteChestScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class NetheriteChestScreen extends HandledScreen<NetheriteChestScreenHandler> {

    private static final Identifier TEXTURE =
            MoreChests.id("textures/gui/container/generic_6x12_separated.png");

    public NetheriteChestScreen(NetheriteChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = 55 + ChestTypes.NETHERITE.rows * 18 + 3 * 18 ;
        this.playerInventoryTitleY = this.backgroundHeight - 89;
        this.playerInventoryTitleX = this.backgroundWidth - 87 ;
        this.backgroundWidth = 284 + 54;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = ((width - backgroundWidth) / 2) + 27;
        int j = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, i + 27, j, 0, 0, this.backgroundWidth - 60, 3 * 18 + 17);

        //top left
        context.drawTexture(TEXTURE, i - 27, j, 0, 0, 18 * 3 + 7, 3 * 18 + 17);

        //top right
        context.drawTexture(TEXTURE, i + 18 * 14 -2, j, 169, 0, 18 * 3 + 7, 3 * 18 + 17);

        //middle
        context.drawTexture(TEXTURE, i + 27, j + 3 * 18 + 17,  0, 17, 18*12 +7, 115);

        //bottom Left
        context.drawTexture(TEXTURE, i - 27, j + 3 * 18 + 17,  0, 17, 18 * 3 + 7, 115);

        //bottom right
        context.drawTexture(TEXTURE, i + 18 * 14 - 2, j + 3 * 18 + 17,  169, 17, 18 * 3 + 7, 115);

        //inventory
        context.drawTexture(TEXTURE, i + 54, j + 9 * 18 + 21,  0, 133, 18 * 12, 96);
        //context.drawTexture(TEXTURE, i, j + this.rows * 18 + 17, 0, 126, this.backgroundWidth, 96);

        context.drawHorizontalLine(0, 284, 30, 255);

    }

    @Override
    public void render(DrawContext texture, int mouseX, int mouseY, float delta) {
        super.render(texture, mouseX, mouseY, delta);
        drawMouseoverTooltip(texture, mouseX, mouseY);
    }
}
