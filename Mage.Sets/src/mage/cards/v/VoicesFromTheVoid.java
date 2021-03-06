
package mage.cards.v;

import java.util.UUID;
import mage.abilities.dynamicvalue.common.DomainValue;
import mage.abilities.effects.common.discard.DiscardTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.target.TargetPlayer;

/**
 *
 * @author Loki
 */
public final class VoicesFromTheVoid extends CardImpl {

    public VoicesFromTheVoid(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{4}{B}");


        // Domain - Target player discards a card for each basic land type among lands you control.
        this.getSpellAbility().addEffect(new DiscardTargetEffect(new DomainValue()));
        this.getSpellAbility().addTarget(new TargetPlayer());
    }

    private VoicesFromTheVoid(final VoicesFromTheVoid card) {
        super(card);
    }

    @Override
    public VoicesFromTheVoid copy() {
        return new VoicesFromTheVoid(this);
    }
}
