
package mage.cards.l;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.costs.common.RevealTargetFromHandCost;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.filter.common.FilterCreatureCard;
import mage.game.Game;
import mage.players.Player;
import mage.target.common.TargetCardInHand;

/**
 *
 * @author jeffwadsworth
 */
public final class LivingDestiny extends CardImpl {

    public LivingDestiny(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.INSTANT},"{3}{G}");


        // As an additional cost to cast Living Destiny, reveal a creature card from your hand.
        TargetCardInHand targetCard = new TargetCardInHand(new FilterCreatureCard("a creature card"));
        this.getSpellAbility().addCost(new RevealTargetFromHandCost(targetCard));
       
        // You gain life equal to the revealed card's converted mana cost.
        this.getSpellAbility().addEffect(new LivingDestinyEffect());
    }

    private LivingDestiny(final LivingDestiny card) {
        super(card);
    }

    @Override
    public LivingDestiny copy() {
        return new LivingDestiny(this);
    }
}

class LivingDestinyEffect extends OneShotEffect {

    public LivingDestinyEffect() {
        super(Outcome.GainLife);
        staticText = "You gain life equal to its converted mana cost";
    }

    public LivingDestinyEffect(LivingDestinyEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        RevealTargetFromHandCost cost = (RevealTargetFromHandCost) source.getCosts().get(0);
        if (cost != null) {
            Player player = game.getPlayer(source.getControllerId());
            int CMC = cost.convertedManaCosts;
            if (player != null) {
                player.gainLife(CMC, game, source);
            }
        }
        return true;
    }

    @Override
    public LivingDestinyEffect copy() {
        return new LivingDestinyEffect(this);
    }

}