package com.andreyyurko.dnd.data.abilities.races

import com.andreyyurko.dnd.data.characterData.Action
import com.andreyyurko.dnd.data.characterData.ActionType
import com.andreyyurko.dnd.data.characterData.character.CharacterInfo
import com.andreyyurko.dnd.data.characterData.ChargesCounter
import com.andreyyurko.dnd.data.characterData.DamageType
import com.andreyyurko.dnd.data.characterData.Languages
import com.andreyyurko.dnd.data.characterData.Priority
import com.andreyyurko.dnd.data.characterData.character.AbilityNode
import com.andreyyurko.dnd.data.spells.CharacterSpells
import com.andreyyurko.dnd.data.spells.SpellLists

var protectorAasimar = AbilityNode(
    name = "Аасимар-защитник",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.wisdom += 1
        if (abilities.level >= 3) {
            if (!abilities.currentState.charges.contains("Сияющая душа")) {
                abilities.currentState.charges["Сияющая душа"] = ChargesCounter(
                    current = 1,
                    maximum = 1
                )
            }
            abilities.actionsMap["Сияющая душа"] =
                Action(
                    name = "Сияющая душа",
                    description = "Вы можете действием высвободить божественную энергию внутри себя, заставляя ваши глаза мерцать, а два светящихся, бестелесных крыла вырасти у вас за спиной. Ваше превращение длится 1 минуту или пока вы не окончите его бонусным действием.\n" +
                            "\n" +
                            "Во время превращения вы получаете скорость полёта 30 футов и раз в свой ход вы можете нанести дополнительный урон излучением одной цели, когда вы наносите ей урон атакой или заклинанием. Дополнительный урон излучением равен вашему уровню. \n" +
                            "\n" +
                            "После того, как вы используете эту особенность, вы не можете использовать её снова, пока не закончите продолжительный отдых.\n",
                    type = ActionType.Action,
                    relatedCharges = "Сияющая душа"
                )

        }
        abilities
    },
    getAlternatives = mutableMapOf(),
    requirements = { true },
    addRequirements = listOf(),
    description = "Аасимар–защитник наполнен силой добра чтобы защищать слабых, искоренять зло где бы то ни было, и неусыпно стоять на пути тьмы.\n" +
            "\n" +
            "С юных лет аасимар-защитник получает советы и указания, которые побуждают его противостоять злу.\n" +
            "\n" +
            "Увеличение характеристик. Значение вашей Мудрости увеличивается на 1.\n" +
            "\n" +
            "Сияющая душа. Начиная с 3-го уровня, вы можете действием высвободить божественную энергию внутри себя, заставляя ваши глаза мерцать, а два светящихся, бестелесных крыла вырасти у вас за спиной. Ваше превращение длится 1 минуту или пока вы не окончите его бонусным действием.\n" +
            "\n" +
            "Во время превращения вы получаете скорость полёта 30 футов и раз в свой ход вы можете нанести дополнительный урон излучением одной цели, когда вы наносите ей урон атакой или заклинанием. Дополнительный урон излучением равен вашему уровню. \n" +
            "\n" +
            "После того, как вы используете эту особенность, вы не можете использовать её снова, пока не закончите продолжительный отдых.\n"
)

var scourgeAasimar = AbilityNode(
    name = "Аасимар-каратель",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.constitution += 1
        if (abilities.level >= 3) {
            if (!abilities.currentState.charges.contains("Испускание сияния")) {
                abilities.currentState.charges["Испускание сияния"] = ChargesCounter(
                    current = 1,
                    maximum = 1
                )
            }
            abilities.actionsMap["Испускание сияния"] =
                Action(
                    name = "Испускание сияния",
                    description = "Вы можете действием высвободить божественную энергию внутри себя, заставляя себя излучать испепеляющий свет, льющийся из ваших глаз и рта и угрожающий опалить вас. Ваше превращение длится 1 минуту или пока вы не окончите его бонусным действием.\n" +
                            "\n" +
                            "Во время превращения вы излучаете яркий свет в пределах 10 футов и тусклый свет в пределах ещё 10 футов, и в конце каждого вашего хода, вы и каждое существо в пределах 10 футов от вас получаете урон излучением, равный половине Вашего уровня (округленного в большую сторону).\n" +
                            "\n" +
                            "Кроме того, раз в свой ход вы можете нанести дополнительный урон излучением одной цели, когда вы наносите ему урон атакой или заклинанием. Дополнительный урон излучением равен вашему уровню. \n" +
                            "\n" +
                            "После того, как вы используете эту особенность, вы не можете использовать её снова, пока не закончите продолжительный отдых.\n",
                    type = ActionType.Action,
                    relatedCharges = "Испускание сияния"
                )

        }
        abilities
    },
    getAlternatives = mutableMapOf(),
    requirements = { true },
    addRequirements = listOf(),
    description = "Аасимар–каратель наполнен божественной энергией, которая пылает внутри. Она подпитывает сильное желание уничтожать зло – желание в лучшем случае твердое, а в худшем — всепоглощающее.\n" +
            "\n" +
            "Многие аасимары-каратели носят маски, дабы оградиться от мира и сосредоточиться на том, чтобы сдерживать эту силу, снимая с себя маску только во время сражения.\n" +
            "\n" +
            "Увеличение характеристик. Значение вашего Телосложения увеличивается на 1.\n" +
            "\n" +
            "Испускание сияния. Начиная с 3-го уровня, вы можете действием высвободить божественную энергию внутри себя, заставляя себя излучать испепеляющий свет, льющийся из ваших глаз и рта и угрожающий опалить вас. Ваше превращение длится 1 минуту или пока вы не окончите его бонусным действием.\n" +
            "\n" +
            "Во время превращения вы излучаете яркий свет в пределах 10 футов и тусклый свет в пределах ещё 10 футов, и в конце каждого вашего хода, вы и каждое существо в пределах 10 футов от вас получаете урон излучением, равный половине Вашего уровня (округленного в большую сторону).\n" +
            "\n" +
            "Кроме того, раз в свой ход вы можете нанести дополнительный урон излучением одной цели, когда вы наносите ему урон атакой или заклинанием. Дополнительный урон излучением равен вашему уровню. \n" +
            "\n" +
            "После того, как вы используете эту особенность, вы не можете использовать её снова, пока не закончите продолжительный отдых.\n\n"
)

var fallenAasimar = AbilityNode(
    name = "Падший аасимар",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.strength += 1
        if (abilities.level >= 3) {
            if (!abilities.currentState.charges.contains("Саван смерти")) {
                abilities.currentState.charges["Саван смерти"] = ChargesCounter(
                    current = 1,
                    maximum = 1
                )
            }
            abilities.actionsMap["Саван смерти"] =
                Action(
                    name = "Саван смерти",
                    description = "Вы можете действием высвободить божественную энергию внутри себя, заставляя ваши глаза превратиться в бездну тьмы, а два призрачных, не способных взлететь скелета крыльев вырасти у вас за спиной.\n" +
                            "\n" +
                            "В момент вашего превращения, другие существа в пределах 10 футов, которые могут вас видеть, должны преуспеть в спасброске Харизмы (Сл 8 + ваш бонус мастерства + ваш модификатор Харизмы) или станут испуганным вами до конца вашего следующего хода. Ваше превращение длится 1 минуту или пока Вы не закончите его бонусным действием.\n" +
                            "\n" +
                            "Во время превращения раз в свой ход вы можете нанести дополнительный урон некротической энергией одной цели, когда вы наносите ей урон атакой или заклинанием. Дополнительный урон некротической энергией равен вашему уровню.\n" +
                            "\n" +
                            "После того, как вы используете эту особенность, вы не можете использовать её снова, пока не закончите продолжительный отдых.\n",
                    type = ActionType.Action,
                    relatedCharges = "Саван смерти"
                )

        }
        abilities
    },
    getAlternatives = mutableMapOf(),
    requirements = { true },
    addRequirements = listOf(),
    description = "Аасимар–каратель наполнен божественной энергией, которая пылает внутри. Она подпитывает сильное желание уничтожать зло – желание в лучшем случае твердое, а в худшем — всепоглощающее.\n" +
            "\n" +
            "Многие аасимары-каратели носят маски, дабы оградиться от мира и сосредоточиться на том, чтобы сдерживать эту силу, снимая с себя маску только во время сражения.\n" +
            "\n" +
            "Увеличение характеристик. Значение вашего Телосложения увеличивается на 1.\n" +
            "\n" +
            "Испускание сияния. Начиная с 3-го уровня, вы можете действием высвободить божественную энергию внутри себя, заставляя себя излучать испепеляющий свет, льющийся из ваших глаз и рта и угрожающий опалить вас. Ваше превращение длится 1 минуту или пока вы не окончите его бонусным действием.\n" +
            "\n" +
            "Во время превращения вы излучаете яркий свет в пределах 10 футов и тусклый свет в пределах ещё 10 футов, и в конце каждого вашего хода, вы и каждое существо в пределах 10 футов от вас получаете урон излучением, равный половине Вашего уровня (округленного в большую сторону).\n" +
            "\n" +
            "Кроме того, раз в свой ход вы можете нанести дополнительный урон излучением одной цели, когда вы наносите ему урон атакой или заклинанием. Дополнительный урон излучением равен вашему уровню. \n" +
            "\n" +
            "После того, как вы используете эту особенность, вы не можете использовать её снова, пока не закончите продолжительный отдых.\n\n"
)

val aasimarAbilities = AbilityNode(
    name = "Способности аасимара",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.charisma += 2
        abilities.languageProficiency.add(Languages.Common)
        abilities.languageProficiency.add(Languages.Celestial)
        if (abilities.additionalAbilities.contains("Тёмное зрение")) {
            var regex = Regex(" [^ ]* футов")
            abilities.additionalAbilities["Тёмное зрение"]?.let {
                regex.find(it)?.let { parsed ->
                    if (60 > parsed.value.split(" ")[1].toInt()) {
                        abilities.additionalAbilities["Тёмное зрение"] =
                            "Благословленное светлым духом, ваше зрение может легко проникать сквозь темноту. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого.\n"
                    }
                }
            }
        } else {
            abilities.additionalAbilities["Тёмное зрение"] =
                "Благословленное светлым духом, ваше зрение может легко проникать сквозь темноту. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого.\n"
        }
        abilities.speed += 30
        abilities.damageResistances.add(DamageType.Radiant)
        abilities.damageResistances.add(DamageType.Necrotic)
        if (!abilities.currentState.charges.contains("Исцеляющие руки аасимара")) {
            abilities.currentState.charges["Исцеляющие руки аасимара"] = ChargesCounter(
                current = 1,
                maximum = 1
            )
        }
        abilities.actionsMap["Исцеляющие руки аасимара"] =
            Action(
                name = "Исцеляющие руки аасимара",
                description = "Действием вы можете коснуться существа и восстановить ему количество хитов, равное вашему уровню. Вы не сможете вновь воспользоваться этой способностью пока не закончите продолжительный отдых.\n",
                type = ActionType.Action,
                relatedCharges = "Исцеляющие руки аасимара"
            )

        if (!abilities.spellsInfo.contains("Заклинания аасимара")) {
            abilities.spellsInfo["Заклинания аасимара"] = CharacterSpells(
                maxKnownSpellsCount = 0,
                maxKnownCantripsCount = 0,
                spellLists = SpellLists(
                    knownCantrips = mutableSetOf("Свет")
                )
            )
        }
        abilities
    },
    getAlternatives = mutableMapOf(
        Pair("subrace", { listOf(protectorAasimar.name, scourgeAasimar.name, fallenAasimar.name) }),
    ),
    requirements = { true },
    description = "Ваш персонаж аасимар обладает следующими расовыми особенностями.\n" +
            "\n" +
            "Увеличение характеристик. Значение вашей Харизмы увеличивается на 2.\n" +
            "\n" +
            "Возраст. Аасимары взрослеют как и люди, но они могут прожить до 160 лет.\n" +
            "\n" +
            "Мировоззрение. Любое.\n" +
            "\n" +
            "Размер. У аасимаров такие же рост и вес, как и у людей.\n" +
            "\n" +
            "Скорость. Ваша базовая скорость ходьбы составляет 30 футов.\n" +
            "\n" +
            "Тёмное зрение. Благословленное светлым духом, ваше зрение может легко проникать сквозь темноту. На расстоянии в 60 футов вы при тусклом освещении можете видеть так, как будто это яркое освещение, и в темноте так, как будто это тусклое освещение. В темноте вы не можете различать цвета, только оттенки серого.\n" +
            "\n" +
            "Небесное сопротивление. У вас есть сопротивление урону излучением и некротической энергией.\n" +
            "\n" +
            "Исцеляющие руки. Действием вы можете коснуться существа и восстановить ему количество хитов, равное вашему уровню. Вы не сможете вновь воспользоваться этой способностью пока не закончите продолжительный отдых.\n" +
            "\n" +
            "Несущий свет. Вам известен заговор свет [light]. Базовой характеристикой для его использования является Харизма.\n" +
            "\n" +
            "Языки. Вы можете разговаривать, читать и писать на Общем и Небесном языках.\n" +
            "\n" +
            "Разновидности. Существует три разновидности аасимаров: аасимар–защитник, аасимар–каратель и падший аасимар. Выберите одну из них для своего персонажа.\n",
    priority = Priority.DoFirst
)

val aasimar = AbilityNode(
    name = "Аасимар ",
    changesInCharacterInfo = { abilities: CharacterInfo ->
        abilities.race = "Аасимар"
        abilities
    },
    getAlternatives = mutableMapOf(
        Pair("abilities", { listOf(aasimarAbilities.name) })
    ),
    requirements = { true },
    description = "Аасимар",
)

val mapOfAasimarAbilities = mutableMapOf(
    Pair(protectorAasimar.name, protectorAasimar),
    Pair(scourgeAasimar.name, scourgeAasimar),
    Pair(fallenAasimar.name, fallenAasimar),
    Pair(aasimarAbilities.name, aasimarAbilities),
    Pair(aasimar.name, aasimar)
)