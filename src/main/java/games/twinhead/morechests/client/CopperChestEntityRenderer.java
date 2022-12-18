package games.twinhead.morechests.client;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.BasicChestBlock;
import games.twinhead.morechests.block.entity.BasicChestBlockEntity;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.block.*;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

public class CopperChestEntityRenderer<T extends BasicChestBlockEntity & LidOpenable> extends ChestBlockEntityRenderer<T> {

    private final ModelPart chestLid;
    private final ModelPart chestBase;
    private final ModelPart chestLock;

    public CopperChestEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        super(ctx);
        ModelPart modelPart = ctx.getLayerModelPart(EntityModelLayers.CHEST);
        this.chestBase = modelPart.getChild("bottom");
        this.chestLid = modelPart.getChild("lid");
        this.chestLock = modelPart.getChild("lock");

    }

    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        boolean bl = world != null;
        BlockState blockState = bl ? entity.getCachedState() : (BlockState) Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);
        if (blockState.getBlock() instanceof Oxidizable) {
            matrices.push();
            BasicChestBlock block = (BasicChestBlock) blockState.getBlock();
            float f = ((Direction)blockState.get(ChestBlock.FACING)).asRotation();
            matrices.translate(0.5F, 0.5F, 0.5F);
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-f));
            matrices.translate(-0.5F, -0.5F, -0.5F);
            DoubleBlockProperties.PropertySource<? extends ChestBlockEntity> properties;
            if (world == null) {
                properties = DoubleBlockProperties.PropertyRetriever::getFallback;
            } else {
                properties = ((BasicChestBlock) block).getBlockEntitySource(blockState, world, entity.getPos(), true);
            }


            float g = ((Float2FloatFunction)properties.apply(ChestBlock.getAnimationProgressRetriever((LidOpenable)entity))).get(tickDelta);
            g = 1.0F - g;
            g = 1.0F - g * g * g;
            int i = ((Int2IntFunction)properties.apply(new LightmapCoordinatesRetriever())).applyAsInt(light);

            Oxidizable oxidizable = (Oxidizable) blockState.getBlock();

            SpriteIdentifier spriteIdentifier = new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE,new Identifier(MoreChests.MOD_ID,"entity/chest/" + (oxidizable.getDegradationLevel() != Oxidizable.OxidationLevel.UNAFFECTED ? oxidizable.getDegradationLevel().name().toLowerCase() + "_" : "") + "copper_chest"));

            VertexConsumer vertexConsumer = spriteIdentifier.getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout);

            this.render(matrices, vertexConsumer, this.chestLid, this.chestLock, this.chestBase, g, i, overlay);


            matrices.pop();
        }
    }

    private void render(MatrixStack matrices, VertexConsumer vertices, ModelPart lid, ModelPart latch, ModelPart base, float openFactor, int light, int overlay) {
        lid.pitch = -(openFactor * 1.5707964F);
        latch.pitch = lid.pitch;
        lid.render(matrices, vertices, light, overlay);
        latch.render(matrices, vertices, light, overlay);
        base.render(matrices, vertices, light, overlay);
    }
}
