package games.twinhead.morechests.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.screen.NetheriteChestScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
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
    protected void drawBackground(MatrixStack context, float delta, int mouseX, int mouseY) {
        int i = ((width - backgroundWidth) / 2) + 27;
        int j = (height - backgroundHeight) / 2;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        drawTexture(context, i + 27, j, 0, 0, this.backgroundWidth - 60, 3 * 18 + 17);

        //top left
        drawTexture(context, i - 27, j, 0, 0, 18 * 3 + 7, 3 * 18 + 17);

        //top right
        drawTexture(context, i + 18 * 14 -2, j, 169, 0, 18 * 3 + 7, 3 * 18 + 17);

        //middle
        drawTexture(context, i + 27, j + 3 * 18 + 17,  0, 17, 18*12 +7, 115);

        //bottom Left
        drawTexture(context, i - 27, j + 3 * 18 + 17,  0, 17, 18 * 3 + 7, 115);

        //bottom right
        drawTexture(context, i + 18 * 14 - 2, j + 3 * 18 + 17,  169, 17, 18 * 3 + 7, 115);

        //inventory
        drawTexture(context, i + 54, j + 9 * 18 + 21,  0, 133, 18 * 12, 96);
    }

    @Override
    public void render(MatrixStack texture, int mouseX, int mouseY, float delta) {
        renderBackground(texture);
        super.render(texture, mouseX, mouseY, delta);
        drawMouseoverTooltip(texture, mouseX, mouseY);
    }
}
