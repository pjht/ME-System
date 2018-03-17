package com.pjht.mesystem.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class BlueprintRecipeFactory implements IRecipeFactory {

    public BlueprintRecipeFactory() {}

    @Override
    public IRecipe parse(JsonContext context, JsonObject json) {
        String group = JsonUtils.getString(json, "group", "");

        NonNullList<Ingredient> ings = NonNullList.create();
        for (JsonElement ele : JsonUtils.getJsonArray(json, "ingredients"))
            ings.add(CraftingHelper.getIngredient(ele, context));

        if (ings.isEmpty())
            throw new JsonParseException("No ingredients for blueprint shapeless recipe");
        if (ings.size() > 9)
            throw new JsonParseException("Too many ingredients for blueprint shapeless recipe");

        ItemStack itemstack = CraftingHelper.getItemStack(JsonUtils.getJsonObject(json, "result"), context);
        return new BlueprintShapelessRecipe(group, itemstack, ings);
    }

}
