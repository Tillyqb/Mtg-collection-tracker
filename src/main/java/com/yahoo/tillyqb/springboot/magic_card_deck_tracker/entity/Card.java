package com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card
{
    @EmbeddedId
    private CardId id;
    private Integer quantity;

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CardId implements Serializable
    {
        private String title;
        private String condition;
        private String deckName;
        private String ownerName;
    }
}