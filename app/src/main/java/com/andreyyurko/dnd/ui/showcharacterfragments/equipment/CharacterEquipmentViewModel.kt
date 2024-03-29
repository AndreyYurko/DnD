package com.andreyyurko.dnd.ui.showcharacterfragments.equipment

import androidx.lifecycle.ViewModel
import com.andreyyurko.dnd.data.inventory.InventoryItemInfo
import com.andreyyurko.dnd.utils.CharacterViewModel
import com.andreyyurko.dnd.utils.InventoryHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterEquipmentViewModel @Inject constructor(
    val characterViewModel: CharacterViewModel,
    val inventoryHandler: InventoryHandler
) : ViewModel() {

    fun getEquippedMagicalItems(): MutableList<InventoryItemInfo> {
        return inventoryHandler.getEquippedMagicalItems(characterViewModel.shownCharacter)
    }

    fun getFirstWeaponInfo(): WeaponInfo {
        val currentState = characterViewModel.shownCharacter.characterInfo.currentState
        return WeaponInfo(
            weaponName = currentState.firstWeaponName,
            properties = currentState.firstWeapon.properties,
            damage = currentState.firstWeapon.shownDamage
        )
    }

    fun getSecondWeaponInfo(): WeaponInfo? {
        val currentState = characterViewModel.shownCharacter.characterInfo.currentState
        currentState.secondWeapon?.let {
            return WeaponInfo(
                weaponName = currentState.secondWeaponName,
                properties = it.properties,
                damage = it.shownSecondWeaponDamage
            )
        }
        return null
    }

    fun getArmorInfo(): ArmorInfo {
        val currentState = characterViewModel.shownCharacter.characterInfo.currentState
        return ArmorInfo(
            armorName = currentState.armorName,
            type = "Тип",
            ac = currentState.armor.ac + (currentState.inventoryRelevantData[currentState.armorName]?.ac ?: 0)
        )
    }

    data class WeaponInfo(
        val weaponName: String,
        val properties: List<String>,
        var damage: String
    )

    data class ArmorInfo(
        val armorName: String,
        val type: String,
        val ac: Int
    )
}