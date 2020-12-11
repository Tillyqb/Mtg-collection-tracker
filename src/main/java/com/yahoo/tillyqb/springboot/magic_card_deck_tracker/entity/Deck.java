package com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deck
{
    @EmbeddedId
    private DeckId id;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "deckName"),
            @JoinColumn(name = "ownerName")
    })
    private List<Card> cards;

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeckId implements Serializable
    {
        public String deckName;
        public String ownerName;
    }
}