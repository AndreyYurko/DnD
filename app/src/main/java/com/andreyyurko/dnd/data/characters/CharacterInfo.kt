package com.andreyyurko.dnd.data.characters


data class CharacterInfo(
    var level: Int = 0,
    var race: String = "",
    var characterClass: String = "",
    var passiveInsightBonus: Int = 0,
    var passivePerceptionBonus: Int = 0,
    var strengthBonus: Int = 0,
    var dexterityBonus: Int = 0,
    var constitutionBonus: Int = 0,
    var intelligenceBonus: Int = 0,
    var wisdomBonus: Int = 0,
    var charismaBonus: Int = 0,
    var proficiencyBonus: Int = 0,
    var skillProficiency: Set<Skill> = emptySet(),
    var expertize: Set<Skill> = emptySet(),
    var savingThrowProf: Set<Ability> = emptySet(),
    var armorProficiency: Set<ArmorProf> = emptySet(),
    var weaponProficiency: Set<WeaponProf> = emptySet(),
    var armorAdditionalProficiency: Set<Int> = emptySet(), //every item has an id
    var weaponAdditionalProficiency: Set<Int> = emptySet(), //every item has an id
    var toolProficiency: Set<Int> = emptySet(), //every tool has an id
    var languageProficiency: Set<Languages> = emptySet(), //every language has an id
    var ac: Int = 0,
    var initiativeBonus: Int = 0,
    var speed: Int = 0,
    var hp: Int = 0,
    var damageResistances: Set<Int> = emptySet(),
    var damageImmunities: Set<Int> = emptySet(),
    var actionsList: List<Action> = emptyList(),
    var inventory: List<EquipmentItem> = emptyList(),
)