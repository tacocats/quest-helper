/*
 * Copyright (c) 2020, tacocats
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.questhelper.quests.dwarfcannon;

import com.questhelper.QuestDescriptor;
import com.questhelper.QuestHelperQuest;
import com.questhelper.Zone;
import com.questhelper.panel.PanelDetails;
import com.questhelper.questhelpers.BasicQuestHelper;
import com.questhelper.requirements.ItemRequirement;
import com.questhelper.steps.*;
import com.questhelper.steps.conditional.ConditionForStep;
import com.questhelper.steps.conditional.Conditions;
import com.questhelper.steps.conditional.ItemRequirementCondition;
import com.questhelper.steps.conditional.ZoneCondition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.coords.WorldPoint;

@QuestDescriptor(
        quest = QuestHelperQuest.DWARF_CANNON
)
public class DwarfCannon extends BasicQuestHelper {
    ItemRequirement hammer;
    Zone sampleZone;
    ConditionForStep sampleCondition;
    QuestStep talkToLawgof;

    // TODO - Above reqs, zones, conditions, steps

    @Override
    public Map<Integer, QuestStep> loadSteps()
    {
        setupItemRequirements();
        setupZones();
        setupConditions();
        setupSteps();

        Map<Integer, QuestStep> steps = new HashMap<>();

        return steps;
    }

    public void setupItemRequirements()
    {
        hammer = new ItemRequirement("Hammer", ItemID.HAMMER);
    }

    public void setupZones()
    {
        sampleZone = new Zone(new WorldPoint(10, 10, 0), new WorldPoint(20, 20, 0));
    }

    public void setupConditions()
    {
        sampleCondition = new ZoneCondition(sampleZone);
    }

    public void setupSteps()
    {
        talkToLawgof = new NpcStep(this, NpcID.CAPTAIN_LAWGOF, new WorldPoint(3443, 3258, 0), "Talk to Captain Lawgof by the Coal truck mining site west of Seers' Village.");
    }

    @Override
    public ArrayList<ItemRequirement> getItemRequirements()
    {
        return new ArrayList<>(Arrays.asList(hammer));
    }

    @Override
    public ArrayList<ItemRequirement> getItemRecommended()
    {
        return new ArrayList<>(Arrays.asList());
    }

    @Override
    public ArrayList<String> getNotes()
    {
        return new ArrayList<>(Arrays.asList("This is a note to appear in the sidebar"));
    }

    @Override
    public ArrayList<PanelDetails> getPanels()
    {
        ArrayList<PanelDetails> allSteps = new ArrayList<>();
        //allSteps.add(new PanelDetails("Getting Started", new ArrayList<>(Arrays.asList(sampleStep)), sampleRequirement));
        allSteps.add(new PanelDetails("Starting off", new ArrayList<>(Arrays.asList(talkToLawgof, pickpocketZealot)), combatGear));
        return allSteps;
    }
}
