package com.yahoo.tillyqb.springboot.magic_card_deck_tracker.repository;

import com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity.User;
import com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity.Card;
import com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity.Deck;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest
{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void userRepositorySavesUserCorrectly()
    {
        Card brainstorm_deck = Card.builder().id(Card.CardId.builder().title("Brainstorm").condition("mint").build()).quantity(4).build();
        Card brainstorm_collection = Card.builder().id(Card.CardId.builder().title("Brainstorm").condition("mint").build()).quantity(10).build();
        Card lightningBolt = Card.builder().id(Card.CardId.builder().title("Lightning Bolt").condition("Light Play").build()).quantity(2).build();
        Deck collectionDeck = Deck.builder().description("this is not a deck, this is your collection").cards(List.of(brainstorm_collection, lightningBolt)).build();
        Deck testDeck = Deck.builder().description("ANIKIN, YOU WERE SUPPOSED TO STOP THE SITH, NOT JOIN THEM").cards(List.of(brainstorm_deck)).build();
        User someBody = User.builder().userName("Shrek").email("shrek@myswamp.fairyland").decks(List.of(testDeck, collectionDeck)).build();
        testDeck.setId(Deck.DeckId.builder().deckName("I HATE YOU").ownerName(someBody.getUserName()).build());
        collectionDeck.setId(Deck.DeckId.builder().deckName("collection").ownerName(someBody.getUserName()).build());
        collectionDeck.getId().setOwnerName(someBody.getUserName());
        brainstorm_deck.getId().setDeckName(testDeck.getId().getDeckName());
        brainstorm_collection.getId().setDeckName(collectionDeck.getId().getDeckName());
        lightningBolt.getId().setDeckName(collectionDeck.getId().getDeckName());
        brainstorm_deck.getId().setOwnerName(someBody.getUserName());
        brainstorm_collection.getId().setOwnerName(someBody.getUserName());
        lightningBolt.getId().setOwnerName(someBody.getUserName());

        userRepository.save(someBody);

        Assert.assertEquals(List.of(someBody), userRepository.findAll());
    }
}
