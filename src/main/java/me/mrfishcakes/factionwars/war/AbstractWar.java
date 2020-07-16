package me.mrfishcakes.factionwars.war;

import com.google.common.collect.Sets;
import com.massivecraft.factions.Faction;

import java.util.Set;

/**
 * Created by MrFishCakes on 15/07/2020 at 22:14
 * Copyrighted to MrFishCakes.
 */
public abstract class AbstractWar {

    protected Set<Faction> teamOne, teamTwo;

    public AbstractWar(final int oneSize, final int twoSize) {
        teamOne = Sets.newHashSetWithExpectedSize(oneSize);
        teamTwo = Sets.newHashSetWithExpectedSize(twoSize);
    }

    public AbstractWar() {
        teamOne = Sets.newHashSet();
        teamTwo = Sets.newHashSet();
    }

}