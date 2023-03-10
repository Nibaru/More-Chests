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

    public final int rows = ChestTypes.NETHERITE.rows;
    public final int columns = ChestTypes.NETHERITE.columns;

    private static final Identifier TEXTURE =
            new Identifier(MoreChests.MOD_ID, "textures/gui/container/generic_6x12_separated.png");

    public NetheriteChestScreen(NetheriteChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.passEvents = false;
        this.backgroundHeight = 55 + this.rows * 18 + 3 * 18 ;
        this.playerInventoryTitleY = this.backgroundHeight - 89;
        this.playerInventoryTitleX = this.backgroundWidth - 114 ;
        this.backgroundWidth = 284;
        this.titleX = titleX - 27;
    }

    public int getBackgroundWidth(){
        return this.backgroundWidth;
    }

    public int getBackgroundHeight(){
        return this.backgroundHeight;
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


        this.drawTexture(matrices, i + 27, j, 0, 0, this.backgroundWidth - 60, 3 * 18 + 17);

        //top left
        this.drawTexture(matrices, i - 27, j, 0, 0, 18 * 3 + 7, 3 * 18 + 17);

        //top right
        this.drawTexture(matrices, i + 18 * 14 -2, j, 169, 0, 18 * 3 + 7, 3 * 18 + 17);

        //middle
        this.drawTexture(matrices, i + 27, j + 3 * 18 + 17,  0, 17, this.backgroundWidth - 42, 115);

        //bottom Left
        this.drawTexture(matrices, i - 27, j + 3 * 18 + 17,  0, 17, 18 * 3 + 7, 115);

        //bottom right
        this.drawTexture(matrices, i + 18 * 14 - 2, j + 3 * 18 + 17,  169, 17, 18 * 3 + 7, 115);

        //inventory
        this.drawTexture(matrices, i + 54, j + 9 * 18 + 21,  0, 133, 18 * 12, 96);
        //this.drawTexture(matrices, i, j + this.rows * 18 + 17, 0, 126, this.backgroundWidth, 96);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
