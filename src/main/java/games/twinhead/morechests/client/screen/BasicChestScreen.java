package games.twinhead.morechests.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import games.twinhead.morechests.screen.BasicChestScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
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
    protected void drawBackground(MatrixStack context, float delta, int mouseX, int mouseY) {
        int i = (width - backgroundWidth) / 2;
        int j = ((height - backgroundHeight) / 2);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        //Chest Section
        drawTexture(context, i, j, 0, 0, this.backgroundWidth, handler.rows * 18 + 17);
        //Inventory Section
        drawTexture(context, i, j + handler.rows * 18 + 17, 0, 126, this.backgroundWidth, 96);

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
