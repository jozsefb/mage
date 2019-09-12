package mage.cards.m;

import mage.MageInt;
import mage.abilities.common.DiesTriggeredAbility;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.abilities.effects.common.LoseLifeSourceControllerEffect;
import mage.abilities.effects.common.PutOnLibraryTargetEffect;
import mage.abilities.keyword.LifelinkAbility;
import mage.cards.AdventureCard;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.target.common.TargetCreatureOrPlaneswalker;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class MurderousRider extends AdventureCard {

    public MurderousRider(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, new CardType[]{CardType.INSTANT}, "{1}{B}{B}", "Swift End", "{1}{B}{B}");

        this.subtype.add(SubType.ZOMBIE);
        this.subtype.add(SubType.KNIGHT);
        this.power = new MageInt(2);
        this.toughness = new MageInt(3);

        // Lifelink
        this.addAbility(LifelinkAbility.getInstance());

        // When Murderous Rider dies, put it on the bottom of its owner's library.
        this.addAbility(new DiesTriggeredAbility(new PutOnLibraryTargetEffect(
                false, "put it on the bottom of its owner's library"
        ), false));

        // Swift End
        // Destroy target creature or planeswalker. You lose 2 life.
        this.getAdventureSpellAbility().addEffect(new DestroyTargetEffect());
        this.getAdventureSpellAbility().addEffect(
                new LoseLifeSourceControllerEffect(2).setText("You lose 2 life.")
        );
        this.getAdventureSpellAbility().addTarget(new TargetCreatureOrPlaneswalker());
    }

    private MurderousRider(final MurderousRider card) {
        super(card);
    }

    @Override
    public MurderousRider copy() {
        return new MurderousRider(this);
    }
}