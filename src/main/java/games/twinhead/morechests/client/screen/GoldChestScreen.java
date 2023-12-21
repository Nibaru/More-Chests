package games.twinhead.morechests.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.GoldChestScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
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
    protected void drawBackground(MatrixStack context, float delta, int mouseX, int mouseY) {
        int i = (width - backgroundWidth) / 2;
        int j = (height - backgroundHeight) / 2;
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        drawTexture(context, i, j, 0, 0, this.backgroundWidth, this.rows * 18 + 17);
        drawTexture(context, i, j + this.rows * 18 + 17, 0, 126, this.backgroundWidth, 96);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
