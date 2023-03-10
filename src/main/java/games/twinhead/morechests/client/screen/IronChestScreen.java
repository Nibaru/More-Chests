package games.twinhead.morechests.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import games.twinhead.morechests.screen.IronChestScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IronChestScreen extends HandledScreen<IronChestScreenHandler> {

    public final int rows = 6;

    private static final Identifier TEXTURE =
            new Identifier("minecraft", "textures/gui/container/generic_54.png");

    public IronChestScreen(IronChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.passEvents = false;
        this.backgroundHeight = 114 + this.rows * 18;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }



    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = (width - backgroundWidth) / 2;
        int j = (height - backgroundHeight) / 2;
        //drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.rows * 18 + 17);
        this.drawTexture(matrices, i, j + this.rows * 18 + 17, 0, 126, this.backgroundWidth, 96);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
