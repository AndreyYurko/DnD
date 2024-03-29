package com.andreyyurko.dnd.data.abilities.other

import com.andreyyurko.dnd.data.characterData.Action
import com.andreyyurko.dnd.data.characterData.ActionType
import com.andreyyurko.dnd.data.characterData.Armor
import com.andreyyurko.dnd.data.characterData.CharacterInfo
import com.andreyyurko.dnd.data.characterData.character.AbilityNode

var archery: AbilityNode = AbilityNode(
    name = "Стрельба",
    // we can add to-hit bonus when this action appears on the screen
    // change current state is dangerous because after every load bonus will accumulate
    changesInCharacterInfo = { abilities: CharacterInfo ->
        for (weaponProf in abilities.weaponProficiency) {
            if (!weaponProf.isMelee) {
                weaponProf.toHitBonus += 2
            }
        }
        abilities
    },
    alternatives = mutableMapOf(),
    requirements = { _: CharacterInfo ->
        true
    },
    description = "Вы получаете бонус +2 к броску атаки, когда атакуете дальнобойным оружием.",
)

var defense: AbilityNode = AbilityNode(
    name = "Оборона",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        if (abilities.currentState.armor != Armor.NoArmor) {
            abilities.ac += 1
        }
        abilities
    },
    alternatives = mutableMapOf(),
    requirements = { _: CharacterInfo ->
        true
    },
    description = "Пока вы носите доспехи, вы получаете бонус +1 к КД.",
)

var dueling: AbilityNode = AbilityNode(
    name = "Дуэлянт",
    // don't know how to process this ability
    // change current state is dangerous
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.additionalAbilities["Боевой стиль: Дуэлянт"] =
            "Пока вы держите рукопашное оружие в одной руке и не используете другого оружия, вы получаете бонус +2 к броскам урона этим оружием."
        abilities
    },
    alternatives = mutableMapOf(),
    requirements = { _: CharacterInfo ->
        true
    },
    description = "Пока вы держите рукопашное оружие в одной руке и не используете другого оружия, вы получаете бонус +2 к броскам урона этим оружием.",
)

var greatWeaponFighting: AbilityNode = AbilityNode(
    name = "Сражение большим оружием",
    // don't know how to process this ability
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.additionalAbilities["Боевой стиль: Сражение большим оружием"] =
            "Если у вас выпало «1» или «2» на кости урона оружия при атаке, которую вы совершали рукопашным оружием, удерживая его двумя руками, то вы можете перебросить эту кость, и должны использовать новый результат, даже если снова выпало «1» или «2». Чтобы воспользоваться этим преимуществом, ваше оружие должно иметь свойство « двуручное» или «универсальное»."
        abilities
    },
    alternatives = mutableMapOf(),
    requirements = { _: CharacterInfo ->
        true
    },
    description = "Если у вас выпало «1» или «2» на кости урона оружия при атаке, которую вы совершали рукопашным оружием, удерживая его двумя руками, то вы можете перебросить эту кость, и должны использовать новый результат, даже если снова выпало «1» или «2». Чтобы воспользоваться этим преимуществом, ваше оружие должно иметь свойство « двуручное» или «универсальное».",
)

var protection: AbilityNode = AbilityNode(
    name = "Защита",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.actionsList.add(
            Action(
                name = "Защита",
                description = "Если существо, которое вы видите, атакует не вас, а другое существо, находящееся в пределах 5 футов от вас, вы можете реакцией создать помеху его броску атаки. Для этого вы должны использовать щит.",
                type = ActionType.Reaction
            )
        )
        abilities
    },
    alternatives = mutableMapOf(),
    requirements = { _: CharacterInfo ->
        true
    },
    description = "Если существо, которое вы видите, атакует не вас, а другое существо, находящееся в пределах 5 футов от вас, вы можете реакцией создать помеху его броску атаки. Для этого вы должны использовать щит.",
)

var twoWeaponFighting: AbilityNode = AbilityNode(
    name = "Сражение двумя оружиями",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        for (action in abilities.actionsList) {
            if (action.name == "Атака второй рукой") {
                action.description =
                    "Если вы совершаете действие «Атака» и атакуете рукопашным оружием со свойством «лёгкое», удерживаемым в одной руке, вы можете бонусным действием атаковать другим рукопашным оружием со свойством «лёгкое», удерживаемым в другой руке.\n" +
                            "\n" +
                            "Если у любого из оружий есть свойство «метательное», вы можете не совершать им рукопашную атаку, а метнуть его."
            }
        }
        abilities
    },
    alternatives = mutableMapOf(),
    requirements = { _: CharacterInfo ->
        true
    },
    description = "Если вы сражаетесь двумя оружиями, вы можете добавить модификатор характеристики к урону от второй атаки.",
)

var mapOfFightingStyles = mutableMapOf<String, AbilityNode>(
    Pair(archery.name, archery),
    Pair(defense.name, defense),
    Pair(dueling.name, dueling),
    Pair(greatWeaponFighting.name, greatWeaponFighting),
    Pair(protection.name, protection),
    Pair(twoWeaponFighting.name, twoWeaponFighting)
)