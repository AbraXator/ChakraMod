package net.chakramod.mod.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.chakramod.mod.screen.StoneWorkBenchScreen;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class StoneWorkBenchRecipe implements Recipe<SimpleInventory>{

    private final Ingredient inputA;
    private final Ingredient inputB;
    private final ItemStack result;
    private final Identifier id;

    public StoneWorkBenchRecipe(Identifier id, ItemStack result, Ingredient inputA, Ingredient inputB){
        this.id = id;
        this.inputA = inputA;
        this.inputB = inputB;
        this.result = result;
    }

    public Ingredient getInputA() {
        return this.inputA;
    }

    public Ingredient getInputB() {
        return this.inputB;
    }

    @Override
    public ItemStack getOutput() {
        return this.result;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(inventory.size() < 2) return false;
        return inputA.test(inventory.getStack(0)) && inputB.test(inventory.getStack(1));
    }

    public static class Type implements RecipeType<StoneWorkBenchRecipe>{
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "stone_work_bench_recipe";
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Serializer implements RecipeSerializer<StoneWorkBenchRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "stone_work_bench_recipe";

        @Override
        public StoneWorkBenchRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new StoneWorkBenchRecipe(id, output, inputs.get(0), inputs.get(1));
        }

        @Override
        public StoneWorkBenchRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(),Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return  new StoneWorkBenchRecipe(id, output,
                    inputs.get(0), inputs.get(1));
        }

        @Override
        public void write(PacketByteBuf buf, StoneWorkBenchRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for(Ingredient ingredient : recipe.getIngredients()){
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}

