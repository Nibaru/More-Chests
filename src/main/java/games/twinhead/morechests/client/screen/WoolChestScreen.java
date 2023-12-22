package games.twinhead.morechests.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.WoolChestScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
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
    protected void drawBackground(MatrixStack context, float delta, int mouseX, int mouseY) {
        int i = (width - backgroundWidth) / 2;
        int j = (height - backgroundHeight) / 2;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        //Chest Section
        drawTexture(context, i, j, 0, 0, this.backgroundWidth, handler.rows * 18 + 17);
        //Inventory Section
        drawTexture(context, i, j + handler.rows * 18 + 17, 0, 126, this.backgroundWidth, 104);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    public void drawForeground(MatrixStack context, int mouseX, int mouseY) {
        textRenderer.draw(context, title, titleX, titleY, lightColors.contains(handler.getColor()) ? 0x404040 : 0xBDBDBD);
        textRenderer.draw(context, playerInventoryTitle, playerInventoryTitleX, playerInventoryTitleY, 0x404040);
        //context.drawText(this.textRenderer, this.title, this.titleX, this.titleY, lightColors.contains(handler.getColor()) ? 0x404040 : 0xBDBDBD, false);
        //context.drawText(this.textRenderer, this.playerInventoryTitle, this.playerInventoryTitleX, this.playerInventoryTitleY, 0x404040, false);
    }


}
